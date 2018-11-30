
import java.io.*;
import java.util.Scanner;

public class CRMDriver {
	
	static Scanner input;
	public static Scanner inputFile;
	public static java.io.File inFile;
	public static final int MAX = 500;
	public static void main(String[] args) throws IOException
	{
		input = new Scanner (System.in);
		inFile = new java.io.File("leads");
		inputFile = new Scanner(inFile);
		
		Lead [] leadArray = new Lead [MAX]; // Declaring and initializing array of leads
		importList ( leadArray );
		
		Pages.viewAllLeads( leadArray );


	} // end main
	
	/***************************************************************************************
	 * Receives a Lead object and allows user to input data members
	 * @param newLead, Lead class object (user will input data)
	 * @return newLead
	 ***************************************************************************************/
	public static Lead createLead (Lead newLead)
	{
		String name; // lead full name
		String address; // lead mailing address
		String email; // lead email address
		String phone; // lead phone number
		String status; // lead status
		String leadSource; // lead source
		int rating; // lead rating
		
		System.out.println ( "\nEnter lead name: " );
		name = input.next ( );
		newLead.setName ( name );
		
		System.out.println ( "\nEnter mailing address: " );
		address = input.next ( );
		newLead.setAddress ( address );
		
		System.out.println ( "\nEnter email address: " );
		email = input.next ( );
		newLead.setEmail ( email );
		
		System.out.println ( "\nEnter phone number: " );
		phone = input.next ( );
		newLead.setPhone ( phone );
		
		System.out.println ( "\nEnter status: " );
		status = input.next ( );
		newLead.setStatus ( status );
		
		System.out.println ( "\nEnter lead source: " );
		leadSource = input.next ( );
		newLead.setLeadSource ( leadSource );
		
		System.out.println ( "\nEnter lead rating: (1 - 10)" );
		rating = input.nextInt ( );
		newLead.setRating ( rating );
		
		return newLead;	
	} // end createLead
	
	/***************************************************************************************
	 * Imports lead list to leadArray
	 * @param leadArray, array of leads (name, address, email, phone, status, leadSource, rating)
	 ***************************************************************************************/
	public static void importList(Lead [] leadArray) 
	{
		Lead arrayObject = new Lead (); // Declaring object of Lead type, used to fill array
		int index = 0; // array location
		if(!inFile.exists())
		{
			System.out.println ( "file not found" );
			System.exit(-1);
		} // end IF inFile exists
		
			while (inputFile.hasNext())
			{
				String name = inputFile.nextLine (); // lead full name
				String address = inputFile.nextLine (); // lead mailing address
				String email = inputFile.nextLine (); // lead email address
				String phone = inputFile.nextLine (); // lead phone number
				String status = inputFile.nextLine (); // lead status
				String leadSource = inputFile.nextLine (); // lead source
				int rating = inputFile.nextInt (); // lead rating
				String junk = inputFile.nextLine(); // import bug fix, Thank you Sarah!

				arrayObject = new Lead (name, address, email, phone, status, leadSource, rating);
				leadArray [index] = arrayObject;
				index ++;
			} // end WHILE hasNext

		inputFile.close ();
	} // end importList

} // end CRMDriver
