package com.example.demospringsecurity.service;

import java.util.Optional;
import java.util.function.Function;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demospringsecurity.domain.CustomPersonDetails;
import com.example.demospringsecurity.domain.Person;
import com.example.demospringsecurity.repository.PersonRepository;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
@Service
public class CustomPersonDetailService implements UserDetailsService{

	@Autowired
	private MongoDatabase mongoclient;
	private PersonRepository personRepository;
	public CustomPersonDetailService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		/*MongoCollection<Document> document = mongoclient.getCollection("persons");
		Document firstDocument = document.find(Filters.eq("userName", userName)).first();
		
		if(firstDocument != null) {
			firstDocument
		}
		*/
		Optional<Person> optionalPersons = personRepository.findByUserName("{userName:"+userName+"}");
		
		optionalPersons.ifPresent(persons->new CustomPersonDetails(persons));
		optionalPersons.orElseThrow(()->new UsernameNotFoundException("oo.. userName not found"));
		return optionalPersons.map(CustomPersonDetails::new).get();
	}

}
