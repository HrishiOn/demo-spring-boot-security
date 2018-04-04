package com.example.demospringsecurity.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demospringsecurity.domain.Cars;
import com.example.demospringsecurity.domain.Clothes;
import com.example.demospringsecurity.domain.Person;
import com.example.demospringsecurity.domain.Role;

@Component
public class PersonRepoSeeder implements CommandLineRunner{

	PersonRepository personRepo;
	
	public PersonRepoSeeder(PersonRepository personRepo) {
		this.personRepo = personRepo;
	}

	@Override
	public void run(String... args) throws Exception {
		Person hrishi = new Person(
				"HA",
				19,
				Arrays.asList(new Cars("MB",123.123)),
				Arrays.asList(new Clothes("ZARA", "L")),
				"hrishi_email@email.com",
				"hrishi_userName",
				"hrishi_password", 
				Arrays.asList(new Role("ADMIN", 1)));
		
		Person shivani = new Person(
				"SD",
				19,
				Arrays.asList(new Cars("BMW",523.123),
						new Cars("VW", 456.456)),
				Arrays.asList(new Clothes("SABYASACHI", "L"),
						new Clothes("GAVAKSH","L")),
				"shivani_email@email.com",
				"shivani_userName",
				"shivani_password",
				Arrays.asList(new Role("USER", 2)));
		Person jonny = new Person(
				"JH",
				9,
				Arrays.asList(new Cars("AUDI",523.123)),
				Arrays.asList(new Clothes("SABYASACHI", "L"),
						new Clothes("GAVAKSH","L")),
				"johnny_email@email.com",
				"johnny_userName",
				"johnny_password",
				Arrays.asList(new Role("USER", 3)));
		//Adding hotels to database
		this.personRepo.deleteAll();
		//Populate hotels at startup
		List<Person> somePersons = Arrays.asList(hrishi,shivani,jonny);
		this.personRepo.saveAll(somePersons);
	}
	

}
