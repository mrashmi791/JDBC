/**
 * 
 */
package com.jdbc_connection.jdbc.configuration;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author lenovo
 *
 */
public class RetriveDataFromDBAndWriteIntoCSVfile {

	
public static void main(String[] args) {
		
		Statement st = null;
		ResultSet rs = null;
		FileOutputStream fos = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/employee_database", "root", "Ankit@123");
			st = con.createStatement();
			rs = st.executeQuery("select * from emp1");
			
//			String data = "eno , ename , esal , eaddress 0xA";
//			
//			
//			
//			while(rs.next()) {
//					data = data + rs.getInt("eno") + " , ";
//					data = data + rs.getString("ename") + " , ";
//					data = data + rs.getInt("esal") + " , ";
//					data = data + rs.getString("eaddress");
//					data = data + "0xA";
//				
//			}
//			
//			
//			
//			fos = new FileOutputStream("E:/Documents/emp.csv");
//			byte[] bt = data.getBytes();
//			fos.write(bt);
//			
			 PrintWriter pw = new PrintWriter(new File("E:/Documents/emp1.csv"));
		        StringBuilder sb = new StringBuilder();
		        sb.append("eno");
		        sb.append(',');
		        sb.append("ename");
		        sb.append(',');
		        sb.append("esal");
		        sb.append(',');
		        sb.append("eaddress");
		        sb.append("\n");

		        while(rs.next()) {
		        	
		        	sb.append("" + rs.getInt("eno"));
			        sb.append(',');
			        
			        sb.append("" + rs.getString("ename"));
			        sb.append(',');
			        sb.append("" + rs.getString("esal"));
			        
			        sb.append(',');
			        sb.append("" + rs.getString("eaddress"));
			        
			        sb.append("\n");
				
			}
		       

		        pw.write(sb.toString());
		        pw.close();
	
			System.out.println("Employee data retrieve successfully and send to E:/documents/emp1.csv");
			
			
					
		} catch(Exception e) {
			e.printStackTrace();
			
		} finally {
			try {
				rs.close();
				st.close();
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}	
	
}


