/**
 * 
 */
package com.jdbc_connection.jdbc.configuration;

import java.sql.Connection;
import java.sql.Statement;

import com.mysql.cj.jdbc.CallableStatement;

/**
 * @author lenovo
 *
 */
public class CallableStatementExample {

	/**
	 * @param args
	 * 
	 * @author Rashmi
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		Connection con = ConnectionConfiguration.getConnection();
		Statement st = con.createStatement();


		CallableStatement cst = (CallableStatement) con.prepareCall("{call update_student_procedure(?,?,?)}");
		cst.setInt(1, 1);
		cst.setString(2, "Ankur manjhi");
		cst.setInt(3, 39);
	
		
		

		boolean res = cst.execute();
		System.out.println("Finished..!!"+ res);
		
		Display.showAllRecords(st);
		
		st.close();
	}

}


