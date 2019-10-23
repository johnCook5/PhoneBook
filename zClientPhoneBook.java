package PhoneBookAssignment;

import java.util.Scanner;


public class zClientPhoneBook
{

	
	
	
	
	public static void main(String[] args)
	{
		//temp data
		Person p1 = new Person("John Doe", "114 Market St", "St Louis", "MO", "63403", "6366435698");
		Person p2 = new Person ("John E Doe", "324 Main St", "St Charles", "MO","63303", "8475390126");
		Person p3 = new Person("John Michael West Doe", "574 Pole ave", "St. Peters", "MO", "63333", "5628592375");
		PhoneBookActivity.addToArray(p1);
		PhoneBookActivity.addToArray(p2);
		PhoneBookActivity.addToArray(p3);
		
		final Scanner keyboard = new Scanner(System.in);
		
		mainMenu();
		keyboard.close();
		
	
	}

	

	public static void mainMenu()
	{
		int mainMenuChoice;

		do
		{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Welcome to the Phone Book.\n\t***MAIN MENU***\nPlease select an option by number from the choices below:\n");
		System.out.println("Option 1:\tAdd an New record to the Phone Book");
		System.out.println("Option 2:\tSearch for an existing record by first name");
		System.out.println("Option 3:\tSearch for an existing record by last name");
		System.out.println("Option 4:\tSearch for an existing record by full name");
		System.out.println("Option 5:\tSearch for an existing record by telephone");
		System.out.println("Option 6:\tSearch for an existing record by city");
		System.out.println("Option 7:\tSearch for an existing record by state");
		System.out.println("Option 8:\tDisplay all records");
		System.out.println("Option 9:\tExit the system");
		System.out.println("\n");
		System.out.print("Please enter your choice: ");
		
		mainMenuChoice = keyboard.nextInt();
		
		} while (mainMenuChoice !=1 &&mainMenuChoice !=2 &&mainMenuChoice !=3 &&mainMenuChoice !=4 &&mainMenuChoice !=5 &&mainMenuChoice !=6 &&mainMenuChoice !=7 &&mainMenuChoice !=8 &&mainMenuChoice !=0);
		
		switch (mainMenuChoice)
		{
		case 1 : addNewRecord(); break; 
		case 2 : searchByFirstName(); break;
		case 3 : searchByLastName(); break;
		case 4 : searchByFullName(); break;
		case 5 : searchByTelephone(); break;
		case 6 : searchByCity(); break;
		case 7 : searchByState(); break;
		case 8 : displayAllRecords(); break; 
		case 9 : exitSystem(); break;	
		}
		
		
							
		
	}

	private static void addNewRecord()
	{
		System.out.println("\n");
		System.out.println("\n");
		System.out.println("*****\tAdd New Record Menu\t*****");
		System.out.println("\n");
		System.out.println("\n");
		System.out.println("Please select an option by number from the choices below:\n");
		System.out.println("Option 1:\tCopy and Paste new Entry (All fields required and must be separated by a Comma");
		System.out.println("Option 2:\tManually create an new entry");
		System.out.println("\n");
		System.out.print("Please enter your choice: ");
		
		Scanner keyboard = new Scanner(System.in);
		int addNewRecordMenuChoice = keyboard.nextInt();
		
		switch (addNewRecordMenuChoice)
		{
		case 1 : addNewRecordPaste(); break; //completed
        case 2 : addNewRecordManually(); break; //completed
		}
		
	}



	private static void addNewRecordManually()
	{
		Scanner keyboard = new Scanner(System.in);
		Person manualAdd = new Person();
		System.out.println("Please enter the First Name ");
		manualAdd.setFirstName(keyboard.nextLine());
		System.out.println("Please enter the Middle Name \n(enter blank space for no middle name ");
		manualAdd.setMiddleName(keyboard.nextLine());
		System.out.println("Please enter the Last Name ");
		manualAdd.setLastName(keyboard.nextLine());
		manualAdd.setFullName(manualAdd.getFirstName()+ " "+ manualAdd.getMiddleName()+" "+ manualAdd.getLastName());
		System.out.println("Please enter the Street address (all numbers and street name) ");
		manualAdd.getAddress().setStreet(keyboard.nextLine());
		System.out.println("Please enter the City");
		manualAdd.getAddress().setCity(keyboard.nextLine());
		System.out.println("Please enter the State ");
		manualAdd.getAddress().setState(keyboard.nextLine());
		System.out.println("Please enter the Zip Code ");
		manualAdd.getAddress().setZipCode(keyboard.nextLine());
		System.out.println("Please enter the telephone number (without spaces or dashes) ");
		manualAdd.setHomeNumber(keyboard.nextLine());
		
		PhoneBookActivity.addToArray(manualAdd);
		System.out.println("Thank you. your records has been added as follows\n");
		System.out.println(manualAdd);
		PhoneBookActivity.optionMenu();
		
		
		
		
	}



	private static void addNewRecordPaste()
	{
		
		System.out.println("\n");
		System.out.println("Entry Must be in the following format: Name , Street Address , City , State , Zip Code, Telephone");
		System.out.println("\n");
		System.out.print("Please enter your record here: ");
		Scanner keyboard = new Scanner(System.in);
		String unparsed = keyboard.nextLine();
		String[] parsed = unparsed.split(",");
		Person pasted = new Person(parsed[0], parsed[1], parsed[2], parsed[3], parsed[4],parsed[5]);
		PhoneBookActivity.addToArray(pasted);
		System.out.println("\nThank you. your records has been added as follows");
		System.out.println(" "+pasted);
		PhoneBookActivity.optionMenu();
		
		
		
	}



	private static void searchByFirstName()
	{
		System.out.println("\n");
		System.out.print("Please enter the first name \nof the record you are searching for: ");
		Scanner keyboard = new Scanner(System.in);
		String fNameSearch = keyboard.nextLine();
		int i = 1;
		PhoneBookActivity.searchArray(fNameSearch, i);
		
		
	}



	private static void searchByLastName()
	{
		System.out.println("\n");
		System.out.print("Please enter the last name \nof the record you are searching for: ");
		Scanner keyboard = new Scanner(System.in);
		String lnameSearch = keyboard.nextLine();
		int i = 2;
		PhoneBookActivity.searchArray(lnameSearch, i);
		
	}



	private static void searchByFullName()
	{
		System.out.println("\n");
		System.out.print("Please enter the Full name \nof the record you are searching for: ");
		Scanner keyboard = new Scanner(System.in);
		String fullNameSearch = keyboard.nextLine();
		int i = 3;
		PhoneBookActivity.searchArray(fullNameSearch, i);
		
	}



	private static void searchByTelephone()
	{
		System.out.println("\n");
		System.out.print("Please enter the telephone \nof the record you are searching for: ");
		Scanner keyboard = new Scanner(System.in);
		String telephoneSearch = keyboard.nextLine();
		int i = 4;
		PhoneBookActivity.searchArray(telephoneSearch, i);
		
	}



	private static void searchByCity()
	{
		System.out.println("\n");
		System.out.print("Please enter the City \nof the record you are searching for: ");
		Scanner keyboard = new Scanner(System.in);
		String citySearch = keyboard.nextLine();
		int i = 5;
		PhoneBookActivity.searchArray(citySearch, i);
		
	}



	private static void searchByState()
	{
		System.out.println("\n");
		System.out.print("Please enter the City \nof the record you are searching for: ");
		Scanner keyboard = new Scanner(System.in);
		String stateSearch = keyboard.nextLine();
		int i = 6;
		PhoneBookActivity.searchArray(stateSearch, i);
		
		
	}



	private static void displayAllRecords()
	{
		Scanner keyboard = new Scanner(System.in);
		PhoneBookActivity.displayArray();
		PhoneBookActivity.optionMenu();
		
		
	}



	private static void exitSystem()
	{
		for (int i = 0; i < 50; ++i) System.out.println();
		System.out.println("Thank you for using the phone book.\nYour session has ended");
		System.exit(0);
		
	}
	
	
	
		
		 
		
}
	

	


	
