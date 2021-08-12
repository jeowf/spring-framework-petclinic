package com.example.pet.consultas.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "visit")
public class Visit {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	private Long ownerId;
	
	private Long petId;
	
	private Long vetId;
	
	private LocalDate date;
	
	private String description;
	
	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public Long getPetId() {
		return petId;
	}

	public void setPetId(Long petId) {
		this.petId = petId;
	}

	public Long getVetId() {
		return vetId;
	}

	public void setVetId(Long vetId) {
		this.vetId = vetId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Visit(Long id, Long ownerId, Long petId, Long vetId, LocalDate date, String description, String status) {
		super();
		this.id = id;
		this.ownerId = ownerId;
		this.petId = petId;
		this.vetId = vetId;
		this.date = date;
		this.description = description;
		this.status = status;
	}
	
	public Visit() {
		
	}
	
}
