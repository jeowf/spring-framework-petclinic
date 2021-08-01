package com.example.Veterinarios.Request;

import javax.validation.constraints.NotBlank;

import com.example.Veterinarios.model.Vet;

public class NewVetRequest {
	@NotBlank
	private String name;
	@NotBlank
	private String specialty;
	public NewVetRequest(@NotBlank String name, @NotBlank String specialty) {
		this.name = name;
		this.specialty = specialty;
	}
	@Override
	public String toString() {
		return "NewVetRequest [name=" + name + ", specialty=" + specialty + "]";
	}
	
	public Vet toModel() {
		return new Vet(name, specialty);
	}
}
