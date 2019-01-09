/**
 * 
 */
package com.jdbc_connection.jdbc.configuration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * Insert date in database.
 * 
 * @author Rashmi
 *
 */
public class InsertDateInDatabase {

	/**
	 * @param args
	 * 
	 * @author Rashmi
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		Connection con =ConnectionConfiguration.getConnection("employee_database");
		Statement st = con.createStatement();
		
		Scanner sc = new Scanner(System.in);
		
		PreparedStatement pst = con.prepareStatement("insert into employee values(?,?,?,?)");
		
		System.out.println("Enter employee id");
		int emp_id = sc.nextInt();
		pst.setInt(1, emp_id);
		
		sc.nextLine();
		
		System.out.println("Enter employee name");
		String emp_name = sc.nextLine();
		pst.setString(2, emp_name);
		
		
		System.out.println("Enter employee DOB");
		String dob = sc.nextLine();
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date ud1 = sdf.parse(dob);
		System.out.println(ud1);
		long ms1 = ud1.getTime();
		java.sql.Date sd1 = new java.sql.Date(ms1);
		pst.setDate(3,sd1);
		System.out.println(sd1);
		//System.out.println("Enter employee DOj");
		//String doj = sc.nextLine();
		
		//java.util.Date ud2 = sdf.parse(doj);
		//long ms2 = ud2.getTime();
		
		long ms2 = System.currentTimeMillis();
		java.sql.Date sd2 = new java.sql.Date(ms2);
		pst.setDate(4,sd2);
		
		int count = pst.executeUpdate();
		System.out.println(count);
	}

}


