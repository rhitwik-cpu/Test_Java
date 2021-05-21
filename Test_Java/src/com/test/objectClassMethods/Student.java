package com.test.objectClassMethods;

public class Student {
	
	private int id;
	private String name;
	private int age;
	
	public Student(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	public void setId(int id) {
		this.id =id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	
	@Override
	public String toString() {
		return id+"\t"+name+"\t"+age;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj==this) {
			return true;
		}
		if(!(obj instanceof Student)) {
			return false;
		}
		Student student = (Student)obj;
		return (this.id==student.id)&&(name != null ? this.name.equals(student.name) : student.name==null);
	}
	
	@Override
	public int hashCode() {
		final int hash = 13;
		final int mul = 17;
		int result = hash * mul;
		result += ((Integer)this.id != null) ? this.id : 0;
		result += (this.name != null) ? this.name.hashCode() : 0;
		return result;
	}
}
