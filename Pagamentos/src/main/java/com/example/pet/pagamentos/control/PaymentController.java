package com.example.pet.pagamentos.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pet.pagamentos.model.Payment;
import com.example.pet.pagamentos.repository.PaymentRepository;

@RestController
@RequestMapping("/payment")
@CrossOrigin(origins="*")
public class PaymentController 
{
	@Autowired
	PaymentRepository paymentRepository;
	
	@PostMapping("/new")
	public String cadastroPayment(@RequestBody Payment payment) 
	{
		try 
		{
			paymentRepository.save(payment);
		}catch(Exception e) 
		{
			return "error";
		}
		
		return "Success";
	}
	
	@PutMapping("/edit")
	public String updatePayment(@RequestBody Payment payment)
	{
		try 
		{
			paymentRepository.save(payment);
		}catch(Exception e) 
		{
			return "error";
		}
		
		return "Success";
	}
	
	@GetMapping("/all")
	public List<Payment> getAll() 
	{
		try 
		{
			return paymentRepository.findAll();
		}catch(Exception e) 
		{
			return null;
		}
	}
	
	@GetMapping("/all/{id}")
	public List<Payment> getAllByVisit(@PathVariable Long id) 
	{
		try 
		{
			return paymentRepository.findByVisitId(id);
		}catch(Exception e) 
		{
			return null;
		}
	}
	
	@GetMapping("/{id}")
	public Payment getPayment(@PathVariable Long id) 
	{
		try 
		{
			return paymentRepository.findById(id).get();
		}catch(Exception e) 
		{
			return null;
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public String deletePayment(@PathVariable Long id)
	{
		try 
		{
			paymentRepository.deleteById(id);
		}catch(Exception e) 
		{
			return "Error";
		}
		
		return "Success";
	}
}
