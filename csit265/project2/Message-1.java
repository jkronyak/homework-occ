//Jared Kronyak

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Message implements MessageInterface
{
	private PriorityQueue<Packet> packetQueue; 
	private String messageID;
	
	public Message(String messageID)
	{
		this.messageID = messageID;
		packetQueue = new PriorityQueue<Packet>(); 
	}
		
	@Override
	public String getSender() 
	{
		return packetQueue.peek().getMessage().substring(0, packetQueue.peek().getMessage().indexOf(" "));
	}

	@Override
	public ArrayList<String> getRecipients()
	{
		ArrayList<String> recipients = new ArrayList<String>();
		
		Scanner s = new Scanner(packetQueue.peek().getMessage());
		s.next();
		
		while(s.hasNext())
		{
			recipients.add(s.next());
		}
		s.close();
		return recipients;
	}

	@Override
	public String getMessageID()
	{
		return messageID;
	}

	@Override
	public void add(Packet p) 
	{
		packetQueue.add(p);
	}

	@Override
	public int size()
	{
		return packetQueue.size();
	}

	@Override
	public Packet remove() 
	{
		return packetQueue.remove();
	}

	@Override
	public boolean equals(Object other)
	{
		return (this.messageID).equals( ((Message)other).getMessageID()   );
	}
	
}