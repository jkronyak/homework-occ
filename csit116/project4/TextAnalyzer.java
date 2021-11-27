//Jared Kronyak

import java.io.*;
import java.util.*;

public class TextAnalyzer
{
	private List<String> dictList;
	
	private class WordObj implements Comparable<WordObj>
	{	
		private String word;
		private String type;
		private int count;
		private double percent;

		public WordObj(String inWord, int inCount, double inPercent, String inType)
		{
			word = inWord;
			type = inType;
			count = inCount;
			percent = inPercent;
		}
		
		@Override
		public int compareTo(WordObj o)
		{
			if(this.count == o.count)
			{
				return this.word.compareTo(o.word);
			}
			else if(this.count > o.count)
			{
				return -1;
			}
			else
			{
				return 1;
			}
		}

		public String toString()
		{
			String result = String.format("%-12s%-8s%-8s%-8s", word, count,String.format("%,.2f",(percent * 100)) + "% ", type );
			
			return result;
		}
		
	}
	
	public TextAnalyzer(String filename) throws IOException
	{
		dictList = new ArrayList<String>();
		
		Scanner input = new Scanner(new File(filename));
		while(input.hasNextLine())
		{
			dictList.add(input.nextLine());
		}
		input.close();
	}
	
	public List<String> analyze(String filename) throws IOException
	{
		List<String> wordList = new ArrayList<String>();
		List<WordObj> wordData = new ArrayList<WordObj>();
		
		Scanner in = new Scanner(new File(filename));
		
		//While 
		while(in.hasNext())
		{
			//Get each line of the file
			String curLine = in.nextLine();
			
			//Remove punctuation from the current line. 
			curLine = curLine.toLowerCase();
			curLine = curLine.replaceAll("[\\[\\]_$@#*(.,;:!\'\"/)%?]","");
			curLine = curLine.replace("--"," ");				//Uses replace() instead of replaceAll() to account for singled-hyphenated words
			
			Scanner line = new Scanner(curLine);
			
			//Loop through the current line. 
			while(line.hasNext())
			{
				String cur = line.next();
				if(!cur.equals("-"))
					wordList.add(cur);
			}
			line.close();
			
		}
		in.close();
		
		Collections.sort(wordList);
		wordData = combineData(wordList);
		
		List<String> results = new ArrayList<String>();
		
		for(int i = 0; i < wordData.size(); i++)
		{
			results.add(wordData.get(i).toString());
		}
		
		return results;
	}
	
	public List<WordObj> combineData(List<String> in)
	{
		List<WordObj> wordData = new ArrayList<WordObj>();
		
		int first = 0;
		int last = 0;
		double totalWordCount = in.size();
		
		while(in.size() > 1)
		{
			String curWord = in.get(0);
			first = in.indexOf(curWord);
			last = in.lastIndexOf(curWord);
			
			wordData.add(new WordObj(curWord, ((last - first) + 1), ((last - first) + 1)/totalWordCount, findType(curWord)));
			in.subList(first,last + 1).clear();
		}
		
		Collections.sort(wordData);
		
		for(int i = 0; i < wordData.size(); i++)
		{
			System.out.println(wordData.get(i));
			 
		}
		
		return wordData;
	}
	
	public String findType(String inWord)
	{
		Scanner curDictLine;
		for(int i = 0; i < dictList.size(); i++)
		{
			curDictLine = new Scanner(dictList.get(i));
			
			if(curDictLine.next().equals(inWord))
			{	
				String result = curDictLine.next();
				curDictLine.close();
				
				return result;
			}
			
			curDictLine.close();
		}
		
		return "<unclassified>";
	}
}
