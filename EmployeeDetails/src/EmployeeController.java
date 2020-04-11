import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeController
 */
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	private EmployeeDAO dao;
	public Employee employee;
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		dao = new EmployeeDAO();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			RequestDispatcher dispatcher = null;
			String action = request.getParameter("action");
			
			if(action.equals("add"))
			{
				int employeeId = Integer.parseInt(request.getParameter("id"));
				String empname = request.getParameter("name");
				String designation = request.getParameter("designation");
				double salary = Double.parseDouble(request.getParameter("salary"));
				//System.out.println(employeeId + name + designation + salary);
				Employee e = new Employee(employeeId, empname, designation, salary);
				//System.out.println(empname);
				boolean ok = dao.addEmployee(e);
				if(!ok)
				{
					dispatcher = request.getRequestDispatcher("/employeeNotAdded.jsp");
				}
				else
				{
					request.setAttribute("employee", e);
					dispatcher = request.getRequestDispatcher("/employeeAdded.jsp");
				}
				dispatcher.forward(request, response);
			}
			else if(action.equals("showall"))
			{
				
				List <Employee> lst = (List<Employee>)dao.allEmployee();
				request.setAttribute("showall", lst);
				dispatcher = request.getRequestDispatcher("/allEmployee.jsp");
				//System.out.println("All employees");
				dispatcher.forward(request, response);
			}
			else if(action.equals("retrive"))
			{
				int id = Integer.parseInt(request.getParameter("id"));
				Employee e = dao.retriveEmployee(id);
				request.setAttribute("retrive", e);
				if(e != null) dispatcher = request.getRequestDispatcher("/retriveEmployee.jsp");
				else dispatcher = request.getRequestDispatcher("/noId.jsp");
				dispatcher.forward(request, response);
			}
			else if(action.equals("remove"))
			{
				int id = Integer.parseInt(request.getParameter("id"));
				employee = dao.removeEmployee(id);
				if(employee != null) 
				{	
					request.setAttribute("employee", employee);
					dispatcher = request.getRequestDispatcher("/removeEmployee.jsp");
				}
				
				else
				{ 
					dispatcher = request.getRequestDispatcher("/noId.jsp");
				}
				dispatcher.forward(request, response);
			}
			else if(action.equals("update"))
			{
				int oldId = Integer.parseInt(request.getParameter("oldid"));
				int id = Integer.parseInt(request.getParameter("id"));
				String name = request.getParameter("name");
				String designation = request.getParameter("designation");
				double salary = Double.parseDouble(request.getParameter("salary"));
				Employee e = new Employee(id, name, designation, salary);
				boolean ok = dao.updateEmployee(e, oldId);
				request.setAttribute("update", e);
				if(ok) dispatcher = request.getRequestDispatcher("/updateEmployee.jsp");
				else dispatcher = request.getRequestDispatcher("/noId.jsp");
				dispatcher.forward(request, response);
			}
	}
}
