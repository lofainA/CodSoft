package main;

@SuppressWarnings("serial")
public class LowBalanceException extends Exception {
	
	static String str = "Your balance is too low to withdraw";
	public LowBalanceException(int amount, int balance) { 
		
		super(str);
	}
}
