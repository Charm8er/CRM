
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
		importList (leadArray);
//		viewAllLeads (leadArray);
		Pages.viewAllLeads(leadArray);
//		viewSingleLead (leadArray);

	} // end main
	
	/***************************************************************************************
	 * Receives a Lead object and allows user to input data members
	 * @param newLead, Lead class object (user will input data)
	 * @return newLead
	 ***************************************************************************************/
	public static void mainMenu ()
	{
		System.out.println( "\nWelcome to CRM\nPlease choose an option from the menu below.");
	}
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
	 * Prints the full array unless null
	 * @param leadArray, array of leads (name, address, email, phone, status, leadSource, rating)
	 ***************************************************************************************/
	public static void printLeadArray (Lead [] leadArray)
	{
		for (int index = 0; index < MAX; index ++)
		{	
			if (leadArray [index] != null)
			{
				System.out.println ( leadArray [index] );
			} // end IF != null
		} // end FOR index location
	} // end printLeadArray
	
	/******************************************************************************************************
	 * Reads the leadArray and displays all leads
	 * @param leadArray, array of leads (name, address, email, phone, status, leadSource, rating)
	 ******************************************************************************************************/
	public static void viewAllLeads(Lead [] leadArray )
	{
		String pageTitle = "   ALL LEADS   "; // page title
		int titleLine = 66; // line for page title
		int fullLine = 147;	// full width line

		Display.pageTitleBar(pageTitle, titleLine, fullLine);
		Display.allLeadsMenu(fullLine);
		Display.leadsHeader(fullLine);

		for (int index = 0; index < MAX; index++)
		{
			if (leadArray [index] != null)
			{
				System.out.printf("%-10s%-20s%-40s%-20s%-20s%-10s%-20s%-10s\n",	
				index+1,
				leadArray[index].getName(),
				leadArray[index].getAddress(),
				leadArray[index].getEmail(),
				leadArray[index].getPhone(),
				leadArray[index].getStatus(),
				leadArray[index].getLeadSource(),
				leadArray[index].getRating());
			} // end IF != null
		} // end FOR loop
		
		Display.allLeadsFooter(fullLine);
		
		// input for menu options
		
	} // end viewAllLeads
	
	/******************************************************************************************************
	 * Reads the leadArray and displays all leads
	 * @param leadArray, array of leads (name, address, email, phone, status, leadSource, rating)
	 ******************************************************************************************************/
	public static void viewLead( Lead [] leadArray )
	{
		int titleLine = 59;
		int fullLine = 147;	
		String leadName = "Donald Bloomenthal"; // pass in from view all leads
		String pageTitle = leadName;
		
		Display.pageTitleBar(pageTitle, titleLine, fullLine);
		Display.viewLeadMenu (fullLine);
		Display.leadsHeader (fullLine);
		
		System.out.printf ( "%-20s%-40s%-20s%-20s%-10s%-20s%-10s\n", "Name","Address", "Email", "Phone", "Status", "Lead Source", "Rating\n" );
		for (int index = 0; index < MAX; index++)
		{
			if (leadArray [index] != null)
			{
				System.out.printf("%-20s%-40s%-20s%-20s%-10s%-20s%-10s\n",	
				leadArray[index].getName(),
				leadArray[index].getAddress(),
				leadArray[index].getEmail(),
				leadArray[index].getPhone(),
				leadArray[index].getStatus(),
				leadArray[index].getLeadSource(),
				leadArray[index].getRating());
			} // end IF != null
		} // end FOR loop
		
		Display.viewLeadFooter(fullLine);
		
	} // end viewSingleLead
	
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
				//System.out.println(name);
				String address = inputFile.nextLine (); // lead mailing address
				//System.out.println(address);
				String email = inputFile.nextLine (); // lead email address
				//System.out.println(email);
				String phone = inputFile.nextLine (); // lead phone number
				//System.out.println(phone);
				String status = inputFile.nextLine (); // lead status
				//System.out.println(status);
				String leadSource = inputFile.nextLine (); // lead source
				//System.out.println(leadSource);
				int rating = inputFile.nextInt (); // lead rating
				//System.out.println(rating);
				String junk = inputFile.nextLine();
				//System.out.println(junk);
				
				//System.out.println("test");

				arrayObject = new Lead (name, address, email, phone, status, leadSource, rating);
				leadArray [index] = arrayObject;
				index ++;
			} // end WHILE hasNext

		inputFile.close ();
	} // end importList

} // end CRMDriver
