
public class Display {
	


	public static void dashLine (int line) 
	{	

		for (int dash = line ; dash > 0 ; dash--)
		{
			System.out.print ( "-" );			
		} // end FOR dash
		
	} // end dashLine
	
	public static void starLine (int line) 
	{	

		for (int star = line ; star > 0 ; star--)
		{
			System.out.print ( "*" );	
		} // end FOR star
		
	} // end starLine
	
	public static void pageTitleBar (String pageTitle, int titleLine, int fullLine)
	{	
		starLine(fullLine);
		System.out.println( );
		starLine(titleLine);
		System.out.print( pageTitle );
		starLine(titleLine);
		System.out.println( );
		starLine(fullLine);
		System.out.println( );
		
	} // end allLeadsTitleBar
	
	public static void leadsHeader (int fullLine)
	{
		dashLine(fullLine);
		System.out.println( );		
		System.out.printf ( "\n%-10s%-20s%-40s%-20s%-20s%-10s%-20s%-10s\n", "ID","Name","Address", "Email", "Phone", "Status", "Lead Source", "Rating" );	
		dashLine(fullLine);
		System.out.println( );
		System.out.println( );
	} // end allLeadsFooter
	
	public static void allLeadsMenu (int fullLine)
	{
		System.out.printf("\n%29s%10s","", "New Lead (1) | View Lead (2) | Sort by Name (3) | Sort by Status (4) | Sort by Rating (5)\n");
		System.out.println( );
		starLine(fullLine);
		System.out.println( );
	} // end allLeadsFooter
	
	public static void allLeadsFooter (int fullLine)
	{		
		System.out.println( );
		dashLine(fullLine);
		System.out.println( );
		starLine(fullLine);
		System.out.println( );
		
		System.out.printf("\n%29s%10s","", "New Lead (1) | View Lead (2) | Sort by Name (3) | Sort by Status (4) | Sort by Rating (5)\n");
		
		System.out.println( );
		starLine(fullLine);
		System.out.println( );
	} // end allLeadsFooter
	
	public static void viewLeadMenu (int fullLine)
	{
		System.out.printf("\n%29s%10s","", "New Lead (1) | View Lead (2) | Sort by Name (3) | Sort by Status (4) | Sort by Rating (5)\n");
		System.out.println( );
		starLine(fullLine);
		System.out.println( );
	} // end allLeadsFooter
	
	public static void viewLeadFooter (int fullLine)
	{
		System.out.println( );
		dashLine(fullLine);
		System.out.println( );
		starLine(fullLine);
		System.out.println( );
		
		System.out.printf("\n%29s%10s","", "New Lead (1) | View Lead (2) | Sort by Name (3) | Sort by Status (4) | Sort by Rating (5)\n");
		
		System.out.println( );
		starLine(fullLine);
		System.out.println( );
	} // end leadFooter
}
