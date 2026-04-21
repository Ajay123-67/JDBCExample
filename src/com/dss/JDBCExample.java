package com.dss;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCExample {

	public static void main(String[] args) {
		try {
			
			//1.load driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2 create connection
			Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/b46", "root", "root");
			//3.create a statement
			Statement st=con.createStatement();
			// 4.execute query
			ResultSet rs=st.executeQuery("select *from student");
			
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
				
			}
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}

	}

}
