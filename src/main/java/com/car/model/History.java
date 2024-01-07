package com.car.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class History {
	
	private String username;
	private String carmodel;
	private String carregno;
	private String service;
	private String date;
	
		public History(String username, String carmodel, String carregno, String service, String date) {
		super();
		this.username = username;
		this.carmodel = carmodel;
		this.carregno = carregno;
		this.service = service;
		this.date = date;
	}
		public History() {
			
		}

		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getCarmodel() {
			return carmodel;
		}
		public void setCarmodel(String carmodel) {
			this.carmodel = carmodel;
		}
		public String getCarregno() {
			return carregno;
		}
		public void setCarregno(String carregno) {
			this.carregno = carregno;
		}
		public String getService() {
			return service;
		}
		public void setService(String service) {
			this.service = service;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public ArrayList<History> historyOfServices() {
			try {
				ArrayList<History> hs = new ArrayList<History>();
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				System.out.println("Driver Loaded Successfully");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/css","root","root");
				System.out.println("Connection established");
				String s="select * from history";
				Statement cst = con.createStatement();
				ResultSet resultSet = cst.executeQuery(s);
				
				while(resultSet.next()) {
					
			    username=resultSet.getString(1);
			    carmodel=resultSet.getString(2);
			    carregno=resultSet.getString(3);
			    service=resultSet.getString(4);
			    date=resultSet.getString(5);
			    
				hs.add(new History(username,carmodel,carregno,service,date));
				
				}
				return hs;
					
			} 
			catch (Exception e) {
				System.out.println("Sql exception is occured while getting history details");
				e.printStackTrace();
			}
			
		   return null;
		}
		public ArrayList<History> getHistory() {
			try {
				ArrayList<History> hs = new ArrayList<History>();
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				System.out.println("Driver Loaded Successfully");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/css","root","root");
				System.out.println("Connection established");
				String s="select * from history where username=?";
				PreparedStatement pst = con.prepareStatement(s);
				pst.setString(1, username);
				ResultSet resultSet = pst.executeQuery();
				
				while(resultSet.next()) {
			    username=resultSet.getString(1);
			    carmodel=resultSet.getString(2);
			    carregno=resultSet.getString(3);
			    service=resultSet.getString(4);
			    date=resultSet.getString(5);
			    
				hs.add(new History(username,carmodel,carregno,service,date));
				
				}
				return hs;
					
			} 
			catch (Exception e) {
				System.out.println("Sql exception is occured while getting history details");
				e.printStackTrace();
			}
			
		   return null;
		}
		
}
