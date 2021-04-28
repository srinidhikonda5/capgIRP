package com.capg.student.service;


import java.util.List;

import com.capg.student.dao.IStudentDAO;
import com.capg.student.dao.StudentDAOImpl;
import com.capg.student.model.Student;

public class StudentServiceImpl implements IStudentService{

	private IStudentDAO dao= new  StudentDAOImpl();
	
	public void addStudentDetails(Student student) {
		 dao.addStudentDetails(student);
	}

	public Student getStudentByRollNumber(Integer studentRollNumber) {
		return dao.getStudentByRollNumber(studentRollNumber);
	}

	public List<Student> getAllStudents() {
		return dao.getAllStudents();
	}

	public List<Student> getAllStudentsByCourse(String courseName) {
		
		return dao.getAllStudentsByCourse(courseName);
	}
	

}
