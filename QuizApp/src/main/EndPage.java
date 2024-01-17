package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
//import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

//import java.net.*;

public class EndPage implements ActionListener {
	
	Color blue = new Color(17, 141, 240);
	Color navy = new Color(14, 47, 86);
	Color red = new Color(255, 48, 79);
	Color beige = new Color(236, 236, 218);
	
	JFrame frame = new JFrame();
	
	JLabel status = new JLabel();
	JLabel pointStat = new JLabel();
	
	ImageIcon repeat = new ImageIcon("icons\\repeat.png");
	Image sRepeat = repeat.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	ImageIcon Rerepeat = new ImageIcon(sRepeat);
	
	JButton tryAgain = new JButton();
	JButton close = new JButton();
	JButton main = new JButton();
	
	
	
	
	EndPage(GamePage2 prev) throws FileNotFoundException {
		
		//GamePage2 prev = new GamePage2()
		
		
		int points = prev.points;
		
		frame.add(status);
		frame.add(pointStat);
		
		status.setBounds(220, 120, 600, 100);
		status.setFont(new Font("Comic Sans MS", Font.BOLD, 42));
		status.setForeground(navy);
		
		pointStat.setBounds(310, 200, 400, 100);
		pointStat.setFont(new Font("Comic Sans MS", Font.BOLD, 32));
		pointStat.setForeground(red);
		
		if(points == 10) {
			status.setText("You got all of them correct !!!");
			status.setBounds(120, 120, 600, 100);
			status.setFont(new Font("Comic Sans MS", Font.BOLD, 39));
			pointStat.setText("Points: " + points);
		}
		
		
		else { 
			int pointsLost = 10 - points; 
			status.setText("You got " + pointsLost + " wrong");
			pointStat.setText("Points: " + points); 
			
		}
		
		frame.add(tryAgain);
		tryAgain.setBounds(285, 340, 194, 70);
		tryAgain.setBackground(blue);
		tryAgain.setBorder(BorderFactory.createLineBorder(navy, 5, false));
		tryAgain.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		tryAgain.setForeground(Color.WHITE);
		tryAgain.setIcon(Rerepeat);
		//tryAgain.repaint();
		tryAgain.setText("Try Again?");
		tryAgain.addActionListener(this);
		tryAgain.setFocusable(false);
		
		frame.add(close);
		close.setText("Exit");
		
		frame.add(main);
		main.setText("Back to main");
		
		frame.setSize(800,650);
		frame.setLocation(200,100);
		frame.setLayout(null);
		frame.setTitle("What's Bigger?");
		frame.setResizable(false);
		frame.setVisible(true);
		frame.getContentPane().setBackground(beige);
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == tryAgain) {
			
			new StartPage();
			frame.dispose();
			
//			System.out.println("Status:" + Rerepeat.getImageLoadStatus());
//			System.out.println("Icon width: " + Rerepeat.getIconWidth());
//			System.out.println("Icon height: " + Rerepeat.getIconHeight());
		}
	}
	
}
