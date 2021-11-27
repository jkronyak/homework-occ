//Jared Kronyak

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class WordIndexer
{
	Map<String, List<String>> indexMap;
	
	//Default Constructor
	public WordIndexer()
	{
		indexMap = new HashMap<String, List<String>>();
	}
	
	//Constructor which receives the fileName, calls indexFile. 
	public WordIndexer(String fileName) throws FileNotFoundException	
	{
		indexMap = new HashMap<String, List<String>>();
		indexFile(fileName);
	}
	
	/*
	 * Pre-conditions: Receives a String containing the path to the file to index.
	 * Post-conditions: Returns a String each word in the file and the line numbers at which it appears.
	 */
	public String indexFile(String fileName) throws FileNotFoundException
	{
		File fileToIndex = new File(fileName);
		Scanner input = new Scanner(fileToIndex);
		
		int lineNumber = 1;
	
		String curLine = "";
		while(input.hasNextLine())
		{
			curLine = input.nextLine();
			curLine = curLine.replaceAll("[\\[\\]_$@#*(-.,;:!\'\"/)%?]","");
			
			Scanner line = new Scanner(curLine);
			
			while(line.hasNext())
			{
				add(line.next(), lineNumber + "");
			}
			
			lineNumber++;
			line.close();
		}
		input.close();
		
		return toString();
	}
	
	/*
	 * Pre-conditions: Receives two Strings key and value, which respectively contain the key and value to add to the 
	 * HashMap. Words should have their punctuation stripped already.
	 * Post-conditions: Returns true if the word was successfully added as a new entry, false if not. 
	 */
	public boolean add(String key, String value)
	{
		String lowerKey = key.toLowerCase();
		
		if(key.length() <= 3)
			return false;
	
		//If the word is already in indexMap
		if(indexMap.containsKey(lowerKey))
		{
			//If the lineNumber (value) is already present in that key location i.e. a word appears multiple times on one line.
			if(indexMap.get(lowerKey).contains(value))
			{
				return false;		//Was not entirely sure whether or not to return true of false here.
			}						//No new value is added, but the word is present. 
			
			indexMap.get(lowerKey).add(value);
			return true;

		}
		indexMap.put( lowerKey, new ArrayList<String>() {{ add(value); }} );
		return true;
	}
	
	/*
	 * Pre-conditions: None
	 * Post-conditions: Returns a formatted output in alphabetical order of each key and its associated values.
	 */
	public String toString()
	{
		String result = "";
		
		ArrayList<String> keyList = new ArrayList<String>(indexMap.keySet());
		
		Collections.sort(keyList);
		
		
		for(int i = 0; i < keyList.size(); i++)
		{
			result += keyList.get(i) + " - ";
			
			for(int j = 0; j < indexMap.get( keyList.get(i) ).size()  ; j++)
			{
				//If/else to account for the unnecessary comma at the end of the output. 
				if(j < indexMap.get( keyList.get(i) ).size() - 1)
					result += indexMap.get(keyList.get(i)).get(j) + ", ";
				else
					result += indexMap.get(keyList.get(i)).get(j);
			}
			result += "\n";
			
		}
		return result;
	}
	
}
