package com.dev.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

	@Scheduled(fixedRate = 4000)
	public void generateReport() {
		// logic to perform task based on requirement
		System.out.println("report generated");
	}
}
