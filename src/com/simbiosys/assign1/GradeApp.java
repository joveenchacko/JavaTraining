package com.simbiosys.assign1;

import java.util.Scanner;

public class GradeApp {
	static Grade grade1 = new Grade();
	static GradeApp gradeAppDriver = new GradeApp();
	static Scanner sc = new Scanner(System.in); 

	/**
	 * @Author Joveen Chacko
	 * @Title Student
	 * @param args
	 * HW Assignment 1
	 * This method test the Grade class. Takes a number between 1 to 100 from users and outputs the 
	 * corresponding grade for it
	 */
	public static void main(String[] args) {
		
		System.out.println("Welcome to the Letter Grade Converter");
		System.out.println("\n");
		
		gradeAppDriver.startGrading();
		
		
		

	}
	
	public void startGrading(){
        System.out.print("Enter numerical grade(between 0 and 100: ");
		
		
		
		int score = sc.nextInt();
		
		if ( score < 0 || score > 100){
			System.out.println("You need to enter a valid value between 1 and 100");
			
		}else{
			
			grade1.returnGrade(score);
			GradeApp.continueGrading();
		}
		
	}
	
	public static void continueGrading(){
    
		System.out.print("Continue? y/n: ");
		
		
		String choice =  sc.next();
		
		if(choice.compareToIgnoreCase("y")==0){
			
			gradeAppDriver.startGrading();
		}
		
		
		
	}

}
