import java.util.*;

public class Sort 
{
	
//	static class SortByName implements Comparator<Lead>
//	{
//		@Override
//		public int compare(Lead a, Lead b) 
//		{
//			return a.getName().compareTo(b.getName());
//		} // end compare name	
//	} // end SortByName
//	
//	static class SortByStatus implements Comparator<Lead>
//	{
//		@Override
//		public int compare(Lead a, Lead b) 
//		{	
//			return a.getStatus().compareTo(b.getStatus());
//		} // end compare status
//	} // end SortByStatus
//	
//	static class SortByRating implements Comparator<Lead>
//	{
//
//		@Override
//		public int compare(Lead a, Lead b) 
//		{	
//			return a.getRating() - b.getRating();
//		} // end compare rating	
//	} // end SortbyRating

	static class SortByRating
	{
		int partition(Lead[]leadArray, int low, int high) 
	    { 
	        int pivot = leadArray[high].getRating();  
	        int i = (low-1); // index of smaller element 
	        for (int j=low; j<high; j++) 
	        { 
	            // If current element is smaller than or 
	            // equal to pivot 
	            if (leadArray[j].getRating() <= pivot) 
	            { 
	                i++; 
	  
	                // swap arr[i] and arr[j] 
	                Lead temp = leadArray[i];
	                leadArray[i] = leadArray[j]; 
	                leadArray[j] = temp; 
	            } 
	        } 
	  
	        // swap arr[i+1] and arr[high] (or pivot) 
	        Lead temp = leadArray[i+1]; 
	        leadArray[i+1] = leadArray[high]; 
	        leadArray[high] = temp; 
	  
	        return i+1; 
	    } 
	    
	    /* The main function that implements QuickSort() 
	      arr[] --> Array to be sorted, 
	      low  --> Starting index, 
	      high  --> Ending index */
	    void sort(Lead leadArray[], int low, int high) 
	    { 
	        if (low < high) 
	        { 
	            /* pi is partitioning index, arr[pi] is  
	              now at right place */
	            int pi = partition(leadArray, low, high); 
	  
	            // Recursively sort elements before 
	            // partition and after partition 
	            sort(leadArray, low, pi-1); 
	            sort(leadArray, pi+1, high); 
	        } 
	    }
	}
	   
}
