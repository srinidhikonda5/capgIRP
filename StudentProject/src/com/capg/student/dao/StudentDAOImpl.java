package com.capg.student.dao;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.capg.student.model.Student;


public class StudentDAOImpl implements IStudentDAO {

	private List<Student> studentList = new ArrayList<Student>();
	
	public StudentDAOImpl() {
		List<String> courses1 = new ArrayList<String>();
		courses1.add("Java");
		courses1.add("oracle");
	 	Student student1= new Student(111, "Srinidhi", courses1);
	 	
	 	List<String> courses2 = new ArrayList<String>();
		courses2.add("C");
		courses2.add("Python");
	 	Student student2= new Student(112, "Shravan", courses2);
	 	
	 	List<String> courses3 = new ArrayList<String>();
		courses3.add("C++");
		courses3.add("Java");
	 	Student student3= new Student(113, "Deepika", courses3);
	 	
	 	List<String> courses4= new ArrayList<String>();
		courses4.add("C++");
		courses4.add("Java");
	 	Student student4= new Student(113, "Nidhi", courses3);
	 	
	 	
	 	studentList.add(student1);
	 	studentList.add(student2);
	 	studentList.add(student3);
	 	studentList.add(student4);

	}
	
	
	public void addStudentDetails(Student student) {
		studentList.add(student);
	}

	public Student getStudentByRollNumber(Integer studentRollNumber) {
		Student student1 = null;
		for(Student student: studentList)
		{
			if(student.getStudentRollNumber() == studentRollNumber)
			{
				student1 = student;
			}
		}
		return student1;
	}

	public List<Student> getAllStudents() {
		return studentList;
	}

	public List<Student> getAllStudentsByCourse(String courseName) {
		List<Student> students= new ArrayList<Student>();
		for(Student student: studentList)
		{
			if (student.getStudentCourses().contains(courseName)) {
				students.add(student);
			}
		}
		return students;
	}

}
