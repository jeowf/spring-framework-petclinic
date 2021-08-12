package com.example.pet.consultas.controller;

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

import com.example.pet.consultas.model.Visit;
import com.example.pet.consultas.repository.VisitRepository;

@RestController
@RequestMapping("/visit")
@CrossOrigin(origins="*")
public class VisitController {

	@Autowired
	VisitRepository visitRepository;
	
	@PostMapping("/new")
	public String cadastroVisit(@RequestBody Visit visit) 
	{
		try 
		{
			visitRepository.save(visit);
		}catch(Exception e) 
		{
			return "error";
		}
		
		return "Success";
	}
	
	@PutMapping("/edit")
	public String updateVisit(@RequestBody Visit visit)
	{
		try 
		{
			visitRepository.save(visit);
		}catch(Exception e) 
		{
			return "error";
		}
		
		return "Success";
	}
	
	@GetMapping("/all")
	public List<Visit> getAll() 
	{
		try 
		{
			return visitRepository.findAll();
		}catch(Exception e) 
		{
			return null;
		}
	}
	
	@GetMapping("/all/{id}")
	public List<Visit> getAllByOwner(@PathVariable Long id) 
	{
		try 
		{
			return visitRepository.findByOwnerId(id);
		}catch(Exception e) 
		{
			return null;
		}
	}
	
	@GetMapping("/{id}")
	public Visit getVisit(@PathVariable Long id) 
	{
		try 
		{
			return visitRepository.findById(id).get();
		}catch(Exception e) 
		{
			return null;
		}
	}
	
	@GetMapping("/owner/{id}")
	public List<Visit> getVisitByOwner(@PathVariable Long id) 
	{
		try 
		{
			return visitRepository.findByOwnerId(id);
		}catch(Exception e) 
		{
			return null;
		}
	}
	
	@GetMapping("/vet/{id}")
	public List<Visit> getVisitByVet(@PathVariable Long id) 
	{
		try 
		{
			return visitRepository.findByVetId(id);
		}catch(Exception e) 
		{
			return null;
		}
	}
	
	
	@DeleteMapping("/delete/{id}")
	public String deleteVisit(@PathVariable Long id)
	{
		try 
		{
			visitRepository.deleteById(id);
		}catch(Exception e) 
		{
			return "Error";
		}
		
		return "Success";
	}
	
}
