//Jared Kronyak


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class WordFinder
{
	private ArrayList<String> dict;
		
	public WordFinder(String dictionaryFilename) throws IOException
	{
		dict = new ArrayList<String>();
		Scanner in = new Scanner(new File(dictionaryFilename));
		
		while(in.hasNext())
		{
			dict.add(in.next());
		}
		in.close();
	}
	
	public List<String> search(String... elements)
	{
		ArrayList<String> results = new ArrayList<String>();
		ArrayList<String> given = new ArrayList<String>();
		ArrayList<Word> words = new ArrayList<Word>();
			
		for(String cur : elements)
		{
			given.add(cur.toLowerCase());
		}
		
		//Go through each word in the dictionary.
		for(int i = 0; i < dict.size(); i++)
		{
			String curWord = dict.get(i);
			String temp = curWord;
			
			boolean isDone = false;
			int index = 0;
			while(isDone == false && index != given.size())
			{
				String curGiven = given.get(index);
				
				if(temp.indexOf(curGiven) == -1)
				{
					isDone = true;
				}
				else
				{
					temp = temp.replaceFirst(curGiven, "");
					index++;
				}
			}
			if(index == given.size() )
			{
				words.add(new Word(curWord, calculatePointValue(curWord)));
				//results.add(curWord + " - " + calculatePointValue(curWord));
			}
		}	
		
		Collections.sort(words);
		for(Word cur : words)
		{
			//System.out.println(cur.getWord() + " - " + cur.getValue());
			results.add(cur.getWord() + " - " + cur.getValue());
		}
		
		return results;
	}
	
	public int calculatePointValue(String word)
	{
		String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
				"s", "t", "u", "v", "w", "x", "y", "z"};
		int[] pointValue = { 1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 
				1, 1, 1, 4, 4, 8, 4, 10};
		
		int score = 0;
		//Iterate through word
		for(int i = 0; i < word.length(); i++)
		{
			//iterate through alphabet
			for(int j = 0; j < alphabet.length; j++	)
			{
				if(word.substring(i, i + 1).equals(alphabet[j]))
				{
					score += pointValue[j];
				}
			}
		}
		return score;
	}
	
	public class Word implements Comparable<Word>
	{
		private String word;
		private int value;
		
		public Word(String inWord, int inValue)
		{
			word = inWord;
			value = inValue;
		}
		
		public String getWord()
		{
			return word;
		}
		
		public int getValue()
		{
			return value;
		}

		@Override
		public int compareTo(Word o)
		{
			if(this.value == o.value)
			{
				return this.word.compareTo(o.word);
			}
			else if(this.value > o.value)
			{
				return -1;
			}
			else
			{
				return 1;
			}
		}
	
	}

}
