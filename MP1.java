//MP1, Sophia M. Toliver, CIS 340, 4:30pm

import java.util.Scanner;

public class MP1 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
	
        //declare and initialize main variables
		String[] names; 
		double [][] scores;
		int numScoresPerStudent = 0;
		String choiceNumber = "";
		
		names = new String [3];
	
		System.out.print("\nHow many quiz scores per student? ");
		numScoresPerStudent = Integer.parseInt(scanner.nextLine());
		
		scores = new double [names.length] [numScoresPerStudent];
		
		//store names and quizzes per student
	    for (int i = 0; i < names.length; i++) {
	    	
	        System.out.printf("\nEnter name for student %d: ", i + 1);
	        names[i] = scanner.nextLine();
	        
	        System.out.printf("\nEntering scores for %s\n", names[i]);
	        for (int j = 0; j < numScoresPerStudent; j++) {
	        	System.out.printf("Quiz %d: ", j + 1);
	        	scores[i][j] = Double.parseDouble(scanner.nextLine());
	        	
	        }//end for
	    	
	    }//end for
		
	    //menu for program
	    do {
	    	
	    	showMenu();
	    	
	    	System.out.print("\n\nEnter choice number, or x, to exit: ");
	    	choiceNumber = scanner.nextLine();
	    	
	    	switch (choiceNumber) {
	    	
	    	case "1": 
	    		//declare and initialize variable to pass into class average method
	    		double classAverage = 0.0;
	    		classAverage = calculateClassAverage(scores);
	    		System.out.printf("Class average for all quizzes is %.2f", classAverage);
	    		break;
	    	case "2":
	    		//asking for student name to calculate average for 
	    		String studentName = "";
	    		System.out.println("\nCalculating Average By Student.");
	    		System.out.print("\nEnter student name: ");
	    		studentName = scanner.nextLine();

	    		//declare and initialize variable to pass into student average method
	    		double studentAverage = 0.0;
	    		studentAverage = calculateStudentAverage(studentName, names, scores);
	    		
	    		//criteria for incorrect name entered or not
	    		if (studentAverage == 0) {
	    			System.out.println("Student not found.");
	    		}//end if
	    		else
	    		System.out.printf("\n%s's average is %.2f", studentName, studentAverage);
	    		
	    	    break;
	    	case "3":
	    		//asking for quiz number to calculate average for 
	    		int quizNumber = 0;
	    		System.out.println("\nCalculating Average By Quiz Number.");
	    		System.out.print("\nEnter quiz number: ");
	    		quizNumber = Integer.parseInt(scanner.nextLine());
	    		
	    		//declare and initialize variable to pass into quiz average method
	    		double quizAverage = 0.0;
	    		quizAverage = calculatesQuizAverage(quizNumber, scores);
	    		System.out.printf("\nQuiz %d average is %.2f", quizNumber, quizAverage);
	    		break;
	    	
	    	}//end switch
	    	
	    	//white space for formatting
	    	System.out.println("\n\n\n");
	    	
	    	//sentinel for user input to stop program
	    } while (! choiceNumber.equalsIgnoreCase("x"));
	    
		
		scanner.close();
		
	}//end main

	private static void showMenu() {
		
		System.out.println("\nMenu");
		System.out.println("1. Class Average \n2. Student Average \n3. Quiz Average");
		
	}//end showMenu
	
	private static double calculateClassAverage (double [][] scoresArray) {
		
		 double scoresTotal = 0.0;
		 int numOfScores = 0;
		 double average = 0.0;
		
		for (int i = 0; i < scoresArray.length; i++) {
			for (int j = 0; j < scoresArray[i].length; j++) {
				
				//accumulated totals 
				scoresTotal += scoresArray[i][j];
				numOfScores++;
			}//end for
			
		}//end for
		
		average = scoresTotal / numOfScores;
		
		return average;
		
	}//end classAverage
	
	private static double calculateStudentAverage (String name, String [] namesArray, double [][] scoresArray) {
		
		int position = 0;
		double average = 0.0;
		double scoresTotal = 0.0;
		int numOfScores = 0;
		
		for (int i = 0; i < namesArray.length; i++) {
			
			if (name.equalsIgnoreCase(namesArray[i])) {
				position = i;
				
			
				for( int j = 0; j < scoresArray[i].length; j++) {
					
					//accumulated totals
					scoresTotal += scoresArray[i][j];
					numOfScores++;
					
				}//end for
				System.out.printf("%s's scores are: ", name);
				for (int k = 0; k < scoresArray[i].length; k++) {
				     System.out.printf(" %.2f", scoresArray[i][k] );
				}//end for
				
				average = scoresTotal / numOfScores;
				break;
			}//end if
			
		}//end for
		
		if(numOfScores == 0)
		average = 0;
		
		return average;
			
	}//end calculateStudentAverage
	
	private static double calculatesQuizAverage (int quiz, double [][] scoresArray) {
		
		double average = 0.0;
		double scoresTotal = 0.0;
		int numOfScores = 0;
		
			
			for(int i = 0; i < scoresArray.length; i++) {
			
				//offset by 1 because quizzes in the program start with 0, not 1
				scoresTotal += scoresArray[i][quiz - 1];
				numOfScores++;
			
			}//end for
		
		average = scoresTotal / numOfScores;
		
		return average;
		
	}//end calculateStudentAverage
	
}//end class
