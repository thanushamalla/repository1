package com.employee.model;

public class User {
	private int id;
	private String firstname;
	private String lastname;
	private int salary;
	private String department;
	private String position;
	private String emailaddress;
	private int contactnumber;
	private Blob picture;
	
	public User(int id, String firstname, String lastname, int salary, String department, String position,
			String emailaddress, int contactnumber, Blob picture) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.salary = salary;
		this.department = department;
		this.position = position;
		this.emailaddress = emailaddress;
		this.contactnumber = contactnumber;
		this.picture = picture;
	}
	
	public User(String firstname, String lastname, int salary, String department, String position, String emailaddress,
			int contactnumber, Blob picture) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.salary = salary;
		this.department = department;
		this.position = position;
		this.emailaddress = emailaddress;
		this.contactnumber = contactnumber;
		this.picture = picture;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getEmailaddress() {
		return emailaddress;
	}
	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}
	public int getContactnumber() {
		return contactnumber;
	}
	public void setContactnumber(int contactnumber) {
		this.contactnumber = contactnumber;
	}
	public Blob getPicture() {
		return picture;
	}
	public void setPicture(Blob picture) {
		this.picture = picture;
	}
	

}
