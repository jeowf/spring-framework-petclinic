package com.example.pet.pets.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pet.pets.model.Pet;

public interface PetRepository extends JpaRepository<Pet, Long>{

	List<Pet> findByOwnerId(Long ownerId);
	
}
