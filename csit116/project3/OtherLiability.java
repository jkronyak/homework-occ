//Jared Kronyak

public class OtherLiability implements Liability
{
	private String name;
	private String desc;
	private double owed;
	
	public OtherLiability(String inName, String inDesc, double inOwed)
	{
		name = inName;
		desc = inDesc;
		owed = inOwed;
	}
	
	public String getDesc()
	{
		return desc;
	}
	
	@Override
	public String getName() 
	{
		return name;
	}

	@Override
	public double getAmountOwed() 
	{
		return owed;
	}

	public String toString()
	{
		return name + " is owed $" +  String.format("%,.2f",owed) + " for " + desc;
	}
	
	
}
