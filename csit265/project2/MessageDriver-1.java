//Jared Kronyak

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MessageDriver 
{
	public static void main(String[] args) throws FileNotFoundException
	{
		File messageFile = new File("Project2.txt");
		Scanner s = new Scanner(messageFile);
		
		//Read in all Packets from the File, store them in an List of Packets. 
		List<Packet> packetList = new ArrayList<Packet>();
		while(s.hasNext())
		{
			Packet packet = new Packet(s.nextLine(), Integer.parseInt(s.nextLine()), s.nextLine());
			packetList.add(packet);
		}
		s.close();
		
		ArrayList<Message> messageList = new ArrayList<Message>();
		
		//Loop through each packet.
		for(int i = 0; i < packetList.size(); i++)
		{
			Message tempMessage = new Message(packetList.get(i).getMessageID());
			
			//If there are no Messages OR the current ID does not match any Messages, i.e. the current Message is NOT already in the list.
			if(messageList.size() == 0 || !messageList.contains(tempMessage))
			{
				tempMessage.add(packetList.get(i)); //Add the current Packet to the Message.
				messageList.add(tempMessage); //Add the Message to the messageList.
			}
			else 
			{	//Loop through each message. 
				for(int j = 0; j < messageList.size(); j++)
				{
					//If the ID of the current Message matches the ID of the current Packet, add the Packet to that Message, shift the index j. 
					if(packetList.get(i).getMessageID().equals(messageList.get(j).getMessageID()))
					{
						messageList.get(j).add(packetList.get(i));
						j = messageList.size() - 1;
					}
				}
			}
		}
		
		//Output each reassembled message.  
		for(int i = 0; i < messageList.size(); i++)
		{
			System.out.println("\n----- NEW MESSAGE -----\n");
			Message message = messageList.get(i);
			while(message.size() > 0)
			{
				System.out.println(message.remove().getMessage());
			}
		}
		
		
		/*TESTING PURPOSES
		 * 
		Message m = messageList.get(3);
		
		//System.out.println(m.getSender());
		
		ArrayList<String> rec = messageList.get(3).getRecipients();
		
		
		for(String str : rec)
			System.out.println(str);
		
		for(int i = 0; i < messageList.size(); i++)
		{
			Message message = messageList.get(i);
			int count = 0;
			while(message.size() > 0)
			{
				System.out.println(count + ":\t" + message.remove().getMessage());
				count++;
			}
			count = 0;
			System.out.println("****************************");
		}
		
		System.out.println("TESTING");
		*/
	}
}
