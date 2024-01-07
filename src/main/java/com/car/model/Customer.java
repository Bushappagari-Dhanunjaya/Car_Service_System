package com.car.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ArrayList;

public class Customer {
	private String name;
	private String username;
	private String email;
	private String password;
	
	public Customer(String name, String username, String email, String password) {
		super();
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
	}
	public Customer() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int checkDetails() {
		
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			System.out.println("Driver Loaded Successfully");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/css","root","root");
			System.out.println("Connection established");
			String s="select * from customer where username=?";
			String s1="select * from customer where email=?";
			PreparedStatement pst = con.prepareStatement(s);
			PreparedStatement pst1 = con.prepareStatement(s1);
			pst.setString(1, username);
			pst1.setString(1, email);
			ResultSet resultSet = pst.executeQuery();
			ResultSet resultSet1 = pst1.executeQuery();
			
			if(resultSet.next()) {
				return -1;
			}
			else if(resultSet1.next()) {
				return 0;
			}
			else {
				
				return 1;	
			}
		} 
		catch (Exception e) {
			System.out.println("Sql exception is occured while try to login customer details");
			e.printStackTrace();
		}
		return 0;

		
	}
	public int register() {
		int row = 0;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			System.out.println("Driver Loaded Successfully");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/css","root","root");
			System.out.println("Connection established");
			String s2="insert into customer values(?,?,?,?)";
			PreparedStatement pst2=con.prepareStatement(s2);
			pst2.setString(1, name);
			pst2.setString(2, username);
			pst2.setString(3, email);
			pst2.setString(4, password);
			 row=pst2.executeUpdate();
			
		} 
		catch (Exception e) {
			System.out.println("Sql exception is occured while try to login customer details");
			e.printStackTrace();
		}
		return row;
	
	}
	
	public int validExistingUser() {
		try {
			
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			System.out.println("Driver Loaded Successfully");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/css","root","root");
			System.out.println("Connection established");
			String s="select * from customer where username=?";
			PreparedStatement pst = con.prepareStatement(s);
			pst.setString(1, username);
			ResultSet resultSet = pst.executeQuery();
			if(resultSet.next()) {
				if(resultSet.getString(4).equals(password)) {
					name=resultSet.getString(1);
					return 1;
				}
				else {
					return -1;
				}
				
			}
			else {
				
				return 0;	
			}

			
		} 
		catch (Exception e) {
			System.out.println("Sql exception is occured while try to login customer details");
			e.printStackTrace();
		}
		return 0;
	}
	
	//Get Registered Customers
	public ArrayList<Customer> getCustomers() {
		try {
			ArrayList<Customer> al = new ArrayList<Customer>();
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			System.out.println("Driver Loaded Successfully");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/css","root","root");
			System.out.println("Connection established");
			String s="select * from customer";
			Statement cst = con.createStatement();
			ResultSet resultSet = cst.executeQuery(s);
			while(resultSet.next()) {
				name=resultSet.getString(1);
				username=resultSet.getString(2);
				email=resultSet.getString(3);
				
				al.add(new Customer(name,username,email,null));
			}
			return al;
				
		} 
		catch (Exception e) {
			System.out.println("Sql exception is occured while try to login customer details");
			e.printStackTrace();
		}
		
	   return null;
	}
	
	// Retrieving a specific customer 
	public int searchCustomer() {
		try {
			
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			System.out.println("Driver Loaded Successfully");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/css","root","root");
			System.out.println("Connection established");
			String s="select * from customer where username=?";
			PreparedStatement pst = con.prepareStatement(s);
			pst.setString(1, username);
			ResultSet resultSet = pst.executeQuery();
			if(resultSet.next()) {
				name=resultSet.getString("name");
				username=resultSet.getString("username");
				email=resultSet.getString("email");
				return 1;
				
			}

		} 
		catch (Exception e) {
			System.out.println("Sql exception is occured while searching customer");
			e.printStackTrace();
		}
		return 0;
	}
	
	//Deleting a customer
	public int deleteCustomer() {
		try {
			
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			System.out.println("Driver Loaded Successfully");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/css","root","root");
			System.out.println("Connection established");
			String s="delete from customer where username=?";
			PreparedStatement pst = con.prepareStatement(s);
			pst.setString(1, username);
			int row = pst.executeUpdate();
            if(row==1) {
            	return 1;
            }
		} 
		catch (Exception e) {
			System.out.println("Sql exception is occured while searching customer");
			e.printStackTrace();
		}
		return 0;
	}
	
	
	
	
	

}
