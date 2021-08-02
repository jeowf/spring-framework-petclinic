package com.example.Veterinarios.controller;

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

import com.example.Veterinarios.Request.NewVetRequest;
import com.example.Veterinarios.Request.VetRequest;
import com.example.Veterinarios.model.Vet;
import com.example.Veterinarios.repository.VetRepository;

@RestController
@RequestMapping("/Vet")
@CrossOrigin(origins="*")
public class VetController {
	
	@Autowired
	VetRepository vetRepository; 
	
	final static String ROOT_URI = "http://localhost:";
	
	@PostMapping("/")
	public String newVet(@RequestBody NewVetRequest request) {
		Vet vet = request.toModel();
		
		try 
		{
			vetRepository.save(vet);
		}catch(Exception e) 
		{
			return "error";
		}
		
		return "Success";
	}
	
	@PutMapping("/")
	public String updateVet(@RequestBody VetRequest request) {
		Vet vet = request.toModel();
		
		try 
		{
			vetRepository.save(vet);
		}catch(Exception e) 
		{
			return "error";
		}
		
		return "Success";
		
	}
	
	@GetMapping("/all")
	public List<Vet> getAll() 
	{
		try 
		{
			return vetRepository.findAll();
		}catch(Exception e) 
		{
			return null;
		}
	}
	
	@GetMapping("/{id}")
	public Vet getClient(@PathVariable Long id) 
	{
		try 
		{
			return vetRepository.findById(id).get();
		}catch(Exception e) 
		{
			return null;
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteClient(@PathVariable Long id)
	{
		try 
		{
			vetRepository.deleteById(id);
		}catch(Exception e) 
		{
			return "Error";
		}
		
		return "Success";
	}
}
