//A1, Sophia M. Toliver, CIS 340 TTH 4:30pm

import java.util.Scanner;

public class TaxCalculator {

	public static void main(String[] args) {
		
		double gross_income = 0.0;
		int deduction = 0;
		double net_income = 0.0;
		double federal_tax = 0.0;
		double state_tax = 0.0;
		double income_tax = 0.0;
		String filing_status = "";

		//import scanner to read user output
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("\t \t \t \t Income Tax Calculator");
		System.out.println("\n This program will calculate your income tax.");
		System.out.printf("\n What is your gross income? $");
		  gross_income = Double.parseDouble(scanner.nextLine());
		  
		//menu for filing status 
		System.out.println("\n FILING STATUS. \n Single - SG" +
		"\n Married Joint - MJ \n Married Separately - MS" +
		"\n Head of Household - HH");
		
		System.out.printf("\n Enter the two letter code corresponding " +
		"with your status: ");
		  filing_status = scanner.nextLine();
		 
		//calculation of deduction & net_income based on filing status
		    switch (filing_status) {
		    case "sg":
		    case "SG":
				deduction = 5950;
				net_income = gross_income - deduction;
				break;
		    case "mj":
		    case "MJ":
		    	deduction = 11900;
		    	net_income = gross_income - deduction;
		    	break;
		    case "ms":
		    case "MS":
		    	deduction = 5950;
		    	net_income = gross_income - deduction;
		    	break;
		    case "hh":
		    case "HH":
		        deduction = 8700;
		        net_income = gross_income - deduction;
		        break;
		    default: 
		    	System.out.println("\n Invalid option was selected. " + 
		    "Your final tax liability cannot be calculated correctly.");
		    	break;
		    }//end switch
		    
	  //calculation of federal_tax
		    if (net_income < 30000) {
		    	federal_tax = 0.0; }//end if
		    if (net_income >= 30000 && net_income < 60000) {
		    	federal_tax = net_income * 0.1; }//end if
		    if (net_income >= 60000 && net_income < 100000) {
		    	federal_tax = net_income * 0.2; }//end if
		    if (net_income >= 100000 && net_income < 250000) {
		    	federal_tax = net_income * 0.3; }//end if
		    if (net_income >= 250000) {
		    	federal_tax = net_income * 0.4; }//end if
     //calculation of state_tax
		    state_tax = net_income * .025;
     
     //calculation of final tax
		    income_tax = federal_tax + state_tax;
		    
	 //final tax liability
		    System.out.printf("\n Your stated income was $%.2f.", gross_income);
		    System.out.printf("\n Your final tax liability was $%.2f.", income_tax);
		    
		    scanner.close();
		    		
		  
				  }//end main

}//end class
