//Jared Kronyak

public class Mortgage extends Loan
{
	public Mortgage(String inName, String inDesc, double inOwed)
	{
		super(inName, inDesc, inOwed);
	}
	
	public String toString()
	{
		return getName() + " is owed " + String.format("%,.2f", getAmountOwed()) + " for " + getDesc();
	}

}
