package PhoneBookAssignment;

import java.util.Scanner;
import java.util.Arrays;


public class PhoneBookActivity
{
	public static Person[] totalPeople = new Person[0];
	
	
	public static void addToArray(Person p1)
	{
		Person[] tempArray = new Person[totalPeople.length+1];
		for  (int i = 0; i < totalPeople.length; i++)
		{
			tempArray[i] = totalPeople[i];
		}
		totalPeople = tempArray;
		totalPeople[totalPeople.length-1] = p1;
		
		
		
	}
	public static void displayArray()
	{
		//Arrays.sort(totalPeople);
		
		System.out.println("The total entries in the phone book: \n");
		for (int i = 0; i < totalPeople.length; i++)
		{
			System.out.print(totalPeople[i].toString() + "\n");
			
		}
		
		for (int i=0; i<5; i++)
		{
			System.out.println("\n");
		}
	}
	public static void searchArray(String searchVar, int choice)
	{
		
		switch (choice)
		{
		case 1 : 
			
			int count =0;
			for (int i = 0; i < totalPeople.length; i++)
			{
				if (totalPeople[i].getFirstName().equalsIgnoreCase(searchVar))
				{
					count++;
					System.out.println(totalPeople[i]);				
					
				}
				
			}
			if (count == 0)
				{
				System.out.println("Im Sorry, there are no items that matched your search.");
				}
			
			break; 
			
		case 2 : 
			
			count = 0;
			
			for (int i = 0; i < totalPeople.length; i++)
			{
				if (totalPeople[i].getLastName().equalsIgnoreCase(searchVar))
				{
					count++;
					System.out.println(totalPeople[i]);		
				}
				
			} 
			if (count == 0)
			{
			System.out.println("Im Sorry, there are no items that matched your search.");
			}
			 
			
			break;
			
		case 3 : 
			count = 0;
		for (int i = 0; i < totalPeople.length; i++)
			{
				if (totalPeople[i].getFullName().toLowerCase().contains(searchVar.trim().toLowerCase()))
				{
					count++;
					System.out.println(totalPeople[i]);				
				}
				
			} 
			
			if (count==0)
			{
				System.out.println("Im Sorry, there are no items that matched your search.");
			}
			
			break;
			
		case 4 : 
			
			count = 0;
			
			for (int i = 0; i < totalPeople.length; i++)
			{
				if (totalPeople[i].getHomeNumber().equalsIgnoreCase(searchVar))
				{
					count++;
					System.out.println(totalPeople[i]);				
					
				}
				
			} 
			if (count==0)
			{
				System.out.println("Im Sorry, there are no items that matched your search.");
			}
			
			break;
			
		case 5 : 
			count = 0;
			
			for (int i = 0; i < totalPeople.length; i++)
			{
				if (totalPeople[i].getAddress().getCity().equalsIgnoreCase(searchVar))
				{
					count++;
					System.out.println(totalPeople[i]);				
					
				}
				
			} 
			if (count==0)
			{
				System.out.println("Im Sorry, there are no items that matched your search.");
			}
			break;
			
		case 6 : 
			count=0;

			for (int i = 0; i < totalPeople.length; i++)
			{
				if (totalPeople[i].getAddress().getState().equalsIgnoreCase(searchVar))
				{
					count++;
					System.out.println(totalPeople[i]);				
					
				}
			} 
			if (count==0)
			{
				System.out.println("Im Sorry, there are no items that matched your search.");
			}
		
		break;
		}
		System.out.println("\n");
		System.out.println("\n");
		optionMenu();
			

	}
	public static void optionMenu()
	{
		int choice;
		Scanner keyboard= new Scanner (System.in);
		do 
		{
		System.out.println("You have reached the Option Menu:\n\t***Option MENU***");
		System.out.println("Please select one of the following choices");
		System.out.println("1.\tDelete an existing record using the telephone number");
		System.out.println("2.\tUpdate an existing record using the telephone number");
		System.out.println("3.\tReturn to the MAIN menu");
		System.out.print("Enter your choice number here ");
		choice = keyboard.nextInt();
		}	
		while (choice != 1 && choice != 2 && choice!=3);
		switch (choice)
		{
		case 1: deleteFromArray();				break;
		case 2: updateEntry(); 					break;
		case 3: zClientPhoneBook.mainMenu(); 	break;
		}
				
		 
	}
	
	private static void deleteFromArray()
	{
		String confirmDelete ="";
		System.out.println("\n");
		System.out.println("Please enter the phone number of the record you wish \nto delete:");
		
		Scanner keyboard= new Scanner (System.in);
		String numberToDelete = keyboard.nextLine();
		String stringWithoutSpaces = numberToDelete.replaceAll("\\s+", "");
		String stringWithoutSpacesAndDashes = stringWithoutSpaces.replaceAll("-", "");
		numberToDelete = stringWithoutSpacesAndDashes;
		
		
		int count = 0;
		int indexSpot;
		
		for (int i = 0; i < totalPeople.length; i++)
		{
			if (totalPeople[i].getHomeNumber().equalsIgnoreCase(numberToDelete))
			{
				count++;
				System.out.println(totalPeople[i]);	
				indexSpot = i;
				System.out.println("\n");
				System.out.println("Delete this Record? Y or N? ") ;
				confirmDelete = keyboard.next();
				confirmDelete = confirmDelete.toLowerCase();
				if (confirmDelete.contains("y"))
				{
					Person[] tempArray = new Person[totalPeople.length-1];
					for  (int j = 0; j < totalPeople.length; j++)
					{
						if (j< indexSpot)
							tempArray[j] = totalPeople[j];
						if (j> indexSpot)
							tempArray[j-1] = totalPeople[j];
						
					}
					totalPeople = tempArray;
					System.out.println("********TEST*********\n");
					displayArray();
					
				}
				if (confirmDelete.contains("n"))
				{
					optionMenu();
				}
					
								
			}
			
		} 
			if (count==0)
			{
			System.out.println("Im Sorry, there are no items that matched your search.");
			}
		
		optionMenu();	
		 
	}
	
	private static void updateEntry()
	{
		String confirmEdit ="";
		String temp;
		int choice;
		int count = 0;
		int indexSpot;
		Scanner keyboard= new Scanner (System.in);
		
		
		System.out.println("\n");
		System.out.println("Please enter the phone number of the record you wish \nto  edit:");
		String numberToDelete = keyboard.nextLine().replaceAll("\\s+", "").replaceAll("-", "");

		
		
		for (int i = 0; i < totalPeople.length; i++)
		{
			if (totalPeople[i].getHomeNumber().equalsIgnoreCase(numberToDelete))
			{
				count++;
				System.out.println(totalPeople[i]);	
				indexSpot = i;
				System.out.println("\n");
				System.out.println("Edit this Record? Y or N? ");
				confirmEdit = keyboard.next();
				confirmEdit = confirmEdit.toLowerCase();
				if (confirmEdit.equalsIgnoreCase("y"))
				{
					do 
					{
					System.out.println("Please select one of the following choices");
					System.out.println("1.\tEdit the First Name");
					System.out.println("2.\tEdit the Middle Name");
					System.out.println("3.\tEdit the Last Name");
					System.out.println("4.\tEdit the Street Address");
					System.out.println("5.\tEdit the City");
					System.out.println("6.\tEdit the State");
					System.out.println("7.\tEdit the Zip");
					System.out.println("8.\tEdit the MainPhone");
					System.out.print("Enter your choice number here ");
					choice = keyboard.nextInt();
					}	
					while (choice != 1 && choice != 2 && choice!=3 && choice!=4&& choice!=5&& choice!=6&& choice!=7&& choice!=8&& choice!=9);
					
					
					switch (choice)
					{
					
					
					case 1: 
						Scanner input1= new Scanner(System.in);
						System.out.println("Edit First Name ");
						System.out.println("The current First Name is "+totalPeople[indexSpot].getFirstName());
						System.out.println("Please enter the New First Name: ");
						temp = input1.nextLine();
						totalPeople[indexSpot].setFirstName(temp);
						System.out.println("\nThe First Name has been updated to "+ totalPeople[indexSpot].getFirstName());
					
					break;
					
					case 2: 
						Scanner input2= new Scanner(System.in);
						System.out.println("Edit Middle Name ");
						System.out.println("The current Middle Name is "+totalPeople[indexSpot].getMiddleName());
						System.out.println("Please enter the New Middle Name: ");
						temp = input2.nextLine();
						totalPeople[indexSpot].setMiddleName(temp);
						System.out.println("\nThe Middle Name has been updated to "+ totalPeople[indexSpot].getMiddleName());
										
					break;
					
					case 3: 
						Scanner input3= new Scanner(System.in);
						System.out.println("Edit Last Name ");
						System.out.println("The current Last Name is "+totalPeople[indexSpot].getLastName());
						System.out.println("Please enter the New Last Name: ");
						temp = input3.nextLine();
						totalPeople[indexSpot].setLastName(temp);
						System.out.println("\nThe Last Name has been updated to "+ totalPeople[indexSpot].getLastName());
									
					break;
					
					case 4: 
						Scanner input4= new Scanner(System.in);
						System.out.println("Edit Street Address ");
						System.out.println("The current Street Address is "+totalPeople[indexSpot].getAddress().getStreet());
						System.out.println("Please enter the New Last Name: ");
						temp = input4.nextLine();
						totalPeople[indexSpot].getAddress().setStreet(temp);
						System.out.println("\nThe Street Address has been updated to "+ totalPeople[indexSpot].getAddress().getStreet());
									
					break;
						
					case 5: 
						Scanner input5= new Scanner(System.in);
						System.out.println("Edit City ");
						System.out.println("The current City is "+totalPeople[indexSpot].getAddress().getCity());
						System.out.println("Please enter the New City: ");
						temp = input5.nextLine();
						totalPeople[indexSpot].getAddress().setCity(temp);
						System.out.println("\nThe City has been updated to "+ totalPeople[indexSpot].getAddress().getCity());
									
					break;
						
					case 6: 
						Scanner input6= new Scanner(System.in);
						System.out.println("Edit State ");
						System.out.println("The current State is "+totalPeople[indexSpot].getAddress().getState());
						System.out.println("Please enter the New State: ");
						temp = input6.nextLine();
						totalPeople[indexSpot].getAddress().setState(temp);
						System.out.println("\nThe State has been updated to "+ totalPeople[indexSpot].getAddress().getState());
									
					break;
						
					case 7: 
						Scanner input7= new Scanner(System.in);
						System.out.println("Edit Zip ");
						System.out.println("The current Zip is "+totalPeople[indexSpot].getAddress().getZipCode());
						System.out.println("Please enter the New Zip: ");
						temp = input7.nextLine();
						totalPeople[indexSpot].getAddress().setZipCode(temp);
						System.out.println("\nThe Zip has been updated to "+ totalPeople[indexSpot].getAddress().getZipCode());
									
					break;
						
					case 8: 
						Scanner input8= new Scanner(System.in);
						System.out.println("Edit Main Phone Number ");
						System.out.println("The current Number is "+totalPeople[indexSpot].getHomeNumber());
						System.out.println("Please enter the Number: ");
						temp = input8.nextLine();
						totalPeople[indexSpot].setHomeNumber(temp);
						System.out.println("\nThe Number has been updated to "+ totalPeople[indexSpot].getHomeNumber());
									
					break;
					
					}
					
					
					
					
					
					
					
				}
				if (confirmEdit.contains("n"))
				{
					optionMenu();
				}
					
								
			}
			
		} 
			if (count==0)
			{
			System.out.println("Im Sorry, there are no items that matched your search.");
			}
		
		optionMenu();	
		
	}
		
	
	
	

}
