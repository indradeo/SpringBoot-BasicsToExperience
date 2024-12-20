package com.dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dev.request.Passenger;
import com.dev.response.Ticket;
import com.dev.service.MakeMyTripService;

@Controller
public class MakeMyTripController {
	
	@Autowired
	private MakeMyTripService tripService;
	
	@GetMapping("/")
	public String loadPage(Model model) {
		
		model.addAttribute("passenger", new Passenger());
		
		return "index";
	}
	
	@GetMapping("/ticket")
	public String getTicketForm(Model model) {
		model.addAttribute("ticket", new Ticket());
		return "ticket";
	}
	
	@PostMapping("/ticket")
	@ResponseBody
	public Ticket bookTicket(@ModelAttribute Passenger passenger) {
		System.out.println(passenger);
		
		return tripService.bookTicket(passenger);
	}
	
	@GetMapping("/get-ticket")
	public String getTicket(@RequestParam("ticketNum") Integer ticketNum, Model model) {
		Ticket ticket=  tripService.getTicket(ticketNum);
		model.addAttribute("ticket", ticket);
		return "ticket";
	}
}
