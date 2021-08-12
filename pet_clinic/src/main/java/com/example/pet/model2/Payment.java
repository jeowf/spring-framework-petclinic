package com.example.pet.model2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Payment 
{

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

	public Long getVisitId() 
	{
		return visitId;
	}

	public void setVisitId(Long visit) 
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
