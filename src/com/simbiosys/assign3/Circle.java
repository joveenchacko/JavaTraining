package com.simbiosys.assign3;


public class Circle extends CircleShape {

	static double area;
	
	public Circle(double r) {
		super(r);
		
	}


	@Override
	public void area() {
		area = CircleShape.PI * radius * radius;
	}

	@Override
	public String toString() {
		return ("The radius of the CIRCLE is " + radius + " and the area is " + area);
	}

}
