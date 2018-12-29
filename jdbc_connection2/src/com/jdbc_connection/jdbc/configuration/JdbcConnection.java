package com.jdbc_connection.jdbc.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class JdbcConnection {

	public static void main(String[] args) throws Exception {
		
		String databaseUrl = "jdbc:mysql://localhost:3308/student_database";
		String databaseUserName = "root";
		String databasePassword = "Ankit@123";
		
		String query = "select name,roll from StudentInfo where id = 105";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(databaseUrl,databaseUserName,databasePassword);
		
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		
		rs.next();
		String name = rs.getString("name");
		int roll = rs.getInt("roll");
		
		System.out.println("name: "+ name +" and rollNo: "+ roll);
		

	}

}
