package com.bandgeeks.data.hibernate;

import java.util.Set;

import com.bandgeeks.beans.Request;

public interface RequestDAO {

	
	public Integer createRequest(Request request);
	public Request getRequest(Request request);
	public Request getRequestById(Integer id);
	public Set<Request> getRequests();
	public void updateRequest(Request request);
	public void deleteRequest(Request request);
	
	
	
}
