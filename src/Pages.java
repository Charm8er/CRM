import java.io.FileNotFoundException;
import java.util.Scanner;

public class Pages
{
	static Scanner input;
	static Scanner menuSelect;
	public static final int MAX = 500;
	
	/******************************************************************************************************
	 * Reads the leadArray and displays all leads
	 * @param leadArray, array of leads (name, address, email, phone, status, leadSource, rating)
	 * @throws FileNotFoundException 
	 ******************************************************************************************************/
	public static void viewAllLeads( Lead [] leadArray ) throws FileNotFoundException
	{
		input = new Scanner (System.in);
		menuSelect = new Scanner(System.in);
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
				newLead( leadArray );
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
				System.out.println( " TEST SORT NAME"); /////////////////////////////////
				menuSelect = 0;
			}
			else if ( menuSelect == 4)
			{
				System.out.println( " TEST SORT STATUS"); ///////////////////////////////
				menuSelect = 0;
			}
			else if (menuSelect == 5)
			{
				System.out.println( " TEST SORT RATING"); ///////////////////////////////
				menuSelect = 0;
			}
			else
			{
//				System.out.println( "Invalid menu selection!\nPlease try again.");
				menuSelect = input.nextInt();
			}
			
		} while ( menuSelect > 0 || menuSelect < 6); // end WHILE menuSelect 1-5

		// input for menu options
		
	} // end viewAllLeads
	
	
	/******************************************************************************************************
	 * Reads the leadArray and displays all leads
	 * @param leadArray, array of leads (name, address, email, phone, status, leadSource, rating)
	 * @throws FileNotFoundException 
	 ******************************************************************************************************/
	public static void viewLead( int leadID, Lead [] leadArray ) throws FileNotFoundException
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

		// TODO Pages.Notes current lead.... ////////////////////////////////////////////
			
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
				editLead(leadID, leadArray);
				menuSelect = 0;
			}
			else if ( menuSelect == 3)
			{
				System.out.println( " TEST CONVERT LEAD");//////////////////////////////
				menuSelect = 0;
			}
			else if ( menuSelect == 4)
			{
				System.out.println( " TEST ADD NOTES"); ////////////////////////////////
				menuSelect = 0;
			}
			else
			{
//				System.out.println( "Invalid menu selection!\nPlease try again.");
				menuSelect = input.nextInt();
			}
			
		} while ( menuSelect > 0 || menuSelect < 5);// end WHILE menuSelect > 1 || < 4
		
		
	} // end viewLead
	
	/******************************************************************************************************
	 * Displays page for creating a new lead, assigns it an array location and exports to list
	 * @param leadArray, array of leads (name, address, email, phone, status, leadSource, rating)
	 ******************************************************************************************************/
	public static void editLead ( int leadID, Lead [] leadArray ) throws FileNotFoundException
	{
		int titleLine = 66;
		int fullLine = 147;
		String pageTitle = "   Edit Lead   ";
		String object = "editLead";
		int editLead = 0;
		int saveLead = 0;
		String field;
		String skip; // nextLine fix...
		
		String currentName, currentAddress, currentEmail, currentPhone, currentStatus, currentLeadSource;
		int currentRating;
		
		String updatedName, updatedAddress, updatedEmail, updatedPhone, updatedStatus, updatedLeadSource;
		int updatedRating;
		
		Display.pageTitleBar(pageTitle, titleLine, fullLine);
		Display.editLeadMenu(fullLine); 
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
		
		Display.editLeadFooter(fullLine); 
		editLead = input.nextInt();
		
		while ( editLead > 0 || editLead < 8)
		{
			if ( editLead == 0)
			{
				viewLead(leadID + 1, leadArray);
			} // end IF cancel edit			
			else if ( editLead == 1 )
			{
				field = "name";
				currentName = leadArray[leadID].getName();
				System.out.println( "Current Name: " + currentName);
				
				Display.toolTips(object, field);
				System.out.println( "Enter New Name: \n");
				skip = input.nextLine();
				updatedName = input.nextLine();			
				leadArray[leadID].setName(updatedName);			
				System.out.println( "Save Changes (8) or Revert Changes (9): ");
				saveLead = input.nextInt();
				if (saveLead == 8)
				{
					CRMDriver.exportList(leadArray);
					viewLead(leadID + 1, leadArray);
				} // end IF save changes
				else if (saveLead == 9)
				{
					leadArray[leadID].setName(currentName);
					viewLead(leadID + 1, leadArray);
				} // end IF revert changes
			} // end IF change name
			else if ( editLead == 2 )
			{
				field = "address";
				currentAddress = leadArray[leadID].getAddress();
				System.out.println( "Current address: " + currentAddress);
				Display.toolTips(object, field);
				System.out.println( "Enter new address: ");
				skip = input.nextLine();
				updatedAddress = input.nextLine();
				leadArray[leadID].setAddress(updatedAddress);
				
				System.out.println( "Save Changes (8) or Revert Changes (9): ");
				editLead = input.nextInt();
				if (editLead == 8)
				{
					CRMDriver.exportList(leadArray);
					viewLead(leadID + 1, leadArray);
				} // end IF save changes
				else if (editLead == 9)
				{
					leadArray[leadID].setAddress(currentAddress);
					viewLead(leadID + 1, leadArray);
				} // end IF revert changes
			} // end IF change address
			else if ( editLead == 3 )
			{
				field = "email";
				currentEmail = leadArray[leadID].getEmail();
				System.out.println( "Current email: " + currentEmail);
				Display.toolTips(object, field);
				System.out.println( "Enter new email: ");
				skip = input.nextLine();
				updatedEmail = input.nextLine();
				leadArray[leadID].setEmail(updatedEmail);
				
				System.out.println( "Save Changes (8) or Revert Changes (9): ");
				editLead = input.nextInt();
				if (editLead == 8)
				{
					CRMDriver.exportList(leadArray);
					viewLead(leadID + 1, leadArray);
				} // end IF save changes
				else if (editLead == 9)
				{
					leadArray[leadID].setEmail(currentEmail);
					viewLead(leadID + 1, leadArray);
				} // end IF revert changes
			} // end IF change email
			else if ( editLead == 4 )
			{
				field = "phone";
				currentPhone = leadArray[leadID].getPhone();
				System.out.println( "Current phone: " + currentPhone);
				Display.toolTips(object, field);
				System.out.println( "Enter new phone: ");
				skip = input.nextLine();
				updatedPhone = input.nextLine();
				updatedPhone = updatedPhone.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3"); // format phone number
				leadArray[leadID].setPhone(updatedPhone);
				
				System.out.println( "Save Changes (8) or Revert Changes (9): ");
				editLead = input.nextInt();
				if (editLead == 8)
				{
					CRMDriver.exportList(leadArray);
					viewLead(leadID + 1, leadArray);
				} // end IF save changes
				else if (editLead == 9)
				{
					leadArray[leadID].setPhone(currentPhone);
					viewLead(leadID + 1, leadArray);
				} // end IF revert changes
			} // end IF change phone
			else if ( editLead == 5 )
			{
				field = "status";
				currentStatus = leadArray[leadID].getStatus();
				System.out.println( "Current status: " + currentStatus);
				Display.toolTips(object, field);
				System.out.println( "Enter new status: ");
				skip = input.nextLine();
				updatedStatus = input.nextLine();
				leadArray[leadID].setStatus(updatedStatus);
				
				System.out.println( "Save Changes (8) or Revert Changes (9): ");
				editLead = input.nextInt();
				if (editLead == 8)
				{
					CRMDriver.exportList(leadArray);
					viewLead(leadID + 1, leadArray);
				} // end IF save changes
				else if (editLead == 9)
				{
					leadArray[leadID].setStatus(currentStatus);
					viewLead(leadID + 1, leadArray);
				} // end IF revert changes
			} // end if change status
			else if ( editLead == 6 )
			{
				field = "leadSource";
				currentLeadSource = leadArray[leadID].getLeadSource();
				System.out.println( "Current lead source: " + currentLeadSource);
				Display.toolTips(object, field);
				System.out.println( "Enter new lead source: ");
				skip = input.nextLine();
				updatedLeadSource = input.nextLine();
				leadArray[leadID].setLeadSource(updatedLeadSource);
				
				System.out.println( "Save Changes (8) or Revert Changes (9): ");
				editLead = input.nextInt();
				if (editLead == 8)
				{
					CRMDriver.exportList(leadArray);
					viewLead(leadID + 1, leadArray);
				} // end IF save changes
				else if (editLead == 9)
				{
					leadArray[leadID].setLeadSource(currentLeadSource);
					viewLead(leadID + 1, leadArray);
				} // end IF revert changes
			} // end IF change lead source
			else if ( editLead == 7 )
			{
				field = "rating";
				currentRating = leadArray[leadID].getRating();
				System.out.println( "Current Rating: " + currentRating);
				Display.toolTips(object, field);
				System.out.println( "Enter new rating: ");
				updatedRating = input.nextInt();
				leadArray[leadID].setRating(updatedRating);
				
				System.out.println( "Save Changes (8) or Revert Changes (9): ");
				editLead = input.nextInt();
				if (editLead == 8)
				{
					CRMDriver.exportList(leadArray);
					viewLead(leadID + 1, leadArray);
				} // end IF save changes
				else if (editLead == 9)
				{
					leadArray[leadID].setRating(currentRating);
					viewLead(leadID + 1, leadArray);
				} // end IF revert changes
			} // end IF change rating		
		} // end WHILE edit lead field
		
//		viewLead(leadID + 1, leadArray);
			
	} // end editLead
	
	////////////////////////// BUG FIX - When looping back to create additional leads it skips first field /////////////////////////////
	
	/******************************************************************************************************
	 * Displays page for creating a new lead, assigns it an array location and exports to list
	 * @param leadArray, array of leads (name, address, email, phone, status, leadSource, rating)
	 ******************************************************************************************************/
	public static void newLead ( Lead [] leadArray ) throws FileNotFoundException
	{
		int titleLine = 63;
		int fullLine = 147;
		int menuSelect = 0;
		String pageTitle = "   Create New Lead   ";
		
		Display.pageTitleBar(pageTitle, titleLine, fullLine);
		Display.newLeadMenu(fullLine);
		
		menuSelect = input.nextInt();
		while ( menuSelect < 3 || menuSelect > 0 )
		{
			if ( menuSelect == 1 )
			{
				for (int index = 0; index < MAX && menuSelect == 1; index++)
				{
					if ( leadArray [index] == null )
					{
						Lead newLead = new Lead(); // Declaring Lead object
						leadArray [index] = CRMDriver.createLead(newLead);
						menuSelect = 0;
						CRMDriver.exportList(leadArray);
					} // end if nullIndex == null
				} // end FOR loop
			} // end IF menuSelect = 1
			else if ( menuSelect == 2 )
			{
				Pages.viewAllLeads(leadArray);
			} // end IF menuSelect = 2
//			menuSelect = 0;
			Display.newLeadFooter(fullLine);
			menuSelect = input.nextInt();
		}
	} // end newLead

}
