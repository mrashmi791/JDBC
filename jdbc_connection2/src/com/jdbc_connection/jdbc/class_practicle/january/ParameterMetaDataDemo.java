/**
 * 
 */
package com.jdbc_connection.jdbc.class_practicle.january;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;

/**
 * This operation  can used for accessing the information about parameter. 
 * 
 * @author Rashmi
 *
 */
public class ParameterMetaDataDemo {

	/**
	 * @param args
	 * 
	 * @author Rashmi
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/student_database?generateSimpleParameterMetadata=true", "root",
				"Ankit@123");
		PreparedStatement pst = con.prepareStatement("insert into studentinfo values(?,?,?)");
		
		pst.setInt(1, 191);
		pst.setString(2,"nngh" );
		pst.setInt(3,9);
		pst.executeUpdate();
		ParameterMetaData pmd = pst.getParameterMetaData();
		
		
		int no = pmd.getParameterCount();
		
		System.out.println("No of rows:" + no);
		
		for(int i = 1; i <= no ; i++) {
			
			System.out.println(pmd.getParameterType(i));
			System.out.println(pmd.getParameterTypeName(i));
			
			
		}
	}

}


