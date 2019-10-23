package PhoneBookAssignment;

public class Person implements Comparable <Object>
{
	private String fullName;
	private String firstName;
	private String middleName;
	private String lastName;
	private String homeNumber;
	public int listingCount = 0;
	
	private Address address;
	
	
	
	
	
	public Person()
	{
		listingCount++;
		this.address = new Address();
		
				
	}
	
	public Person(String name,String street, String city, String state, String zip, String phone)
	{
		listingCount++;
		splitName(name.trim());
		setFullName(name.trim());
		this.setHomeNumber(phone.trim());
		this.address = new Address();
		this.address = new Address(street.trim(), city.trim(), state.trim(), zip.trim());
		
	}
	

	private void splitName(String name)
	{
		String[] fullName = name.split(" ");
		setFirstName(fullName[0].trim());
		setLastName(fullName[fullName.length-1].trim());
		
		String mName="";
		for (int i =1; i< fullName.length-1; i++)  //changed from int i =0; i< fullName.length; i++ to eliminate If statement
		{
			mName= mName+" "+fullName[i];
		}
		mName = mName.trim();
		setMiddleName(mName);
		
	}
	
	


	public String getFullName()
	{
		return firstName+ " " + middleName + " " + lastName;
	}

	public void setFullName(String fullName)
	{
		this.fullName= fullName;
	}


	public String getFirstName()
	{
		return firstName;
	}




	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}




	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getMiddleName()
	{
		return middleName;
	}

	public void setMiddleName(String middleName)
	{
		this.middleName = middleName;
	}


	public String getHomeNumber()
	{
		return homeNumber;
	}

	public void setHomeNumber(String homeNumber)
	{
		this.homeNumber = homeNumber;
	}
	
	
	
	public String toString() 
	{
		return "\nFull Name\t "+ firstName+ " "+ middleName + " " + lastName +" \n"+ "Address\t\t "+address+ " \n"+"Telephone\t "+ homeNumber;
	}

	public Address getAddress()
	{
		
		return address;
	}
	public void setAddress (Address address)
	{
		this.address = address;
	}

	@Override
	public int compareTo(Object person)
	{
		
		return this.fullName.compareToIgnoreCase(((Person)person).getFullName());
	}



	
	
	

}
