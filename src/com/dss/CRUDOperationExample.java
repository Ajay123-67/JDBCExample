package com.dss;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class CRUDOperationExample {

	public static void main(String[] args) throws Exception{
		
		Scanner sc=new Scanner(System.in);
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/b46","root","root");
		while(true) {
			System.out.println("\n1.insert 2.view 3.update 4.delete 5.exist");
			int choice=sc.nextInt();
			
			switch(choice) {
			case 1:
				System.out.println("Enter Id:");
				int id=sc.nextInt();
				sc.nextLine();
				
				System.out.println("Enter Name:");
				String Name=sc.nextLine();
				
				System.out.println("Enter Gmail:");
				String Gmail=sc.nextLine();
				
				System.out.println("Enter Grade:");
				String Grade=sc.nextLine();
				
				PreparedStatement ps=con.prepareStatement("insert into student values(?,?,?,?)");
				ps.setInt(1, id);
				ps.setString(2, Name);
				ps.setString(3, Gmail);
				ps.setString(4, Grade);
				ps.executeUpdate();
				System.out.println("student inserted successfully !");
				break;
			case 2:
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("select*from student");
			    while(rs.next()) {
			    	System.out.println(rs.getInt(1)+"  "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
			    }
				System.out.println("Student details show successfully !");
				break;
			case 3:
				
				System.out.println("Enter id to update:");
				int uid = sc.nextInt();

				PreparedStatement ps1 = con.prepareStatement(
				    "UPDATE student SET Grade=? WHERE Id=?"
				);

				ps1.setString(1, "A+");
				ps1.setInt(2, uid);

				int rows = ps1.executeUpdate();

				System.out.println(rows + " record(s) updated!");
				break;
			case 4:
				System.out.println("Enter id to delete student :");
				int did=sc.nextInt();
				PreparedStatement ps2=con.prepareStatement("delete from student where id=?");
				ps2.setInt(1, did);
				
				ps2.executeUpdate();
				System.out.println("student delete successfully !");
				break;
			case 5:
				con.close();
				System.exit(0);
				
			}
	
		}
		

	}

}
