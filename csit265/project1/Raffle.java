//Jared Kronyak

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Raffle 
{
	ListBag<Entry> raffleBag;
	
	public Raffle(String filePathName)
	{
		raffleBag = new ListBag<Entry>();
		
		try 
		{
			File entries = new File(filePathName);
			Scanner s = new Scanner(entries);
			while(s.hasNextLine())
			{
				String last = s.next();
				String first = s.next();
				String entrySN = s.next();
				addEntry(new Entry(first, last, entrySN));
				
				//The File is formatted as Last, First, eSN, but the Entry Constructor is First, Last, eSN
				//addEntry(new Entry(s.next(), s.next(), s.next()));
			}
			
			s.close();
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public Raffle()
	{
		raffleBag = new ListBag<Entry>();
	}
	
	public boolean addEntry(Entry entry)
	{
		if(raffleBag.contains(entry))
		{
			return false;
		}

		raffleBag.add(entry);
		return true;

	}
	
	public void combine(Raffle other)
	{
		Iterator<Entry> itr = raffleBag.iterator();
		while(itr.hasNext())
		{
			Entry cur = (Entry) itr.next();
			other.raffleBag.remove(cur);
		}
		raffleBag = (ListBag<Entry>) raffleBag.union(other.raffleBag);
	}
	
	public List<Entry> pickWinners(int numberOfWinners)
	{
		List<Entry> winners = new ArrayList<Entry>();
		
		for(int i = 0; i < numberOfWinners; i++)
		{
			winners.add(raffleBag.removeRandom());
		}
	
		return winners;
	}
}
