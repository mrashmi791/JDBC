package com.jdbc_connection.jdbc.configuration;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertRecordByUser {

	public static void main(String[] args) throws SQLException,  Exception {
	
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter student id");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter student name");
		String name = sc.nextLine();
		
		System.out.println("Enter student roll");
		int roll = sc.nextInt();
		String query = "insert into  studentInfo values ("+ id + ",'" + name + "'," + roll + ")";
		
		// connection..
		Connection con = ConnectionConfiguration.getConnection();
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery(query);
		System.out.println(" row inserted");
		st.close();
		//con.close();
		sc.close();

	}

}
