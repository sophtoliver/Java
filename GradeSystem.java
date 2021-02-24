//A5, Sophia M. Toliver, CIS 340, TTH 4:30pm

import java.util.Scanner;

public class GradeSystem {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		//delcare and initialize arrays and variables
		String[] nameArray;
		nameArray = new String[5];
		
		int[] scoreArray;
		scoreArray = new int[5];
		
		String studentName = "";
		int studentPosition = 0;
		
		System.out.println("\t\t\tStudent Grade System");
		System.out.println("\nThis program will store student grades and look them up for you.");
		
		//pass array into method
		populateNameArray(nameArray);
		
		//white space for formatting
		System.out.println("\n\n\n\n");
		
		//pass arrays into method
		populateScoreArray(scoreArray, nameArray);
		
		//white space for formatting
		System.out.println("\n\n\n\n");
		
		//figure out what student user wants to look for and store the name 
		System.out.print("\nEnter name of student whose score you want to find: ");
		studentName = scanner.nextLine();
		
		//pass name and array into method
		studentPosition = findStudentPosition(studentName, nameArray);
	
        //incorrect name entered
		if (studentPosition == -1) {
			
			System.out.println("I'm sorry. There is no student by that name.");
		
		}//end if
			else 
			System.out.printf("%s's score is %d.", studentName, scoreArray[studentPosition]);
		
		
scanner.close();
		
	}//end main
	
	private static void populateNameArray(String[] populateNameArray) {
		
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("\n***************************");
		System.out.println("Enter the names of 5 students");
		System.out.println("***************************\n");
		
		for (int i = 0; i < populateNameArray.length; i++) {
			
			populateNameArray[i] = scanner.nextLine();
			
		}//end for
		
	}//end populateNameArray
	
	private static void populateScoreArray(int[] populateScoreArray, String[] nameArray) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("***************************");
		System.out.println("Enter scores. One score per line.");
		System.out.println("***************************\n");
		
		for (int i = 0; i < populateScoreArray.length; i++) {
			
			System.out.printf("Enter score for %s: ", nameArray[i]);
			populateScoreArray[i] = Integer.parseInt(scanner.nextLine());
			
		}//end for
		
	}//end populateScoreArray
	
	private static int findStudentPosition(String nameOfStudent, String[] nameArray) {
		
		int position = 0;
		
		for (int i = 0; i < nameArray.length; i++) {
			
			if (nameOfStudent.equalsIgnoreCase(nameArray[i])) {
				position = i;
				break;
			}//end if
			else 
				position = -1;
		}//end for
		
		return position;
		
	}//end findStudentPosition

}//end class
