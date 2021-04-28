package com.capg.student.ui;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.capg.student.model.Student;
import com.capg.student.service.IStudentService;
import com.capg.student.service.StudentServiceImpl;


public class StudentUI {

	public static Scanner scanner;
	
	public static IStudentService service= new StudentServiceImpl();
	
	public static void main(String[] args) {
		
		
		do {

		System.out.println("-----------Student Menu---------");
		System.out.println("1. Add Student");
		System.out.println("2. Get All Students");
		System.out.println("3. Get Student by RollNumber");
		System.out.println("4. Get Students by Course");
		System.out.println("5. Enter 5 to exit");
		int input = 0;
		boolean inputFlag = false;
		
		int count=0;
		
		do {
			scanner = new Scanner(System.in);
			
			if(count>2) {
				System.exit(0);
			}
			System.out.println("enter ur input");
			try {
				input = scanner.nextInt();
				if(input == 1 || input == 2 || input == 3 || input == 4 || input == 5)
				{
					inputFlag = true;
				}
				else {
					inputFlag = false;
					System.err.println("Please enter valid option");
				}
			} catch (InputMismatchException e) {
				inputFlag = false;
				count++;
				System.err.println("input should contain only digits");
			}
			
		} while (!inputFlag);
		
		switch(input)
        {
        case 1 :  addStudent(); break;
        case 2 :  getAllStudents();break;
        case 3 :  getStudentByRollNumber(); break;
        case 4 :  getAllStudentsByCourse(); break;
        case 5 :  { 
        				System.out.println("Thank you");
        	 			System.exit(0);
        	 	  };
        }
		
		} while(true);
		
	}
	
	static void addStudent() {
	 scanner = new Scanner(System.in);
	 Student student = new Student();
	 System.out.println("Enter Roll Number : ");
	 student.setStudentRollNumber(scanner.nextInt());
	 System.out.println("Enter Name : ");
	 student.setStudentName(scanner.next());
	 System.out.println("Enter No of courses");
	 int courseCount=scanner.nextInt();
	 List<String> courseList= new ArrayList<String>();
	 for(int i=0;i<courseCount;i++)
	 {
		 System.out.println("Enter Course Name :");
		 courseList.add(scanner.next());
	 }
	 student.setStudentCourses(courseList);
	 service.addStudentDetails(student);
	}
	
	static void getAllStudents() {
		List<Student> studentDetails=service.getAllStudents();
		System.out.println("List of Students");
		System.out.println("---------------------------------------------");
		System.out.println("RollNumber        Name         Courses" );
		for(Student student:studentDetails)
		{
			System.out.println(student.getStudentRollNumber()+ "            "+ student.getStudentName()+ "         "+ student.getStudentCourses());
		}
	}
	
	static void getStudentByRollNumber() {
		scanner = new Scanner(System.in);
		System.out.println("Enter Roll Number : ");
		int studentRollNumber = scanner.nextInt();
		Student student = service.getStudentByRollNumber(studentRollNumber);
		if(student != null) {
		
		System.out.println("Student Details");
		System.out.println("-----------------------------------");
		System.out.println("Roll Number               "+ student.getStudentRollNumber());
		System.out.println("Name                      "+ student.getStudentName());
		System.out.println("Courses                   "+ student.getStudentCourses());
		}
		else {
			System.err.println("Student with roll Number "+ studentRollNumber + " Not Found");
		}
	}
	
	static void getAllStudentsByCourse() {
		scanner = new Scanner(System.in);
		System.out.println("Enter Course Name : ");
		String courseName = scanner.next();
		List<Student> students = service.getAllStudentsByCourse(courseName);
		if(!students.isEmpty()) {
		
		System.out.println("List of Students");
		System.out.println("---------------------------------------------");
		System.out.println("RollNumber        Name         Courses" );
		for(Student student:students)
		{
			System.out.println(student.getStudentRollNumber()+ "            "+ student.getStudentName()+ "         "+ student.getStudentCourses());
		}
		}
		else
		{
			System.out.println("Student not Found with course " + courseName);
		}
	}
		
}


