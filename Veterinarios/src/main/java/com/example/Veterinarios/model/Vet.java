package com.example.Veterinarios.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

@Entity
public class Vet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String name;
	
	@NotNull
	private String specialty;
	
	@Deprecated
	public Vet() {
	}


	public Vet(@NotBlank String name, @NotBlank String specialty) {
		this.name = name;
		this.specialty = specialty;
	}
	

	public Vet(Long id, @NotBlank String name, @NotBlank String specialty) {
		this.id = id;
		this.name = name;
		this.specialty = specialty;
	}


	@Override
	public String toString() {
		return "Vet [id=" + id + ", name=" + name + ", specialty=" + specialty + "]";
	}
}
