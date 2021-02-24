//A8, Sophia M. Toliver, CIS 340, TTH 4:30pm

public class Loan {
	
	private double loanAmount;
	private int years;
	private double annualInterestRate;
	private double total;
	
	public Loan () {
		
		annualInterestRate = 5.0;
		
	}//loan
	
	public Loan (double loanAmount, double total) {
		this.loanAmount = loanAmount;
		this.total = total;
	}//loan

	public void printLoans () {
		
		System.out.printf("%-15.2f %-15.2f\n", loanAmount, total);
		
	}//printLoans

	public double monthlyPayment (double amount, int years) {
		
		double monthInterestRate = 0.0;
		double monthlyPayment = 0.0;
		
		monthInterestRate = annualInterestRate / 1200 ;
		monthlyPayment = amount * monthInterestRate / (1- (Math.pow(1 / (1+ monthInterestRate), years * 12)));
		
		return monthlyPayment;
	
	}//monthlyPayment
	
	public double totalPayment (double monthlyPayment, int years) {
		
		total = monthlyPayment * 12 * years ;
		
		return total; 
		
	}//totalPayment
	
	public double getLoanAmount () {
		
		return loanAmount;
		
	}//getLoanAmount
	
	public void setLoanAmount (double loanAmount) {
		
		this.loanAmount = loanAmount; 
		
	}//getLoanAmount
	
	public double getTotal () {
		
		return total;
		
	}//getTotal
	
	public void setTotal (double total) {
		
		this.total = total; 
		
	}//setTotal
	
}//Loan
