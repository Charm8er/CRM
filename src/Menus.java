import java.io.FileNotFoundException;
import java.util.Scanner;

public class Menus 
{
	static Scanner input;
	public static final int MAX = 500; // lead array size
	public static final int NOTE_MAX = 4000; // note array size
	
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
		int fullLine = 147;	// full width line
		int menuSelect = 0; // menu selection
		boolean continueSearch = true;// lcv for search
		String regex = "[0-9]+"; // numbers only for regex
		String search; // search query
				
		do
		{
			menuSelect = input.nextInt ( );
			input.nextLine(); // bug fix
			if ( menuSelect == 1)
			{
				Pages.viewAllLeads(listSize, noteListSize, noteArray, leadArray);
				menuSelect = 0;
			} // end IF menuSelect 1 (view all leads)
			else if ( menuSelect == 2)
			{
				String status = "Converted";
				Pages.searchAllLeads(listSize, noteListSize, status, noteArray, leadArray);
				menuSelect = 0;
			} // end IF menuSelect 2 (view converted leads)
			else if ( menuSelect == 3)
			{
				do
				{
					Display.search(fullLine);
					continueSearch = true;
					search = input.nextLine();
					if (search.length() == 10 && search.matches(regex))
					{
						search = search.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3"); // format phone number
					} // end IF search match regex (phone format)
				
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
						else if (leadArray[index].getName().contains(search) 
								|| leadArray[index].getAddress().contains(search) 
								|| leadArray[index].getPhone().contains(search) 
								|| leadArray[index].getEmail().contains(search))
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
				System.out.println( "Invalid menu selection!\nPlease try again.");
				menuSelect = input.nextInt();
			} // end IF search no results
			
		} while ( menuSelect > 0 || menuSelect < 6); // end WHILE menuSelect 1-5
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
		
		menuSelect = input.nextInt ( );
		do
		{
			switch (menuSelect)
			{
				case 0: // main menu
					Pages.mainMenu(listSize, noteListSize, noteArray, leadArray);
					menuSelect = -1;
					break;
				case 1: // new lead
					listSize = Pages.newLead(listSize, noteListSize, noteArray, leadArray);
					menuSelect = -1;
					break;
				case 2: // view lead
					System.out.println( "\nEnter Lead ID: ");
					leadSelect = input.nextInt();
					for (int index = 0; index < MAX; index++)
					{
						if ((leadArray [index] != null) && (leadArray[index].getLeadNum() == leadSelect))
						{
							Pages.viewLead( listSize, noteListSize, index, noteArray, leadArray );
						} // end IF != null and leadNum == leadSelect
					} // end FOR array loop	
					menuSelect = -1;
					break;
				case 3: // sort by name
	//				Arrays.sort(leadArray,new Sort.SortByName());
					menuSelect = -1;
					break;
				case 4: // sort by status
	//				Arrays.sort(leadArray,new Sort.SortByStatus());
					menuSelect = -1;
					break;
				case 5: // sort by rating
	//				Sort.SortByRating sortRating = new Sort.SortByRating();
	//				sortRating.sort(leadArray, 0, listSize);
	//				viewAllLeads(listSize, leadArray);
					
	//				Arrays.sort(leadArray,new Sort.SortByRating());
	//				System.out.println(Arrays.asList(leadArray));
					menuSelect = -1;
					break;
				default: // invalid selection
					System.out.println( "Invalid menu selection!\nPlease try again.");			
			} // end switch menuSelect		
		} while ( menuSelect > 0 || menuSelect < 6); // end WHILE menuSelect 1-5
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
		int menuSelect; // menu selection
		
		menuSelect = input.nextInt ( );	
		do
		{
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
			} //end menuSelect 3 (convert lead)
			else if ( menuSelect == 4)
			{
				for (int i = noteListSize; i < NOTE_MAX; i++)
				{
						noteListSize++;
						Note newNote = new Note(); // Declaring Lead object
						noteArray [i] = CRMDriver.createNote(leadID, newNote);
//						menuStatus = false;
						CRMDriver.exportNoteList(noteArray);
						Pages.viewLead(listSize, noteListSize, index, noteArray, leadArray);
				} // end FOR array loop
				menuSelect = 0;
			} // end menuSelect 4 (add notes)
			else
			{
				System.out.println( "Please select a menu option: \n");
				menuSelect = input.nextInt();
			} // end invalid selection
			
		} while (menuSelect > 0 || menuSelect < 5);// end WHILE menuSelect > 1 || < 4
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
			int listSize, int noteListSize, int leadID, Note [] noteArray, Lead [] leadArray ) throws FileNotFoundException
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
				Pages.viewLead(listSize, noteListSize, leadID, noteArray, leadArray);
			} // end IF cancel edit			
			else if ( editLead == 1 )
			{
				field = "name";
				currentName = leadArray[leadID].getName();
				System.out.println( "Current Name: " + currentName);
				
				Display.toolTips(object, field);
				System.out.println( "Enter New Name: \n");
				input.nextLine();
				updatedName = input.nextLine();			
				leadArray[leadID].setName(updatedName);			
				System.out.println( "Save Changes (8) or Revert Changes (9): ");
				saveLead = input.nextInt();
				if (saveLead == 8)
				{
					CRMDriver.exportList(leadArray);
				} // end IF save changes
				else if (saveLead == 9)
				{
					leadArray[leadID].setName(currentName);
				} // end IF revert changes
			} // end IF change name
			else if ( editLead == 2 )
			{
				field = "address";
				currentAddress = leadArray[leadID].getAddress();
				System.out.println( "Current address: " + currentAddress);
				Display.toolTips(object, field);
				System.out.println( "Enter new address: ");
				input.nextLine();
				updatedAddress = input.nextLine();
				leadArray[leadID].setAddress(updatedAddress);
				
				System.out.println( "Save Changes (8) or Revert Changes (9): ");
				editLead = input.nextInt();
				if (editLead == 8)
				{
					CRMDriver.exportList(leadArray);
				} // end IF save changes
				else if (editLead == 9)
				{
					leadArray[leadID].setAddress(currentAddress);
				} // end IF revert changes
			} // end IF change address
			else if ( editLead == 3 )
			{
				field = "email";
				currentEmail = leadArray[leadID].getEmail();
				System.out.println( "Current email: " + currentEmail);
				Display.toolTips(object, field);
				System.out.println( "Enter new email: ");
				input.nextLine();
				updatedEmail = input.nextLine();
				leadArray[leadID].setEmail(updatedEmail);
				
				System.out.println( "Save Changes (8) or Revert Changes (9): ");
				editLead = input.nextInt();
				if (editLead == 8)
				{
					CRMDriver.exportList(leadArray);
				} // end IF save changes
				else if (editLead == 9)
				{
					leadArray[leadID].setEmail(currentEmail);
				} // end IF revert changes
			} // end IF change email
			else if ( editLead == 4 )
			{
				field = "phone";
				currentPhone = leadArray[leadID].getPhone();
				System.out.println( "Current phone: " + currentPhone);
				Display.toolTips(object, field);
				System.out.println( "Enter new phone: ");
				input.nextLine();
				updatedPhone = input.nextLine();
				updatedPhone = updatedPhone.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3"); // format phone number
				leadArray[leadID].setPhone(updatedPhone);
				
				System.out.println( "Save Changes (8) or Revert Changes (9): ");
				editLead = input.nextInt();
				if (editLead == 8)
				{
					CRMDriver.exportList(leadArray);
				} // end IF save changes
				else if (editLead == 9)
				{
					leadArray[leadID].setPhone(currentPhone);
				} // end IF revert changes
			} // end IF change phone
			else if ( editLead == 5 )
			{
				field = "status";
				currentStatus = leadArray[leadID].getStatus();
				System.out.println( "Current status: " + currentStatus);
				Display.toolTips(object, field);
				System.out.println( "Enter new status: ");
				input.nextLine();
				updatedStatus = input.nextLine();
				leadArray[leadID].setStatus(updatedStatus);
				
				System.out.println( "Save Changes (8) or Revert Changes (9): ");
				editLead = input.nextInt();
				if (editLead == 8)
				{
					CRMDriver.exportList(leadArray);
				} // end IF save changes
				else if (editLead == 9)
				{
					leadArray[leadID].setStatus(currentStatus);
				} // end IF revert changes
			} // end if change status
			else if ( editLead == 6 )
			{
				field = "leadSource";
				currentLeadSource = leadArray[leadID].getLeadSource();
				System.out.println( "Current lead source: " + currentLeadSource);
				Display.toolTips(object, field);
				System.out.println( "Enter new lead source: ");
				input.nextLine();
				updatedLeadSource = input.nextLine();
				leadArray[leadID].setLeadSource(updatedLeadSource);
				
				System.out.println( "Save Changes (8) or Revert Changes (9): ");
				editLead = input.nextInt();
				if (editLead == 8)
				{
					CRMDriver.exportList(leadArray);
				} // end IF save changes
				else if (editLead == 9)
				{
					leadArray[leadID].setLeadSource(currentLeadSource);
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
				} // end IF save changes
				else if (editLead == 9)
				{
					leadArray[leadID].setRating(currentRating);
				} // end IF revert changes
			} // end IF change rating	
			Pages.editLead(listSize, noteListSize, leadID, noteArray, leadArray);
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
		int fullLine = 147; // full width line
		int menuSelect = 0; // menu selection
		int lastLeadNum; // last assigned leadNum 
		
		menuSelect = input.nextInt();
		while ( menuSelect < 3 || menuSelect > 0 )
		{
			lastLeadNum = leadArray [listSize-1].getLeadNum();
			if ( menuSelect == 1 )
			{
				for (int index = listSize; index < MAX && menuSelect == 1; index++)
				{
						listSize++;
						Lead newLead = new Lead(); // Declaring Lead object
						leadArray [index] = CRMDriver.createLead(lastLeadNum, newLead);
						menuSelect = 0;
						CRMDriver.exportList(leadArray);
				} // end FOR loop
			} // end IF menuSelect = 1
			else if ( menuSelect == 2 )
			{
				Pages.viewAllLeads(listSize, noteListSize, noteArray, leadArray);
			} // end IF menuSelect = 2
			Display.newLeadFooter(fullLine);
			menuSelect = input.nextInt();
		} // end WHILE menuSelect 1-2
		return listSize;
	} // end newLeadMenuSelect
	
} // end Menus class
