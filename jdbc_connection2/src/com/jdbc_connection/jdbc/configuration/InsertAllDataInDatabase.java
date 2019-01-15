/**
 * 
 */
package com.jdbc_connection.jdbc.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * @author lenovo
 *
 */
public class InsertAllDataInDatabase {
	
	public static void showOptions() {
		System.out.println("Enter 1 for insert the data");
		
		System.out.println("Enter 2 for display the data by id");
		System.out.println("Enter 3 for insert the data by stored procedure");
		System.out.print("\nEnter 4 to show all records: ");
		System.out.print("\nEnter 0 for exit:");
		System.out.println("Enter choice");
	}
	
	public static void insert(Scanner sc, PreparedStatement pst, Connection con) throws Exception, SQLException {
		System.out.println("Enter employee id");
		int emp_id = sc.nextInt();
		pst.setInt(1,emp_id);
		
		System.out.println("Enter employee name");
		String emp_name = sc.nextLine();
		pst.setString(2,emp_name);
		sc.nextLine();
		
		System.out.println("Enter employee address");
		String address = sc.nextLine();
		pst.setString(3,address);
		sc.nextLine();
		
		System.out.println("Enter employee date of birth");
		String dob = sc.nextLine();
		InsertAllDataInDatabase.date(dob, pst);
		
	
		
		System.out.println("Enter employee image");
		String path = sc.nextLine();
	
		
		InsertAllDataInDatabase.image(path, pst);
		
		
		
	}
	
	public static void image(String path, PreparedStatement pst ) throws FileNotFoundException, SQLException {
		File f = new File(path);
		FileInputStream fis = new FileInputStream(f);
		
		pst.setBlob(6, fis);

		int retCount = pst.executeUpdate();

		if (retCount > 0) {
			System.out.println("Image is inserted in Database");
	
		} else {
			System.out.println("Image is Not inserted in Database");
		}
	}
	
	
	
	public static void date(String dob, PreparedStatement pst) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date ud1 = sdf.parse(dob);
		
		long ms1 = ud1.getTime();
		java.sql.Date sd1 = new java.sql.Date(ms1);
		pst.setDate(4,sd1);
	
		
		long ms2 = System.currentTimeMillis();
		java.sql.Date sd2 = new java.sql.Date(ms2);
		pst.setDate(5,sd2);
		
	}
	
	
	
	public static void show(Connection con, Scanner sc) throws Exception {
		Statement st = con.createStatement();
		System.out.println("Enter id");
		int emp_id = sc.nextInt();

		String query = "SELECT * FROM employeeinformation where emp_id = " + emp_id;

		ResultSet rs = st.executeQuery(query);
		boolean temp = rs.next();
		if (temp) {
			while (temp) {
				System.out.println("\nemp_id: " + rs.getInt("emp_id") + "\nemp_name: " + rs.getString("emp_name") +  "\naddress: " + rs.getString("address") + "\ndate: " +rs.getDate("dob") + "\ndate: " +rs.getDate("doj") + "\nimage: " +rs.getBlob("image"));
				temp = rs.next();
			}

		} else {
			System.out.println("No record available in database..!!");
		}
	}
	
	
	
	
	
	public static void insertByProcedure (Connection con, Scanner sc) throws Exception {
		
		CallableStatement cst = con.prepareCall("{call employee_procedure(?,?,?,?)}");
		
		//Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter manager id");
		int id = sc.nextInt();
		
		cst.setInt(1, id);
		
		System.out.println("Enter manager name");
		String name = sc.nextLine();
		
		cst.setString(2, name);
		
		//sc.nextLine();
		
		System.out.println("Enter manager address");
		String add = sc.nextLine();
		
		cst.setString(3, add);
		
		System.out.println("Enter manager sallary");
		int sal = sc.nextInt();
		
		cst.setInt(4, sal);
		
		cst.execute();
		
	}

	
	
	
	public static void showAllRecords(Connection con) throws SQLException {

		Statement st = con.createStatement();
		String query ="SELECT * FROM employeeinformation";

		ResultSet rs = st.executeQuery(query);
		boolean temp = rs.next();
		if (temp) {
			System.out.println("\nemp_id: " + rs.getInt("emp_id") + "\nemp_name: " + rs.getString("emp_name") +  "\naddress: " + rs.getString("address") + "\ndate: " +rs.getDate("dob") + "\ndate: " +rs.getDate("doj") + "\nimage: " +rs.getBlob("image"));
			temp = rs.next();
			}

		 else {
			System.out.println("No record available in database..!!");
		}

	}

	

}










