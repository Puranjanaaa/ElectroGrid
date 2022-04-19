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

public class MonitorRepository {
	
	Connection con=null;
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	
	
	public MonitorRepository() {
		
	  String url = "jdbc:mysql://127.0.0.1:3306/pafdb";
	  String driverName = "com.mysql.jdbc.Driver";
	  String username = "root";
	  String password = "";
	 
	  try {
		  
		  Class.forName(driverName);
		  con=DriverManager.getConnection(url,username,password);
		  
	  }catch(Exception e) {
		  System.out.print(e);
	  }
		
	}
	
	public List<Monitor> getMonitors(){
		
		List<Monitor> monitors =new ArrayList<Monitor>();
		String sql="select * from monitoringservice";
		try {
			
			Statement st=con.createStatement();
			ResultSet rs= st.executeQuery(sql);
			while(rs.next()) {
				
				Monitor m=new Monitor();
				m.setAccountNo(rs.getInt(1));
				m.setCurrentUnits(rs.getInt(2));
				m.setDate(rs.getString(3));
				
				monitors.add(m);
			}
			
		}catch(Exception e) {
			System.out.print(e);
		}
		return monitors;
	}
	
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
				
			}
			
		}catch(Exception e) {
			System.out.print(e);
		}
		return m;
	}
	
	public void create(Monitor m1) {
		
		String sql="insert into monitoringservice values (?,?,?)";
		
		try {
			
			PreparedStatement st= con.prepareStatement(sql);
			
			st.setInt(1, m1.getAccountNo());
			st.setInt(2, m1.getCurrentUnits());
			st.setString(3, formatter.format(new Date()).toString());
			
			st.executeUpdate();
			
			
		}catch(Exception e) {
			System.out.print(e);
		}
		
		
	}
	
public void update(Monitor m1) {
		
		String sql="update monitoringservice set  NoOfUnits=? where  AccountNumber=?";
		
		try {
			
			PreparedStatement st= con.prepareStatement(sql);
			
			st.setInt(2, m1.getAccountNo());
			st.setInt(1, m1.getCurrentUnits());
			//st.setString(3, formatter.format(new Date()).toString());
			
			st.executeUpdate();
			
			
		}catch(Exception e) {
			System.out.print(e);
		}
		
		
	}

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
