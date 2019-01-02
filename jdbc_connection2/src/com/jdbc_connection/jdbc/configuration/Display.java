/**
 * 
 */
package com.jdbc_connection.jdbc.configuration;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.jdbc.CallableStatement;

/**
 * @author lenovo
 *
 */
public class Display {

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
		if (count > 0) {
			System.out.println("Record inserted");
		} else {
			System.out.println("Something went wrong..!!");
		}

	}
	
	/**
	 * This method is used to add records by using stored procedure.
	 * 
	 * @param sc
	 * @param st
	 * @param con
	 * @throws SQLException
	 * 
	 * @author Rashmi
	 */
	public static void insertUsingStoredProcedure(Scanner sc, Statement st, Connection con) throws SQLException {

		System.out.println("Enter id");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter name");
		String name = sc.nextLine();
		System.out.println("Enter roll");
		int roll = sc.nextInt();

		CallableStatement cst = (CallableStatement) con.prepareCall("{call student_database.myproc(?,?,?)}");
		cst.setInt(1, id);
		cst.setString(2, name);
		cst.setInt(3, roll);

		boolean res = cst.execute();
		System.out.println("Finished..!!"+ res);
	}

	/**
	 * This method is used for updating student details.
	 * 
	 * @param id   student id
	 * @param name student name
	 * @param roll roll number
	 * @param st   { Statement }
	 * @throws SQLException
	 */
	public static void update(int id, String name, int roll, Statement st) throws SQLException {
		String updateQuery = "update studentInfo set name = '" + name + "', roll = " + roll + " where id = " + id;

		int count = st.executeUpdate(updateQuery);
		if (count > 0) {
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
		if (resCount > 0) {
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
			while (temp) {
				System.out.println("\nid: " + rs.getInt("id") + "\nname: " + rs.getString("name") + "\nroll: "
						+ rs.getInt("roll"));
				temp = rs.next();
			}

		} else {
			System.out.println("No record available in database..!!");
		}

	}

	/**
	 * This method is showing the records by using student id.
	 * 
	 * @param sc
	 * @param st
	 * @throws SQLException
	 * 
	 * @author Rashmi
	 */

	public static void showRecordsById(Scanner sc, Statement st) throws SQLException {
		System.out.println("Enter id");
		int id = sc.nextInt();

		String query = "SELECT * FROM studentInfo where id = " + id;

		ResultSet rs = st.executeQuery(query);
		boolean temp = rs.next();
		if (temp) {
			while (temp) {
				System.out.println("\nid: " + rs.getInt("id") + "\nname: " + rs.getString("name") + "\nroll: "
						+ rs.getInt("roll"));
				temp = rs.next();
			}

		} else {
			System.out.println("No record available in database..!!");
		}

	}

	/**
	 * This method is used to show records by using student name.
	 * 
	 * @param sc
	 * @param st
	 * @throws SQLException
	 * 
	 * @author Rashmi
	 */

	public static void showRecordsByName(Scanner sc, Statement st) throws SQLException {
		System.out.println("Enter name");
		String name = sc.nextLine();

		String query = "SELECT * FROM studentInfo where name = " + name;

		ResultSet rs = st.executeQuery(query);
		boolean temp = rs.next();
		if (temp) {
			while (temp) {
				System.out.println("\nid: " + rs.getInt("id") + "\nname: " + rs.getString("name") + "\nroll: "
						+ rs.getInt("roll"));
				temp = rs.next();
			}

		} else {
			System.out.println("No record available in database..!!");
		}

	}

	/**
	 * This method delete all records.
	 * 
	 * @param sc
	 * @param st
	 * @throws SQLException
	 * 
	 * @author Rashmi
	 */

	public static void DeleteAllRecord(Statement st) throws SQLException {

		String query = "DELETE FROM studentInfo";

		int resCount = st.executeUpdate(query);
		if (resCount > 0) {
			System.out.println("Record deleted ");
		} else {
			System.out.println("Record not available with this id..!!");
		}

	}

	/**
	 * This method is used to update specific records by using student id.
	 * 
	 * @param sc
	 * @param st
	 * @throws SQLException
	 * 
	 * @author Rashmi
	 */

	public static void UpdateRecord(Scanner sc, Statement st) throws SQLException {
		System.out.println("Enter id");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter name");
		String name = sc.nextLine();
		System.out.println("Enter roll");
		int roll = sc.nextInt();

		String query = " update  studentInfo set name = '" + name + "',roll = " + roll + ", +  where id = " + id;

		int count = st.executeUpdate(query);
		if (count > 0) {
			System.out.println("Record updated");
		} else {
			System.out.println("Something went wrong..!!");
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
		System.out.println("\nEnter 9 to add records by using stored procedure: ");
		System.out.print("\nEnter 0 for exit:");
		System.out.println("Enter choice");
	}

}
