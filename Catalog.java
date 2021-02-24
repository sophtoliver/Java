//MP2, Sophia M. Toliver, CIS 340, TTH 4:30 pm

import java.util.Scanner;
import java.util.ArrayList;

public class Catalog {

	public static void main(String[] args) {
		
		//create an instance to invoke non static method
		Catalog newCatalog = new Catalog();
		
		//invoke method
		newCatalog.loadCatalog();
		

	}//main
	
	public static Scanner scanner = new Scanner(System.in);
	private ArrayList<Devices> catalog;
	private String sku = "";
	private String name = "";
	private boolean status = true;
	
	//variables used for formatting purposes
	private String skuHeader = "SKU";
	private String nameHeader = "Name";
	private String index = "#";
	 
	public Catalog () {
		catalog = new ArrayList<>();
	}//Catalog
	
	public void sampleData() {
		
		Devices tmpDevice = new Devices();
		
		//Device 1
		tmpDevice.setSku("6757a");
		tmpDevice.setName("Apple 9.7-inch iPad Pro");
		tmpDevice.setStatus(true);
		catalog.add(tmpDevice);
		
		//Device 2
		tmpDevice = new Devices();
		tmpDevice.setSku("93P51B");
		tmpDevice.setName("Amazon Kindle Fire Kids Edition");
		tmpDevice.setStatus(true);
		catalog.add(tmpDevice);
		
		//Device 3
		tmpDevice = new Devices();
		tmpDevice.setSku("10n8c");
		tmpDevice.setName("LeapFrog Epic Learning Tablet");
		tmpDevice.setStatus(true);
		catalog.add(tmpDevice);
		
		//Device 4
		tmpDevice = new Devices();
		tmpDevice.setSku("85U20");
		tmpDevice.setName("Amazon Kindle Fire HD 8");
		tmpDevice.setStatus(false);
		catalog.add(tmpDevice);
		
		//Device 5
		tmpDevice = new Devices();
		tmpDevice.setSku("91H2d");
		tmpDevice.setName("HP Envy 8 Note");
		tmpDevice.setStatus(true);
		catalog.add(tmpDevice);
	}//sampleData
	
	public void showMenu() {
	
		System.out.print("\t\t\tLibrary Device Checkout System");
		System.out.print("\n\n1. List Devices By Title"
				+ "\n2. Add New Devices \n3. Edit Device Information"
				+ "\n4. Search By Device Name \n5. Check Out Devices"
				+ "\n6. Check In Devices \n7. Exit");
	
	}//showMenu
	
	public void loopThroughMenu () {
		
		int input = 0;
		
		do {
			
			//try and catch method used so the system won't crash if the user 
			//does not enter a proper integer
			try {
				
			showMenu();
			System.out.print("\n\n\nSelect menu options 1-7: ");
			input = Integer.parseInt(scanner.nextLine());
			
			}//try
		
			catch (NumberFormatException e) {
				
				System.out.println("An invalid number was entered. Press enter to try again...\n");
		    	scanner.nextLine();
				
			}//catch
		
		//if statement for validity of user input
		if (input <= 7) {
		switch (input) {
		
		case 1:
			System.out.println("\n\n\t\t\tLibrary Device Checkout System - List");
			listDevices();
			System.out.println("\nPress Enter To Continue...");
	    	scanner.nextLine();
			break;
		case 2:
			System.out.println("\n\n\t\t\tLibrary Device Checkout System - Add Device");
			addDevice();
			System.out.println("\nPress Enter To Continue...");
	    	scanner.nextLine();
			break;
		case 3:
			System.out.println("\n\n\t\t\tLibrary Device Checkout System - Edit Device");
			editDevices();
			System.out.println("\nPress Enter To Continue...");
	    	scanner.nextLine();
			break;
		case 4:
			System.out.println("\n\n\t\t\tLibrary Device Checkout System - Search Device");
			searchDevices();
			System.out.println("\nPress Enter To Continue...");
	    	scanner.nextLine();
			break;
		case 5:
			System.out.println("\n\n\t\t\tLibrary Device Checkout System - Check Out Device");
			checkOut();
			System.out.println("\nPress Enter To Continue...");
	    	scanner.nextLine();
			break;
		case 6:
			System.out.println("\n\n\t\t\tLibrary Device Checkout System - Check In Device");
		    checkIn();
		    System.out.println("\nPress Enter To Continue...");
	    	scanner.nextLine();
		
		}//switch
	}//if
		
		else {
			System.out.printf("Enter a number 1-7. Press enter to try again...\n");
	    	scanner.nextLine();
		}//else
		
		} while (input != 7);
		System.out.println("Goodbye!");
		System.exit(0);
		
		
	}//loopThroughMenu
		
	    public void listDevices() {
	    	
	    	System.out.printf("%-1s %-10s %-35s\n", index, skuHeader, nameHeader);
	    
	    	//loop through catalog and print out objects
	    	int i = 0;
	    	for(Devices d : catalog) {
	    
	    		System.out.printf("%d %-10s %-35s %s\n", i+1, d.getSku().toUpperCase(), d.getName(), d.getStatus());
	    		i++;
	    		
	    	}//for
	    	
	    }//listDevices
	    
		public void addDevice () {
			
			//ask user for the new device's unique sku and name
			System.out.print("SKU: ");
			sku = scanner.nextLine();
			System.out.print("Name: ");
			name = scanner.nextLine();
			
			//set the sku and name
			Devices tmpDevice = new Devices(sku, name, status);
			tmpDevice.setName(name);
			tmpDevice.setSku(sku.toUpperCase());
			tmpDevice.setStatus(true);
			
			//add the new device to the catalog
			catalog.add(tmpDevice);
			System.out.printf("Added %s to Catalog.\n", name);

		}//addDevice
		
		public void editDevices () {
			
			int deviceNumber = 0;
			
			listDevices();
			
			try {

			System.out.printf("\n\nEnter device number to edit (1-%d): ", catalog.size());
			deviceNumber = Integer.parseInt(scanner.nextLine());
			
			//if statement for validity of user input
			if (deviceNumber < catalog.size()+1) {
				//ask user for what they want to change the chosen device's sku
				//and name too	
				System.out.print("\nSKU: ");
				sku = scanner.nextLine();
				System.out.print("Name: ");
				name = scanner.nextLine();
				
				//set the revised sku and name of chosen device
				catalog.get(deviceNumber-1).setSku(sku);
				catalog.get(deviceNumber-1).setName(name);
				
				System.out.println("\nDevice information updated.");
				}//if
				
				else { 
					System.out.printf("Must enter a number 1-%d. Main menu will reload.\n", catalog.size());
				}//else
			
			}//try
			
			catch (NumberFormatException e) {
				
				System.out.println("An invalid number was entered. Main menu will reload.\n");
		
			}//catch
			
		}//editDevice
		
		public void searchDevices () {
			
			String search = "";

			System.out.print("\n\nEnter device to search for: ");
			search = scanner.nextLine();
			
			System.out.printf("Listings for '%s'\n", search);
			
			System.out.printf("%-1s %-10s %-35s\n", index, skuHeader, nameHeader);
			
			
			int i = 0;
			for (Devices d : catalog) {
				
				//compare the name of each object to the search and return it's information if a match
				//name and search converted to upper case for case insentivity
				if(catalog.get(i).getName().toUpperCase().contains(search.toUpperCase())) {
		
					System.out.printf("%d %-10s %-35s\n", i+1, d.getSku(), d.getName());
				}//if
				
				i++;
				
			}//for
			

		}//searchInDevices
		
		public void checkOut () {
			
			int input = 0;
			
			System.out.println("\n\nAvailable Devices\n");
			System.out.printf("%-1s %-10s %-35s\n", index, skuHeader, nameHeader);
			
			int i = 0;
			//loop through objects of devices and return only those that are available
			for (Devices d : catalog) {
				
				if (catalog.get(i).getStatus().equals("Available")) {
					
					System.out.printf("%d %-10s %-25s\n" ,i+1, d.getSku(), d.getName());
				}//if
				
				i++;
			}//for
			
			try {
				
			System.out.print("\n\nEnter device number: ");
			input = Integer.parseInt(scanner.nextLine());
		
		//throw error code if user input is out of array list bounds and re- loop
		if (input < catalog.size()+1) {
			
			//if the device entered is already checked out, throw an error code to user and re- loop
			if (catalog.get(input-1).getStatus().equals("Available")) {
			catalog.get(input-1).setStatus(false);
			
			System.out.println("Successfully checked out.");
			}//if
			
			else {
				System.out.printf("This device is already checked out. Main menu will reload.\n");
			}//else
			
		}//if
	
			else {
			System.out.printf("Must enter a number 1-%d. Main menu will reload.\n", catalog.size());
		
			}//else
			
		}//try
		
		catch (NumberFormatException e) {
			
			System.out.println("An invalid number was entered. Main menu will reload.\n");
			
		}//catch

		}//checkOut
		
		public void checkIn () {
			
			int input = 0;
		
			System.out.println("\n\nChecked Out Devices\n");
			System.out.printf("%-1s %-10s %-35s\n", index, skuHeader, nameHeader);
			
			int i = 0;
			//loop through objects of devices and return only those that are checked out
			for (Devices d : catalog) {
			
				if (catalog.get(i).getStatus().equals("Checked Out")) {
					
					System.out.printf("%d %-10s %-25s\n", i+1, d.getSku(), d.getName());
				}//if
				
				i++;
			}//for
			
		try {
			
			System.out.print("\n\nEnter device number: ");
			input = Integer.parseInt(scanner.nextLine());
		
		//throw error code if user input is out of array list bounds and re- loop
		if (input < catalog.size()+1) {
				
			//if the device entered is already checked in, throw an error code to user and re- loop
			if (catalog.get(input-1).getStatus().equals("Checked Out")) {
			catalog.get(input-1).setStatus(true);
			
			System.out.println("Successfully checked in.");
            }//if
			
			else {
				System.out.printf("This device is already checked in. Main menu will reload.\n");
			}//else
			
		}//if
	
			else {
			System.out.printf("Must enter a number 1-%d. Main menu will reload.\n", catalog.size());
		
			}//else
			
		}//try
		
		catch (NumberFormatException e) {
			
			System.out.println("An invalid number was entered. Main menu will reload.\n");
			
		}//catch
			
		}//checkIn
		
	public void loadCatalog() {
		sampleData();
		loopThroughMenu();
	}//loadCatalog

}//Catalog
