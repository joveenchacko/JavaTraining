package com.simbiosys.assign1;

public class Grade {

	/*
	 * @Author Joveen Chacko
	 * @Title Student
	 * @param args
	 * HW Assignment 1
	 * Returns grades for a given integer
	 * The grading criteria is as follows:
	 * 
	 * A 88-100
	 * 
	 * B 80-87
	 * 
	 * C 67-79
	 * 
	 * D 60-66
	 * 
	 * F <60
	 */

	public void returnGrade(int number) {
		String grade;

		if ((number >=88) && (number <=100)){
			grade ="A";
		}else if((number >=80) && (number <=87)){
			grade ="B";
		}else if((number >=67) && (number <=79)){
			grade ="C";
		}else if((number >=60) && (number <=66)){
			grade ="D";
		} else{
			grade ="F";
		}
		
	
	   System.out.println("Your grade is: " + grade + "\r");
	   
	   
		
      
		
		
	}
	
	
}
