package com.example.pet.pagamentos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pet.pagamentos.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>
{
	public List<Payment> findByVisitId(Long visitId);
}
