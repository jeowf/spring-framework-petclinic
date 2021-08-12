package com.example.pet.consultas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pet.consultas.model.Visit;

public interface VisitRepository extends JpaRepository<Visit,Long> {

	public List<Visit> findByOwnerId(Long id);
	
	public List<Visit> findByVetId(Long id);
	
}
