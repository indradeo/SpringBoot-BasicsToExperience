package com.dev.service;

import com.dev.request.Passenger;
import com.dev.response.Ticket;

public interface MakeMyTripService {
	
	public Ticket bookTicket(Passenger passenger);
	
	public Ticket getTicket(Integer ticketNumber);

}
