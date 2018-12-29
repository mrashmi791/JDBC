package com.jdbc_connection.jdbc.configuration;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * This class is mainly used for CRUD operation.
 * 
 * @author Rashmi
 *
 */
public class MultipleTask {

	/**
	 * This method is used for inserting student details.
	 *  
	 * @param sc {link Scanner }
	 * @param st {link Statement }
	 * @throws SQLException
	 * 
	 * @author Rashmi
	 */
	public static void insert(Scanner sc, Statement st) throws SQLException {
		
		System.out.println("Enter id");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter name");
		String name = sc.nextLine();
		System.out.println("Enter roll");
		int roll = sc.nextInt();
		
		String query = "insert into studentInfo values (" + id + ",'" + name + "'," + roll + ")";

		int count = st.executeUpdate(query);
		if(count > 0) {
			System.out.println("Record inserted");
		} else {
			System.out.println("Something went wrong..!!");
		}
		
	}

	/**
	 * This method is used for updating student details.
	 * 
	 * @param id student id
	 * @param name student name
	 * @param roll roll number
	 * @param st { Statement }
	 * @throws SQLException
	 */
	public static void update(int id, String name, int roll, Statement st) throws SQLException {
		String updateQuery = "update studentInfo set name = '"+ name + "', roll = "+ roll + " where id = "+ id;

		int count  = st.executeUpdate(updateQuery);
		if(count > 0) {
			System.out.println("Record updated");
		} else {
			System.out.println("Something went wrong..!!");
		}
	
	}

	/**
	 * This method is used to delete student record by id.
	 * 
	 * @param id
	 * @param st
	 * @throws SQLException
	 * 
	 * @author Rashmi
	 */
	public static void delete(int id, Statement st) throws SQLException {
		String deleteQuery = "delete from studentInfo where id = " + id;

		int resCount = st.executeUpdate(deleteQuery);
		if(resCount > 0) {
			System.out.println("Record deleted ");
		} else {
			System.out.println("Record not available with this id..!!");
		}
		
	}
	
	
	 /**
	  * This method is used for fetch all student details.
	  * 
	  * @param st
	  * @throws SQLException
	  * 
	  * @author Rashmi
	  */
	public static void showAllRecords(Statement st) throws SQLException {
		
		String query = "SELECT * FROM studentInfo";
		
		ResultSet rs = st.executeQuery(query);
		boolean temp = rs.next();
		if (temp) {
			while(temp) {
				System.out.println("\nid: " + rs.getInt("id") + "\nname: " + rs.getString("name") + "\nroll: " + rs.getInt("roll"));
				temp = rs.next();
			}
			
		} else {
			System.out.println("No record available in database..!!");
		}

	}
	
	
	
	/**
	 * This method is used to show options.
	 * 
	 * @author Rashmi
	 */
	public static void showOptions() {
		System.out.print("Enter 1 for insert data: ");
		System.out.print("\nEnter 2 for update data: ");
		System.out.print("\nEnter 3 for delete data: ");
		System.out.print("\nEnter 4 to show all records: ");
		System.out.print("\nEnter 5 to show specific record by id: ");
		System.out.print("\nEnter 6 to show specific record by name:");
		System.out.print("\nEnter 7 to delete all record: ");
		System.out.print("\nEnter 8 to update all specific column of records:");
		System.out.print("\nEnter 0 for exit:");
		System.out.println("Enter choice");
	}
	
	/**
	 * Main method..!
	 * 
	 * @param args
	 * @throws Exception
	 * 
	 * @author Rashmi
	 */
	public static void main(String[] args) throws Exception {
		
		// Database connection..!
		Connection con = ConnectionConfiguration.getConnection();
		Statement st = con.createStatement();

		Scanner sc = new Scanner(System.in);
		int choice;
		
		do {

			showOptions();
			choice = sc.nextInt();
	
			switch (choice) {
			case 1:
				insert(sc, st);
				break;
	
			case 2:
				System.out.println("Enter id");
				int sid = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter name");
				String sname = sc.nextLine();
				System.out.println("Enter roll");
				int sroll = sc.nextInt();
				update(sid, sname, sroll, st);
				break;
	
			case 3:
				System.out.println("Enter id");
				int studentid = sc.nextInt();
	
				delete(studentid, st);
				break;
				
			case 4:
				showAllRecords(st);
				break;
	
			}
		} while(choice != 0);
		sc.close();
	}

}
