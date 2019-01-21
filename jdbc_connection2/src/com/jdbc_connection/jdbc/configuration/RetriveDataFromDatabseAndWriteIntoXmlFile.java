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
public class RetriveDataFromDatabseAndWriteIntoXmlFile {

	public static void main(String[] args) {
		
		Statement st = null;
		ResultSet rs = null;
		FileOutputStream fos = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/employee_database", "root", "Ankit@123");
			st = con.createStatement();
			rs = st.executeQuery("select * from emp1");
			
			String data = "<employees>";
			
			
			
			while(rs.next()) {
				data = data + "<employee>";
				
					data = data +"<eno>" + rs.getInt("eno") + "</eno>";
					data = data +"<ename>" + rs.getString("ename") + "</ename>";
					data = data +"<esal>" + rs.getInt("esal") + "</esal>";
					data = data +"<eaddress>" + rs.getString("eaddress") + "</eaddress>";
	
				data = data + "</employee>";
				
			}
			
			data = data + "</employees>";
			
			
			fos = new FileOutputStream("E:/Documents/emp.xml");
			byte[] bt = data.getBytes();
			fos.write(bt);
			
			System.out.println("Employee data retrieve successfully and send to E:/documents/emp.xml");
			
			
					
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


