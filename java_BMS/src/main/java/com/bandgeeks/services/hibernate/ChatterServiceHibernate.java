package com.bandgeeks.services.hibernate;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bandgeeks.beans.Chatter;
import com.bandgeeks.data.hibernate.ChatterDAO;


@Service
public class ChatterServiceHibernate implements ChatterService{

	@Autowired
	private ChatterDAO cDAO;
	
	@Override
	public Chatter createMessage(Chatter message) {
		//Add new message to the DB
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		message.setTimestamp(timestamp);
		return cDAO.createMessage(message);
	}

	@Override
	public List<Chatter> getAllUnreadMessages(int userId) {
		//Get all unread messages.
		
		List<Chatter> messageList = new ArrayList<>();
		List<Chatter> unreadMessages = new ArrayList<>();
		
		
		messageList = cDAO.getAllUnreadMessages(userId);
		for(Chatter c : messageList) {
			if("N".equalsIgnoreCase(c.getRead())) {
				unreadMessages.add(c);
			}
		}
		
		
		return unreadMessages;
	}

	@Override
	public boolean updateMessage(Chatter message) {
		return cDAO.updateMessage(message);
	}

}
