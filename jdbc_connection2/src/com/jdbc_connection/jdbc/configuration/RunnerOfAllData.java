/**
 * 
 */
package com.jdbc_connection.jdbc.configuration;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.jdbc_connection.jdbc.configuration.InsertAllDataInDatabase;

/**
 * @author lenovo
 *
 */
public class RunnerOfAllData {

	/**
	 * @param args
	 * 
	 * @author Rashmi
	 */
	public static void main(String[] args) throws Exception {
		
		Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/employee_database", "root", "Ankit@123");
		PreparedStatement pst = con.prepareStatement("insert into employeeinformation values(?,?,?,?,?,?)");
		
		
		Scanner sc = new Scanner(System.in);
		
		
		
		int choice;
		
		do {
			InsertAllDataInDatabase.showOptions();
			choice = sc.nextInt();
			
			switch (choice) {
			case 1: InsertAllDataInDatabase.insert(sc, pst,con);
					break;
					
			case 2: InsertAllDataInDatabase.show(con, sc);
					break;
					
			}
		} while(choice != 0) ;
			sc.close();
		
		

	}

}


