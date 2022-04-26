package ElectroGrid.EmployeeManagement;

import jakarta.xml.bind.annotation.XmlRootElement;
@XmlRootElement

public class Employee {
	
	private int id;
	private String name;
	private String address;
	private int telNum;
	private int otHours;
	private int salary;
	
	public int getId() {
		return id;
	}
	public void setId(int id ) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String string) {
		this.address = string;
	}
	public int getTelNum() {
		return telNum;
	}
	public void setTelNum(int telNum) {
		this.telNum = telNum;
	}
	public int getOtHours() {
		return otHours;
	}
	public void setOtHours(int otHours) {
		this.otHours = otHours;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address + ", telNum=" + telNum + ", otHours="
				+ otHours + ", salary=" + salary + "]";
	}
	
	

}
