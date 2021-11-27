//Jared Kronyak

public class RetirementAccount extends Investment
{
	public RetirementAccount(String inName, String inDesc, double inValue)
	{
		super(inName, inDesc, inValue);
	}
	
	public String toString()
	{
		return getName() + " has $" + String.format("%,.2f", getValue()) + " for " + getDesc();
	}
}
