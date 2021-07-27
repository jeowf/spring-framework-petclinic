package com.example.pet.cliente.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "clients")
public class Client extends Person
{
	@Column(name = "cpf")
	private String cpf;
	
	@Column(name = "birthdate")
	private LocalDate birthdate;
	
	public String getCpf() 
	{
		return cpf;
	}
	public void setCpf(String cpf) 
	{
		this.cpf = cpf;
	}
	public LocalDate getBirthdate() 
	{
		return birthdate;
	}
	public void setBirthdate(LocalDate birthdate) 
	{
		this.birthdate = birthdate;
	}	
}
