package com.simbiosys.assign4;


public class Student implements Comparable {

	private String fname;
	private String lname;
	private int grade;
	
	
	Student(String lname, String fname, int grade){
		this.fname =fname;
		this.lname= lname;
		this.grade=grade;
		
		
	}


	@Override
	public int compareTo(Object obj) {
		
		Student student =  (Student) obj;
		
		if(lname.equalsIgnoreCase(student.lname)){
			return fname.compareTo(student.fname);
		}else{
		  return lname.compareTo(student.lname);
		}
			
		
	}
	
	

	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
	}


	public int getGrade() {
		return grade;
	}


	public void setGrade(int grade) {
		this.grade = grade;
	}

}
