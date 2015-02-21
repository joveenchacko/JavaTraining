package com.simbiosys.assign4;

import java.util.Arrays;
import java.util.Scanner;

public class StudentGrader {
	
	static Scanner sc = new Scanner(System.in);
	static Student[] students;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("Welcome to the Students Scores Application\n");
		
		//1. Get number of students and validate the count
		System.out.print("Enter the number of students to enter: ");
		
		int studentCount = sc.nextInt();
		while(!(studentCount > 0)){
			System.out.println("Number of students has to be number > 0:");
			studentCount=sc.nextInt();
		}
		
		String fname, lname;
		int score;
		Scanner sc1= new Scanner(System.in);
		Scanner sc2= new Scanner(System.in);
		Scanner sc3= new Scanner(System.in);
		students = new Student[studentCount];
		
		// 2. GET INPUT FOR ALL STUDENTS
		
		for(int i=1;i<=studentCount;i++){
			System.out.print("Student "+i+" last name: ");
			lname=sc1.next();
			
			while(lname.trim().isEmpty()){
				System.out.println("Last name cannot be empty");
				System.out.print("Student "+i+" last name: ");
				lname=sc1.next();
			}
			
			System.out.print("Student "+i+" first name: ");
			fname=sc2.next();
			while(fname.trim().isEmpty()){
				System.out.println("First name cannot be empty");
				System.out.print("Student "+i+" first name: ");
				fname=sc2.next();
			}
			
			System.out.print("Student "+i+" score: ");
			score=sc3.nextInt();
			while(!(score>0 && score<=100)){
				System.out.println("Score has to be between 1 and 100");
				System.out.print("Student "+i+" score: ");
				score=sc3.nextInt();
			}
			System.out.println("\n");
			//3. Create student object
			Student s= new Student(lname,fname,score);
			//4. Add student to array
			students[i-1] = s;
			
			
		}
		//5. display the results
		displayResults(students);
			
	}

	private static void displayResults(Student[] students2) {
		
		// sort the students
		Arrays.sort(students2);
		
		// display the results
		for (int i=0;i<students2.length;i++){
			System.out.println(students2[i].getLname()+", "+students2[i].getFname()+ ": "+students[i].getGrade());
			
		}
		
	}

}
