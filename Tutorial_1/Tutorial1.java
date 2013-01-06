package Tutorial_1;

import java.util.GregorianCalendar;

import javax.swing.*;


public class Tutorial1 {
	public static void main(String[] args) {
		// Create a new person
		Person1 person1 = new Person1("John",
				"Buderim",
				075333222,"john@buderim.com");
		
		// Print out their properties
		System.out.println(person1.toString());
		
		Student1 student1 = new Student1();
		
		Staff staff1 = new Staff("Jane","Maroochydore",
				12345677,"jane@hotmail.com",
				"Level 6", "G5.2",60000,new GregorianCalendar(),
				"Manager");
		
	}
}
class Person1 {
	Person1 () {	
	}
	Person1 (String name, String address, int phone,
			String email) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}
	private String name = new String();
	// Get name
	public String getName() {
		return name;
	}
	/**
	 * Sets the name of this person object to newName
	 * @param newName
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	private String address = new String();
	private int phone = 0;
	private String email = new String();
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String toString() {
		return "Class name: Person. Object name: " 
		+ this.name;
	}
}
// Build subclasses of person named Student and Employee
// Student has class status
// Employee has office, salary and date hired
class Student1 extends Person1 {
	private String status;
	
	public Student1() {
		
	}
	
	public Student1 (String name, String address, int phone,
			String email, String status) {
		super(name,address,phone,email);
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
class Employee extends Person1 {
	private String office;
	private int salary;
	private GregorianCalendar dateHired;
	
	public Employee() {
		
	}
	public Employee (String name, String address, int phone,
			String email, String status, String office,
			int salary, GregorianCalendar dateHired) {
		super(name,address,phone,email);
		this.office = office;
		this.salary = salary;
		this.dateHired = dateHired;
	}
	
	public GregorianCalendar getDateHired() {
		return dateHired;
	}
	public void setDateHired(GregorianCalendar dateHired) {
		this.dateHired = dateHired;
	}
	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
}
// Make Faculty and Staff subclasses of Employee
class Faculty extends Employee {
	String officeHours;
	String rank;
	public Faculty(String name, String address, int phone,
			String email, String status, String office,
			int salary, GregorianCalendar dateHired,
			String officeHours, String rank) {
		super (name,address,phone,email, status, office,
				salary, dateHired);
		this.officeHours = officeHours;
		this.rank = rank;
	}
}
class Staff extends Employee {
	String title;
	public Staff(String name, String address, int phone,
			String email, String status, String office,
			int salary, GregorianCalendar dateHired,
			String title) {
		super (name,address,phone,email, status, office,
				salary, dateHired);
		this.title = title;
	}
}
