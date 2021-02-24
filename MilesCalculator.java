//A2, Sophia M. Toliver, CIS 340, TTH 4:30

import java.util.Scanner; 

public class MilesCalculator {

	public static void main(String[] args) {
		
		String airportCode = "";
		double distance = 0.0;
		int flyerStatus = 0;
		double bonusMiles = 0.0;
		double totalDistance = 0.0;
	
		Scanner scanner = new Scanner(System.in);
	
		System.out.println("\t\t\t\t Miles Calculator" +
		"\n\nThis program will calculate how many miles you " +
		"earn on your Phoenix Air flight.");
		
		System.out.print("\nDESTINATIONS:\nLos Angeles (LAX)" +
		"\nSan DIego (SAN) \nLas Vegas (LAS)" + "\n\nEnter destination"
		+ " airport code: ");
		airportCode = scanner.nextLine();
		
		//distances for flights 
		switch (airportCode) {
		case "lax":
		case "LAX":
			distance = 369;
			break;
		case "san":
		case "SAN":
			distance = 304;
			break;
		case "las":
		case "LAS":
			distance = 255;
			break;
		default: 
				System.out.printf("\nPhoenix Air does not fly to %s. " +
				"There will be zero miles earned. \n" + 
			    "Press enter to quit...", airportCode);
				 System.exit(0);
					
		}//end switch
		
		System.out.print("\nSTATUS\n1. Bronze\n2. Silver\n3. Gold" +
		"\n4. Platinum\n\nEnter frequent flyer status opinion (1-4): ");
		flyerStatus = Integer.parseInt(scanner.nextLine());
		
		//how many extra miles are earned per status
		switch (flyerStatus) {
		case 1:
			bonusMiles = 0;
			totalDistance = bonusMiles + distance;
			break;
		case 2: 
			bonusMiles = distance * 0.25;
			totalDistance = bonusMiles + distance;
			break;
		case 3:
			bonusMiles = distance * 0.50;
			totalDistance = bonusMiles + distance;
			break;
		case 4:
			bonusMiles = distance * 1.0;
			totalDistance = bonusMiles + distance;
			break;
		default:
		    System.out.print("\nIncorrect input entered. " +
		"Status is not applied to total miles earned.");
		    totalDistance = distance;
			
		}//end 
		
		System.out.printf("\nYou will earn %.2f miles flying from" +
		" Phoenix to %s.", totalDistance, airportCode);
		
		scanner.close();
		
	}//end main

}//end class
