package com.example.pet.web;

import java.time.LocalDate;
import java.util.Random;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.pet.model2.Payment;
import com.example.pet.model2.Pet;
import com.example.pet.model2.Vet;
import com.example.pet.model2.Visit;

@RestController
@RequestMapping("/general")
@CrossOrigin(origins="*")
public class Orchestra {
	
	private static String vet_url = "http://localhost:9031/Vet/";
	private static String visit_url = "http://localhost:9033/visit/";
	private static String pay_url = "http://localhost:9034/payment/";
	
	@PostMapping("/create-visit")
	public Payment createVisit(@RequestBody Pet pet) {
		System.out.println("PAO");
		RestTemplate restTemplate = new RestTemplate();
		String uri = vet_url + "available";
		ResponseEntity<Vet> response = restTemplate.getForEntity(uri, Vet.class);
		
		Visit visit = new Visit(null, pet.getOwnerId(), pet.getId(), response.getBody().getId(), LocalDate.now(), " ", "Opened");
		
		
		Long visitId = restTemplate.postForEntity(visit_url+"new", visit, Long.class).getBody();
		
		Random rng = new Random();
		
		Payment payment = new Payment(null, visitId,rng.nextDouble()*50+10,"Waiting");
		
		return restTemplate.postForEntity(pay_url+"new", payment, Payment.class).getBody();
	}
	
}
