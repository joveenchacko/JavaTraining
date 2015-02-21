package com.simbiosys.assign5;

public class Validator {
	
	// input string should be equal to either c1 or c2 values

	public static boolean validate(String input, String c1, String c2){
		if (((input.trim().compareToIgnoreCase(c1)==0) ||  (input.trim().compareToIgnoreCase(c2)==0))){
			
			return true;
			
		}
		
		return false;
	}

	public static boolean validateAmount(double amount,double bal) {
		// TODO Auto-generated method stub
		if (amount< bal){
			return true;
		}
		
		if (amount < 0){
			return true;
		}
		return false;
	}
	
	/*public static boolean validateAmountGreaterThanZero(double amount,double bal) {
		// TODO Auto-generated method stub
		if (amount>0){
			return true;
		}
		return false;
	}*/
}
