package com.car.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Admin {
	private String name;
	private String password;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int checkAdmin() {
		try {
			System.out.println("Entered into check admin");
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			System.out.println("Driver Loaded Successfully");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/css","root","root");
			System.out.println("Connection established");
			String s="select * from admin where name=?";
			PreparedStatement pst = con.prepareStatement(s);	
			pst.setString(1, name);
			ResultSet resultSet = pst.executeQuery();
			if(resultSet.next()) {
				if(resultSet.getString(2).equals(password)) {
					System.out.println("username and password are equal");
					return 1;
				}
				else {
					System.out.println("incorrect password");
					return -1;
				}
			}
			else {
				System.out.println("incorrect username");
				return 0;
			}

			
		} 
		catch (Exception e) {
			System.out.println("Sql exception is occured while try to login admin details");
			e.printStackTrace();
		}

		return 0;
		
	}
	
	

}
