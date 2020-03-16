package com.bandgeeks.data.hibernate;

import java.util.List;

import com.bandgeeks.beans.Assignment;
import com.bandgeeks.beans.Chatter;


public interface ChatterDAO {
	
	public Chatter createMessage(Chatter message);
	public List<Chatter> getAllUnreadMessages(int userId);
	public boolean updateMessage(Chatter message);


}
