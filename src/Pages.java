// Contains the pages for console display, pulls elements from Menus.java and Display.java to create the interface.

import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Pages
{
	static Scanner input; // scanner
	public static final int FULLLINE = 147; // full width line
	
	/******************************************************************************************************
	 * Main menu for program
	 * @param listSize, array size of leadArray
	 * @param noteListSize, array size of note Array
	 * @param noteArray, array of notes (leadNum, date, contents)
	 * @param leadArray, array of leads (name, address, email, phone, status, leadSource, rating, leadNum)
	 * @throws FileNotFoundException 
	 ******************************************************************************************************/
	public static void mainMenu( 
			int listSize, int noteListSize, Note [] noteArray, Lead [] leadArray ) throws FileNotFoundException
	{
		input = new Scanner (System.in);
		String pageTitle = "   CRM MENU   "; // page title
		int titleLine = 66; // line for page title

		Display.pageTitleBar(pageTitle, titleLine, FULLLINE);
		Display.mainMenu(FULLLINE);	
		Menus.mainMenuSelect(listSize, noteListSize, noteArray, leadArray);
		
	} // end mainMenu
	
	/******************************************************************************************************
	 * Reads the leadArray and displays all leads
	 * @param listSize, array size of leadArray
	 * @param noteListSize, array size of note Array
	 * @param noteArray, array of notes (leadNum, date, contents)
	 * @param leadArray, array of leads (name, address, email, phone, status, leadSource, rating, leadNum)
	 * @throws FileNotFoundException 
	 ******************************************************************************************************/
	public static void viewAllLeads( 
			int listSize, int noteListSize, Note [] noteArray, Lead [] leadArray ) throws FileNotFoundException
	{
		String pageTitle = "   ALL LEADS   "; // page title for header
		int titleLine = 66; // line for page title

		Display.pageTitleBar(pageTitle, titleLine, FULLLINE);
		Display.allLeadsMenu(FULLLINE);
		Display.leadsHeader(FULLLINE);

		for (int index = 0; index < listSize; index++)
		{
			if (leadArray [index] != null && !"Converted".equals(leadArray [index].getStatus())) 
			{
				System.out.printf("%-10s%-20s%-40s%-20s%-20s%-10s%-20s%-10s\n",	
				leadArray[index].getLeadNum(),			
				leadArray[index].getName(),
				leadArray[index].getAddress(),
				leadArray[index].getEmail(),
				leadArray[index].getPhone(),
				leadArray[index].getStatus(),
				leadArray[index].getLeadSource(),
				leadArray[index].getRating());
			} // end IF != null
		} // end FOR loop
		
		Display.allLeadsFooter(FULLLINE);
		Menus.leadsMenuSelect(listSize, noteListSize, noteArray, leadArray);
		
	} // end viewAllLeads
	
	/******************************************************************************************************
	 * Reads the leadArray and displays all leads that match search query
	 * @param listSize, array size of leadArray
	 * @param noteListSize, array size of note Array
	 * @param search, search query
	 * @param noteArray, array of notes (leadNum, date, contents)
	 * @param leadArray, array of leads (name, address, email, phone, status, leadSource, rating, leadNum)
	 * @throws FileNotFoundException 
	 ******************************************************************************************************/
	public static void searchAllLeads( 
			int listSize, int noteListSize, String search, Note [] noteArray, Lead [] leadArray ) throws FileNotFoundException
	{	
		String pageTitle = "   SEARCH RESULT   "; // page title for header
		int titleLine = 64; // line for page title

		Display.pageTitleBar(pageTitle, titleLine, FULLLINE);
		Display.allLeadsMenu(FULLLINE);
		Display.leadsHeader(FULLLINE);

		for (int index = 0; index < listSize; index++)
		{
			if ((leadArray [index] != null) && 
					((leadArray[index].getName().toLowerCase().contains(search) 
					|| leadArray[index].getAddress().toLowerCase().contains(search) 
					|| leadArray[index].getPhone().toLowerCase().contains(search) 
					|| leadArray[index].getEmail().toLowerCase().contains(search)) 
					|| (leadArray[index].getStatus().toLowerCase().equals(search))))
			{
				System.out.printf("%-10s%-20s%-40s%-20s%-20s%-10s%-20s%-10s\n",	
				leadArray[index].getLeadNum(),	
				leadArray[index].getName(),
				leadArray[index].getAddress(),
				leadArray[index].getEmail(),
				leadArray[index].getPhone(),
				leadArray[index].getStatus(),
				leadArray[index].getLeadSource(),
				leadArray[index].getRating());
			} // end IF != null && search params 
		} // end FOR loop
		
		Display.allLeadsFooter(FULLLINE);
		Menus.searchMenuSelect(listSize, noteListSize, search, noteArray, leadArray);
		
	} // end viewAllLeads		
	
	/******************************************************************************************************
	 * Reads the leadArray and displays the selected lead
	 * @param listSize, array size of leadArray
	 * @param noteListSize, array size of note Array
	 * @param noteArray, array of notes (leadNum, date, contents)
	 * @param leadArray, array of leads (name, address, email, phone, status, leadSource, rating, leadNum)
	 * @throws FileNotFoundException 
	 ******************************************************************************************************/
	public static void viewLead( 
			int listSize, int noteListSize, int index, Note [] noteArray, Lead [] leadArray ) throws FileNotFoundException
	{
		String pageTitle = "   View Lead   "; // page title for header
		int titleLine = 66; // line for page title
		int subTitleLine = 68; // line for subtitle
		int leadID = 0; // lead ID number		
		
		Display.pageTitleBar(pageTitle, titleLine, FULLLINE);
		Display.viewLeadMenu (FULLLINE);
		Display.leadsHeader (FULLLINE);

			if (leadArray [index] != null)
			{
				leadID = leadArray[index].getLeadNum();
				System.out.printf("%-10s%-20s%-40s%-20s%-20s%-10s%-20s%-10s\n",	
				leadArray[index].getLeadNum(),		
				leadArray[index].getName(),
				leadArray[index].getAddress(),
				leadArray[index].getEmail(),
				leadArray[index].getPhone(),
				leadArray[index].getStatus(),
				leadArray[index].getLeadSource(),
				leadArray[index].getRating());
			} // end IF != null
			else
			{
				System.out.println( "\nOops!  It looks like there is no information stored here.");
				viewAllLeads(listSize, noteListSize, noteArray, leadArray);
			} // end IF no item at array location
			
		Display.notes(FULLLINE, subTitleLine);
		
		for (int i = 0; i < noteListSize; i++)
		{
			if (noteArray [i] != null && noteArray [i].getLeadNum() == (leadArray [index].getLeadNum())) 
			{
				SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
				String formatDate = sdf.format(noteArray [i].getDate());
				
				System.out.printf("%-20s%-10s%-130s\n",
				formatDate,		
				" | ",
				noteArray[i].getContents());
			} // end IF != null && Note leadNum == Lead leadNum
		} // end FOR array loop
			
		Display.viewLeadFooter(FULLLINE);
		Menus.viewLeadMenuSelect(listSize, noteListSize, index, leadID, noteArray, leadArray);
		
	} // end viewLead
	
	/******************************************************************************************************
	 * Displays page for editing a lead, assigns it an array location and exports to list
	 * @param listSize, array size of leadArray
	 * @param noteListSize, array size of note Array
	 * @param leadID, assigned lead ID
	 * @param noteArray, array of notes (leadNum, date, contents)
	 * @param leadArray, array of leads (name, address, email, phone, status, leadSource, rating, leadNum)
	 ******************************************************************************************************/
	public static void editLead ( 
			int listSize, int noteListSize, int leadID, Note [] noteArray, Lead [] leadArray ) throws FileNotFoundException
	{
		int titleLine = 66; // line for page title
		String pageTitle = "   Edit Lead   "; // page title for header

		Display.pageTitleBar(pageTitle, titleLine, FULLLINE);
		Display.editLeadMenu(FULLLINE); 
		Display.leadsHeader (FULLLINE);

		if (leadArray [leadID] != null)
		{
			System.out.printf("%-10s%-20s%-40s%-20s%-20s%-10s%-20s%-10s\n",	
			leadArray[leadID].getLeadNum(),
			leadArray[leadID].getName(),
			leadArray[leadID].getAddress(),
			leadArray[leadID].getEmail(),
			leadArray[leadID].getPhone(),
			leadArray[leadID].getStatus(),
			leadArray[leadID].getLeadSource(),
			leadArray[leadID].getRating());
		} // end IF != null
		else
		{
			System.out.println( "\nOops!  It looks like there is no information stored here.");
			viewAllLeads(listSize, noteListSize, noteArray, leadArray);
		} // end IF array location empty	
		
		Display.editLeadFooter(FULLLINE); 
		Menus.editLeadMenuSelect(listSize, noteListSize, leadID, noteArray, leadArray);
			
	} // end editLead

	/******************************************************************************************************
	 * Displays page for creating a new lead, assigns it an array location and exports to list
	 * @param listSize, array size of leadArray
	 * @param noteListSize, array size of note Array
	 * @param noteArray, array of notes (leadNum, date, contents)
	 * @param leadArray, array of leads (name, address, email, phone, status, leadSource, rating, leadNum)
	 ******************************************************************************************************/
	public static int newLead ( 
			int listSize, int noteListSize, Note [] noteArray, Lead [] leadArray ) throws FileNotFoundException
	{
		int titleLine = 63; // line for page title
		String pageTitle = "   Create New Lead   ";
		
		Display.pageTitleBar(pageTitle, titleLine, FULLLINE);
		Display.newLeadMenu(FULLLINE);
		listSize = Menus.newLeadMenuSelect(listSize, noteListSize, noteArray, leadArray);
		
		return listSize;
	} // end newLead

} // end Pages class
