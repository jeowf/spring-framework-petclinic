package com.example.pet.model2;

public class VisitPayment {

	private Visit visit;
	private Payment payment;
	
	public VisitPayment(Visit visit, Payment payment) {
		super();
		this.visit = visit;
		this.payment = payment;
	}
	
	public Visit getVisit() {
		return visit;
	}
	public void setVisit(Visit visit) {
		this.visit = visit;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	public VisitPayment() {
		
	}
	
}
