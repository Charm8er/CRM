// Contains sub-classes for sorting leadArray by name, status, rating or leadNum

public class Sort 
{
	/***************************************************************************************
	 * This whole Sort class was implemented using help from online resources.  I used 
	 * several different sites including stackoverflow, GeeksForGeeks and Baeldung along
	 * with just playing around with it a bunch to get working code.  Special thanks to 
	 * Sarah for helping me get rid of the nullPointerException I couldn't figure out!
	 ***************************************************************************************/
	
	/***************************************************************************************
	 * QuickSort Name field for leadArray, checks and swaps array elements
     * @param leadArray, array of leads (name, address, email, phone, status, leadSource, rating, leadNum)
     * @param low, starting index 
     * @param high, ending index 
	 ***************************************************************************************/
	static class SortByName
	{
		public int partition(Lead[]leadArray, int low, int high) 
	    { 	
		        String pivot = leadArray[high].getName();
		        int i = (low-1); // index of smaller element
		        for (int j=low; j<high; j++) 
		        { 
		        	// check leadArray[j] < pivot
		            if ( leadArray[j].getName().compareToIgnoreCase(pivot) < 0 )
		            { 
		                i++; 
		  
		                // swap leadArray[i] and leadArray[j] 
		                Lead temp = leadArray[i];
		                leadArray[i] = leadArray[j]; 
		                leadArray[j] = temp; 
		            } // end IF leadArray [j] <= pivot
		        } //end FOR array loop
			
			// swap leadArray[i+1] and leadArray[high] (or pivot)  
	        Lead temp = leadArray[i+1]; 
	        leadArray[i+1] = leadArray[high]; 
	        leadArray[high] = temp; 
	  
	        return i+1; 
	    } // end partition 
		
		/***************************************************************************************
	     * The main function that implements SortByName 
	     * @param leadArray, array of leads (name, address, email, phone, status, leadSource, rating, leadNum)
	     * @param low, starting index 
	     * @param high, ending index 
		***************************************************************************************/
	    void sort(Lead leadArray[], int low, int high) 
	    { 
	        if (low < high) 
	        { 
	        	// partitioning index - leadArray[pi] in correct space now
	            int pi = partition(leadArray, low, high); 
	  
	            // recursively sort elements before and after partition
	            sort(leadArray, low, pi-1); 
	            sort(leadArray, pi+1, high); 
	        } // end IF low < high
	    } // end sort 

	} // end SortByName
	
	/***************************************************************************************
	 * QuickSort Status field for leadArray, checks and swaps array elements
     * @param leadArray, array of leads (name, address, email, phone, status, leadSource, rating, leadNum)
     * @param low, starting index 
     * @param high, ending index 
	 ***************************************************************************************/
	static class SortByStatus
	{
		public int partition(Lead[]leadArray, int low, int high) 
	    { 	
		        String pivot = leadArray[high].getStatus();
		        int i = (low-1); // index of smaller element
		        for (int j=low; j<high; j++) 
		        { 
		        	// check leadArray[j] < pivot
		            if ( leadArray[j].getStatus().compareToIgnoreCase(pivot) < 0 )
		            { 
		                i++; 
		  
		                // swap leadArray[i] and leadArray[j] 
		                Lead temp = leadArray[i];
		                leadArray[i] = leadArray[j]; 
		                leadArray[j] = temp; 
		            } // end IF leadArray [j] <= pivot
		        } //end FOR array loop
			
	        // swap leadArray[i+1] and leadArray[high] (or pivot) 
	        Lead temp = leadArray[i+1]; 
	        leadArray[i+1] = leadArray[high]; 
	        leadArray[high] = temp; 
	  
	        return i+1; 
	    } // end partition 
		
		/***************************************************************************************
	     * The main function that implements SortByStatus 
	     * @param leadArray, array of leads (name, address, email, phone, status, leadSource, rating, leadNum)
	     * @param low, starting index 
	     * @param high, ending index 
		***************************************************************************************/
	    void sort(Lead leadArray[], int low, int high) 
	    { 
	        if (low < high) 
	        { 
	        	// partitioning index - leadArray[pi] in correct space now
	            int pi = partition(leadArray, low, high); 
	  
	            // recursively sort elements before and after partition
	            sort(leadArray, low, pi-1); 
	            sort(leadArray, pi+1, high); 
	        } // end IF low < high
	    } // end sort 

	} // end SortByStatus
	
	/***************************************************************************************
	 * QuickSort Rating field for leadArray, checks and swaps array elements
     * @param leadArray, array of leads (name, address, email, phone, status, leadSource, rating, leadNum)
     * @param low, starting index 
     * @param high, ending index 
	 ***************************************************************************************/
	static class SortByRating
	{
		public int partition(Lead[]leadArray, int low, int high) 
	    { 	
		        int pivot = leadArray[high].getRating(); 
		        int i = (low-1); // index of smaller element
		        for (int j=low; j<high; j++) 
		        { 
		            if (leadArray[j].getRating() <= pivot) 
		            { 
		                i++; 
		  
		                // swap leadArray[i] and leadArray[j] 
		                Lead temp = leadArray[i];
		                leadArray[i] = leadArray[j]; 
		                leadArray[j] = temp; 
		            } // end IF leadArray [j] <= pivot
		        } //end FOR array loop
			
			// swap leadArray[i+1] and leadArray[high] (or pivot)  
	        Lead temp = leadArray[i+1]; 
	        leadArray[i+1] = leadArray[high]; 
	        leadArray[high] = temp; 
			
	        return i+1; 
	    } // end partition 
	    
		/***************************************************************************************
	     * The main function that implements SortByRating 
	     * @param leadArray, array of leads (name, address, email, phone, status, leadSource, rating, leadNum)
	     * @param low, starting index 
	     * @param high, ending index 
		***************************************************************************************/
	    void sort(Lead leadArray[], int low, int high) 
	    { 
	        if (low < high) 
	        { 
	        	// partitioning index - leadArray[pi] in correct space now
	            int pi = partition(leadArray, low, high); 
	  
	            // recursively sort elements before and after partition
	            sort(leadArray, low, pi-1); 
	            sort(leadArray, pi+1, high); 
	        } // end IF low < high
	    } // end sort    
	} // end SortByRating
	
	/***************************************************************************************
	 * QuickSort LeadNum field for leadArray, checks and swaps array elements
     * @param leadArray, array of leads (name, address, email, phone, status, leadSource, rating, leadNum)
     * @param low, starting index 
     * @param high, ending index 
	 ***************************************************************************************/
	static class SortByLeadNum
	{
		public int partition(Lead[]leadArray, int low, int high) 
	    { 	
		        int pivot = leadArray[high].getLeadNum(); 
		        int i = (low-1); // index of smaller element
		        for (int j=low; j<high; j++) 
		        { 
		            if (leadArray[j].getLeadNum() <= pivot) 
		            { 
		                i++; 
		  
		                // swap leadArray[i] and leadArray[j] 
		                Lead temp = leadArray[i];
		                leadArray[i] = leadArray[j]; 
		                leadArray[j] = temp; 
		            } // end IF leadArray [j] <= pivot
		        } //end FOR array loop
			
			// swap leadArray[i+1] and leadArray[high] (or pivot)  
	        Lead temp = leadArray[i+1]; 
	        leadArray[i+1] = leadArray[high]; 
	        leadArray[high] = temp; 
			
	        return i+1; 
	    } // end partition 
	    
		/***************************************************************************************
	     * The main function that implements SortByLeadNum 
	     * @param leadArray, array of leads (name, address, email, phone, status, leadSource, rating, leadNum)
	     * @param low, starting index 
	     * @param high, ending index 
		***************************************************************************************/
	    void sort(Lead leadArray[], int low, int high) 
	    { 
	        if (low < high) 
	        { 
	        	// partitioning index - leadArray[pi] in correct space now
	            int pi = partition(leadArray, low, high); 
	  
	            // recursively sort elements before and after partition
	            sort(leadArray, low, pi-1); 
	            sort(leadArray, pi+1, high); 
	        } // end IF low < high
	    } // end sort    
	} // end SortByLeadNum
	
} // end Sort class
