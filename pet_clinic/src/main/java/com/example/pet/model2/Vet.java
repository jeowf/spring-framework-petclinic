package com.example.pet.model2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;


public class Vet {

	private Long id;
	
	private String name;
	
	private String specialty;
	

	public Vet() {
	}


	public Vet(String name,String specialty) {
		this.name = name;
		this.specialty = specialty;
	}
	

	public Vet(Long id,  String name, String specialty) {
		this.id = id;
		this.name = name;
		this.specialty = specialty;
	}


	@Override
	public String toString() {
		return "Vet [id=" + id + ", name=" + name + ", specialty=" + specialty + "]";
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSpecialty() {
		return specialty;
	}


	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	
	
}
