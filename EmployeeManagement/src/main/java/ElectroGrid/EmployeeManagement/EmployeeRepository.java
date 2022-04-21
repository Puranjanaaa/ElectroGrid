package ElectroGrid.EmployeeManagement;

import java.util.ArrayList;
import java.util.List;
//import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeRepository {
	
	//List<Employee> employees;
	
	Connection con = null;
	
	 public EmployeeRepository()
	 {
		 /*employees = new ArrayList<>();
		 
		 Employee e1 = new Employee();
			e1.setId(001);
			e1.setName("Kamal");
			e1.setAddress("Colombo");
			e1.setTelNum(776964747);
			e1.setSalary(30000);
			e1.setOtHours(4);
			
			Employee e2 = new Employee();
			e2.setId(002);
			e2.setName("Namal");
			e2.setAddress("Kandy");
			e2.setTelNum(776362347);
			e2.setSalary(40000);
			e2.setOtHours(5);
			
			Employee e3 = new Employee();
			e3.setId(002);
			e3.setName("Namal");
			e3.setAddress("Kandy");
			e3.setTelNum(776362347);
			e3.setSalary(40000);
			e3.setOtHours(5);
			
			employees.add(e1);
			employees.add(e2);
			//employees.add(e3);*/
		 
		 String url = "jdbc:mysql://localhost:3306/electrogriddb";
		 String username = "root";
		 String password = "root";
		 
		 try
		 {
			 Class.forName("com.mysql.jdbc.Driver");
		 con = DriverManager.getConnection(url,username,password);
		 }
		 catch(Exception e){
			 System.out.println(e);
		 }
			
	 }
	 
	 public List<Employee>getEmployees(){
		 
		 List<Employee> employees = new ArrayList<>();
		 String sql = "select * from employee ";
		 
		 try
		 {
			 Statement st = con.createStatement();
			 ResultSet rs = st.executeQuery(sql);
			 while(rs.next())
			 {
				 Employee e =  new Employee();
				 e.setId(rs.getInt(1));
				 e.setName(rs.getString(2));
				 e.setAddress(rs.getString(3));
				 e.setTelNum(rs.getInt(4));
				 e.setOtHours(rs.getInt(5));
				 e.setSalary(rs.getInt(6));
				 
				 employees.add(e);
			 }
		 }
		 catch(Exception e){
			 System.out.println(e);
		 }
		 return employees;
	 }

	 public Employee getEmployee(int id) {
		 
		 /*Employee e1 = null;
		 
		 for(Employee e :employees)
		 {
			 if(e.getId()==id)
				 return e;
		 }
		 
		 return null;*/
		 
		 String sql = "select * from employee where id="+id;
		 Employee e =  new Employee();
		 try
		 {
			 Statement st = con.createStatement();
			 ResultSet rs = st.executeQuery(sql);
			 if(rs.next())
			 {
				
				 e.setId(rs.getInt(1));
				 e.setName(rs.getString(2));
				 e.setAddress(rs.getString(3));
				 e.setTelNum(rs.getInt(4));
				 e.setOtHours(rs.getInt(5));
				 e.setSalary(rs.getInt(6));
				 
			 }
		 }
		 catch(Exception er){
			 System.out.println(er);
		 }
		  return e;
	 }

	/*public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return null;
	}*/

	public void create(Employee e1) {
		// TODO Auto-generated method stub
		//employees.add(e1);
		
		String sql = "insert into employee values (?,?,?,?,?,?)";
		
		 try
		 {
			 PreparedStatement st = con.prepareStatement(sql);
			 st.setInt(1, e1.getId());
			 st.setString(2, e1.getName());
			 st.setString(3, e1.getAddress());
			 st.setInt(4, e1.getTelNum());
			 st.setInt(5, e1.getOtHours());
			 st.setInt(6, e1.getSalary());
			 
			 st.executeUpdate();
			 
		 }
		 catch(Exception e){
			 System.out.println(e);
		 }
			
	}

	public void update(Employee e1) {
		// TODO Auto-generated method stub
		//employees.add(e1);
		
		String sql = "update employee set name=?, address=?, telnum=?, otHours=?, salary=? where id=?";
		
		 try
		 {
			 PreparedStatement st = con.prepareStatement(sql);
			 
			 st.setString(1, e1.getName());
			 st.setString(2, e1.getAddress());
			 st.setInt(3, e1.getTelNum());
			 st.setInt(4, e1.getOtHours());
			 st.setInt(5, e1.getSalary());
			 st.setInt(6, e1.getId());
			 
			 st.executeUpdate();
			 
		 }
		 catch(Exception e){
			 System.out.println(e);
		 }
			
	}
	
	public void delete(int id) {
		
		String sql = "delete from employee where id=?";
		
		 try
		 {
			 PreparedStatement st = con.prepareStatement(sql);
			 st.setInt(1, id);
			 st.executeUpdate();
			 
		 }
		 catch(Exception e){
			 System.out.println(e);
		 }
		
	}
 
}
