package com.payment.Payment_Management;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.*;
import java.sql.Statement;



import java.sql.Connection;


public class PaymentRepository {
	
	Connection con = null;
	
	public PaymentRepository() {
	
		String url = "jdbc:mysql://localhost:3306/electrogrid";
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
	
	public List<Payment> getPayments(){
		List<Payment> payments = new ArrayList<>();
		String sql = "select * from payment";
		try {
			
			Statement st=con.createStatement();
			ResultSet rs= st.executeQuery(sql);
			while(rs.next()) {
				
				Payment p=new Payment();
				p.setAccNo(rs.getInt(1));
				p.setAmount(rs.getString(2));
				p.setPricePerUnit(rs.getString(3));;
				p.setAdditionalUnits(rs.getString(4));
				p.setDueDate(rs.getString(5));
				
				
				payments.add(p);
			}
			
		}catch(Exception e) {
			System.out.print(e);
		}
		return payments;
	}
	
	
	public Payment getPayment(int accNo){
		String sql = "select * from payment where accNo =" +accNo;
		Payment p = new Payment();
		try {
			
			Statement st=con.createStatement();
			ResultSet rs= st.executeQuery(sql);
			if(rs.next()) {
				p.setAccNo(rs.getInt(1));
				p.setAmount(rs.getString(2));
				p.setPricePerUnit(rs.getString(3));;
				p.setAdditionalUnits(rs.getString(4));
				p.setDueDate(rs.getString(5));
			
			}
			
		}catch(Exception e) {
			System.out.print(e);
		}
		return p;
	}

	public void create(Payment p1) {
		String sql = "insert into payment values(?,?,?,?,?)";
			try {
						PreparedStatement st=con.prepareStatement(sql);
						st.setInt(1,p1.getAccNo());
						st.setString(2, p1.getAmount());
						st.setString(3, p1.getPricePerUnit());
						st.setString(4, p1.getAdditionalUnits());
						st.setString(5,p1.getDueDate());
						st.executeUpdate();
						
					}catch(Exception e) {
						System.out.print(e);
					}		
	}
	
	public void update(Payment p1) {
		String sql = "update payment set amount =?,dueDate=?  where accNo=? ";
			try {
						PreparedStatement st=con.prepareStatement(sql);
						
						st.setString(1, p1.getAmount());
						st.setString(2,p1.getDueDate());
						st.setInt(3,p1.getAccNo());
						st.executeUpdate();
						
					}catch(Exception e) {
						System.out.print(e);
					}		
	}
	
	public void delete(int accNo) {
		String sql = "delete from payment where accNo=? ";
		try {
					PreparedStatement st=con.prepareStatement(sql);
					st.setInt(1,accNo);
					st.executeUpdate();
					
				}catch(Exception e) {
					System.out.print(e);
				}	
	}
}
