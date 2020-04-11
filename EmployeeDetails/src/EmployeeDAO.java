import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class EmployeeDAO 
{
	private DataSource dataSource;

	public EmployeeDAO() {
		super();
		// TODO Auto-generated constructor stub
		try
		{
			Context ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB");
		}
		catch(NamingException e)
		{
			e.printStackTrace();
		}
	}
	
	public boolean addEmployee(Employee e) throws DatabaseException
	{
		int p = 0;
		try
		{
			System.out.println(e);
			Connection con = dataSource.getConnection();
			String sql = "insert into employee values(?, ?, ?, ?)";
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setInt(1, e.getEmployeeId());
			pst.setString(2, e.getEmployeeName());
			pst.setString(3, e.getDesignation());
			pst.setDouble(4, e.getSalary());
			p = pst.executeUpdate();
			con.close();
		}	
		catch (SQLException e1) {
			throw new DatabaseException("Unable to insert into DB");
			
	 	}
		return p > 0;
	}
	
	public List <Employee> allEmployee() throws DatabaseException
	{
		List <Employee> lst = new ArrayList <Employee> ();
		
			try {
				Connection con = dataSource.getConnection();
				String sql = "select * from employee";
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();
				while(rs.next())
				{
					int id = rs.getInt(1);
					String name = rs.getString(2);
					String designation = rs.getString(3);
					double salary = rs.getDouble(4);
					lst.add(new Employee(id, name, designation, salary));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new DatabaseException("Unable to connect / retrive ");
			}
		return lst;
	}
	
	public Employee retriveEmployee(int id) throws DatabaseException
	{
		Employee e = null;
		try {
			Connection con = dataSource.getConnection();
			String sql = "select * from employee where id = " + id + "";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if(rs.next())
			{
				id = rs.getInt(1);
				String name = rs.getString(2);
				String designation = rs.getString(3);
				double salary = rs.getDouble(4);
				e = new Employee(id, name, designation, salary);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			throw new DatabaseException("Unable to connect / retrive / insert in DB");
		}
		return e;
	}
	
	public Employee removeEmployee(int id) throws DatabaseException
	{
		int b = 0;
		String res = "";
		Employee e = null;
		try {
			Connection con = dataSource.getConnection();
			
			String str = "select * from employee where id = " + id;
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(str);
			
			if(rs.next()){
				id = rs.getInt(1);
				String name = rs.getString(2);
				String designation = rs.getString(3);
				double salary = rs.getDouble(4);
				e = new Employee(id, name, designation, salary);
			}
			String sql = "delete from employee where id = " + id + "";
			PreparedStatement pst = con.prepareStatement(sql);
			b = pst.executeUpdate();
			
				
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			throw new DatabaseException("Unable to connect / retrive / insert in DB");
		}
		return e;
	}
	
	public boolean updateEmployee(Employee e, int oldid) throws DatabaseException
	{
		int b = 0;
		try {
			Connection con = dataSource.getConnection();
			int id = e.getEmployeeId(); 
			String name = e.getEmployeeName();
			String designation = e.getDesignation();
			double salary = e.getSalary();
			String sql = "update employee set id = ?, name = ?, designation = ?, salary = ? where id = ?";
			
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setInt(1, id); pst.setString(2, name); pst.setString(3, designation); pst.setDouble(4, salary);
			pst.setInt(5, oldid);
			//System.out.println(pst.toString());
			b = pst.executeUpdate();
				
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			throw new DatabaseException("Unable to connect / retirve / insert in DB");
		}
		return b > 0;
	}
}
