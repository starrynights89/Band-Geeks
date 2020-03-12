package com.bandgeeks.services.hibernate;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bandgeeks.beans.Request;
import com.bandgeeks.data.hibernate.RequestDAO;

@Service
public class RequestServiceHibernate implements RequestService{
	
	@Autowired
	private RequestDAO rd;
	
	
	@Override
	public Integer createRequest(Request request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Request getRequest(Request request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Request getRequestById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Request> getRequests() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateRequest(Request request) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRequest(Request request) {
		// TODO Auto-generated method stub
		
	}

}
