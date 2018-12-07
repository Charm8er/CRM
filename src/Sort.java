import java.util.*;
import java.lang.*; 
import java.io.*;

public class Sort {
	
	
//	public static void SortByName (Lead[]leadArray)
//	{
//		
//	}
//	
//	public static void SortByStatus (Lead[]leadArray)
//	{
//		
//	}
//	
//	public static void SortByRating (Lead[]leadArray)
//	{
//		
//	}
//	
	class SortByName implements Comparator<Lead>
	{

		@Override
		public int compare(Lead a, Lead b) 
		{
			return a.getName().compareTo(b.getName());
		} // end compare rating
		
	}
	
	class SortByStatus implements Comparator<Lead>
	{

		@Override
		public int compare(Lead a, Lead b) 
		{
			
			return a.getStatus().compareTo(b.getStatus());
		} // end compare rating
		
	}
	
	class SortByRating implements Comparator<Lead>
	{

		@Override
		public int compare(Lead a, Lead b) 
		{
			
			return a.getRating() - b.getRating();
		} // end compare rating
		
	}

}
