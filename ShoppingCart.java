//A4, Sophia M. Toliver, CIS 340, TTH 4:30

import java.util.Scanner;

public class ShoppingCart {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("\t\t\tShopping Cart" + 
		"\n\nThis program maintains a list of products (name, category, price)." +
		" It will calculate average dollars spent per category for you.\n");
		
		//declare arrays
		String [] products;
		String [] category;
		double [] price;
		
		//initialize arrays
		products = new String [5];
		category = new String [5];
		price = new double [5];
		
		//declare & initialize variables
		double total = 0.0;
		double average = 0.0;
		int countOfProducts = 0;
		
		//to store 5 products' descriptions 
		//inputed by user into the correct arrays
		for(int i = 0; i < products.length; i++) {
			System.out.print("\nEnter product name: ");
			products[i] = scanner.nextLine();
			
			System.out.print("Enter product category (Tech/Grocery/Office): ");
			category[i] = scanner.nextLine();
			
			System.out.print("Enter product price: ");
			price[i] = Double.parseDouble(scanner.nextLine());
		
		}//end for
		
		//the next 4 for loops are outputting the products
		// and average dollars spent per category
		
		//tech products & average amount spent
		System.out.println("\nTECH PRODUCTS");
		for(int i = 0; i < products.length; i++) {
			if (category[i].equalsIgnoreCase("tech")) {
				System.out.print(products[i]);
				System.out.println();
				//accumulated totals
				total =+ price[i];
				countOfProducts++;
			}//end if
			
		}//end for
		average = total / countOfProducts;
		System.out.printf("Average dollars spent: %.2f\n", total);
	
		//resetting countOfProducts and total back to zero
		//for proper calculation of average
		countOfProducts = 0;
		total = 0.0;
		//grocery products & average amount spent
		System.out.println("\nGROCERY PRODUCTS");
		for(int i = 0; i < products.length; i++) {
			if(category[i].equalsIgnoreCase("grocery")) {
				System.out.print(products[i]);
				System.out.println();
				total = total + price[i];
				countOfProducts++;
			}//end if
			
		}//end for
		average = total / countOfProducts;
		System.out.printf("Average dollars spent: %.2f\n", average);
		
		countOfProducts = 0;
		total = 0.0;
		//office products & average amount spent
		System.out.println("\nOFFICE PRODUCTS");
		for(int i = 0; i < products.length; i++) {
			if(category[i].equalsIgnoreCase("office")) {
				System.out.print(products[i]);
				System.out.println();
				total = total + price[i];
				countOfProducts++;
			}//end if
			
		}//end for
		average = total / countOfProducts;
		System.out.printf("Average dollars spent: %.2f\n", average);
		
		countOfProducts = 0;
		total = 0.0;
		//other products (due to user not inputing
		//one of the three category options correctly)
		System.out.println("\nOTHER");
		for(int i = 0; i < products.length; i++) {
			if(!category[i].equalsIgnoreCase("tech") &&
					!category[i].equalsIgnoreCase("grocery") &&
							!category[i].equalsIgnoreCase("office")) {
				System.out.print(products[i]);
				System.out.println();
				total = total + price[i];
				countOfProducts++;
			}//end if
			
		}//end for
		average = total / countOfProducts;
		System.out.printf("Average dollars spent: %.2f\n", average);
		
				
    scanner.close();
 
	}//end main


}//end class 
