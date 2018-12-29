package com.jdbc_connection.jdbc.configuration;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class ConnectionConfiguration {
	
	public static Connection getConnection() throws Exception {
		Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/student_database", "root", "Ankit@123");

		return con;
	}

}
