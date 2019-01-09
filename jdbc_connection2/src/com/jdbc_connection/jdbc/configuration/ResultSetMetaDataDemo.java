/**
 * 
 */
package com.jdbc_connection.jdbc.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

/**
 * Use ResultSetMetaData to access information like column name, column type ...etc.
 * 
 * @author rashmi
 *
 */
public class ResultSetMetaDataDemo {

	/**
	 * @param args
	 * 
	 * @author Rashmi
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/student_database","root" , "Ankit@123");
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery("select * from studentinfo ");
		ResultSetMetaData rsmd = rs.getMetaData();
		
		int cols = rsmd.getColumnCount();
		
		System.out.println("Number of columns: " + cols);
		
		for(int i = 1; i <= cols; i++) {
			System.out.println(rsmd.getColumnName(i));
			System.out.println(rsmd.getColumnType(i));
			System.out.println(rsmd.getTableName(i));
			System.out.println(rsmd.getCatalogName(i));
			System.out.println(rsmd.getColumnTypeName(i));
			System.out.println(rsmd.getSchemaName(i));
			//System.out.println()
		}
		
				

	}

}


