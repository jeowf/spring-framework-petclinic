package com.example.pet.pagamentos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pets")
public class Payment 
{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Long visitId;
	
	private Double value;
	
	private String status;

	public Payment() {
		
	}
	
	public Payment (Long id, Long visitId, Double value, String status) 
	{
		this.id = id;
		this.visitId = visitId;
		this.value = value;
		this.status = status;
	}
	
	public Long getId() 
	{
		return id;
	}

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Long getVisit() 
	{
		return visitId;
	}

	public void setVisit(Long visit) 
	{
		this.visitId = visit;
	}

	public Double getValue() 
	{
		return value;
	}

	public void setValue(Double value) 
	{
		this.value = value;
	}

	public String getStatus() 
	{
		return status;
	}

	public void setStatus(String status) 
	{
		this.status = status;
	}
}
