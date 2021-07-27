package com.example.pet.cliente.repository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pet.cliente.model.Client;

public interface ClienteRepository extends JpaRepository<Client, Long>
{
	Optional<Client> findById(Long id);
}
