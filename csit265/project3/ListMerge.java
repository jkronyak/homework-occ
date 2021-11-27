//Jared Kronyak
import java.util.ArrayList;
import java.util.List;

public class ListMerge 
{
	public static List listMerge(List a, List b)
	{
		List combined = new ArrayList<>();
		
		if(a.isEmpty() && b.isEmpty())
			return combined;

		List copyA = new ArrayList<>();
		List copyB = new ArrayList<>();
		
		copyA = makeSubCopyOf(a, 1, copyA);
		copyB = makeSubCopyOf(b, 1, copyB);
		
		combined = listMerge(copyA, copyB);
		
		if(!combined.contains(a.get(0)))
			combined.add( a.get(0) );
	
		if(!combined.contains(b.get(0)))
			combined.add( b.get(0) );
		
		return combined;
	}
	
	
	/*
	 * 	This method is used for making a deep copy of a given List starting from a given index. 
	 * 	List original is the original List object which is to be cloned.
	 * 	int i is the index from which to begin the cloning. i.e. when i = 0 in the initial call, the whole list is cloned.
	 * 	List copy represents the deep clone. 
	 * 
	 */
	public static List makeSubCopyOf(List original, int i, List copy)
	{
		if(i == original.size())
		{
			return copy;
		}
		copy.add(original.get(i));
		
		return makeSubCopyOf(original, i + 1, copy);
	}
	
}
