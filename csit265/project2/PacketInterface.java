//Jared Kronyak

public interface PacketInterface 
{    
	/*
	 * Returns the messageID string     
	 *    
	 * @return String   
	 *    
	 */   
	String getMessageID();   
	
	/*    
	 * Returns the index number of the packet    
	 *   
	 * @return int   
	 *      
	 */    
	int getIndex();   
	
	/*   
	 * Returns the message   
	 *   
	 * @return String     
	 *     
	 */    
	String getMessage();
}
