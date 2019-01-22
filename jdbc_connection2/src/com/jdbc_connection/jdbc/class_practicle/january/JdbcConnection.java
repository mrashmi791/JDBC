/**
 * 
 */
package com.jdbc_connection.jdbc.class_practicle.january;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

/**
 * @author Rashmi
 *
 */
public class JdbcConnection {
	
	public static Connection getConnection() throws Exception {
		Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/student_information_database", "root", "Ankit@123");

		return con;
	}
}


