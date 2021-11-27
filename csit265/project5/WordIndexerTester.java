//Jared Kronyak

import java.io.FileNotFoundException;

public class WordIndexerTester
{
	
	public static void main(String[] args) throws FileNotFoundException
	{

		WordIndexer indexer = new WordIndexer();
		System.out.println(indexer.indexFile("words.txt"));
		
		
		/*
		//Testing the add() method with duplicates.
		indexer.add("Word", "1");
		indexer.add("Word", "1");
		indexer.add("Word", "1");
		
		indexer.add("word", "1");
		indexer.add("Word", "2");
		indexer.add("word", "2");
		
		//This is entered as "an-other" and not "another", as the - is accounted for only in the indexFile method.
		indexer.add("an-other", "2"); 
		*/
		
		//System.out.println(	indexer.toString() );
		
		
		
		
		//System.out.println("end");
	}
	
}
