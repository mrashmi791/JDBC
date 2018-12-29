package com.jdbc_connection.jdbc.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsertRecord {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		String databaseUrl = "jdbc:mysql://localhost:3308/student_database";
		String databaseUserName = "root";
		String databasePassword = "Ankit@123";

		//String query = "insert into studentInfo values (444,'Rashmi Sharma', 420)";

		//String updateQuery = "update studentInfo set name = 'Rashmi mishra' where id = 444";
		String query2 = "select * from studentInfo where id = 1";
		// String deleteQuery = "delete from studentInfo where id = 444";

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(databaseUrl, databaseUserName, databasePassword);

		Statement st = conn.createStatement();
		//int count = st.executeUpdate(query);

		ResultSet rs = st.executeQuery(query2);
		boolean temp = rs.next();
		if (temp) {
			while(temp) {
				System.out.println("\nid: " + rs.getInt("id") + "\nname: " + rs.getString("name") + "\nroll: " + rs.getInt("roll"));
				temp = rs.next();
			}
			
		} else {
			System.out.println("No record available in database..!!");
		}

		st.close();
	}

}
