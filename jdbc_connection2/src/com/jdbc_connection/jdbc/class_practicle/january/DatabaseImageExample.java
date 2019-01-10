package com.jdbc_connection.jdbc.class_practicle.january;
import java.io.*;
import java.sql.*;
 
public class DatabaseImageExample {
	public static void main(String args[]){
		try{

			Driver d = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(d);
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/employee_database", "root",
					"Ankit@123");
			
			
			byte b[];
			Blob blob;
			
			PreparedStatement ps=con.prepareStatement("select * from newemployee"); 
			ResultSet rs=ps.executeQuery();
			
			FileOutputStream fos = null;
			
			while(rs.next()){
				File file=new File("E:\\images\\output_image\\" + rs.getString(1) +".jpg");
				Thread.sleep(1000);
				fos = new FileOutputStream(file);
				blob=rs.getBlob("emp_image");
				b=blob.getBytes(1,(int)blob.length());
				fos.write(b);
			}
			
			ps.close();
			fos.close();
			//con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}