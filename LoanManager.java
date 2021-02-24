//A8, Sophia M. Toliver, CIS 340, TTH 4:30pm

import java.util.ArrayList;
import java.util.Scanner;

public class LoanManager {
	
	public static void main(String[] args) {
		
		System.out.println("\t\t\tFirst National Loans\n");
		
		//create an instance to invoke non static methods
		LoanManager loansInSystem = new LoanManager();
		
		//invoke methods
		loansInSystem.loop();
		loansInSystem.loansRecorded();

	}//main

	Scanner scanner = new Scanner(System.in);
    ArrayList<Loan> loans;
    double allLoansTotal = 0.0;

    public LoanManager () {
    	
		loans = new ArrayList<>();
		
    }//LoanManager

    public void addNewLoan () {
	
	    double loanAmount = 0.0;
	    int years = 0;
	    double monthPayment;
	    double total;
	   
	//Create a new loan 
	    System.out.print("\nEnter loan amount: ");
	    loanAmount = Double.parseDouble(scanner.nextLine());
	
	    System.out.print("Enter number of years: ");
        years = Integer.parseInt(scanner.nextLine());
    
    //create an instance to calculate total of loan
        Loan calculateTotal = new Loan();
       
        monthPayment = calculateTotal.monthlyPayment(loanAmount, years);
        total = calculateTotal.totalPayment(monthPayment, years);
  	    System.out.printf("The total payment on this loan will be $%.2f\n", total);
  	    
  	    //running total of all loans
  	    allLoansTotal = allLoansTotal + total;
	    
  		//add the loan to the array
  	    Loan tmpLoan = new Loan ();
  	    tmpLoan.setLoanAmount(loanAmount);
  	    tmpLoan.setTotal(total);
  	    
        loans.add(tmpLoan);
  	    
}//addNewLoan
	
    public void loop() {
    	
    	String input = "";
    	
      do {
    	  
    	  addNewLoan();
    	      		
  	    System.out.print("\n\nDo you want to apply for another loan? (Y/N): ");
  	    input = scanner.nextLine();
    	  
      } while (input.equalsIgnoreCase(("y")));
       
      scanner.close();
		
    }//loopMenu
    
    public void loansRecorded () {
    	
    	//variables used for formatting purposes
    			String amount = "Amount";
    			String total = "Total Payment";
    			
    	//print out all loans and amounts 
    			System.out.println("\nFollowing are the loans in the system.");
    			System.out.printf("%-15s %-15s\n", amount, total);
    			
    			for(Loan l : loans) {
    				
    				l.printLoans();
    				
    			}//for
    	      
    			System.out.printf("\nThe total payment of all loans is $%.2f", allLoansTotal);
    			System.out.println("\nPress Enter to exit...");
    			System.exit(0);			
    			
    }//loansRecorded
    
}//class
