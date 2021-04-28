package com.capg.student.service;

import java.util.List;

import com.capg.student.model.Student;

public interface IStudentService {

	void addStudentDetails(Student student);
	Student getStudentByRollNumber(Integer studentRollNumber);
	List<Student> getAllStudents();
	List<Student> getAllStudentsByCourse(String courseName);
	
}

