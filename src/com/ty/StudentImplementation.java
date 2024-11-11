package com.ty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentImplementation implements StudentInterface {

	@Override
	public void addStudent() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter student Id");
		int id=sc.nextInt();
		System.out.println("Enter student Name");
		String name=sc.next();
		System.out.println("Enter student Age");
		int age=sc.nextInt();
		System.out.println("Enter student Marks");
		int marks=sc.nextInt();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","root");
			PreparedStatement preparedStatement=connection.prepareStatement("insert into student values(?,?,?,?)");
			preparedStatement.setInt(1,id);
			preparedStatement.setString(2,name);
			preparedStatement.setInt(3,age);
			preparedStatement.setInt(4,marks);
			preparedStatement.execute();
			connection.close();
			System.out.println("Data Saved");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateStudent() {
		Scanner sc=new Scanner(System.in);
		System.out.println("1:Update Name\n2:Update Age\n3:Update Marks\n4:Exit");
		System.out.println("Enter your choice");
		int choice=sc.nextInt();
		switch(choice) {
		case 1:
			System.out.println("Enter id");
			int id=sc.nextInt();
			System.out.println("Enter Name");
			String name=sc.next();
			try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","root");
			PreparedStatement preparedStatement=connection.prepareStatement("update student set name=? where id=?");
			preparedStatement.setString(1,name);
			preparedStatement.setInt(2,id);
			preparedStatement.execute();
			System.out.println("Data Updated");
			connection.close();
			} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
			break;
		case 2:
			System.out.println("Enter id");
			int id1=sc.nextInt();
			System.out.println("Enter Age");
			int age=sc.nextInt();
			try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","root");
			PreparedStatement preparedStatement=connection.prepareStatement("update student set age=? where id=?");
			preparedStatement.setInt(1,age);
			preparedStatement.setInt(2,id1);
			preparedStatement.execute();
			System.out.println("Data Updated");
			connection.close();
			} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
			break;
		case 3:
			System.out.println("Enter id");
			int id2=sc.nextInt();
			System.out.println("Enter Marks");
			int marks=sc.nextInt();
			try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","root");
			PreparedStatement preparedStatement=connection.prepareStatement("update student set marks=? where id=?");
			preparedStatement.setInt(1,marks);
			preparedStatement.setInt(2,id2);
			preparedStatement.execute();
			System.out.println("Data Updated");
			connection.close();
			} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
			break;
		case 4:
			System.exit(0);
			break;
		default:
			System.out.println("Enter valid choice");
		}
		
	}

	@Override
	public void deleteStudent() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter id to be deleted");
		int id=sc.nextInt();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "root");
			PreparedStatement preparedStatement=connection.prepareStatement("delete from student where id=?");
			preparedStatement.setInt(1, id);
			preparedStatement.execute();
			System.out.println("Data deleted");
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void getAllStudent() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root","root");
			PreparedStatement preparedStatement=connection.prepareStatement("select * from student");
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				System.out.println("Student id is "+resultSet.getInt(1));
				System.out.println("Student name is "+resultSet.getString(2));
				System.out.println("Student age is "+resultSet.getInt(3));
				System.out.println("Student gender is "+resultSet.getString(4));
				System.out.println("   ");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteAllStudent() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "root");
			PreparedStatement preparedStatement=connection.prepareStatement("delete from student");
			preparedStatement.execute();
			System.out.println("Data deleted");
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void getStudentById() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter id");
		int id=sc.nextInt();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root","root");
			PreparedStatement preparedStatement=connection.prepareStatement("select * from student where id=?");
			preparedStatement.setInt(1,id);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				System.out.println("Student id is "+resultSet.getInt(1));
				System.out.println("Student name is "+resultSet.getString(2));
				System.out.println("Student age is "+resultSet.getInt(3));
				System.out.println("Student gender is "+resultSet.getString(4));
				System.out.println("   ");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

}
