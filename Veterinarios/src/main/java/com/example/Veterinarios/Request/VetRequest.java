package com.example.Veterinarios.Request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.NumberFormat;

import com.example.Veterinarios.model.Vet;

public class VetRequest {
		@NotBlank
		@NotNull
		@NumberFormat
		public Long id;
		@NotBlank
		private String name;
		@NotBlank
		private String specialty;
		public VetRequest(@NotBlank @NotNull @NumberFormat Long id,@NotBlank String name, @NotBlank String specialty) {
			this.id = id;
			this.name = name;
			this.specialty = specialty;
		}
		@Override
		public String toString() {
			return "NewVetRequest [name=" + name + ", specialty=" + specialty + "]";
		}
		
		public Vet toModel() {
			return new Vet(id,name, specialty);
		}
	}

