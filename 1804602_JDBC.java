package com.higradius;
import java.sql.*;

public class JDBC {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/infinity war","root","Fumo&!0724");
		
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select *from avengers");
		
		while(rs.next()) {
			String fName = rs.getString("First Name");
			String lName = rs.getString("Last Name");
			int serial = rs.getInt("Serial");
			String alias = rs.getString("Alias");
			String quote = rs.getString("Quote");
			System.out.println(fName+" "+lName+" "+serial+" "+alias+" "+quote);
		}
		st.close();
		con.close();
		

	}

}
