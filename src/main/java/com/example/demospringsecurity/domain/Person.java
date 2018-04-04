package com.example.demospringsecurity.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="persons")
public class Person{
	@Id
	private String id;
	private String name;
	private int age;
	private List<Cars> car;
	private List<Clothes> shirt;
	private String email;
	private String userName;
	private String password;
	private List<Role> roles;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<Cars> getCar() {
		return car;
	}
	public void setCar(List<Cars> car) {
		this.car = car;
	}
	public List<Clothes> getShirt() {
		return shirt;
	}
	public void setShirt(List<Clothes> shirt) {
		this.shirt = shirt;
	}
	public Person() {
		// TODO Auto-generated constructor stub
	}
	public Person(Person person) {
		person.id = id;
		person.name = name;
		person.age = age;
		person.car = car;
		person.shirt = shirt;
		person.email = email;
		person.userName = userName;
		person.password = password;
		person.roles = roles;
	}
	public Person(String name, int age, List<Cars> car, List<Clothes> shirt, String email, String userName,
			String password, List<Role> roles) {
		this.name = name;
		this.age = age;
		this.car = car;
		this.shirt = shirt;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.roles = roles;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	
}
