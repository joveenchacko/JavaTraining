package com.simbiosys.assign6;

public class CheckNumberRunnable implements Runnable{
	int inputNumber;
	int begRangeNumber;
	int endRangeNumber;
	static int yieldCounter=0;
	boolean found = false;
	
	CheckNumberRunnable(int inputNumber, int begRangeNumber, int endRangeNumber){
		this.inputNumber = inputNumber;
		this.begRangeNumber = begRangeNumber;
		this.endRangeNumber = endRangeNumber;
	}
	public void run(){
		Thread t = Thread.currentThread();
		
		for(int i=begRangeNumber;i<=endRangeNumber;i++){
			if(i==this.inputNumber){
				System.out.println("\n"+ t.getName() +" found the number " + this.inputNumber);
				found = true;
			}
		}
		if(found==false){
			yieldCounter++;
			System.out.println("thread yielded: "+ CheckNumberRunnable.yieldCounter +" times" );
			Thread.yield();
			
		}
	}

}
