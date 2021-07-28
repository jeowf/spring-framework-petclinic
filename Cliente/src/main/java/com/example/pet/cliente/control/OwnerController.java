package com.example.pet.cliente.control;

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

import com.example.pet.cliente.model.Owner;
import com.example.pet.cliente.repository.OwnerRepository;

@RestController
@RequestMapping("/Owner")
@CrossOrigin(origins="*")
public class OwnerController 
{
	@Autowired
	OwnerRepository ownerRepository;
	
	final static String ROOT_URI = "http://localhost:";
	
	@PostMapping("/new")
	public String createOwner(@RequestBody Owner owner) 
	{
		try 
		{
			ownerRepository.save(owner);
		}catch(Exception e) 
		{
			return "error";
		}
		
		return "Success";
	}
	
	@GetMapping("/all")
	public List<Owner> getOwners() 
	{
		try 
		{
			return ownerRepository.findAll();
		}catch(Exception e) 
		{
			return null;
		}
	}
	
	@GetMapping("/{id}")
	public Owner getOwner(@PathVariable Long id) 
	{
		try 
		{
			return ownerRepository.findById(id).get();
		}catch(Exception e) 
		{
			return null;
		}
	}
	
	@PutMapping("/edit")
	public String editOwner(@RequestBody Owner owner) 
	{
		try 
		{
			ownerRepository.save(owner);
		}catch(Exception e) 
		{
			return "error";
		}
		
		return "Success";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteOwner(@PathVariable Long id)
	{
		try 
		{
			ownerRepository.deleteById(id);
		}catch(Exception e) 
		{
			return "Error";
		}
		
		return "Success";
	}
}
