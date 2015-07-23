package org.rbkpro.javacf.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.rbkpro.javacf.messenger.database.DataBaseClass;
import org.rbkpro.javacf.messenger.model.*;

public class MessageService {
	
	private Map<Long, Message> messages = DataBaseClass.getMessages();
	
	public MessageService (){
		messages.put(1L, new Message(1,"HELLO WORLD ", "rabeh", "just for test"));
		messages.put(2L, new Message(2, "Hello jersy", "rbkpro", "test year"));
	}
	
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());
 	}
	
	public List<Message> getAllMessagesForYear(int year){
		List<Message> messagesForYear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for (Message message : messages.values()){
			cal.setTime(message.getCreated());
			if (cal.get(Calendar.YEAR)==year){
				messagesForYear.add(message);
			}
			
		}
		return messagesForYear;
	}
	
	public List<Message> gettAllMessagesPaginated(int start, int size){
		ArrayList<Message> list= new ArrayList<Message>(messages.values());
		if (start+size > list.size()) return new ArrayList<Message>();
		return list.subList(start,start+size);		
	}
	
	public Message getMessage(long id) {
		return messages.get(id);
		
	}
	
	public void cfMedoth(String name){
		
	}
	public Message addMessage(Message message) {
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message) {
		if(message.getId()<=0){
			return null;
		}
		 messages.put(message.getId(), message);
		 return message;
	}
	
	public Message removeMessage(long id) {
		return messages.remove(id);
		
	}
}
