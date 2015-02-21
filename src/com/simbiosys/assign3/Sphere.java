package com.simbiosys.assign3;

public class Sphere extends Circle {
	static double area;

	
	public Sphere(double r) {
		super(r);
	}

	@Override
	public  void area() {
		area = 4 * PI * radius * radius;
		

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ("The radius of the SPHERE is " + radius + " and the area is " + area);
	}
	
	

}
