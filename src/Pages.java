import java.util.Scanner;

public class Pages
{
	static Scanner input;
	public static final int MAX = 500;
	
	/******************************************************************************************************
	 * Reads the leadArray and displays all leads
	 * @param leadArray, array of leads (name, address, email, phone, status, leadSource, rating)
	 ******************************************************************************************************/
	public static void viewAllLeads( Lead [] leadArray )
	{
		input = new Scanner (System.in);
		String pageTitle = "   ALL LEADS   "; // page title
		int titleLine = 66; // line for page title
		int fullLine = 147;	// full width line
		int menuSelect = 0; // menu selection
		int leadSelect ; // lead selection

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
		
		menuSelect = input.nextInt ( );
		
		do
		{
			if ( menuSelect == 1)
			{
				System.out.println( " TEST NEW LEAD");// Pages.newLead();
				menuSelect = 0;
			}
			else if ( menuSelect == 2)
			{
				System.out.println( "\nEnter Lead ID: ");
				leadSelect = input.nextInt();
				viewLead( leadSelect, leadArray );
				menuSelect = 0;
			}
			else if ( menuSelect == 3)
			{
				System.out.println( " TEST SORT NAME");
				menuSelect = 0;
			}
			else if ( menuSelect == 4)
			{
				System.out.println( " TEST SORT STATUS");
				menuSelect = 0;
			}
			else if (menuSelect == 5)
			{
				System.out.println( " TEST SORT RATING");
				menuSelect = 0;
			}
			else
			{
				System.out.println( "Invalid menu selection!\nPlease try again.");
				menuSelect = input.nextInt();
			}
			
		} while ( menuSelect > 0 || menuSelect < 6); // end WHILE menuSelect 1-5

		// input for menu options
		
	} // end viewAllLeads
	
	
	/******************************************************************************************************
	 * Reads the leadArray and displays all leads
	 * @param leadArray, array of leads (name, address, email, phone, status, leadSource, rating)
	 ******************************************************************************************************/
	public static void viewLead( int leadID, Lead [] leadArray )
	{
		int titleLine = 66;
		int fullLine = 147;
		int menuSelect = 0; // menu selection
		String leadName;
		String pageTitle = "   View Lead   ";
		leadID -= 1;
		
		Display.pageTitleBar(pageTitle, titleLine, fullLine);
		Display.viewLeadMenu (fullLine);
		Display.leadsHeader (fullLine);

			if (leadArray [leadID] != null)
			{

				System.out.printf("%-10s%-20s%-40s%-20s%-20s%-10s%-20s%-10s\n",	
				leadID+1,		
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
				viewAllLeads(leadArray);
			}	

		// TODO Pages.Notes current lead....
			
		Display.viewLeadFooter(fullLine);

		menuSelect = input.nextInt ( );
		
		do
		{
			if ( menuSelect == 1)
			{
				viewAllLeads(leadArray);
			}
			else if ( menuSelect == 2)
			{
				System.out.println( " TEST EDIT LEAD");
				menuSelect = 0;
			}
			else if ( menuSelect == 3)
			{
				System.out.println( " TEST CONVERT LEAD");
				menuSelect = 0;
			}
			else if ( menuSelect == 4)
			{
				System.out.println( " TEST ADD NOTES");
				menuSelect = 0;
			}
			else
			{
				System.out.println( "Invalid menu selection!\nPlease try again.");
				menuSelect = input.nextInt();
			}
			
		} while ( menuSelect > 0 || menuSelect < 5);// end WHILE menuSelect > 1 || < 4
		
		
	} // end viewSingleLead

}
