package com.dev.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.dev.request.Passenger;
import com.dev.response.Ticket;

@Service
public class MakeMyTripServiceImpl implements MakeMyTripService {

	private static String Book_Ticket_Url = "http://localhost:8080/ticket";
	private static String Get_Ticket_Url = "http://localhost:8080/ticket/{ticketNum}";

	@Override
	public Ticket bookTicket(Passenger passenger) {

		/*
		 * RestTemplate rt = new RestTemplate(); ResponseEntity<Ticket> respEntity =
		 * rt.postForEntity(Book_Ticket_Url, passenger, Ticket.class); Ticket ticket =
		 * respEntity.getBody(); return ticket;
		 */
		
		WebClient client = WebClient.create();
		
		Ticket ticket = client.post()
						.uri(Book_Ticket_Url)
						.bodyValue(passenger)
						.retrieve()
						.bodyToMono(Ticket.class)
						.block();
		
		return ticket;
	}

	@Override
	public Ticket getTicket(Integer ticketNumber) {

		/*
		 * RestTemplate rt = new RestTemplate();
		 * 
		 * ResponseEntity<Ticket> respEntity = rt.getForEntity(Get_Ticket_Url,
		 * Ticket.class,ticketNumber); return respEntity.getBody();
		 */

		WebClient client = WebClient.create();

		Ticket ticket = client.get()
							.uri(Get_Ticket_Url, ticketNumber)
							.retrieve()
							.bodyToMono(Ticket.class)
							.block();// sync call
		
		return ticket;
	}

}



class A {
	
}

class B extends A{
	
}


