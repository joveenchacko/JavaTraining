package com.simbiosys.assign6;

import java.util.Random;
import java.util.Scanner;

import com.simbiosys.assign5.Validator;

public class CheckNumberDriver {

	static int generatedRandomInteger;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Welcome to the guess number application");
		playAgain();
		
	}

	private static void playAgain(){
        generatedRandomInteger = generateRandomNumber(1000);
        System.out.println("Number is: "+ generatedRandomInteger);
		
		createThreads();
		System.out.print("\n");
	}
	private static void createThreads() {
		
		Thread t0 = new Thread(new CheckNumberRunnable(generatedRandomInteger,0,250));
		t0.setName("Thread-0");
		Thread t1 = new Thread(new CheckNumberRunnable(generatedRandomInteger,251,500));
		t1.setName("Thread-1");
		Thread t2 = new Thread(new CheckNumberRunnable(generatedRandomInteger,501,750));
		t2.setName("Thread-2");
		Thread t3 = new Thread(new CheckNumberRunnable(generatedRandomInteger,751,1000));
		t3.setName("Thread-3");
		
		t0.start();
		t1.start();
		t2.start();
		t3.start();
		try{
			// this makes sure all threads complete before moving forward to remaining of main method
			// else random order of output 
			t0.join();
			t1.join();
			t2.join();
			t3.join();
			
		}catch(Exception e){
			System.out.println("exception");
		}
		
		
		System.out.println("Again y/n? ");
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		while(!Validator.validate(input, "y", "n")){
			System.out.println("You need to type y or n");
			input = sc.next();
		}
		
		if (input.compareToIgnoreCase("y")==0){
			playAgain();
		}
		
		if (input.compareToIgnoreCase("n")==0){
			
				System.exit(0);
			
			
		}
		
		
	}

	private static int generateRandomNumber(int n) {
		// TODO Auto-generated method stub
		Random r = new Random();
		// below you are doing n+1 to include 1000 too. else by default Random next 
		// does 0 inclusive to n exclusive
		int randomNo = r.nextInt(n+1);
		
		return randomNo;
		
	}

}
