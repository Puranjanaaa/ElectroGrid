package com.CustomerService.customerService;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class CustomerRepository {
	
	
Connection con = null;
	
	
	public CustomerRepository() {
		
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
	
	
	public List<Customer> getCustomer()                            //RedNotice
	{
		List<Customer> customer = new ArrayList<>();
		String sql = "select * from customer";
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				Customer r = new Customer();
				r.setElectricityAccountNo(rs.getInt(1));
				r.setCustomerName(rs.getString(2));
				r.setCustomerAddress(rs.getString(3));
				r.setPremisesID(rs.getInt(4));

				
				customer.add(r);
				
			}
			
		}
		catch (Exception e) {
				System.out.println(e);
		}
		
		return customer;
	}
	
	public Customer getCustomer(int ElectricityAccountNo)
	{

			String sql = "select * from customer where ElectricityAccountNo="+ElectricityAccountNo;
			Customer r = new Customer();
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next()) {
				
				r.setElectricityAccountNo(rs.getInt(1));
				r.setCustomerName(rs.getString(2));
				r.setCustomerAddress(rs.getString(3));
				r.setPremisesID(rs.getInt(4));
				
 				
			}
			
		}
		catch (Exception e) {
				System.out.println(e);
		}
		
		return r;
		
	}


	public void create(Customer r1) {
		
		String sql = "insert into customer values (?,?,?,?)";
		try {
			PreparedStatement st= con.prepareStatement(sql);
			st.setInt(1, r1.getElectricityAccountNo());
			st.setString(2, r1.getCustomerName());
			st.setString(3, r1.getCustomerAddress());
			st.setInt(4, r1.getPremisesID());
			
			st.executeUpdate();
						
		}
		catch (Exception e) {
				System.out.println(e);
		}
	}
	
public void update(Customer r1) {
		
		String sql="update customer set CustomerName=?, CustomerAddress=?, PremisesID=? where ElectricityAccountNo=?";
		
		try {
			
			PreparedStatement st= con.prepareStatement(sql);
			
			st.setInt(4, r1.getElectricityAccountNo());
			st.setString(1, r1.getCustomerName());
			st.setString(2, r1.getCustomerAddress());
			st.setInt(3, r1.getPremisesID());
			
			st.executeUpdate();
			
			
		}catch(Exception e) {
			System.out.print(e);
		}
		
		
	}


public void delete(int ElectricityAccountNo) {
String sql="delete from customer where ElectricityAccountNo=?";
	
	try {
		
		PreparedStatement st= con.prepareStatement(sql);
		
		st.setInt(1,ElectricityAccountNo);
		 
		st.executeUpdate();
		
		
	}catch(Exception e) {
		System.out.print(e);
	}
	
}


}
