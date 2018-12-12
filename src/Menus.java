// Contains menu options for each page along with various other functions such as the search, edit lead and add note 
// these features are contained within their respective menu areas.

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Menus 
{
	static Scanner input;
	public static final int LEAD_MAX = 500; // leadArray MAX size
	public static final int NOTE_MAX = 4000; // noteArray MAX size
	public static final int FULLLINE = 147; // full width line
	
	/******************************************************************************************************
	 * Displays and accepts menu input for Pages.mainMenu, contains search algorithm for Lead search in menu 3
	 * @param listSize, array size of leadArray
	 * @param noteListSize, array size of note Array
	 * @param noteArray, array of notes (leadNum, date, contents)
	 * @param leadArray, array of leads (name, address, email, phone, status, leadSource, rating, leadNum)
	 * @throws FileNotFoundException 
	 ******************************************************************************************************/
	public static void mainMenuSelect( 
			int listSize, int noteListSize, Note [] noteArray, Lead [] leadArray ) throws FileNotFoundException
	{
		input = new Scanner (System.in);
		int menuSelect = 0; // menu selection
		boolean continueSearch = true;// lcv for search
		String numRegex = "[0-9]+"; // numbers only for regex
		String search; // search query
				
		do
		{
			menuSelect = input.nextInt ( );
//			input.nextLine(); // bug fix
			if ( menuSelect == 1)
			{
				Sort.SortByLeadNum sortLeadNum = new Sort.SortByLeadNum();
				sortLeadNum.sort(leadArray, 0, listSize-1);
				Pages.viewAllLeads(listSize, noteListSize, noteArray, leadArray);
				menuSelect = 0;
			} // end IF menuSelect 1 (view all leads)
			else if ( menuSelect == 2)
			{
				String status = "converted";
				Pages.searchAllLeads(listSize, noteListSize, status, noteArray, leadArray);
				menuSelect = 0;
			} // end IF menuSelect 2 (view converted leads)
			else if ( menuSelect == 3)
			{
				do
				{
					Display.search(FULLLINE);
					continueSearch = true;
					input.nextLine(); //bug fix
					search = input.nextLine();
					search = search.toLowerCase();  // convert to lowerCase before search
					
					// converts regex matching strings to phone format before search
					if (search.length() == 10 && search.matches(numRegex))
					{
						search = search.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3"); // format phone number
					} // end IF search match numRegex (phone format)
					
					for (int index = 0; index < listSize && continueSearch == true; index++)
					{
						if (leadArray[index].getName().equalsIgnoreCase(search)
								|| leadArray[index].getAddress().equalsIgnoreCase(search) 
								|| leadArray[index].getPhone().equalsIgnoreCase(search) 
								|| leadArray[index].getEmail().equalsIgnoreCase(search))
						{
							
							Pages.viewLead(listSize, noteListSize, index, noteArray, leadArray);
							menuSelect = 0;
							continueSearch = false;
						} // end IF search matches data params
						else if (leadArray[index].getName().toLowerCase().contains(search) 
								|| leadArray[index].getAddress().toLowerCase().contains(search) 
								|| leadArray[index].getPhone().toLowerCase().contains(search) 
								|| leadArray[index].getEmail().toLowerCase().contains(search))
						{					
							Pages.searchAllLeads(listSize, noteListSize, search, noteArray, leadArray);
							menuSelect = 0;
							continueSearch = false;
						} // end IF search contains data params	
						else if (search.equals("00"))
						{
							continueSearch = false;
							Pages.mainMenu(listSize, noteListSize, noteArray, leadArray);
						} // end IF exit search 00				
					} // end FOR array Loop
					System.out.println("\nYour search returned (0) results.\n");
				} while (!"00".equals(search) ); // end search loop
				Pages.mainMenu(listSize, noteListSize, noteArray, leadArray);
			} // end IF menuSelect 3 (search)
			else
			{
				System.out.println( "Invalid menu selection!\nPlease try again: \n");
//				menuSelect = 0;
//				menuSelect = input.nextInt();
			} // end IF search no results
			
		} while ( menuSelect < 0 || menuSelect > 3); // end WHILE menuSelect 1-5
	} // end mainMenuSelect
	
	/******************************************************************************************************
	 * Displays and accepts menu input for Pages.viewAllLeads and Pages.seachAllLeads
	 * @param listSize, array size of leadArray
	 * @param noteListSize, array size of note Array
	 * @param noteArray, array of notes (leadNum, date, contents)
	 * @param leadArray, array of leads (name, address, email, phone, status, leadSource, rating, leadNum)
	 * @throws FileNotFoundException 
	 ******************************************************************************************************/
	public static void leadsMenuSelect( 
			int listSize, int noteListSize, Note [] noteArray, Lead [] leadArray ) throws FileNotFoundException
	{
		int menuSelect = 9; // menu selection
		int leadSelect ; // lead selection
			
		do
		{
			menuSelect = input.nextInt ( );
			switch (menuSelect)
			{
				case 0: // main menu
					Pages.mainMenu(listSize, noteListSize, noteArray, leadArray);
					menuSelect = 9;
					break;
				case 1: // new lead
					listSize = Pages.newLead(listSize, noteListSize, noteArray, leadArray);
					menuSelect = 9;
					break;
				case 2: // view lead
					System.out.println( "\nEnter Lead ID: ");
					leadSelect = input.nextInt();
					for (int index = 0; index < listSize; index++)
					{
						if ((leadArray [index] != null) && (leadArray[index].getLeadNum() == leadSelect))
						{
							Pages.viewLead( listSize, noteListSize, index, noteArray, leadArray );
						} // end IF != null and leadNum == leadSelect
					} // end FOR array loop	
					menuSelect = 9;
					break;
				case 3: // sort by name
					Sort.SortByLeadNum sortLeadNum = new Sort.SortByLeadNum();
					sortLeadNum.sort(leadArray, 0, listSize-1);
					menuSelect = 9;
					Pages.viewAllLeads(listSize, noteListSize, noteArray, leadArray);
					break;
				case 4: // sort by name
					Sort.SortByName sortName = new Sort.SortByName();
					sortName.sort(leadArray, 0, listSize-1);
					menuSelect = 9;
					Pages.viewAllLeads(listSize, noteListSize, noteArray, leadArray);
					break;
				case 5: // sort by status
					Sort.SortByStatus sortStatus = new Sort.SortByStatus();
					sortStatus.sort(leadArray, 0, listSize-1);
					menuSelect = 9;
					Pages.viewAllLeads(listSize, noteListSize, noteArray, leadArray);
					break;
				case 6: // sort by rating
					Sort.SortByRating sortRating = new Sort.SortByRating();
					sortRating.sort(leadArray, 0, listSize-1);
					menuSelect = 9;
					Pages.viewAllLeads(listSize, noteListSize, noteArray, leadArray);
					break;
				default: // invalid selection
					System.out.println( "Invalid menu selection!\nPlease try again: \n");
					menuSelect = 9;
			} // end switch menuSelect		
		} while ( menuSelect < 0 || menuSelect > 6); // end WHILE menuSelect != 1-6
	} // end leadsMenuSelect
	
	/******************************************************************************************************
	 * Displays and accepts menu input for Pages.viewAllLeads and Pages.seachAllLeads
	 * @param listSize, array size of leadArray
	 * @param noteListSize, array size of note Array
	 * @param search, search query
	 * @param noteArray, array of notes (leadNum, date, contents)
	 * @param leadArray, array of leads (name, address, email, phone, status, leadSource, rating, leadNum)
	 * @throws FileNotFoundException 
	 ******************************************************************************************************/
	public static void searchMenuSelect( 
			int listSize, int noteListSize, String search, Note [] noteArray, Lead [] leadArray ) throws FileNotFoundException
	{
		int menuSelect = 9; // menu selection
		int leadSelect ; // lead selection
				
		do
		{
			menuSelect = input.nextInt ( );
			switch (menuSelect)
			{
				case 0: // main menu
					Pages.mainMenu(listSize, noteListSize, noteArray, leadArray);
					menuSelect = 9;
					break;
				case 1: // new lead
					listSize = Pages.newLead(listSize, noteListSize, noteArray, leadArray);
					menuSelect = 9;
					break;
				case 2: // view lead
					System.out.println( "\nEnter Lead ID: ");
					leadSelect = input.nextInt();
					for (int index = 0; index < listSize; index++)
					{
						if ((leadArray [index] != null) && (leadArray[index].getLeadNum() == leadSelect))
						{
							Pages.viewLead( listSize, noteListSize, index, noteArray, leadArray );
						} // end IF != null and leadNum == leadSelect
					} // end FOR array loop	
					menuSelect = 9;
					break;
				case 3: // sort by name
					Sort.SortByLeadNum sortLeadNum = new Sort.SortByLeadNum();
					sortLeadNum.sort(leadArray, 0, listSize-1);
					menuSelect = 9;
					Pages.searchAllLeads(listSize, noteListSize, search, noteArray, leadArray);
					break;
				case 4: // sort by name
					Sort.SortByName sortName = new Sort.SortByName();
					sortName.sort(leadArray, 0, listSize-1);
					menuSelect = 9;
					Pages.searchAllLeads(listSize, noteListSize, search, noteArray, leadArray);
					break;
				case 5: // sort by status
					Sort.SortByStatus sortStatus = new Sort.SortByStatus();
					sortStatus.sort(leadArray, 0, listSize-1);
					menuSelect = 9;
					Pages.searchAllLeads(listSize, noteListSize, search, noteArray, leadArray);
					break;
				case 6: // sort by rating
					Sort.SortByRating sortRating = new Sort.SortByRating();
					sortRating.sort(leadArray, 0, listSize-1);
					menuSelect = 9;
					Pages.searchAllLeads(listSize, noteListSize, search, noteArray, leadArray);
					break;
				default: // invalid selection
					System.out.println( "Invalid menu selection!\nPlease try again: \n");			
			} // end switch menuSelect		
		} while ( menuSelect < 0 || menuSelect > 6); // end WHILE menuSelect != 1-6
	} // end leadsMenuSelect
	
	/******************************************************************************************************
	 * Displays and accepts menu input for Pages.viewLead
	 * @param listSize, array size of leadArray
	 * @param noteListSize, array size of note Array
	 * @param index, location in array
	 * @param leadID, lead ID number
	 * @param noteArray, array of notes (leadNum, date, contents)
	 * @param leadArray, array of leads (name, address, email, phone, status, leadSource, rating, leadNum)
	 * @throws FileNotFoundException 
	 ******************************************************************************************************/
	public static void viewLeadMenuSelect( 
			int listSize, int noteListSize, int index, int leadID, Note [] noteArray, Lead [] leadArray ) throws FileNotFoundException
	{
		int menuSelect = 0; // menu selection
		
		do
		{
			menuSelect = input.nextInt ( );
			if ( menuSelect == 1)
			{
				Pages.viewAllLeads(listSize, noteListSize, noteArray, leadArray);
				menuSelect = 0;
			} // end menuSelect 1 (view leads)
			else if ( menuSelect == 2)
			{
				Pages.editLead(listSize, noteListSize, index, noteArray, leadArray);
				menuSelect = 0;
			} // end menuSelect 2 (edit lead)
			else if ( menuSelect == 3)
			{
				leadArray [index].setStatus("Converted");
				leadArray [index].setRating(10);			
				CRMDriver.exportList(leadArray);
				System.out.println( "Congratulations! " + leadArray[index].getName() + " has been Converted to an Account.");
				menuSelect = 0;
				Pages.viewLead(listSize, noteListSize, index, noteArray, leadArray);
			} //end menuSelect 3 (convert lead)
			else if ( menuSelect == 4)
			{
				for (int i = 0; i < NOTE_MAX; i++)
				{
					if (noteArray [i] == null)
					{
						noteListSize++;
						Note newNote = new Note(); // Declaring Lead object
						noteArray [i] = CRMDriver.createNote(leadID, newNote);
						CRMDriver.exportNoteList(noteArray);
						Pages.viewLead(listSize, noteListSize, index, noteArray, leadArray);
					} // end IF i = null
				} // end FOR array loop
				menuSelect = 0;
			} // end menuSelect 4 (add notes)
			else
			{
				System.out.println( "Invalid menu selection!\nPlease try again: \n");
			} // end invalid selection
			
		} while (menuSelect < 0 || menuSelect > 4);// end WHILE menuSelect != 1-4
	} // end viewLeadMenuSelect
	
	/******************************************************************************************************
	 * Displays and accepts menu input for Pages.editLead, contains options to change data params and export
	 * @param listSize, array size of leadArray
	 * @param noteListSize, array size of note Array
	 * @param leadID, assigned lead ID 
	 * @param noteArray, array of notes (leadNum, date, contents)
	 * @param leadArray, array of leads (name, address, email, phone, status, leadSource, rating, leadNum)
	 * @throws FileNotFoundException 
	 ******************************************************************************************************/
	public static void editLeadMenuSelect( 
			int listSize, int noteListSize, int index, Note [] noteArray, Lead [] leadArray ) throws FileNotFoundException
	{
		int editLead = 0; // menu selection for cancel or continue edit
		int saveLead = 0; // menu selection for save or revert changes to lead
		String field; // field for tool tips
		String object = "editLead"; // object for tooltips
		
		String currentName, currentAddress, currentEmail, currentPhone, currentStatus, currentLeadSource;
		int currentRating; // current values
		
		String updatedName, updatedAddress, updatedEmail, updatedPhone, updatedStatus, updatedLeadSource;
		int updatedRating; // updated values
		
		editLead = input.nextInt();
		
		while ( editLead > 0 || editLead < 8)
		{
			if ( editLead == 0)
			{
				Pages.viewLead(listSize, noteListSize, index, noteArray, leadArray);
			} // end IF cancel edit			
			else if ( editLead == 1 )
			{
				field = "name";
				currentName = leadArray[index].getName();
				System.out.println( "Current Name: " + currentName);
				
				Display.toolTips(object, field);
				System.out.println( "Enter New Name: \n");
				input.nextLine();
				updatedName = input.nextLine();			
				leadArray[index].setName(updatedName);			
				System.out.println( "Save Changes (8) or Revert Changes (9): ");
				saveLead = input.nextInt();
				if (saveLead == 8)
				{
					CRMDriver.exportList(leadArray);
				} // end IF save changes
				else if (saveLead == 9)
				{
					leadArray[index].setName(currentName);
				} // end IF revert changes
			} // end IF change name
			else if ( editLead == 2 )
			{
				field = "address";
				currentAddress = leadArray[index].getAddress();
				System.out.println( "Current address: " + currentAddress);
				Display.toolTips(object, field);
				System.out.println( "Enter new address: ");
				input.nextLine();
				updatedAddress = input.nextLine();
				leadArray[index].setAddress(updatedAddress);
				
				System.out.println( "Save Changes (8) or Revert Changes (9): ");
				editLead = input.nextInt();
				if (editLead == 8)
				{
					CRMDriver.exportList(leadArray);
				} // end IF save changes
				else if (editLead == 9)
				{
					leadArray[index].setAddress(currentAddress);
				} // end IF revert changes
			} // end IF change address
			else if ( editLead == 3 )
			{
				field = "email";
				currentEmail = leadArray[index].getEmail();
				System.out.println( "Current email: " + currentEmail);
				Display.toolTips(object, field);
				System.out.println( "Enter new email: ");
				input.nextLine();
				updatedEmail = input.nextLine();
				leadArray[index].setEmail(updatedEmail);
				
				System.out.println( "Save Changes (8) or Revert Changes (9): ");
				editLead = input.nextInt();
				if (editLead == 8)
				{
					CRMDriver.exportList(leadArray);
				} // end IF save changes
				else if (editLead == 9)
				{
					leadArray[index].setEmail(currentEmail);
				} // end IF revert changes
			} // end IF change email
			else if ( editLead == 4 )
			{
				field = "phone";
				currentPhone = leadArray[index].getPhone();
				System.out.println( "Current phone: " + currentPhone);
				Display.toolTips(object, field);
				System.out.println( "Enter new phone: ");
				input.nextLine();
				updatedPhone = input.nextLine();
				updatedPhone = updatedPhone.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3"); // format phone number
				leadArray[index].setPhone(updatedPhone);
				
				System.out.println( "Save Changes (8) or Revert Changes (9): ");
				editLead = input.nextInt();
				if (editLead == 8)
				{
					CRMDriver.exportList(leadArray);
				} // end IF save changes
				else if (editLead == 9)
				{
					leadArray[index].setPhone(currentPhone);
				} // end IF revert changes
			} // end IF change phone
			else if ( editLead == 5 )
			{
				field = "status";
				currentStatus = leadArray[index].getStatus();
				System.out.println( "Current status: " + currentStatus);
				Display.toolTips(object, field);
				System.out.println( "Enter new status: ");
				input.nextLine();
				updatedStatus = input.nextLine();
				leadArray[index].setStatus(updatedStatus);
				
				System.out.println( "Save Changes (8) or Revert Changes (9): ");
				editLead = input.nextInt();
				if (editLead == 8)
				{
					CRMDriver.exportList(leadArray);
				} // end IF save changes
				else if (editLead == 9)
				{
					leadArray[index].setStatus(currentStatus);
				} // end IF revert changes
			} // end if change status
			else if ( editLead == 6 )
			{
				field = "leadSource";
				currentLeadSource = leadArray[index].getLeadSource();
				System.out.println( "Current lead source: " + currentLeadSource);
				Display.toolTips(object, field);
				System.out.println( "Enter new lead source: ");
				input.nextLine();
				updatedLeadSource = input.nextLine();
				leadArray[index].setLeadSource(updatedLeadSource);
				
				System.out.println( "Save Changes (8) or Revert Changes (9): ");
				editLead = input.nextInt();
				if (editLead == 8)
				{
					CRMDriver.exportList(leadArray);
				} // end IF save changes
				else if (editLead == 9)
				{
					leadArray[index].setLeadSource(currentLeadSource);
				} // end IF revert changes
			} // end IF change lead source
			else if ( editLead == 7 )
			{
				field = "rating";
				currentRating = leadArray[index].getRating();
				System.out.println( "Current Rating: " + currentRating);
				Display.toolTips(object, field);
				System.out.println( "Enter new rating: ");
				updatedRating = input.nextInt();
				leadArray[index].setRating(updatedRating);
				
				System.out.println( "Save Changes (8) or Revert Changes (9): ");
				editLead = input.nextInt();
				if (editLead == 8)
				{
					CRMDriver.exportList(leadArray);
				} // end IF save changes
				else if (editLead == 9)
				{
					leadArray[index].setRating(currentRating);
				} // end IF revert changes
			} // end IF change rating	
			Pages.editLead(listSize, noteListSize, index, noteArray, leadArray);
		} // end WHILE edit lead field
	} // end editLeadMenuSelect
	
	/******************************************************************************************************
	 * Displays and accepts menu input for Pages.newLead
	 * @param listSize, array size of leadArray
	 * @param noteListSize, array size of note Array
	 * @param noteArray, array of notes (leadNum, date, contents)
	 * @param leadArray, array of leads (name, address, email, phone, status, leadSource, rating, leadNum)
	 * @throws FileNotFoundException 
	 ******************************************************************************************************/
	public static int newLeadMenuSelect( 
			int listSize, int noteListSize, Note [] noteArray, Lead [] leadArray ) throws FileNotFoundException
	{
		int menuSelect = 0; // menu selection
		int lastLeadNum; // last assigned leadNum 
		
		menuSelect = input.nextInt();
		while ( menuSelect < 3 || menuSelect > 0 )
		{
			lastLeadNum = leadArray [listSize-1].getLeadNum();
			if ( menuSelect == 1 )
			{
				for (int i = 0; i < listSize + 1 && menuSelect == 1; i++)
				{
					if (leadArray [i] == null)
					{
						listSize++;
						Lead newLead = new Lead(); // Declaring Lead object
						leadArray [i] = CRMDriver.createLead(lastLeadNum, newLead);
						menuSelect = 0;
						CRMDriver.exportList(leadArray);
						Pages.viewLead(listSize, noteListSize, i, noteArray, leadArray);
					} // end IF i = null	
				} // end FOR loop
			} // end IF menuSelect = 10
			else if ( menuSelect == 2 )
			{
				Pages.viewAllLeads(listSize, noteListSize, noteArray, leadArray);
			} // end IF menuSelect = 2
			Display.newLeadFooter(FULLLINE);
			menuSelect = input.nextInt();
		} // end WHILE menuSelect 1-2
		return listSize;
	} // end newLeadMenuSelect
	
} // end Menus class
