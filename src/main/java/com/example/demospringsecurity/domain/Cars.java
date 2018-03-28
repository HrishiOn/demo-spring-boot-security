package com.example.demospringsecurity.domain;

import org.springframework.stereotype.Component;

@Component
public class Cars {

	private String make;
	private double licenceNumber;
	public Cars(String make, double licenceNumber) {
		this.make = make;
			this.licenceNumber = licenceNumber;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public double getLicenceNumber() {
		return licenceNumber;
	}
	public void setLicenceNumber(double licenceNumber) {
		this.licenceNumber = licenceNumber;
	}
	public Cars() {
		// TODO Auto-generated constructor stub
	}
	
	
}
