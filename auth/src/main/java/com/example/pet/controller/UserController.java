package com.example.pet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pet.model.Response;
import com.example.pet.model.User;
import com.example.pet.repository.UserRepository;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins="*")
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@PostMapping("/new")
	public String newUser(@RequestBody User user) {
		try {
			userRepository.save(user);
			
			return "Success";
		} catch(Exception e) {
			return "Error";
		}
	}
	
	@PutMapping("/update")
	public String updateUser(@RequestBody User user) {
		try {
			userRepository.save(user);

			return "Success";
		} catch(Exception e) {
			return "Error";
		}
	}
	
	@GetMapping("/all")
	public List<User> getAll(){
		try {
			return userRepository.findAll();

		} catch(Exception e) {
			return null;
		}
	}
	
	@GetMapping("/{id}")
	public User getUser(@PathVariable Long id) {
		try {
			return userRepository.findById(id).get();

		} catch(Exception e) {
			return null;
		}
	}
	
	@PostMapping("/login")
	public Response login(@RequestBody User user) {
		try {
			User r = userRepository.findByUsername(user.getUsername());
			if (r.getPassword().equals(user.getPassword())) {
				return new Response(r.getId(), r.getRole());
			} else {
				return null;
			}
		} catch(Exception e) {
			return null;
		}
	}
	
}
