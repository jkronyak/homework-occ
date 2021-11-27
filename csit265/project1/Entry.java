//Jared Kronyak
public class Entry
{
	String firstName;
	String lastName;
	String entrySN;
	
	public Entry(String firstName, String lastName, String entrySN)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.entrySN = entrySN;
	}
	
	@Override
	public boolean equals(Object other)
	{
		return entrySN.equals(((Entry)other).entrySN);

	}
		
}