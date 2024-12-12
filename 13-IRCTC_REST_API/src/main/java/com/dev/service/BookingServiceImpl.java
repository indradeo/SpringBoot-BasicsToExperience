package com.dev.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.dev.request.Passenger;
import com.dev.response.Ticket;

@Service
public class BookingServiceImpl implements BookingService {
	
	private Map<Integer, Ticket> tickMap= new HashMap<>();
	private Integer ticketNum=1;
	
	@Override
	public Ticket bookTicket(Passenger passenger) {
		Ticket ticket= new Ticket();
		BeanUtils.copyProperties(passenger, ticket);
		ticket.setTicketCost(2200.0);
		ticket.setStatus("CONFIRMED");
		ticket.setTicketNum(ticketNum);
		tickMap.put(ticketNum, ticket);
		ticketNum++;
		return ticket;
	}

	@Override
	public Ticket getTicket(Integer ticketNumber) {
		if(tickMap.containsKey(ticketNumber)) {
			return tickMap.get(ticketNumber);
		}
		return null;
	}

}
