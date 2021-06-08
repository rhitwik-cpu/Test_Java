package com.test.objectClassMethods;

import java.util.Scanner;

public class DeepCopyDemo {

	public static void main(String[] args) throws CloneNotSupportedException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Name :");
		String name = sc.nextLine();
		System.out.println("Enter Age :");
		int age = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Contact Number :");
		String contactNum = sc.nextLine();
		System.out.println("Enter Email :");
		String email = sc.nextLine();
		System.out.println("Enter City :");
		String city = sc.nextLine();
		Employee employee = new Employee(name, age, new Contact(contactNum, email, city));
		Employee shallowCoppiedEmployee = (Employee)employee.clone();
		System.out.println("Original Object : "+employee);
		System.out.println("Cloned Object : "+shallowCoppiedEmployee);
		System.out.println("Enter New Name : ");
		name = sc.nextLine();
		System.out.println("Enter New Age : ");
		age = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter New Contact Number : ");
		contactNum = sc.nextLine();
		System.out.println("Enter New Email : ");
		email = sc.nextLine();
		System.out.println("Enter New City : ");
		city = sc.nextLine();
		shallowCoppiedEmployee.setAge(age);
		shallowCoppiedEmployee.setName(name);
		shallowCoppiedEmployee.getContact().setContactNum(contactNum);
		shallowCoppiedEmployee.getContact().setEmail(email);
		shallowCoppiedEmployee.getContact().setCity(city);
		System.out.println("Cloned Object : "+shallowCoppiedEmployee);
		System.out.println("Original Object : "+employee);
		sc.close();
	}
}