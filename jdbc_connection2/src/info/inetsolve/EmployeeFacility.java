/**
 * 
 */
package info.inetsolve;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author lenovo
 *
 */
public class EmployeeFacility {
	Statement st = null;

	String status = "";
	public EmployeeFacility() {
		try {
			
			Driver d = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(d);
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/student_database", "root", "Ankit@123");
			 st = con.createStatement();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public String add(int id, String name, int roll) {
		
		try {
			
			ResultSet rs = st.executeQuery("select * from studentinfo where id = " +id);
			boolean temp = rs.next();
			
			if(temp == true) {
				status = "Data inserted successfully";
			} else {
				int count = st.executeUpdate("insert into studentinfo values("+ id +",'" +name +"' , "+roll+")");
				if(count == 1 ) {
					status = "Data inserted successfully";
				} else {
					status = "Data not inserted";
				}
				
				
			}
			
		} catch (Exception e) {
			
			status = "Data not inserted";
			e.printStackTrace();
		}
		
		return status;
		
	}
}


