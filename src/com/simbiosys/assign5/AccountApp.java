package com.simbiosys.assign5;

import java.util.Scanner;

public class AccountApp {

	static final double initialCheckingBalance = 5500;
	static final double initialSavingsBalance = 22000;

	static Scanner sc = new Scanner(System.in);

	static Double amountInput;
	static String accountChoice;
	static Account acct = new Account();

	static CheckingAccount checkingAcct = new CheckingAccount(
			initialCheckingBalance);
	static SavingsAccount savingsAcct = new SavingsAccount(
			initialSavingsBalance);
	
	public static void main(String args[]) {

		//1. Welcome section
		System.out.println("Welcome to the Account application\n");
		System.out.println("Starting Balance");
		System.out.println("CHECKING: " + AccountApp.initialCheckingBalance);
		System.out.println("SAVINGS: " + AccountApp.initialSavingsBalance);
		System.out.println("\nEnter the transaction for the month\n");

		//2. Start a transaction. Gives u choice withdraw or desposit. Then choice of checking or saving
		// then amount associated with the transaction
		AccountApp.startTransaction();
		
	
	}

	
	private static String validatemoreTransactions(){

		String moreTransactionsChoice;
		System.out.print("Continue? y/n): ");
		moreTransactionsChoice = sc.next();
		// if you want to do more transactions while
		while (!Validator.validate(moreTransactionsChoice, "y", "n") == true) {
			System.out.println("Please choose y/n.");
			System.out.print("Continue? y/n): ");
			moreTransactionsChoice = sc.next();
		}
		return moreTransactionsChoice;
	}
	
	
	private static void startTransaction() {
		String transactionChoice;
		System.out.print("Withdrawal or deposit? (w/d): ");
		transactionChoice = sc.next();
		while (!Validator.validate(transactionChoice, "w", "d") == true) {
			System.out.println("Please choose w/d");
			System.out.println("Withdrawal or deposit? (w/d): ");
			transactionChoice = sc.next();
		}
		// System.out.println("trasnaction choice: " + transactionChoice);

		System.out.print("Checking or savings? (c/s):");
		accountChoice = sc.next();
		while (!Validator.validate(accountChoice, "c", "s") == true) {
			System.out.println("Please choose c/s");
			System.out.print("Checking or savings? (c/s): ");
			accountChoice = sc.next();
		}

		//System.out.println("accountChoice choice: " + accountChoice);

		System.out.print("Amount?: ");
		amountInput = sc.nextDouble();
		
		//TODO you need to do the validation of amount based on deposit or withdrawable
		while (!Validator.validateAmount(amountInput, acct.getBalance()) == true) {

			System.out.println("Amount chosen has to be greater than 0 and less than balance");
			System.out.print("Amount?: ");
			amountInput = sc.nextDouble();
		}

		if (accountChoice.compareTo("c") == 0) {

			if (transactionChoice.compareTo("w") == 0) {
				Transactions.withdraw(checkingAcct, amountInput);
			} else if (transactionChoice.compareTo("d") == 0) {
				Transactions.deposit(checkingAcct, amountInput);
			}
		} else if (accountChoice.compareTo("s") == 0) {
			if (transactionChoice.compareTo("w") == 0) {
				Transactions.withdraw(savingsAcct, amountInput);
			} else if (transactionChoice.compareTo("d") == 0) {
				Transactions.deposit(savingsAcct, amountInput);
			}
		}
		
		 //3. Check if user wants to do more transactions
		String continueOn = AccountApp.validatemoreTransactions();

		if (continueOn.compareTo("y") == 0) {
			//moreTransactions=1;
			AccountApp.startTransaction();
		} else if (continueOn.compareTo("n") == 0) {
			// if you don't have any transactions to do
			AccountApp.displayResults();
		}

	}

	private static void displayResults() {

		System.out.println("Monthly Payments and Fees");
		System.out.println("Checking Fee: " + CheckingAccount.getMONTHLY_FEE());
		// calculate monthly payment
		SavingsAccount.calculateMonthlyPayment();
		System.out.println("Savings Interest Payment: "
				+ SavingsAccount.getMonthlyPayment());

		System.out.println("\nFinal Balances");
		System.out.println("Checking: " + CheckingAccount.checkingBalance);
		double savingsFinalBalance = SavingsAccount.savingsBalance + SavingsAccount.getMonthlyPayment();
		System.out.println("Savings: "+ savingsFinalBalance);

	}
}
