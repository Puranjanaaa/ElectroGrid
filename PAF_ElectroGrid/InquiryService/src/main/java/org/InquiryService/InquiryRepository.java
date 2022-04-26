package org.InquiryService;

import java.util.ArrayList;

import java.util.List;
import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class InquiryRepository {

	//List<RedNotice> rednotice;
	
	Connection con = null;
	
	
	public InquiryRepository() {
		
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
		
		String url = "jdbc:mysql://127.0.0.1:3306/electrogriddb";
	 
		String username = "root";
		String password = "root";
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			  con=DriverManager.getConnection(url,username,password);

			
			
		} catch (Exception e) {
		
			System.out.println(e);
		}

	
	}
	
	
	public List<Inquiry> getInquiry()
	{
		List<Inquiry> inquiry = new ArrayList<>();
		String sql = "select * from inquiry";
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				Inquiry i = new Inquiry();
				i.setInquiryID(rs.getInt(1));
				i.setCusName(rs.getString(2));
				i.setConNo(rs.getInt(3));
				i.setEmail(rs.getString(4));
				i.setInquiryState(rs.getString(5));
				
				inquiry.add(i);
				
			}
			
		}
		catch (Exception e) {
				System.out.println(e);
		}
		
		return inquiry;
	}
	
	public Inquiry getInquiry(int InquiryID)
	{

			String sql = "select * from inquiry where InquiryID="+InquiryID;
			Inquiry i = new Inquiry();
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next()) {
				
				i.setInquiryID(rs.getInt(1));
				i.setCusName(rs.getString(2));
				i.setConNo(rs.getInt(3));
				i.setEmail(rs.getString(4));
				i.setInquiryState(rs.getString(5));
				
 				
			}
			
		}
		catch (Exception e) {
				System.out.println(e);
		}
		
		return i;
		
	}


	public void create(Inquiry i1) {
		
		String sql = "insert into inquiry values (?,?,?,?,?)";
		try {
			PreparedStatement st= con.prepareStatement(sql);
			st.setInt(1, i1.getInquiryID());
			st.setString(2, i1.getCusName());
			st.setInt(3, i1.getConNo());
			st.setString(4, i1.getEmail());
			st.setString(5, i1.getInquiryState());
			st.executeUpdate();
			
						
		}
		catch (Exception e) {
				System.out.println(e);
		}
	}
	
public void update(Inquiry i1) {
		
		String sql="update inquiry set ConNo=?, email=?, InquiryState=? where InquiryID=?";
		
		try {
			
			PreparedStatement st= con.prepareStatement(sql);
			
			st.setInt(4, i1.getInquiryID());
			st.setInt(1, i1.getConNo());
			st.setString(2, i1.getEmail());
			st.setString(3, i1.getInquiryState());
			st.executeUpdate();
			
			
		}catch(Exception e) {
			System.out.print(e);
		}
		
		
	}


public void delete(int InquiryID) {
String sql="delete from inquiry where InquiryID=?";
	
	try {
		
		PreparedStatement st= con.prepareStatement(sql);
		
		st.setInt(1,InquiryID);
		 
		st.executeUpdate();
		
		
	}catch(Exception e) {
		System.out.print(e);
	}
	
}

	
}