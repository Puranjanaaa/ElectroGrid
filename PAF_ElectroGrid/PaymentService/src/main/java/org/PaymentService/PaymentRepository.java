package org.PaymentService;




import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
//import java.sql.*;
import java.sql.Statement;
import com.sun.jersey.api.client.*;
import com.sun.jersey.api.client.WebResource;



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
	
	public String getPayments(){
		//List<Payment> payments = new ArrayList<>();
		String sql = "select * from payment";
		try {
			
			Statement st=con.createStatement();
			String output = "<table border=\"1\"><tr><th>Account Number</th>" + "<th>Number of Units</th> "
					+ "<th>Additional Units</th>" + "<th>Amount</th>" + "<th>Due Date</th></tr>";
			ResultSet rs= st.executeQuery(sql);
			while(rs.next()) {
				
				Payment p=new Payment();
				p.setAccNo(rs.getInt(1));
				p.setUnits(rs.getDouble(2));
				p.setAdditionalUnits(rs.getDouble(3));;
				p.setAmount(rs.getDouble(4));
				p.setDueDate(rs.getString(5));
				
				
				output += "<tr><td>" + p.getAccNo() + "</td>";
				output += "<td>" + p.getUnits() + "</td>";
				output += "<td>" + p.getAdditionalUnits() + "</td>";
				output += "<td>" + p.getAmount() + "</td>";
				output += "<td>" + p.getDueDate() + "</td>";
			}
			output += "</table>";
			return output;
			
			
		}catch(Exception e) {
			System.out.print(e);
			return "Error occured during retrieving data";
		}
		
	}
	
	
	public Payment getPayment(int accNo){
		String sql = "select * from payment where accNo =" +accNo;
		Payment p = new Payment();
		try {
			
			Statement st=con.createStatement();
			ResultSet rs= st.executeQuery(sql);
			if(rs.next()) {
				p.setAccNo(rs.getInt(1));
				p.setUnits(rs.getDouble(2));
				p.setAdditionalUnits(rs.getDouble(3));;
				p.setAmount(rs.getDouble(4));
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
						st.setDouble(2, p1.getUnits());
						st.setDouble(3, p1.getAdditionalUnits());
						st.setDouble(4, p1.getAmount());
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
						
						st.setDouble(1, p1.getAmount());
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
	
	public double getUnitsdb(int accNo){
		String sql = "select units from payment where accNo =" +accNo;
		Payment p = new Payment();
		try {
			
			Statement st=con.createStatement();
			ResultSet rs= st.executeQuery(sql);
			if(rs.next()) {
				p.setUnits(rs.getDouble(1));
			}
			
		}catch(Exception e) {
			System.out.print(e);
		}
		return p.getUnits();
		
	}
	
	public double getAddUnitsdb(int accNo){
		String sql = "select additionalUnits from payment where accNo=" +accNo;
		Payment p = new Payment();
		try {
			
			Statement st=con.createStatement();
			ResultSet rs= st.executeQuery(sql);
			if(rs.next()) {
				p.setAdditionalUnits(rs.getDouble(1));
			}
			
		}catch(Exception e) {
			System.out.print(e);
		}
		return p.getAdditionalUnits();
		
	}
	
	public double calcAmount(int accNo) {
		Payment p = new Payment();
		double units = getUnitsdb(accNo);
		double additionalUnits = getAddUnitsdb(accNo);
		double amount;
		
		amount = (units*p.unitPrice)+(additionalUnits*p.additionalUnitPrice)+p.fixedAmount;
		return amount;
	}
	
	public void addAmount(int accNo) {
		String sql = "update payment set amount =? where accNo=? ";
		double amount = calcAmount(accNo);
			try {
						PreparedStatement st=con.prepareStatement(sql);
						//Payment p1 = new Payment();
						
						st.setDouble(1,amount);
						st.setInt(2,accNo);
						st.executeUpdate();
						
					}catch(Exception e) {
						System.out.print(e);
					} System.out.print("Monthly Amount:"+amount); 		
	}
	
	

	 public String readMonitor() {
	 Client c = Client.create();
	 WebResource resource =
	 c.resource("http://localhost:8090/PAF_MonitoringService/webapi/monitors");
	 String output = resource.get(String.class);
	 return "From Monitoring Service"+ output;
	 }
	 
	 


}

