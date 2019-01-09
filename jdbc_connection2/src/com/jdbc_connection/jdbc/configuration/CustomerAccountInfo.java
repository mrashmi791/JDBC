/**
 * 
 */
package com.jdbc_connection.jdbc.configuration;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * @author Rashmi
 *
 */
public class CustomerAccountInfo {

	/**
	 * @param args
	 * 
	 * @author Rashmi
	 * @throws Exception
	 */
	public static void main(String[] args) throws SQLException {

		Scanner sc = new Scanner(System.in);
		Connection con = null;
		try {
			System.out.println("Enter debit account");
			int faccno = sc.nextInt();

			System.out.println("Enter credit account");
			int taccno = sc.nextInt();

			System.out.println("Enter ammount");
			int ammount = sc.nextInt();

			con = ConnectionConfiguration.getConnection("bank_account");
			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery("select * from accountinfo");
			System.out.println(rs.toString());

			int balance1 = 0, balance2 = 0;
			boolean temp = rs.next();
			if (temp) {
				while (temp) {
					System.out.println(" " + rs.getInt(1) + "--->" + rs.getInt(3));
					if (rs.getInt(1) == faccno)
						balance1 = rs.getInt(3);
					if (rs.getInt(1) == taccno)
						balance2 = rs.getInt(3);
					temp = rs.next();

				}
			}
			con.setAutoCommit(false);

			System.out.println(faccno + " " + balance1);
			System.out.println(taccno + " " + balance2);
			st.executeUpdate(
					"update accountinfo set balance = " + (balance1 - ammount) + " where account_no = " + faccno);
			st.executeUpdate(
					"update accountinfo set balance = " + (balance2 + ammount) + " where account_no = " + taccno);

			con.commit();
			System.out.println("Amount transferred");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// con.close();
			sc.close();
		}

	}

}
