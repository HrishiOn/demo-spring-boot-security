package com.example.demospringsecurity.domain;

import org.springframework.stereotype.Component;

@Component
public class Clothes {
	private String brand;
	private String size;
	public Clothes(String brand, String size) {
		this.brand = brand;
		this.size = size;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public Clothes() {
		// TODO Auto-generated constructor stub
	}
	
}
