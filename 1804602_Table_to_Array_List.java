package com.higradius;

import java.util.*;
import java.sql.*;
import java.util.ArrayList;

public class TableToArrayList {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/infinity war","root","Fumo&!0724");
		Statement stmt = con.createStatement();		
		ResultSet rs = stmt.executeQuery("select * from avengers");
		ArrayList<Avenger> avgrList = new ArrayList<>();	
		while(rs.next()) {
			Avenger avgrObj= new Avenger();
			avgrObj.setFname(rs.getString("First Name"));
			avgrObj.setLname(rs.getString("Last Name"));
			avgrObj.setSerial(rs.getInt("Serial"));
			avgrObj.setAlias(rs.getString("Alias"));
			avgrObj.setQuote(rs.getString("Quote"));
			avgrList.add(avgrObj);
			}
		
		System.out.println("Enter 1 to fetch and display whole table data or 2 to fetch Alias, Quote Column Data using Serial.");
		boolean pass = false;
		while(pass==false) {
			try {
				int x = sc.nextInt();
				if (x==1) {
					for (Avenger obj : avgrList) {
							System.out.print("First Name: "+obj.getFname()+", ");
							System.out.print("Last Name: "+obj.getLname()+", ");
							System.out.print("Serial: "+obj.getSerial()+", ");
							System.out.print("Alias: "+obj.getAlias()+", ");
							System.out.print("Quote: "+obj.getQuote());
							System.out.println();
						}
					pass=true;
					}
				else if (x==2) {
					System.out.println("Enter Serial Number");
					int s = sc.nextInt();
					for (Avenger obj : avgrList) {
						if (s==obj.getSerial()) {
							System.out.print("Alias: "+obj.getAlias()+", ");
							System.out.print("Quote: "+obj.getQuote());
							System.out.println();
						}
					}
					pass=true;
				}
				else {
					System.out.println("ERROR: You must enter something else than 1 and 2 \nTry Again!");
				}
			}
			catch(Exception e) {
				System.out.println("ERROR: You must enter something else than 1 and 2 \nTry Again!");
				sc.next();
			}
		}
	}
}
