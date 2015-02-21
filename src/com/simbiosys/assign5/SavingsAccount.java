package com.simbiosys.assign5;

public class SavingsAccount extends Account {

	// setting monthly interest to
	private static final double MONTHLY_INTEREST = 10.0;

	private static double monthlyPayment;
	//static Account acct = new Account();
	

	static double savingsBalance;

	SavingsAccount(double startingBal) {
		savingsBalance = startingBal;
		monthlyPayment = 0.0;

	}

	/**
	 * This method calculates the monthly payment
	 * 
	 * @return
	 */
	public static void calculateMonthlyPayment() {

		double payment = (MONTHLY_INTEREST / 100) * savingsBalance;
		monthlyPayment = payment;

	}

	/**
	 * Method returns monthly interest rate
	 * 
	 * @return
	 */
	public double getMonthlyInterest() {

		return MONTHLY_INTEREST;
	}

	public static double getMonthlyPayment() {
		return monthlyPayment;
	}

	public void setMonthlyPayment(double mpayment) {
		monthlyPayment = mpayment;
	}

	public void withDraw(double amt) {
		//calculateMonthlyPayment();
		//UpdateBalance();
		savingsBalance = savingsBalance - amt;
	}
	
	public void deposit(double amt) {
		//calculateMonthlyPayment();
		//UpdateBalance();
		savingsBalance = savingsBalance + amt;
	}

	
}
