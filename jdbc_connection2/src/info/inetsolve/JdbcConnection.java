package info.inetsolve;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcConnection {

	public static void main(String[] args) throws Exception {

		String url = "jdbc:mysql://localhost:3308/new_schema_default";
		String uname = "root";
		String pass = "Ankit@123";
		int s_id = 105;
		
		String query = "select s_name from student_details  where s_id = " + s_id;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, uname, pass);

		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);

		rs.next();
		
		String name = rs.getString("s_name");
		System.out.println(name);

		st.close();
		//conn.close();

	}

}
