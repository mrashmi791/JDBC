/**
 * 
 */
package com.jdbc_connection.jdbc.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author lenovo
 *
 */
public class InsertImageInDatabase {

	/**
	 * @param args
	 * 
	 * @author Rashmi
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/employee_database", "root", "Ankit@123");
			
		
		PreparedStatement pst = con.prepareStatement("insert into newemployee values(?,?)");
		
		pst.setString(1,"ram");
		File f = new File("E:\\images\\flower.jpg");
		FileInputStream fis = new FileInputStream (f);
		
		pst.setBlob(2, fis);
		//int retCount = pst.executeUpdate();
		
		//if(retCount > 0) {
			System.out.println("Image is inserted in Database");
			display(con);
			
		//} else {
			System.out.println("Image is Not inserted in Database");
		//}
		
		
		
		
		fis.close();
		
		
	}
	
	public static void display(Connection con) throws SQLException, IOException {
		Statement st = con.createStatement();
		File f = new File("E:\\images\\kkk.jpg");
		FileOutputStream fos = new  FileOutputStream(f);
		
		ResultSet rs = st.executeQuery("select * from newemployee where emp_name = 'ram' ");
		if(rs.next()) {
			fos.write(rs.getBytes(2));
		}
		
	}
	
	

}


