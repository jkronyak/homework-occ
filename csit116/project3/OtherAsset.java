//Jared Kronyak

public class OtherAsset implements Asset
{
	private String name;
	private String desc;
	private double value;
	
	public OtherAsset(String inName, String inDesc, double inValue)
	{
		name = inName;
		desc = inDesc;
		value = inValue;
	}
	
	public String getDesc()
	{
		return desc;
	}
	
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
	
	public String toString()
	{
		return desc + " has an asset worth $" + String.format("%,.2f", value) + " in " + name;
	}
	
	
}
