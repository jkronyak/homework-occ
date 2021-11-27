//Jared Kronyak

public class Investment implements Asset
{
	private String name;
	private String desc;
	private double value;
	
	public Investment(String inName, String inDesc, double inValue)
	{
		name = inName;
		desc = inDesc;
		value = inValue;
	}
	
	//Implemented methods
	@Override
	
	public double getValue()
	{
		return value;
	}
	
	@Override
	public String getName()
	{
		return name;
	}
	
	//Methods
	public String getDesc()
	{
		return desc;
	}
	
	public String toString()
	{
		return name + " has a value of $" + String.format("%,.2f", value) + " in " + desc;
	}
}
