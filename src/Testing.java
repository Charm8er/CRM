
public class Testing 
{
	/***************************************************************************************
	 * Prints the full lead array unless null
	 * @param leadArray, array of leads (name, address, email, phone, status, leadSource, rating)
	 ***************************************************************************************/
	public static void printLeadArray (Lead [] leadArray)
	{
		for (int index = 0; index < 500; index ++)
		{	
			if (leadArray [index] != null)
			{
				System.out.println ( leadArray [index] );
			} // end IF != null
		} // end FOR index location
	} // end printLeadArray
}
