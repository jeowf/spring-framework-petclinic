package com.example.pet.cliente.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pet.cliente.model.Client;
import com.example.pet.cliente.repository.ClienteRepository;

@RestController
@RequestMapping("/Clients")
public class ClientService 
{
	@Autowired
	ClienteRepository clienteRepository;
	
	final static String ROOT_URI = "http://localhost:";
	
	@PostMapping("/new")
	public String cadastroClient(@RequestBody Client cliente) 
	{
		try 
		{
			clienteRepository.save(cliente);
		}catch(Exception e) 
		{
			return "error";
		}
		
		return "Success";
	}
	
	@PutMapping("/edit")
	public String updateClient(@RequestBody Client cliente)
	{
		try 
		{
			clienteRepository.save(cliente);
		}catch(Exception e) 
		{
			return "error";
		}
		
		return "Success";
	}
	
	@GetMapping("/all")
	public List<Client> getAll() 
	{
		try 
		{
			return clienteRepository.findAll();
		}catch(Exception e) 
		{
			return null;
		}
	}
	
	@GetMapping("/{id}")
	public Client getClient(@PathVariable Long id) 
	{
		try 
		{
			return clienteRepository.findById(id).get();
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
			clienteRepository.deleteById(id);
		}catch(Exception e) 
		{
			return "Error";
		}
		
		return "Success";
	}
}
