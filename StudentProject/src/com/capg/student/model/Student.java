package com.capg.student.model;


import java.util.List;

public class Student {

	private int studentRollNumber;
	private String  studentName;
	private List<String> studentCourses;
	
	public Student() {
		
	}

	public Student(int studentRollNumber, String studentName, List<String> studentCourses) {
		super();
		this.studentRollNumber = studentRollNumber;
		this.studentName = studentName;
		this.studentCourses = studentCourses;
	}

	public int getStudentRollNumber() {
		return studentRollNumber;
	}

	public void setStudentRollNumber(int studentRollNumber) {
		this.studentRollNumber = studentRollNumber;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public List<String> getStudentCourses() {
		return studentCourses;
	}

	public void setStudentCourses(List<String> studentCourses) {
		this.studentCourses = studentCourses;
	}

	@Override
	public String toString() {
		return "Student [studentRollNumber=" + studentRollNumber + ", studentName=" + studentName + ", studentCourses="
				+ studentCourses + "]";
	}
	
	
 }
