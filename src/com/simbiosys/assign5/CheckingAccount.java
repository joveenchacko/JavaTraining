package com.simbiosys.assign5;

public class CheckingAccount extends Account {

	private static final double MONTHLY_FEE = 1.00;

	static double checkingBalance;

	CheckingAccount(double bal) {
		checkingBalance = bal;

	}

	private void UpdateBalance() {
		checkingBalance = checkingBalance - getMONTHLY_FEE();
		// return checkingBalance;

	}

	public void withDraw(double amt) {
		UpdateBalance();
		checkingBalance = checkingBalance - amt;
	}

	public void deposit(double amt) {
		UpdateBalance();
		checkingBalance = checkingBalance + amt;
	}

	public static double getMONTHLY_FEE() {
		return MONTHLY_FEE;
	}

}
