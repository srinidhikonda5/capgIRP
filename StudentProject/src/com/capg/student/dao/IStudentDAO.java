package com.capg.student.dao;

import java.util.List;

import com.capg.student.model.Student;


public interface IStudentDAO {

	void addStudentDetails(Student student);
	Student getStudentByRollNumber(Integer studentRollNumber);
	List<Student> getAllStudents();
	List<Student> getAllStudentsByCourse(String courseName);
	
}

