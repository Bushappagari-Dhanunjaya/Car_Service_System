package com.car.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class Car {
	private String username;
	private String carmodel;
	private String cartype;
	private String carregno;
	private String carservice;
	private String carstatus;
	
	public Car(String username, String carmodel, String cartype, String carregno, String carservice,
			String carstatus) {
		super();
		this.username = username;
		this.carmodel = carmodel;
		this.cartype = cartype;
		this.carregno = carregno;
		this.carservice = carservice;
		this.carstatus = carstatus;
	}
	public Car() {
		
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
	public String getCartype() {
		return cartype;
	}
	public void setCartype(String cartype) {
		this.cartype = cartype;
	}
	public String getCarregno() {
		return carregno;
	}
	public void setCarregno(String carregno) {
		this.carregno = carregno;
	}
	public String getCarservice() {
		return carservice;
	}
	public void setCarservice(String carservice) {
		this.carservice = carservice;
	}
	public String getCarstatus() {
		return carstatus;
	}
	public void setCarstatus(String carstatus) {
		this.carstatus = carstatus;
	}

	public int setCarDetails() {
		int row = 0;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			System.out.println("Driver Loaded Successfully");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/css","root","root");
			System.out.println("Connection established");
			String s="insert into car values(?,?,?,?,?,?)";
			PreparedStatement pst=con.prepareStatement(s);
			pst.setString(1, username);
			pst.setString(2, carmodel);
			pst.setString(3, cartype);
			pst.setString(4, carregno);
			pst.setString(5, "Pending");
			pst.setString(6, "Pending");
			 row=pst.executeUpdate();
			 return row;
			
			
		} 
		catch (Exception e) {
			System.out.println("Sql exception is occured while try to login customer details");
			e.printStackTrace();
		}
		
		return row;
	
		
	}
	
	public int serviceRequest() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/css", "root", "root");
			
			String s = "update car set service=?, status=? where car_reg_no=? AND username=?";
			pstmt = con.prepareStatement(s);
			pstmt.setString(1, carservice);
			pstmt.setString(2, "Pending");
			pstmt.setString(3, carregno);
			pstmt.setString(4, username);
			int row = pstmt.executeUpdate();
		
			return row;
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

		
		return 0;

	}
	
	
	public int checkRegNo() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		try {
			
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/css", "root", "root");
			
			String s = "select * from car where car_reg_no=?";
			pstmt = con.prepareStatement(s);
			pstmt.setString(1, carregno);
			ResultSet result = pstmt.executeQuery();
			
			if(result.next()) {
				 if(result.getString("car_reg_no").equals(carregno)) {
					  return 1;
				  }
				  else {
					  return 0;
				  }
			}
		 
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	
	public int editCarDetails() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/css", "root", "root");
			
			String s = "update car set car_model=?, car_type=? where car_reg_no=? AND username=?";
			pstmt = con.prepareStatement(s);
			pstmt.setString(1, carmodel);
			pstmt.setString(2, cartype);
			pstmt.setString(3, carregno);
			pstmt.setString(4, username);
			int row = pstmt.executeUpdate();
		
			return row;
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
		
	}
	
	public int checkService() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		try {
			
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/css", "root", "root");
			
			String s = "select * from car where car_reg_no=? AND username=? and service!=?";
			pstmt = con.prepareStatement(s);
			pstmt.setString(1, carregno);
			pstmt.setString(2, username);
			pstmt.setString(3, "NULL");
			ResultSet result = pstmt.executeQuery();
			
			if(result.next()) {
				carmodel=result.getString("car_model");
				cartype=result.getString("car_type");
				carservice=result.getString("service");
				carstatus=result.getString("status");
				return 1;
			}
			else {
				return 0;
			}
		 
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public ArrayList<Car> getServiceRequests() {
		try {
			ArrayList<Car> al = new ArrayList<Car>();
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			System.out.println("Driver Loaded Successfully");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/css","root","root");
			System.out.println("Connection established");
			String s="select * from car where status=?";
			PreparedStatement pst = con.prepareStatement(s);
			pst.setString(1, "Pending");
			ResultSet resultSet = pst.executeQuery();
			
			while(resultSet.next()) {
				
		    username=resultSet.getString(1);
		    carmodel=resultSet.getString(2);
		    cartype=resultSet.getString(3);
		    carregno=resultSet.getString(4);
		    carservice=resultSet.getString(5);
		    carstatus=resultSet.getString(6);
		    System.out.println(username);
			al.add(new Car(username,carmodel,cartype,carregno,carservice,carstatus));
			
			}
			return al;
				
		} 
		catch (Exception e) {
			System.out.println("Sql exception is occured while try to login customer details");
			e.printStackTrace();
		}
		
	   return null;
	}
	
	//This is for updating the service
	public int updateService() {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet res = null;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/css", "root", "root");
			String s = "update car set status=? where username=?";
			pst = con.prepareStatement(s);
			pst.setString(1, "Completed");
			pst.setString(2, username);
			int row = pst.executeUpdate();
			if(row>0) {
				String s2="select * from car where username=? and status=?";
				PreparedStatement pst2 = con.prepareStatement(s2);
				pst2.setString(1, username);
				pst2.setString(2, "Completed");
				ResultSet RS = pst2.executeQuery();
				if(RS.next()) {
					String rn=RS.getString("car_reg_no");
					String cm=RS.getString("car_model");
					String service2=RS.getString("service");
					String s3="insert into history values(?,?,?,?,?)";
					PreparedStatement pst3 = con.prepareStatement(s3);
					pst3.setString(1, username);
					pst3.setString(2, cm);
					pst3.setString(3, rn);
					pst3.setString(4, service2);
				    Date date = new Date();
					java.sql.Date d=new java.sql.Date(date.getTime());
					pst3.setDate(5, d);
					pst3.executeUpdate();
					
				}
				
						
			}
			return row;
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
		
	}
	
	
}
