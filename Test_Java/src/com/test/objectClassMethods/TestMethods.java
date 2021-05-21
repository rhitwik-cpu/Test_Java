package com.test.objectClassMethods;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TestMethods {

	public static void main(String[] args) {
		
		Student student0 = new Student(101, "Harry", 25);
		Student student1 = new Student(102, "Sally", 24);
		Student student2 = new Student(103, "Olivia", 29);
		Student student3 = new Student(103, "Olivia", 30);
		
		Set<Student> stuSet = new HashSet<Student>();
		
		stuSet.add(student0);
		stuSet.add(student1);
		stuSet.add(student2);
		stuSet.add(student3);
		
		Map<Student,Integer> stuMap = new HashMap<Student,Integer>();
		
		stuMap.put(student0, 97);
		stuMap.put(student1, 95);
		stuMap.put(student2, 90);
		stuMap.put(student3, 99);
		
		System.out.println(stuSet);
		
		for(Map.Entry<Student, Integer> studentEntry : stuMap.entrySet()) {
			System.out.println("Student : "+studentEntry.getKey()+"\tScore : "+studentEntry.getValue());
			System.out.println("Hash value of Student : "+studentEntry.getKey().hashCode()+"\n");
		}
		
		Iterator<Student> itr = stuSet.iterator();
		
		while(itr.hasNext()) {
			Student tempStudent = itr.next();
			System.out.println("Student :"+tempStudent.toString());
			System.out.println("Hash value of Student : "+tempStudent.hashCode());
		}
	}
}