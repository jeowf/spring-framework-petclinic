package com.example.Veterinarios.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Veterinarios.model.Vet;

public interface VetRepository extends  JpaRepository<Vet, Long>{
	
	Optional<Vet> findById(Long id);
}
