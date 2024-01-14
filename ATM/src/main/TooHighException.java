package main;

@SuppressWarnings("serial")
public class TooHighException extends Exception{
	
	static String str = "Amount must be less than 25000";
	public TooHighException(int amount) { 
		
		super(str);
	}
}
