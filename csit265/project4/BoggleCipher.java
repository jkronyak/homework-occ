//Jared Kronyak

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import jsjf.LinkedBinarySearchTree;

public class BoggleCipher
{
	LinkedBinarySearchTree<BoggleLetter> boggleTree;
	
	/*
	 * Constructor which receives a String containing the file name of the
	 * key table. The constructor iterates through each line, then within each line, 
	 * and adds a constructed BoggleLetter to the boggleTree. 
	 */
	public BoggleCipher(String keyFile) throws FileNotFoundException
	{
		boggleTree = new LinkedBinarySearchTree<BoggleLetter>();
		
		File boggleFile = new File(keyFile);
		Scanner s = new Scanner(boggleFile);
		
		//Iterate through each line in the file.
		while(s.hasNextLine())
		{
			Scanner sLine = new Scanner(s.nextLine());

			int col = 0; //Column number.
			String firstTwoDigits = sLine.next();	//The first element of each line is always the row number. 
			//Iterate through each element of the current line. 
			while(sLine.hasNext())
			{
				BoggleLetter word = new BoggleLetter(firstTwoDigits + col, sLine.next());
				boggleTree.addElement(word);
				col++;	
			}
			sLine.close();
		}
		s.close();
	}
	
	/*
	 * Receives a String codedWord containing the file name of a coded message. 
	 * Returns a String result containing a decoded message using the information from boggleTree. 
	 */
	public String decrypt(String codedWord) throws FileNotFoundException
	{
		File coded = new File(codedWord);
		Scanner s = new Scanner(coded);
		
		String result = "";
	
		while(s.hasNext())
		{
			//Temporary BoggleLetter used for comparisons. Only the num paramter is necessary. 
			BoggleLetter temp = new BoggleLetter(s.next(), null);	
			
			if((temp.num).substring((temp.num).length() - 1).equals("6"))
				result += ".";
			else if((temp.num).substring((temp.num).length() - 1).equals("7"))
				result += ",";
			else if((temp.num).substring((temp.num).length() - 1).equals("8"))
				result += "\n";
			else if((temp.num).substring((temp.num).length() - 1).equals("9"))
				result += " ";
			else
				result += boggleTree.find(temp);
		}
		
		s.close();

		return result;
	}
	/*	
	 * 	A private inner class used to store information about each numeric
	 * 	identifier from the boggle table, and its associated letters.	
	 */
	class BoggleLetter implements Comparable<BoggleLetter>
	{
		public String num;
		public String letter;
		
		public BoggleLetter(String num, String letter)
		{
			this.num = num;
			this.letter = letter;
		}

		@Override
		public int compareTo(BoggleLetter o)
		{	
			String other = o.num;
			
			return num.compareTo(other);
		}
		
		//	The LinkedBinarySearchTree requires a .compareTo method from Comparable.
		//	Yet the LinkedBinarySearchTree.find() method did not work without a .equals() method.
		@Override
		public boolean equals(Object o)
		{
			BoggleLetter other = (BoggleLetter)o;
			return num.equals(other.num);
		}
		
		@Override
		public String toString()
		{
			return letter;
		}
		
	}

}

