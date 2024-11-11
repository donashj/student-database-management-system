package com.ty;

import java.util.Scanner;

public class Student {
public static void main(String[] args) {
	StudentInterface si=new StudentImplementation();
	Scanner sc=new Scanner(System.in);
	System.out.println("Welcome to Student Database");
	while(true) {
	System.out.println("1.Add Student\n2:Update Student\n3:Delete Student\n4:Get All Student\n5:Delete All Student\n6:Get Student By Id\n7:Exit");
	System.out.println("Enter your choice");
	int choice=sc.nextInt();
	
		switch(choice) {
		case 1:
			si.addStudent();
			break;
		case 2:
			si.updateStudent();
			break;
		case 3:
			si.deleteStudent();
			break;
		case 4:
			si.getAllStudent();
			break;
		case 5:
			si.deleteAllStudent();
			break;
		case 6:
			si.getStudentById();
			break;
		case 7:
			System.out.println("Thank You");
			System.exit(0);
			break;
	   default:
		   System.out.println("Enter valid choice");
				
		}
	}
	
}
}
