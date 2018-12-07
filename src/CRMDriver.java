
import java.io.*;
import java.util.Scanner;

public class CRMDriver {
	
	static Scanner input;
	public static Scanner inputFile;
	public static java.io.File inFile;
	public static java.io.File outFile;
	public static final int MAX = 500;
	public static void main(String[] args) throws IOException
	{
		String importFileName = "test"; // file name for import of list to leadArray
		String exportFileName = "test"; // file name for export from leadArray to list
		inFile = new java.io.File(importFileName);
		outFile = new java.io.File(exportFileName);
		
		input = new Scanner (System.in);
		inputFile = new Scanner(inFile);
		
		Lead [] leadArray = new Lead [MAX]; // Declaring and initializing array of leads
		importList ( leadArray );
		Pages.viewAllLeads( leadArray );
//		Pages.newLead( leadArray );
		

	} // end main
	
	/***************************************************************************************
	 * Receives a Lead object and allows user to input data members
	 * @param newLead, Lead class object (user will input data)
	 * @return newLead
	 ***************************************************************************************/
	public static Lead createLead (Lead newLead)
	{
		String object = "newLead"; // identifies this object for other methods
		String field; // identifies the field for other methods
		
		String name; // lead full name
		String address; // lead mailing address
		String email; // lead email address
		String phone; // lead phone number
		String status; // lead status
		String leadSource = null; // lead source
		int rating; // lead rating	
		int fullLine = 147;
		
		field = "name";
		Display.toolTips( object, field );
		System.out.println ( "\nEnter lead name: " );
		name = input.nextLine();
//		String first = input.nextLine(); // split first name for bug fix //////////////////////////////////////
//		String last = input.nextLine ( ); // split last name for bug fix
//		name = first + " " + last;
		newLead.setName ( name );
		Display.dashLine(fullLine);
		
		field = "address";
		Display.toolTips( object, field );
		System.out.println ( "\nEnter mailing address: " );
		address = input.nextLine ( );
		newLead.setAddress ( address );
		Display.dashLine(fullLine);
		
		field = "email";
		Display.toolTips( object, field );
		System.out.println ( "\nEnter email address: " );
		email = input.nextLine ( );
		newLead.setEmail ( email );
		Display.dashLine(fullLine);
			
		field = "phone";
		Display.toolTips( object, field );
		System.out.println ( "\nEnter phone number: " );
		phone = input.nextLine ( );
//		Display.formatData(field);
		phone = phone.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3"); // format phone number
		newLead.setPhone ( phone );
		Display.dashLine(fullLine);
		
		field = "status";
		Display.toolTips( object, field );
		System.out.println ( "\nEnter status: " );
		status = input.nextLine ( );
		newLead.setStatus ( status );
		Display.dashLine(fullLine);
		
		field = "leadSource";
		Display.toolTips( object, field );
		System.out.println ( "\nEnter lead source: " );
		leadSource = input.nextLine ( );
		newLead.setLeadSource ( leadSource );
		Display.dashLine(fullLine);
		
		field = "rating";
		Display.toolTips( object, field );
		System.out.println ( "\nEnter lead rating: " );
		rating = input.nextInt ( );
		input.nextLine(); // nextLine bug fix, Thank you Vicki!
		newLead.setRating ( rating );
		Display.dashLine(fullLine);
		
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
			inputFile.nextLine(); // import bug fix, Thank you Sarah!

			arrayObject = new Lead (name, address, email, phone, status, leadSource, rating);
			leadArray [index] = arrayObject;
			index ++;
		} // end WHILE hasNext

		inputFile.close ();
	} // end importList
	
	/***************************************************************************************
	 * Writes changes to leadArray 
	 * @param leadArray, array of leads (name, address, email, phone, status, leadSource, rating)
	 * @throws FileNotFoundException
	 ***************************************************************************************/
	public static void exportList(Lead [] leadArray) throws FileNotFoundException 
	{
		java.io.PrintWriter fout= new java.io.PrintWriter(outFile);
		
		for (int index = 0; index < MAX; index++)
		{
			if (leadArray [index] != null)
			{
				fout.println(leadArray [index].getName()); // lead full name
				fout.println(leadArray [index].getAddress()); // lead mailing address
				fout.println(leadArray [index].getEmail()); // lead email address
				fout.println(leadArray [index].getPhone()); // lead phone number
				fout.println(leadArray [index].getStatus()); // lead status
				fout.println(leadArray [index].getLeadSource()); // lead source
				fout.println(leadArray [index].getRating()); // lead rating
			}
		}
		fout.println( ); // prints blank line at end of list
		fout.close();
	} // end exportList

} // end CRMDriver
