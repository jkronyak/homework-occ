//Jared Kronyak

import java.util.ArrayList;
public class DiceCup
{
	private ArrayList<Die> cup;
	private int lastTotal;
	
	public DiceCup()
	{
		cup = new ArrayList<Die>();
		lastTotal = 0;
	}
	
	public boolean add(int numberOfFaces)
	{
		cup.add(new Die(numberOfFaces));
		
		return true;
	}
	
	public int rollDice()
	{
		int total = 0;
		
		for(Die cur : cup)
		{
			cur.roll();
			total += cur.getLastRoll();
		}
		lastTotal = total;
		
		return total;
	}
	
	public int getLastRoll()
	{
		return lastTotal;
	}
	
	public int countDiceByFaces(int numberOfFaces)
	{
		int count = 0;
		
		for(Die cur : cup)
		{
			if(cur.getNumberOfFaces() == numberOfFaces)
			{
				count++;
			}
		}
		return count;
	}
}

//Jared Kronyak
public class Die
{
	private int faces;
	private int lastRoll;
	
	public Die(int numberOfFaces)
	{
		faces = numberOfFaces;
		lastRoll = -1;
	}
	
	public int roll()
	{
		int roll = (int) (Math.random() * faces) + 1;
		lastRoll = roll;
		
		return roll;
	}
	
	public int getLastRoll()
	{
		return lastRoll;
	}
	
	public int getNumberOfFaces()
	{
		return faces;
	}
	
}

