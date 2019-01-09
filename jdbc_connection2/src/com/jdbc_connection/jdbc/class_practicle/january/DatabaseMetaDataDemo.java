/**
 * 
 */
package com.jdbc_connection.jdbc.class_practicle.january;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Driver;
import java.sql.DriverManager;

/**
 * @author Rashmi
 *
 */
public class DatabaseMetaDataDemo {

	/**
	 *  Use DatabaseMetaData to access information like Driver name, UserName, URL ...etc
	 * 
	 * @param args
	 * 
	 * @author Rashmi
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/student_database", "root", "Ankit@123");
		
		DatabaseMetaData  dbmd = con.getMetaData();
		
		System.out.println(dbmd.getDriverName());
		System.out.println(dbmd.getDatabaseProductName());
		System.out.println(dbmd.getDriverVersion());
		System.out.println(dbmd.getURL());
		System.out.println(dbmd.getDatabaseMajorVersion());
		System.out.println(dbmd.getDatabaseMinorVersion());
		
		

	}

}


