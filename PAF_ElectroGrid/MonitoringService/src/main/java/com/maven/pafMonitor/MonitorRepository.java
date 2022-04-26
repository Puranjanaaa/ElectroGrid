package com.maven.pafMonitor;

import java.text.SimpleDateFormat;  

import java.util.Date;  
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//model class which interacts with the database

public class MonitorRepository {
	
	Connection con=null;
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	
	
	public MonitorRepository() {
		
		//establishing database connection 
	  String url = "jdbc:mysql://127.0.0.1:3306/pafdb";
	  String driverName = "com.mysql.cj.jdbc.Driver";
	  String username = "root";
	  String password = "";
	 
	  try {
		  
		  Class.forName(driverName);
		  con=DriverManager.getConnection(url,username,password);
		  
	  }catch(Exception e) {
		  System.out.print(e);
	  }
		
	}
	
	//method to retrieve all records
	public String getMonitors(){
		
		
		String sql="select * from monitoringservice";
		try {
			
			Statement st=con.createStatement();
			String output = "<table border=\"1\"><tr><th>Account Number</th>" + "<th>Number of Units</th> "
					+ "<th>Date and Time</th>" + "<th>Additional Units</th></tr>";
			ResultSet rs= st.executeQuery(sql);
			
			while(rs.next()) {
				
				Monitor m=new Monitor();
				m.setAccountNo(rs.getInt(1));
				m.setCurrentUnits(rs.getInt(2));
				m.setDate(rs.getString(3));
				m.setAdditionalUnits(rs.getInt(4));
				
				output += "<tr><td>" + m.getAccountNo() + "</td>";
				output += "<td>" + m.getCurrentUnits() + "</td>";
				output += "<td>" + m.getDate() + "</td>";
				output += "<td>" + m.getAdditionalUnits() + "</td>";
			}
			output += "</table>";
			return output;
			
		}catch(Exception e) {
			System.out.print(e);
			return "Error occured during retrieving data";
		}
		
	}
	
	//method to retrieve single record
	public Monitor getMonitor(int accNo) {
		
		Monitor m=new Monitor();
		String sql="select * from monitoringservice where AccountNumber="+accNo;
		try {
			
			Statement st=con.createStatement();
			ResultSet rs= st.executeQuery(sql);
			if(rs.next()) {
				
				m.setAccountNo(rs.getInt(1));
				m.setCurrentUnits(rs.getInt(2));
				m.setDate(rs.getString(3));
				m.setAdditionalUnits(rs.getInt(4));
				
			}
			
		}catch(Exception e) {
			System.out.print(e);
		}
		return m;
	}
	
	//create method
	public void create(Monitor m1) {
		
		String sql="insert into monitoringservice values (?,?,?,?)";
		int addUnits;
		
		try {
			
			 addUnits= m1.getCurrentUnits()-100;
			if (addUnits < 0) {
				addUnits=0;
			}
			
			PreparedStatement st= con.prepareStatement(sql);
			
			st.setInt(1, m1.getAccountNo());
			st.setInt(2, m1.getCurrentUnits());
			st.setString(3, formatter.format(new Date()).toString());
			st.setInt(4, addUnits);;
			st.executeUpdate();
			
			
		}catch(Exception e) {
			System.out.print(e);
		}
		
		
	}
	
	//update method
	public void update(Monitor m1) {
		
		String sql="update monitoringservice set  NoOfUnits=?, AdditionalUnits=?, DateTime=? where  AccountNumber=?";

		 int addUnits= m1.getCurrentUnits()-100;
		if (addUnits < 0) {
			addUnits=0;
		}
		
		try {
			
			PreparedStatement st= con.prepareStatement(sql);
			
			
			st.setInt(1, m1.getCurrentUnits());
			st.setInt(2, addUnits);
			st.setString(3, formatter.format(new Date()).toString());
			st.setInt(4, m1.getAccountNo());
			
			st.executeUpdate();
			
			
		}catch(Exception e) {
			System.out.print(e);
		}
		
		
	}

	//delete method
	public void delete(int accNo) {
		String sql="delete from monitoringservice  where  AccountNumber=?";
	
		try {
		
		PreparedStatement st= con.prepareStatement(sql);
		
		st.setInt(1, accNo);
		//st.setInt(1, m1.getCurrentUnits());
		//st.setString(3, formatter.format(new Date()).toString());
		
		st.executeUpdate();
		
		
	}catch(Exception e) {
		System.out.print(e);
	}
	
	
}



}
