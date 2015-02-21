package com.simbiosys.assign2;

import java.util.Random;
import java.util.Scanner;

/**
 * 
 * @author Joveen Chacko
 * 
 */
public class GuessGame {

	// initialize variables
	private static int randomNo;
	private static int n = 100;
	private static int tryCounter = 0;


	/**
	 * This method generates a random integer number between 1 and max
	 * @return int
	 */
	private static int generateRandomNumber(int max){
		Random random = new Random();
		// (random.next(100) generates from 0 to 99,
		int x = random.nextInt(max);
		// you need to pick from 1 to 100 which is 100-1=99 numbers and then add
		// 1 to the result.)
		// 100-1=99
		GuessGame.randomNo = x + 1;
		//System.out.println("Random no is:" + GuessGame.randomNo);
		return randomNo;
	}
	
	/**
	 * This method asks the user to enter a number from 1 to 100
	 * @return
	 */
	private static int guessNumber() {
		if (tryCounter == 0) {
			System.out.println("I am thinking of a number between 1 and 100 ");
			System.out.println("Try to guess it.");
		}
		System.out.print("\nEnter a number: ");
		Scanner sc = new Scanner(System.in);
		int userInput = sc.nextInt();

		while (userInput < 1 || userInput > 100) {
			System.out
					.println("Invalid Entry.Number has to be between 1 and 100.");
			System.out.println("Try to guess it\n");
			System.out.print("Enter a number: ");
			userInput = sc.nextInt();
		}
		
		tryCounter++;

		return userInput;

	}

	private void compareNumbers(int input, int randomNo) {

		//tryCounter++;
		System.out.println("Counter:" + tryCounter);
		if (input == randomNo) {
			GuessGame.displayMsg(tryCounter);
			playAgain();

		} else if (input > randomNo) {

			if (input > randomNo + 10) {
				System.out.println("Way to High! Guess Again.");

			} else {
				System.out.println("Too High! Guess Again.");
			}

			guessAgain();

		} else if (input < randomNo && input > 0) {

			System.out.println("Too Low! Guess Again.");
			guessAgain();
		}

	}

	/**
	 * @author Joveen Chacko This method allows the user to guess again
	 */
	private void guessAgain() {

		int userInput1 = guessNumber();
		// 3. compare nos
		compareNumbers(userInput1, randomNo);

	}

	/**
	 * This method based on user input y/n to decide if they want to play a new
	 * game or not
	 */
	private void playAgain() {

		System.out.print("Try again? (y/n): ");

		String play = null;
		Scanner sc = new Scanner(System.in);
		play = sc.next();
		if (play == "") {
			System.out.println("Error! This entry is required. Try again.");
			playAgain();
		} else if (play.compareToIgnoreCase("y") == 0) {

			startGame();
		} else if (play.compareToIgnoreCase("n") == 0) {
			System.out.println("Bye - Come back soon");
		} else {
			System.out.println("Entry must be a 'y' or 'n'. Try again");
			playAgain();
		}

	}

	/**
	 * Based on no passed in it displays corresponding message <=3 Great work!
	 * You are a mathematical wizard.
	 * 
	 * >3 and <=7 Not too bad! You've got some potential.
	 * 
	 * >7 What took you so long? Maybe you should take some lessons
	 * 
	 * @param noOfTries
	 */
	private static void displayMsg(int noOfTries) {
		System.out.println("You got it in " + noOfTries + " tries.");
		if (noOfTries <= 3) {
			System.out.println("Great work! You are a mathematical wizard.\n");
		} else if (noOfTries > 3 && noOfTries <= 7) {
			System.out.println("Not too bad! You've got some potential.\n");
		} else if (noOfTries > 7) {
			System.out
					.println("What took you so long? Maybe you should take some lessons.\n");
		}

	}

	/**
	 * Entry point to the guessing game
	 * 
	 * @author Joveen Chacko
	 */
	public void startGame() {
		// 1, reset counter to 0
		tryCounter = 0;
		// 2. Generate a random number
		//getRandomNo();
		generateRandomNumber(n);
		// 3. Get a user input number
		int guessedNo = guessNumber();
		
		// 4. Compare guessed number with random number
		compareNumbers(guessedNo, randomNo);

	}

}
