package com.ElectroGrid.RedNotice;

import java.util.ArrayList;

import java.util.List;
import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class RedNoticeRepository {

	//List<RedNotice> rednotice;
	
	Connection con = null;
	
	
	public RedNoticeRepository() {
		
		/*rednotice = new ArrayList<>();
		
		RedNotice r1 = new RedNotice();
		r1.setAccountID(2);
		r1.setCharges(5400);
		r1.setCustomerName("Sachi");
		r1.setDuedate("25/07/2021");
		r1.setUnits(34);
		
		RedNotice r2 = new RedNotice();
		r2.setAccountID(5);
		r2.setCharges(5555);
		r2.setCustomerName("Sachi");
		r2.setDuedate("25/07/2021");
		r2.setUnits(34);
		
		rednotice.add(r1);
		rednotice.add(r2);*/
		
		String url = "jdbc:mysql://127.0.0.1:3306/RedNotice";
	 
		String username = "root";
		String password = "admin";
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			  con=DriverManager.getConnection(url,username,password);

			
			
		} catch (Exception e) {
		
			System.out.println(e);
		}

	
	}
	
	
	public List<RedNotice> getRedNotice()
	{
		List<RedNotice> rednotice = new ArrayList<>();
		String sql = "select * from rednotice";
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				RedNotice r = new RedNotice();
				r.setAccountID(rs.getInt(1));
				r.setCustomerName(rs.getString(2));
				r.setDuedate(rs.getString(3));
				r.setUnits(rs.getFloat(4));
				r.setCharges(rs.getDouble(5));
				
				rednotice.add(r);
				
			}
			
		}
		catch (Exception e) {
				System.out.println(e);
		}
		
		return rednotice;
	}
	
	public RedNotice getRedNotice(int AccountID)
	{

			String sql = "select * from rednotice where AccountID="+AccountID;
			RedNotice r = new RedNotice();
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next()) {
				
				r.setAccountID(rs.getInt(1));
				r.setCustomerName(rs.getString(2));
				r.setDuedate(rs.getString(3));
				r.setUnits(rs.getFloat(4));
				r.setCharges(rs.getDouble(5));
				
 				
			}
			
		}
		catch (Exception e) {
				System.out.println(e);
		}
		
		return r;
		
	}


	public void create(RedNotice r1) {
		
		String sql = "insert into rednotice values (?,?,?,?,?)";
		try {
			PreparedStatement st= con.prepareStatement(sql);
			st.setInt(1, r1.getAccountID());
			st.setString(2, r1.getCustomerName());
			st.setString(3, r1.getDuedate());
			st.setFloat(4, r1.getUnits());
			st.setDouble(5, r1.getCharges());
			st.executeUpdate();
						
		}
		catch (Exception e) {
				System.out.println(e);
		}
	}
	
public void update(RedNotice r1) {
		
		String sql="update rednotice set Duedate=?, Units=?, Charges=? where AccountID=?";
		
		try {
			
			PreparedStatement st= con.prepareStatement(sql);
			
			st.setInt(4, r1.getAccountID());
			st.setString(1, r1.getDuedate());
			st.setFloat(2, r1.getUnits());
			st.setDouble(3, r1.getCharges());
			st.executeUpdate();
			
			
		}catch(Exception e) {
			System.out.print(e);
		}
		
		
	}


public void delete(int AccountID) {
String sql="delete from rednotice where AccountID=?";
	
	try {
		
		PreparedStatement st= con.prepareStatement(sql);
		
		st.setInt(1,AccountID);
		 
		st.executeUpdate();
		
		
	}catch(Exception e) {
		System.out.print(e);
	}
	
}

	
}
