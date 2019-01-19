/**
 * 
 */
package com.jdbc_connection.jdbc.configuration;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author lenovo
 *
 */
public class RetrieveDataFromDatabaseIntoAnHtml {

	/**
	 * @param args
	 * 
	 * @author Rashmi
	 */
	public static void main(String[] args) {
	
		Statement st = null;
		ResultSet rs = null;
		FileOutputStream fos = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/employee_database", "root", "Ankit@123");
			st = con.createStatement();
			rs = st.executeQuery("select * from emp1");
			
			String data = "<html><body><center><br><br>";
			data = data + "<h2 style='color:red;' align='center'>";
			data = data + "Employee Info";
			data = data + "<h2>";
			data = data + "<table border='1' bgcolor='lightpink'>";
			
			data = data + "<tr>";
			data = data + "<td>ENO</td><td>ENAME</td><td>ESAL</td><td>EADDRESS</td></tr>";
			
			
			while(rs.next()) {
				data = data + "<tr>";
				data = data +"<td>" + rs.getInt("eno") + "</td>";
				data = data +"<td>" + rs.getString("ename") + "</td>";
				data = data +"<td>" + rs.getInt("esal") + "</td>";
				data = data +"<td>" + rs.getString("eaddress") + "</td>";
				
				data = data + "</tr>";
				
			}
			
			data = data + "</table></center></body></html>";
			
			
			fos = new FileOutputStream("E:/Documents/emp.html");
			byte[] bt = data.getBytes();
			fos.write(bt);
			
			System.out.println("Employee data retrieve successfully and send to E:/documents/emp.html");
			
			
					
		} catch(Exception e) {
			e.printStackTrace();
			
		} finally {
			try {
				fos.close();
				rs.close();
				st.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}


