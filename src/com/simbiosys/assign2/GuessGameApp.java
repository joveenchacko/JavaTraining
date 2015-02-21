package com.simbiosys.assign2;

public class GuessGameApp {

	/**
	 * The application prompts the user to enter an int value from 1 to 100 until the user guesses the
     * random number that the application has generated. 
     * The application displays messages that indicate whether the user’s guess is too high or too 
	 * low.
	 * @author Joveen Chacko
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("Welcome to the Guess the Number Game");
		System.out.println("++++++++++++++++++++++++++++++++++++");

		GuessGame g= new GuessGame();
		g.startGame();

	    	
	}

}
