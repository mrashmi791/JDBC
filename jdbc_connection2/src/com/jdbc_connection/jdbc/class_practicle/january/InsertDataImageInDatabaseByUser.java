/**
 * 
 */
package com.jdbc_connection.jdbc.class_practicle.january;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * This program will take images and data from the user.
 * 
 * @author Rashmi
 *
 */
public class InsertDataImageInDatabaseByUser {

	/**
	 * @param args
	 * 
	 * @author Rashmi
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/employee_database", "root",
				"Ankit@123");

		Scanner sc = new Scanner(System.in);

		PreparedStatement pst = con.prepareStatement("insert into newemployee values(?,?)");

		System.out.println("Enter employee name");
		String emp_name = sc.nextLine();
		pst.setString(1, emp_name);

		System.out.println("Enter employee image path");
		String path = sc.nextLine();

		File f = new File(path);
		FileInputStream fis = new FileInputStream(f);
		System.out.println(f + ""+ fis);
		pst.setBlob(2, fis);

		int retCount = pst.executeUpdate();

		if (retCount > 0) {
			System.out.println("Image is inserted in Database");
			display(con, emp_name);

		} else {
			System.out.println("Image is Not inserted in Database");
		}

		sc.close();

	}

	public static void display(Connection con, String name) throws SQLException, IOException {
		Statement st = con.createStatement();
		String filePath = "E:\\images\\output_image\\" + name + "_" +System.currentTimeMillis() + ".jpg";
		File f = new File(filePath);
		FileOutputStream fos = new FileOutputStream(f);

		ResultSet rs = st.executeQuery("select * from newemployee where emp_name='" + name +"'");
		if (rs.next()) {
			fos.write(rs.getBytes(2));
		}

		fos.close();

	}

}
