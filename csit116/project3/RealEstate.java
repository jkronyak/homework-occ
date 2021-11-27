//Jared Kronyak

public class RealEstate extends Investment
{
	
	Mortgage mortgage;
	
	public RealEstate(String inName, double inValue, Mortgage inMortgage)
	{
		super(inName, inMortgage.getDesc(), inValue);
		mortgage = inMortgage;
	}
	
	@Override
	public double getNetValue()
	{
		return getValue() - mortgage.getAmountOwed();
	}
	
	public String toString()
	{
		return getName() + " has a value of $" + String.format("%,.2f", getValue()) + " and a mortgage of $" + String.format("%,.2f", mortgage.getAmountOwed());
	}
}
