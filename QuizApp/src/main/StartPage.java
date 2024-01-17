package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.*;

public class StartPage extends JFrame implements ActionListener {
	
	JFrame startFrame = new JFrame();
	
//	ImageIcon im = new ImageIcon("icons\\background2.png");
//	Image bgImage = im.getImage().getScaledInstance(800,650, Image.SCALE_SMOOTH);
//	ImageIcon ima = new ImageIcon(bgImage);
//	JLabel background = new JLabel(ima);
	
	JLabel title = new JLabel("What's Bigger?");
	JLabel subTitle = new JLabel ("the ultimate quiz that is not as easy as it seems");
	JButton play = new JButton();
	
	Color blue = new Color(17, 141, 240);
	Color navy = new Color(14, 47, 86);
	Color red = new Color(255, 48, 79);
	Color beige = new Color(236, 236, 218);
	
	ImageIcon playIcon = new ImageIcon("icons\\circle2.png");
	Image splayIcon = playIcon.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH);
	ImageIcon playIcon2 = new ImageIcon(splayIcon);
	
	
	
	
	StartPage(){
		
		
		
		title.setBounds(195,100,400,70);
		title.setFont(new Font("Calibri", Font.BOLD, 64));
		title.setForeground(blue);
		
		subTitle.setBounds(165, 160, 600, 50);
		subTitle.setFont(new Font("Calibri", Font.PLAIN, 24));
		subTitle.setForeground(navy);
		
		
		play.setBounds(285,330,200,150);
		play.setFont(new Font("Sans", Font.BOLD, 37));
		play.setForeground(navy);
		play.setOpaque(false);
		play.setContentAreaFilled(false);
		play.setBorderPainted(false);
		//play.setBackground(beige);
		play.setFocusable(false);
		play.setIcon(playIcon2); 
		play.addActionListener(this);
		play.setHorizontalTextPosition(JButton.CENTER);
		//play.setVerticalTextPosition(JButton.BOTTOM);
		play.setText("Start !");
		
		startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		startFrame.setLocation(200, 100);
		startFrame.setSize(800,650);
		startFrame.setVisible(true);
		startFrame.setResizable(false);
		startFrame.setLayout(null);
		startFrame.getContentPane().setBackground(beige);	
		startFrame.add(title);
		startFrame.add(subTitle);
		startFrame.add(play);
		
//		startFrame.add(background);
//		background.setBounds(0, 0, 800, 650);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == play) {
			
			startFrame.dispose();
			
			try {
				new GamePage2();
			} catch (FileNotFoundException e1) {
				
				e1.printStackTrace();
			}
			
		}
		
	}
}
