package com.dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dev.request.Passenger;
import com.dev.response.Ticket;
import com.dev.service.BookingService;

@RestController
public class BookingRestController {

	@Autowired
	private BookingService service;

	@GetMapping("/message")
	public String welcome() {
		return "<center style='margin-top:25%'><h1 style='color:blue'>Welcome To IRCTC APP<h1><center>";
	}

	@PostMapping(value = "/ticket", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Ticket> ticketBooking(@RequestBody Passenger passenger) {
		Ticket ticket = service.bookTicket(passenger);

		return new ResponseEntity<Ticket>(ticket, HttpStatus.CREATED);
	}

	@GetMapping(value = "/ticket/{ticketNum}", produces = "application/json")
	public ResponseEntity<Ticket> getTicket(@PathVariable("ticketNum") Integer ticketNum) {
		Ticket ticket = service.getTicket(ticketNum);

		return new ResponseEntity<Ticket>(ticket, HttpStatus.OK);
	}
}
