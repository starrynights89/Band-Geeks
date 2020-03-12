package com.bandgeeks.data.hibernate;

import com.bandgeeks.beans.Status;

public interface StatusDAO {

	public Status getStatus(Status status);
	public void updateStatus(Status status);
}
