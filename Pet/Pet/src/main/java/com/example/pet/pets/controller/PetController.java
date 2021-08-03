package com.example.pet.pets.controller;

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

import com.example.pet.pets.model.Pet;
import com.example.pet.pets.repository.PetRepository;

@RestController
@RequestMapping("/pet")
@CrossOrigin(origins="*")
public class PetController {

	@Autowired
	PetRepository petRepository;
	
	@PostMapping("/new")
	public String cadastroPet(@RequestBody Pet pet) 
	{
		try 
		{
			petRepository.save(pet);
		}catch(Exception e) 
		{
			return "error";
		}
		
		return "Success";
	}
	
	@PutMapping("/edit")
	public String updatePet(@RequestBody Pet pet)
	{
		try 
		{
			petRepository.save(pet);
		}catch(Exception e) 
		{
			return "error";
		}
		
		return "Success";
	}
	
	@GetMapping("/all")
	public List<Pet> getAll() 
	{
		try 
		{
			return petRepository.findAll();
		}catch(Exception e) 
		{
			return null;
		}
	}
	
	@GetMapping("/all/{id}")
	public List<Pet> getAllByOwner(@PathVariable Long id) 
	{
		try 
		{
			return petRepository.findByOwnerId(id);
		}catch(Exception e) 
		{
			return null;
		}
	}
	
	@GetMapping("/{id}")
	public Pet getPet(@PathVariable Long id) 
	{
		try 
		{
			return petRepository.findById(id).get();
		}catch(Exception e) 
		{
			return null;
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public String deletePet(@PathVariable Long id)
	{
		try 
		{
			petRepository.deleteById(id);
		}catch(Exception e) 
		{
			return "Error";
		}
		
		return "Success";
	}
	
}
