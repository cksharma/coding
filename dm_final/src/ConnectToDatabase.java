


import java.sql.*;
import java.util.*;
import javax.swing.*;

public class ConnectToDatabase
{
    static Connection con;
	static Statement st;
	static ResultSet rs;
    String tablename;
    ConnectToDatabase (String name, String username, String password, String tablename ) throws Exception
    {

        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		con = DriverManager.getConnection( "jdbc:odbc:"+name,username,password);
		st = con.createStatement();
        this.tablename = tablename;
	}
	ResultSet getResultSet() throws Exception
    {
        rs = st.executeQuery("SELECT * FROM " + tablename.toUpperCase());
        return rs;
	}
}
