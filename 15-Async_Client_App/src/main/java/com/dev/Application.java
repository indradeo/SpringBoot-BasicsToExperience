package com.dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.Disposable;

@SpringBootApplication
public class Application {
	private static String Book_Ticket_Url = "http://localhost:8080/ticket";
	private static String Get_Ticket_Url = "http://localhost:8080/ticket/{ticketNum}";

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
		System.out.println("Request Sending started...");
		WebClient client= WebClient.create();
		
		client.get()
			.uri(Get_Ticket_Url, 1)
			.retrieve()
			.bodyToMono(String.class)
			.subscribe(Application::handleResponse);
		
		System.out.println("request Sending end...");
	}
	
	public static void handleResponse(String response) {
		System.out.println(response);
	}
}
