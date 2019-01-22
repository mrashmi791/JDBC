/**
 * 
 */
package com.jdbc_connection.jdbc.class_practicle.january;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;


/**
 * @author Rashmi
 *
 */
public class JdbcRunner {

	/**
	 * @param args
	 * 
	 * @author Rashmi
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		Connection conn = JdbcConnection.getConnection();
		Statement st = conn.createStatement();
		
		Scanner sc = new Scanner(System.in);
		int choice;
		

		do {

			MultipleChoice.showOptions();
			choice = sc.nextInt();
	
			switch (choice) {
			case 1:
				MultipleChoice.insertRecord(sc, st);
				break;
	
			case 2:
				
				MultipleChoice.updateName(sc, st);
				break;
	
			case 3:
				
				MultipleChoice.updateMarks(sc, st);
				break;
			case 4:
				System.out.println("Enter id");
				int studentid = sc.nextInt();
	
				MultipleChoice.delete(studentid, st);
				break;
				
			case 5:
				MultipleChoice.showAllRecords(st);
				break;
	
			case 6:
				MultipleChoice.showRecordsById(sc,st);
				break;
	
			case 7:
				MultipleChoice.showRecordsByName(sc,st);
				break;
	
			
			}
		} while(choice != 0);
		sc.close();
		
	}

}


