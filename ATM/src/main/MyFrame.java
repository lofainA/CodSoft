package main;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener {
	
	
	JLabel label = new JLabel("How can we help you today?");
	JLabel textLabel =  new JLabel ("Amount:");
	JTextField amountField = new JTextField();
	JButton deposit = new JButton("Deposit");
	JButton withdraw = new JButton("Withdraw");
	JButton checkBalance = new JButton("Check Balance");
	JLabel status =  new JLabel();
	
	String amount;
	
	Account acc  = new Account();
	int balance =  acc.balance;
	
	MyFrame() {
		
		
		label.setBounds(186, 120, 500,50);
		label.setFont(new Font("Calibri", Font.BOLD, 30));
		
		textLabel.setBounds(190,190,100,50);
		textLabel.setFont(new Font("Calibri", Font.PLAIN, 18));
		
		amountField.setBounds(275, 198, 250, 35);
		deposit.setBounds(150, 280, 100, 50);
		withdraw.setBounds(300, 280, 100, 50);
		checkBalance.setBounds(450, 280, 120, 50);
		status.setBounds(270,350,250,50);
		
		amountField.addActionListener(this);
		deposit.addActionListener(this);
		withdraw.addActionListener(this);
		checkBalance.addActionListener(this);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(740,500);
		
		this.setTitle("ATM");
		this.setLayout(null);
		this.setResizable(false);
		
		this.add(label);
		this.add(textLabel);
		this.add(amountField);
		this.add(deposit);
		this.add(withdraw);
		this.add(checkBalance);
		this.add(status);
		
		this.setVisible(true);
	}
	
	public void deposit(int amt) {
		
		//add amount to the current balance
		balance += amt;
		amountField.setText("");
	}
	
	public void withdraw(int amt) {
		
		//subtract amount from the current balance
		balance -= amt;
		amountField.setText("");
	}
	
	public void checkBalance() {
		
		//show acc.balance
		status.setText("Your current Balance is: Rs." + balance);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == deposit) {
			
			try {
				
				amount = amountField.getText();
				int amt = Integer.parseInt(amount);
				
				if(amt > 25000) {
					
					throw new TooHighException(amt);
				}
				
				deposit(amt);
				status.setText("Rs." + amount + " has been deposited");
				System.out.println("balance = " + balance);
				
				
			} catch (NumberFormatException nfe) {
				
				status.setText("Enter an amount to deposit");
				
			} catch (TooHighException the) {
				
				status.setText(the.getMessage());
				amountField.setText("");
			}
			
		}
		
		if(e.getSource() == withdraw) {
			
			try {
				
				amount = amountField.getText();
				int amt = Integer.parseInt(amount);
				
				if(amt > 25000) {
					
					throw new TooHighException(amt);
				}
				
				if(amt > balance) {
					
					throw new LowBalanceException(amt, balance);
				}
				withdraw(amt);
				status.setText("Rs." + amount + " has been withdrawn");
				System.out.println("balance = " + balance);
				
			} catch(NumberFormatException nfe) {
				
				status.setText("Enter an amount to withdraw");
				
			} catch (TooHighException the) {
				
				status.setText(the.getMessage());
			
			} catch (LowBalanceException lbe) {
				
				status.setText(lbe.getMessage());
			}
			
			
		}
		
		if(e.getSource() == checkBalance) {
			
			checkBalance();
		}
		
	}
}
