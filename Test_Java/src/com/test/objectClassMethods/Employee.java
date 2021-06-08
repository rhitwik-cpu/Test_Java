package com.test.objectClassMethods;

public class Employee implements Cloneable {
	private String name;
	private int age;
	private Contact contact;
	
	Employee(String name, int age, Contact contact) {
		this.name = name;
		this.age = age;
		this.contact = contact;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public Contact getContact() {
		return contact;
	}
	@Override
	public String toString() {
		return "Name : "+name+" Age : "+age+" "+contact.toString();
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		Employee employee = (Employee)super.clone();
		employee.contact = (Contact)contact.clone();
		return employee;
	}
}
class Contact implements Cloneable {
	private String contactNum;
	private String email;
	private String city;
	
	Contact(String contactNum, String email, String city) {
		this.contactNum = contactNum;
		this.email = email;
		this.city = city;
	}
	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getContactNum() {
		return contactNum;
	}
	public String getEmail() {
		return email;
	}
	public String getCity() {
		return city;
	}
	@Override
	public String toString() {
		return "Contact Number : "+contactNum+" Email ID : "+email+" City : "+city;
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
