package com.simbiosys.assign3;

import java.util.Scanner;

public abstract class CircleShape {
    //static double radius;
	double radius;
   

    static final double PI =3.141592653589793;
    
	public CircleShape() {
		radius = 0.0;
	}
    
	public CircleShape(double r) {
		
		radius =r;
		
	}
	
	public abstract void area();
	
	
    @Override
    public String toString() {
    	
    	return Double.toString(radius);
    }
     
    

	/**
	 * This method validates radius . Has to be > 0
	 * 
	 * @param r
	 */

	public static double validateRadius(double r) {
		Scanner scanner = new Scanner(System.in);

        //radius = r;
		while(!(r > 0)){
			System.out.print("Radius must be > 0. Please try again:");
			r=scanner.nextDouble();
			
		}
		
		return r;

	}
}
