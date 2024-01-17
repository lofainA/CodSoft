package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//import java.util.Timer;
//import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class GamePage2 implements ActionListener {
	
	Color blue = new Color(17, 141, 240);
	Color navy = new Color(14, 47, 86);
	Color red = new Color(255, 48, 79);
	Color beige = new Color(236, 236, 218);
	
	JFrame frame = new JFrame();
	
	JLabel question = new JLabel();
	JLabel extraLine = new JLabel();
	
	JButton option1 = new JButton();
	JButton option2 = new JButton();
	ButtonGroup bg = new ButtonGroup();

	
	//JButton next =  new JButton("next");
	JLabel status = new JLabel();
	JButton restart = new JButton("RESTART");
	//JButton submit = new JButton("submit");
	
	File questions = new File("files\\Questions.txt");
	FileReader fr = new FileReader(questions);
	BufferedReader br = new BufferedReader(fr);
	String currQuestion;
	
	File answers = new File("files\\Answers.txt");
	FileReader fr1 = new FileReader(answers);
	BufferedReader br1 =  new BufferedReader(fr1);
	String currAnswer;
	
	public int points;
	
	Timer timer = new Timer(1100, this);
	//TimerTask task;
	
	int seconds = 6;
	
	GamePage2() throws FileNotFoundException {
		
		frame.add(question);
		question.setBounds(100, 120, 700, 60);
		question.setFont(new Font("Calibri", Font.BOLD, 32));
		question.setForeground(red);
		
		frame.add(extraLine);
		extraLine.setBounds(100, 150, 700, 60);
		extraLine.setFont(new Font("Calibri", Font.BOLD, 32));
		extraLine.setForeground(red);
		
		frame.add(option1);
		option1.setBounds(190, 240, 400, 60);
		option1.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		option1.setForeground(navy);
		option1.setBackground(blue);
		option1.setFocusable(false);
		option1.setBorder(BorderFactory.createDashedBorder(navy, 4, 3, 2, true));
		
		frame.add(option2);
		option2.setBounds(190, 310, 400, 60);
		option2.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		option2.setForeground(navy);
		option2.setBackground(blue);
		option2.setFocusable(false);
		option2.setBorder(BorderFactory.createDashedBorder(navy, 4, 3, 2, true));
		
		bg.add(option1);
		bg.add(option2);
		
		option1.addActionListener(this);
		option2.addActionListener(this);
		
		//frame.add(next);
		//next.setBounds(330, 320, 100, 50);
		
		//frame.add(submit);
		//submit.setBounds(440, 320, 100, 50);
	
		frame.add(status);
		status.setBounds(320, 430, 200,50);
		status.setFont(new Font("Calibri", Font.BOLD, 32));
		status.setForeground(navy);
		
		frame.add(restart);
		restart.setBounds(650, 30, 95, 40);
		restart.setBackground(red);
		restart.setForeground(Color.WHITE);
		restart.setBorder(BorderFactory.createLineBorder(Color.black, 5));
		restart.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		restart.addActionListener(this);
		restart.setFocusable(false);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setSize(800,650);
		frame.setLocation(200,100);
		frame.setLayout(null);
		frame.setTitle("What's Bigger?");
		frame.setResizable(false);
		frame.setVisible(true);
		frame.getContentPane().setBackground(beige);
		
		try {
			displayQuestion();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//next.addActionListener(this);
		
		
	}
	
	JButton correct = new JButton();

	int flag = 0;
	
	public void displayQuestion() throws IOException {
		
		/*
		 * timer = new Timer(1000, new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) {
		 * 
		 * seconds++; status.setText("Seconds: " + seconds); if(seconds > 5) {
		 * timer.stop(); seconds = 0; status.setText("TIMEUP"); try { displayQuestion();
		 * } catch (IOException e1) {
		 * 
		 * e1.printStackTrace(); } } } });
		 */
		
		currQuestion = br.readLine();
		currAnswer = br1.readLine();
		//System.out.println(currAnswer);
		
		if (currQuestion != null) {
			
			String temp = currQuestion.substring(3);
			String[] ques = temp.split(" or ");
			
			if(currQuestion.length() > 39) {
				
				String first = currQuestion.substring(0,38);
				String second = currQuestion.substring(38);
				question.setText(first);
				extraLine.setText(second);
			}
			
			else { 
				question.setText(currQuestion);
			}
			
			//System.out.println(ques[0]);
			//System.out.println(ques[1]);
			
			option1.setText(ques[0]);
			option2.setText(ques[1]);
			
			timer.start();
		}
		
		
	}
	
	//method to perform actions upon clicking an option
	private void handleClick(JButton button, String currAnswer) {
       
        if (button.getText().equals(currAnswer)) {
            points++;
            System.out.println(points); // <-- for tracking
            //answer.setText("CORRECT");
            resetTimer();
            seconds = 6;
        }   
        
        
        else { 
        	//answer.setText("WRONG");
        	resetTimer();
            seconds = 6;
        }
        
        try {
			displayQuestion();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        

    }
	
	public void resetTimer() {
		
		//System.out.println(timer.getInitialDelay());
		--seconds;
    	status.setText("Timer: " + seconds); 
    	if(seconds < 0) {
    		timer.stop();
    		seconds = 6;
    		status.setText("NEXT !!");
    		try {
				displayQuestion();
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
    	}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource() == option1) {
			
			extraLine.setText(null);
			System.out.println(currAnswer); // <-- for tracking
			//System.out.println(option1.getText());
			
			if(currAnswer == null) {
				
				try {
					new EndPage(this);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				frame.dispose();
			}
			handleClick(option1,currAnswer);
			
		}
		
		if(e.getSource() == option2) {
			
			extraLine.setText(null);
			System.out.println(currAnswer); // <-- for tracking
			if(currAnswer == null) {
				
				try {
					new EndPage(this);
					
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				frame.dispose();
			}
			handleClick(option2, currAnswer);
		}
		
		if(e.getSource() == restart) {
			
			new StartPage();
			frame.dispose();
			
		}
			
		
		resetTimer();
		/*
		 * if(e.get) timer = new Timer(1000, new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) {
		 * 
		 * seconds++; status.setText("Seconds: " + seconds); if(seconds > 5) {
		 * timer.stop(); seconds = 0; status.setText("TIMEUP"); try { displayQuestion();
		 * } catch (IOException e1) {
		 * 
		 * e1.printStackTrace(); } } } });
		 */
		/*
		 * if(e.getSource() == next) {
		 * 
		 * currAnswer = "";
		 * 
		 * try { displayQuestion(); } catch (IOException e1) {
		 * 
		 * e1.printStackTrace(); } }
		 */
	}

}
