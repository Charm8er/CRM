
public class Pages 
{
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

		for (int index = 0; index < 500; index++)
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
		for (int index = 0; index < 500; index++)
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
}
