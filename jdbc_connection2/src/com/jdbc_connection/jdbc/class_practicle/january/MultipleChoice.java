/**
 * 
 */
package com.jdbc_connection.jdbc.class_practicle.january;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * @author lenovo
 *
 */
public class MultipleChoice {
	
	public static void insertRecord(Scanner sc, Statement st) throws SQLException {
		System.out.println("Enter id");
		int s_id = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter first name");
		String f_name = sc.nextLine();
		System.out.println("Enter last name");
		String l_name = sc.nextLine();
		System.out.println("Enter roll");
		int s_roll = sc.nextInt();
		System.out.println("Enter marks");
		Double s_marks = sc.nextDouble();
		sc.nextLine(); // used for next line
		System.out.println("Enter address");
		String address = sc.nextLine();
		
		String query = "insert into studentrecords values (" + s_id + ",'" + f_name + "','" + l_name + "',"  + s_roll + "," +  s_marks + ",'" + address +"')";
		System.out.println(query);
		int count = st.executeUpdate(query);
		if (count > 0) {
			System.out.println("Record inserted");
		} else {
			System.out.println("Something went wrong..!!");
		}

		
	}
	public static void updateName(Scanner sc, Statement st) throws SQLException {
		
		System.out.println("Enter id");
		int s_id = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter first name");
		String f_name = sc.nextLine();
		System.out.println("Enter last name");
		String l_name = sc.nextLine();
		
		String updateQuery = "update studentrecords set f_name = '" + f_name + "', l_name = '" + l_name + "' ," + " where id = " + s_id;

		int count = st.executeUpdate(updateQuery);
		if (count > 0) {
			System.out.println("Record updated");
		} else {
			System.out.println("Something went wrong..!!");
		}

	}

public static void updateMarks(Scanner sc, Statement st) throws SQLException {
		
		System.out.println("Enter id");
		int s_id = sc.nextInt();
		System.out.println("Enter marks");
		int s_marks = sc.nextInt();
		
		String updateQuery = "update studentrecords set marks = " + s_marks + " where id = " + s_id;

		int count = st.executeUpdate(updateQuery);
		if (count > 0) {
			System.out.println("Record updated");
		} else {
			System.out.println("Something went wrong..!!");
		}

	}

public static void delete(int id, Statement st) throws SQLException {
	String deleteQuery = "delete from studentrecords where id = " + id;

	int resCount = st.executeUpdate(deleteQuery);
	if (resCount > 0) {
		System.out.println("Record deleted ");
	} else {
		System.out.println("Record not available with this id..!!");
	}

}
public static void showAllRecords(Statement st) throws SQLException {

	String query = "SELECT * FROM studentrecords";

	ResultSet rs = st.executeQuery(query);
	boolean temp = rs.next();
	if (temp) {
		while (temp) {
			System.out.println("\ns_id: " + rs.getInt("s_id") + "\nf_name: " + rs.getString("firstname") +  "\nl_name: " + rs.getString("lastname") +
					 "\nroll: "	+ rs.getInt("roll") +"\nmarks:" +rs.getInt("marks")+ "\naddress: " + rs.getString("address"));
			temp = rs.next();
		}

	} else {
		System.out.println("No record available in database..!!");
	}

}

public static void showRecordsById(Scanner sc, Statement st) throws SQLException {
	System.out.println("Enter id");
	int id = sc.nextInt();

	String query = "SELECT * FROM studentrecords where id = " + id;

	ResultSet rs = st.executeQuery(query);
	boolean temp = rs.next();
	if (temp) {
		while (temp) {
			System.out.println("\nid: " + rs.getInt("id") + "\nf_name: " + rs.getString("f_name") + "\nl_name: " + rs.getString("l_name") + "\nroll: "
					+ rs.getInt("roll") + "\nmarks:" +rs.getInt("marks")+ "\naddress: " + rs.getString("address"));
			temp = rs.next();
		}

	} else {
		System.out.println("No record available in database..!!");
	}

}

public static void showRecordsByName(Scanner sc, Statement st) throws SQLException {
	System.out.println("Enter name");
	String name = sc.nextLine();

	String query = "SELECT * FROM studentrecords where name = " + name;

	ResultSet rs = st.executeQuery(query);
	boolean temp = rs.next();
	if (temp) {
		while (temp) {
			System.out.println("\nid: " + rs.getInt("id") + "\nf_name: " + rs.getString("f_name") + "\nl_name: " + rs.getString("l_name") + "\nroll: "
					+ rs.getInt("roll") + "\nmarks:" +rs.getInt("marks")+ "\naddress: " + rs.getString("address"));
			temp = rs.next();
		}

	} else {
		System.out.println("No record available in database..!!");
	}

}


public static void showOptions() {
	System.out.print("Enter 1 for insert data: ");
	System.out.print("\nEnter 2 for update name: ");
	System.out.print("\nEnter 3 for update marks: ");
	System.out.print("\nEnter 4 for delete data: ");
	System.out.print("\nEnter 5 to show all records: ");
	System.out.print("\nEnter 6 to show specific record by id: ");
	System.out.print("\nEnter 7 to show specific record by name:");
	
	System.out.print("\nEnter 0 for exit:");
	System.out.println("Enter choice");
}

}


