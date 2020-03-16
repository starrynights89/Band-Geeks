package com.bandgeeks.services.hibernate;

import java.util.List;

import com.bandgeeks.beans.Assignment;
import com.bandgeeks.beans.Chatter;
import com.bandgeeks.beans.Course;

public interface ChatterService {
	public Chatter createMessage(Chatter message);
	public List<Chatter> getAllUnreadMessages(int userId);
	public boolean updateMessage(Chatter message);

}
