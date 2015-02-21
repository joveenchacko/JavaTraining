package com.simbiosys.assign5;

public class Account implements Depositable, Withdrawable, Balanceable{
    double balance;


	@Override
	public double getBalance() {
		// TODO Auto-generated method stub
		return balance;
	}

	@Override
	public void setBalance(double bal) {
		// TODO Auto-generated method stub
		balance=bal;
		
	}

	@Override
	public void withDraw(double amount) {
		
		
	}

	@Override
	public void deposit(double amount) {
		
		
	}

}
