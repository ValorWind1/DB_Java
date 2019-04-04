package obtaindata;

import java.sql.*;

public class obtainData {
	 
	// We put the JDBC Driver , and our DB (url)
	static final String JDBC_DRIVER ="org.mariadb.jdbc.Driver";
	static final String DB_URL = " jdbc:mariadb://localhost:3306/Verze";
	
	
	//DB LOG IN
	static final String USER = "root";
	static final String PASS= "1234";
	
	public static void main ( String [] args) {
		Connection conn = null;
		Statement stm = null;
		try {
			
			Class.forName("org.mariadb.jdbc.Driver");
			
			// Starting the connection 
			System.out.println("Connecting to the DB " );
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/Verze","root","1234");
			System.out.println("Connection was succesfull");
			
			System.out.println("Creating the statement");
			stm= conn.createStatement();
			
			String sql=" SELECT User_Name, IP_Address,Computer_Name,Operating_System,Software_Name,Software_Version,Check_Date FROM all_checked_sw";
			ResultSet rs=stm.executeQuery(sql);
			
			while(rs.next()) {
				
				
				
				
				
				
				/*String User_Name =rs.getString("User_Name");
				String IP_Address =rs.getString("IP_Address");
				String Computer_Name =rs.getString("Computer_Name");
				String Operating_System =rs.getString("Operating_System");
				String Software_Name =rs.getString("Software_Name");
				String Software_Version =rs.getString("Software_Version");
				String Check_Date =rs.getString("Check_Date");
				//Display 
				System.out.print("User_Name: "+User_Name);
				System.out.print(",  IP_Address: "+IP_Address);
				System.out.print(",  Computer_Name: "+Computer_Name);
				System.out.print(",  Operating_System: "+Operating_System);
				System.out.print(",  Software_Name: "+Software_Name);
				System.out.print(",  Software_Version: "+Software_Version);
				System.out.print(",  Check_Date: "+Check_Date);*/
				
			}
			rs.close();
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
		
		try {
			if(stm !=null)
				conn.close();
		}catch (SQLException se) {
			
		}
		try {
			if(conn!=null)
				conn.close();
		}catch(SQLException se) {
			se.printStackTrace();
		}
	}
  }
}	

