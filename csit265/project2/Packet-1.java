//Jared Kronyak

public class Packet implements PacketInterface, Comparable<Packet>
{
	private String messageID;
	private int index;
	private String message;
	
	public Packet(String messageID, int index, String message)
	{
		this.messageID = messageID;
		this.index = index;
		this.message = message;	
	}
	
	@Override
	public String getMessageID() 
	{
		return messageID;
	}

	@Override
	public int getIndex() 
	{
		return index;
	}

	@Override
	public String getMessage() 
	{
		return message;
	}

	@Override
	public int compareTo(Packet o)
	{
		if(this.index == o.index)
			return 0;
		if(this.index == -1)
			return 1;
		if(o.index == -1)
			return -1;
		
		return ((Integer) this.index).compareTo((Integer) o.index);
	}
	
	public String toString()
	{
		return "" + this.index;
	}

}
