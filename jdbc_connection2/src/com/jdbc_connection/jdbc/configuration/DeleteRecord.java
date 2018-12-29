package com.jdbc_connection.jdbc.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteRecord {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
		String databaseUrl = "jdbc:mysql://localhost:3308/student_database";
		String databaseUserName = "root";
		String databasePassword = "Ankit@123";
		
		String query = "delete from studentInfo where id = 105";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(databaseUrl,databaseUserName,databasePassword);
		
		Statement st = conn.createStatement();
		int count = st.executeUpdate(query);
		
		System.out.println(count + "row affected");
		st.close();

	}

}
