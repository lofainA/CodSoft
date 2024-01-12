package Main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		
		//initialize variables
		int total = 0;
		int average = 0;
		int limit = 100;
		String grade;
		Scanner sc = new Scanner(System.in);
		
		
		//array to store the subject names
		ArrayList<String> subjects = new ArrayList<String>();
		
		subjects.add("Database Management System");
		subjects.add("TeleHealth and Technology");
		subjects.add("Design and Analysis of Algorithms");
		subjects.add("Operating Systems");
		subjects.add("Computer Networks");
		
		
		
		//array to store the marks
		ArrayList<Integer> marks =  new ArrayList<Integer>();
		
		
		
		
		//get marks as input
		for(String sub: subjects) {
			
			System.out.print("Enter marks in " + sub + ": ");
			
			int mark = sc.nextInt();
			
			while (mark > 100) {
				System.out.println("Mark must be within " + limit + "!");
				System.out.print("Enter marks in " + sub + ": ");
				mark = sc.nextInt();
				
			}
			marks.add(mark);
		}
		
		sc.close();
		
		//calculate total
		for(Integer mark: marks) {
		
			total = total + mark;
		}

		
		average = total / marks.size(); //calculate average
		grade = gradeAssigner(average); //get grade
		
		System.out.println("Total marks: " + total);
		System.out.println("Average: " + average);
		System.out.println("Grade: " + grade);
		
	}
	
	
	
	//method to assign grade for a specific mark
	public static String gradeAssigner(int average) {
		
		String grade;
		
		if (average <= 100 && average >= 91) {
			
			grade = "O";
		}
		else if (average <= 90 && average >= 81) {
			
			grade = "A+";
		}
		else if (average <= 80 && average >= 71) {
			
			grade = "A";
		}
		else if (average <=70 && average >= 61) {
			
			grade = "B+";
		}
		else if (average <= 60 && average >= 56) {
			
			grade = "B";
		}
		else if (average <= 55 && average >= 50) {
			
			grade = "C";
		}
		else {
			
			grade = "RA";
		}
		
		return grade;
	}

}









