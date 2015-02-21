package com.simbiosys.assign3;

import java.util.Scanner;

public class DriverApp {

	static Scanner sc = new Scanner(System.in);
	// static CircleShape circleShape;
	static double radius;
	static CircleShape[] circleShapeRef = new CircleShape[10];
	static String moreShapes = "n";
	static int index = 0;
	static DriverApp driverApp = new DriverApp();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out
				.println("This program calculates and displays the area of 10 circles/spheres\n");

		
		driverApp.calculateArea();

	}

	private void calculateArea() {

		

		
		CircleShape circleShape;

		// 1. Obtain shape input and validate input
		String shapeChoice = getShapeUserInputAndValidate();

		// 2. obtain radius input and validate
		circleShape = getRadiusInputAndValidate(shapeChoice);

		// 3. Populate array
		driverApp.populateCircleShapes(circleShape);

		String moreShapeChoice = addMoreShapes();
		
		
		if (moreShapeChoice.compareToIgnoreCase("y") == 0) {
			calculateArea();
		} else {
			displayResults();
		}

	}

	private void displayResults() {

		System.out.println("*************************");
		System.out.println("AREA DISPLAY");
		System.out.println("*************************");

		for (int i = 0; i < index; i++) {
			System.out.println(circleShapeRef[i].toString());

		}

	}

	/**
	 * This method validate users choice if the want to add more shapes or no
	 * 
	 * @return string (for the shape)
	 */
	private String addMoreShapes() {
		String input;
		System.out
				.println("Would you like to calculate area of another shape?");
		System.out.println("Enter \"y\" to enter another shape or enter \"n\" "
				+ "to view the areas of you shapes");

		input = sc.nextLine();

		while (!(input.compareToIgnoreCase("y") == 0)
				&& !(input.compareToIgnoreCase("n") == 0)) {
			System.out.print("Please enter \"y\" or \"n\": ");
			System.out.println();
			input = sc.nextLine();

		}

		return input;

	}

	/**
	 * This method populates circleShapeRef array as long it's length does not
	 * exceed 10 and user has not chosen n terminate
	 * 
	 * @param circleShape2
	 * @param moreShapes2
	 */

	private void populateCircleShapes(CircleShape circleShape2) {

		if (index==10){
			// basically when array size is full we want to display the results
			displayResults();
			System.exit(0);
		}
		
		circleShapeRef[index] = circleShape2;
		index++;

	}

	/**
	 * This method take user input for which shape they want to calculate area
	 * for and validates the input
	 * 
	 * @return
	 */
	private String getShapeUserInputAndValidate() {
		// 1. Ask if user wants circle or sphere
		System.out
				.println("Would you like to calculate area of a circle or sphere? ");
		System.out.print("Enter c for Circle and s for Sphere: ");

		// 2. validate users shape choice
		String userChoice = validateShapeChoice(sc.nextLine());

		return userChoice;

	}

	/**
	 * This method validates the user input
	 * 
	 * @param input
	 * @return String
	 */
	private String validateShapeChoice(String input) {
		input = input.trim();
		while (!(input.compareToIgnoreCase("c") == 0)
				&& !(input.compareToIgnoreCase("s") == 0)) {
			System.out.print("Please enter \"c\" or \"s\": ");
			System.out.println();
			input = sc.nextLine();

		}
		// System.out.println("validated shape :" + input);
		return input;

	}

	private CircleShape getRadiusInputAndValidate(String choice) {

		CircleShape c = null;
		double r = 0.0;

		// Ask radius of sphere or circle depending on choice
		if (choice.equalsIgnoreCase("s")) {
			System.out.println("Enter the radius of your sphere: ");
			r = sc.nextDouble();
			// Validate the radius

			radius = CircleShape.validateRadius(r);
			c = new Sphere(radius);
			// Sphere.radius=radius;
			c.area();
			return c;

		} else if (choice.equalsIgnoreCase("c")) {
			System.out.println("Enter the radius of your circle: ");
			r = sc.nextDouble();
			// Validate the radius
			radius = CircleShape.validateRadius(r);
			c = new Circle(radius);
			//Circle.radius=radius;
			c.area();
			return c;
		}

		// System.out.println("validated value of radius is "+ radius);
		return c;
	}
}
