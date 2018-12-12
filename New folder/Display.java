// Contains various elements for console display.  Includes lines for dashes, stars and spaces, page titles, tool tips, etc.

public class Display 
{
	/******************************************************************************************************
	 * Prints dashed line
	 * @param line (line length)
	 ******************************************************************************************************/
	public static void dashLine (int line) 
	{	
		for (int dash = line ; dash > 0 ; dash--)
		{
			System.out.print ( "-" );			
		} // end FOR dash
		
	} // end dashLine
	
	/******************************************************************************************************
	 * Prints starred line
	 * @param line (line length)
	 ******************************************************************************************************/
	public static void starLine (int line) 
	{	
		for (int star = line ; star > 0 ; star--)
		{
			System.out.print ( "*" );	
		} // end FOR star
		
	} // end starLine
	
	/******************************************************************************************************
	 * Prints starred line
	 * @param line (line length)
	 ******************************************************************************************************/
	public static void blankLine (int line) 
	{	
		for (int blank = line ; blank > 0 ; blank--)
		{
			System.out.print ( " " );	
		} // end FOR star
		
	} // end starLine
	
	/******************************************************************************************************
	 * Prints the title bar for the page
	 * @param pageTitle (title for given page)
	 * @param titleLine (line next to title)
	 * @param fullLine (lines above and below title line)
	 ******************************************************************************************************/
	public static void pageTitleBar (String pageTitle, int titleLine, int fullLine)
	{	
		System.out.println( "\n\n" );
		starLine(fullLine);
		System.out.println( );
		starLine(titleLine);
		System.out.print( pageTitle );
		starLine(titleLine);
		System.out.println( );
		starLine(fullLine);
		System.out.println( );
		
	} // end allLeadsTitleBar
	
	/******************************************************************************************************
	 * Prints menu options below the title bar for "All Leads" page
	 * @param fullLine (line length)
	 ******************************************************************************************************/
	public static void mainMenu (int fullLine)
	{
		System.out.printf("\n%46s%10s","", "All Leads (1) | Converted Leads (2) | Search Leads (3)\n");
		System.out.println( );
		starLine(fullLine);
		System.out.println( );
	} // end allLeadsFooter
	
	/******************************************************************************************************
	 * Prints search interface on Pages.mainMenu
	 * @param fullLine (line length)
	 ******************************************************************************************************/
	public static void search (int fullLine)
	{
		dashLine(fullLine);
		System.out.println( );
		System.out.println( "\nSearch by (name, address, phone number or email).  Search results will"
				+ " display any related information that matches your query. Enter (00) to exit.\n" );
		dashLine(fullLine);
		System.out.println( );
		System.out.println( );
		System.out.println( "Enter Search Query: \n");
		dashLine(fullLine);
		System.out.println( );
		starLine(fullLine);
		System.out.println( );
	} // end allLeadsFooter
	
	/******************************************************************************************************
	 * Prints notes below viewLead info and above footer menu for "View Lead" page
	 * @param fullLine (line length)
	 ******************************************************************************************************/
	public static void notes (int fullLine, int subTitleLine)
	{
		System.out.println( );
		System.out.println( );
		dashLine(fullLine);
		System.out.println( );
		starLine(subTitleLine);
		System.out.print( "   NOTES   " );
		starLine(subTitleLine);
		System.out.println( );
		dashLine(fullLine);
		System.out.println( );
		System.out.println( );
	} // end allLeadsFooter
	
	/******************************************************************************************************
	 * Prints "All Leads" header for array values
	 * @param fullLine (line length)
	 ******************************************************************************************************/
	public static void leadsHeader (int fullLine)
	{
		dashLine(fullLine);
		System.out.println( );		
		System.out.printf ( "\n%-10s%-20s%-40s%-20s%-20s%-10s%-20s%-10s\n", "ID","Name","Address", "Email", "Phone", "Status", "Lead Source", "Rating" );	
		dashLine(fullLine);
		System.out.println( );
		System.out.println( );
	} // end allLeadsFooter
	
	/******************************************************************************************************
	 * Prints menu options below the title bar for "All Leads" page
	 * @param fullLine (line length)
	 ******************************************************************************************************/
	public static void allLeadsMenu (int fullLine)
	{
		System.out.printf("\n%12s%10s","", "Main Menu (0) | New Lead (1) | View Lead (2) | Sort by ID (3) | Sort by Name (4) | Sort by Status (5) | Sort by Rating (6)\n");
		System.out.println( );
		starLine(fullLine);
		System.out.println( );
	} // end allLeadsFooter
	
	/******************************************************************************************************
	 * Prints menu options below the array table for "All Leads" page
	 * @param fullLine (line length)
	 ******************************************************************************************************/
	public static void allLeadsFooter (int fullLine)
	{		
		System.out.println( );
		dashLine(fullLine);
		System.out.println( );
		starLine(fullLine);
		System.out.println( );
		
		System.out.printf("\n%12s%10s","", "Main Menu (0) | New Lead (1) | View Lead (2) | Sort by ID (3) | Sort by Name (4) | Sort by Status (5) | Sort by Rating (6)\n");
		
		System.out.println( );
		starLine(fullLine);
		System.out.println( );
		System.out.println( "\n\n\n\n\n\n");
	} // end allLeadsFooter
	
	/******************************************************************************************************
	 * Prints menu options below the title bar for "View Lead" page
	 * @param fullLine (line length)
	 ******************************************************************************************************/
	public static void viewLeadMenu (int fullLine)
	{
		System.out.printf("\n%41s%10s","", "All Leads (1) | Edit Lead (2) | Convert Lead (3) | Add Notes (4)\n");
		System.out.println( );
		starLine(fullLine);
		System.out.println( );
	} // end allLeadsFooter
	
	/******************************************************************************************************
	 * Prints menu options below the array table for "View Lead" page
	 * @param fullLine (line length)
	 ******************************************************************************************************/
	public static void viewLeadFooter (int fullLine)
	{
		System.out.println( );
		System.out.println( );
		dashLine(fullLine);
		System.out.println( );
		starLine(fullLine);
		System.out.println( );
		
		System.out.printf("\n%41s%10s","", "All Leads (1) | Edit Lead (2) | Convert Lead (3) | Add Notes (4)\n");
		
		System.out.println( );
		starLine(fullLine);
		System.out.println( );
		System.out.println( "\n\n\n\n\n\n");
	} // end leadFooter
	
	/******************************************************************************************************
	 * Prints menu options below the title bar for "View Lead" page
	 * @param fullLine (line length)
	 ******************************************************************************************************/
	public static void editLeadMenu (int fullLine) 
	{
		System.out.printf("\n%4s%10s","", "Go Back (0) | Edit Name (1) | Edit Address (2) | Edit Email (3) | Edit Phone (4) | Edit Status (5) | Edit Lead Source (6) | "
				+ "Edit Rating (7)\n");
		System.out.println( );
		starLine(fullLine);
		System.out.println( );
		
		dashLine(fullLine);
		System.out.println( );
		System.out.println( "\nWARNING! You're about to edit this lead.  Please read instructions for each item"
				+ " before proceeding to the next.  To cancel this operation enter (0):  " );
//		dashLine(fullLine);
		System.out.println( );
	} // end allLeadsFooter
	
	/******************************************************************************************************
	 * Prints menu options below the array table for "View Lead" page
	 * @param fullLine (line length)
	 ******************************************************************************************************/
	public static void editLeadFooter (int fullLine) 
	{
		System.out.println( );
		dashLine(fullLine);
		System.out.println( );
		starLine(fullLine);
		System.out.println( );
		
		System.out.printf("\n%4s%10s","", "Go Back (0) | Edit Name (1) | Edit Address (2) | Edit Email (3) | Edit Phone (4) | Edit Status (5) | Edit Lead Source (6) | "
				+ "Edit Rating (7)\n");
		
		System.out.println( );
		starLine(fullLine);
		System.out.println( "\n\n\n\n\n\n");
		
	} // end leadFooter
	
	/******************************************************************************************************
	 * Prints menu options below the array table for "View Lead" page
	 * @param fullLine (line length)
	 ******************************************************************************************************/
	public static void newLeadMenu (int fullLine)
	{
		System.out.printf("\n%56s%10s","", "Create New Lead (1) | All Leads (2)\n");
		System.out.println( );
		starLine(fullLine);
		System.out.println( );
		dashLine(fullLine);
		System.out.println( );
		System.out.println( "\nYou're about to enter a new lead into the system.  Please read instructions for each item"
				+ " before proceeding to the next.  Proceed? (1) Back? (2): \n  " );
		dashLine(fullLine);
		System.out.println( );

	} // end leadFooter
	
	/******************************************************************************************************
	 * Prints menu options below the array table for "View Lead" page
	 * @param fullLine (line length)
	 ******************************************************************************************************/
	public static void newLeadFooter (int fullLine)
	{
		System.out.println( );
		dashLine(fullLine);
		System.out.println( );
		starLine(fullLine);
		System.out.println( );
		
		System.out.printf("\n%56s%10s","", "Create New Lead (1) | All Leads (2)\n");
		
		System.out.println( );
		starLine(fullLine);
		System.out.println( );
		System.out.println( "\n\n\n\n\n\n");
	} // end leadFooter
	
	/******************************************************************************************************
	 * Prints tool tips for various areas within program
	 * @param FULLLINE (line length)
	 ******************************************************************************************************/
	public static void toolTips (String object, String field)
	{
		if ( (field == "name") && (object == "newLead" || object == "editLead"))
		{
			System.out.println( "\nPlease enter the full name. ie. (First Last) ");
		}
		else if ( (field == "address") && (object == "newLead" || object == "editLead"))
		{
			System.out.println( "\nPlease enter and format the full address. ie. (123 Test Dr, Loveland, CO  80537) ");
		}
		else if ( (field == "email") && (object == "newLead" || object == "editLead"))
		{
			System.out.println( "\nPlease enter the full email address. ie. (lead@domain.com) ");
		}
		else if ( (field == "phone") && (object == "newLead" || object == "editLead"))
		{
			System.out.println( "\nPlease format the phone number with no dashes or spaces ie. (123456789) ");
		}
		else if ( (field == "status") && (object == "newLead" || object == "editLead"))
		{
			System.out.println( "\nUse only approved status markers. [ New | Working | Qualified | Converted | Lost ]");
		}
		else if ( (field == "leadSource") && (object == "newLead" || object == "editLead"))
		{
			System.out.println( "\nUse only approved sources. [ Flyer | Mailer | Other | Referral | Social Media | Website ]");
		}
		else if ( (field == "rating") && (object == "newLead" || object == "editLead"))
		{
			System.out.println( "\nUse only ratings between 1 and 10, with 1 being the lowest and 10 the highest.");
		}
			
	} // end leadFooter
	
} // end display class
