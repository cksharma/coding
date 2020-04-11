import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class SiteDetails {
	String siteId;
	String siteName;
	String opertorName;
}

public class JDBCForSitenameAndOperators {
	public static void main(String[] args) {
		Connection connection = null;
		try {
			FileReader fileReader = new FileReader(new File("E:/temp/siteids.txt"));
			BufferedReader reader = new BufferedReader(fileReader);
			String str = "";
			String driverName = "oracle.jdbc.driver.OracleDriver";
		    Class.forName(driverName);

		    // Create a connection to the database
		    String serverName = "10.155.10.63";
		    String portNumber = "1521";
		    String sid = "atlstore";
		    String url = "jdbc:oracle:thin:@" + serverName + ":" + portNumber + ":" + sid;
		    String username = "distributor";
		    String password = "distributor";
		    connection = DriverManager.getConnection(url, username, password);
			List <SiteDetails> list = new ArrayList <SiteDetails> ();
		    while((str = reader.readLine()) != null) {
		    	String siteQuery = "select OPERATORNAME, SITENAME from GENERALSITECONFIG where SITEID=?";
				PreparedStatement pst = connection.prepareStatement(siteQuery);
				pst.setString(1, str);
				ResultSet rs = pst.executeQuery();
				if(rs.next()) {
					String str1 = "";//str + "           ";
					str1 += rs.getString(1);
					while(str1.length() < 35) str1 = str1 + " ";
					str1 += rs.getString(2);
					//System.out.println(rs.getString(1) + "    " + rs.getString(2));
					System.out.println(str1);
				} else {
					System.out.println( "  NA" + "                    		  NA");                                                  
				}
					
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		if(connection != null)
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
