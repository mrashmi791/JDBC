		package com.jdbc_connection.jdbc.configuration;
		
		import java.sql.Connection;
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
				Connection con = ConnectionConfiguration.getConnection("student_database");
				Statement st = con.createStatement();
		
				Scanner sc = new Scanner(System.in);
				int choice;
				
				do {
		
					Display.showOptions();
					choice = sc.nextInt();
			
					switch (choice) {
					case 1:
						Display.insert(sc, st);
						break;
			
					case 2:
						System.out.println("Enter id");
						int sid = sc.nextInt();
						sc.nextLine();
						System.out.println("Enter name");
						String sname = sc.nextLine();
						System.out.println("Enter roll");
						int sroll = sc.nextInt();
						Display.update(sid, sname, sroll, st);
						break;
			
					case 3:
						System.out.println("Enter id");
						int studentid = sc.nextInt();
			
						Display.delete(studentid, st);
						break;
						
					case 4:
						Display.showAllRecords(st);
						break;
			
					case 5:
						Display.showRecordsById(sc,st);
						break;
			
					case 6:
						Display.showRecordsByName(sc,st);
						break;
			
					case 7:
						Display.DeleteAllRecord(st);
						break;
			
					case 8:
						Display.UpdateRecord(sc,st);
						break;
						
					case 9:
						Display.insertUsingStoredProcedure(sc, st, con);
			
					}
				} while(choice != 0);
				sc.close();
			}
		
		}
