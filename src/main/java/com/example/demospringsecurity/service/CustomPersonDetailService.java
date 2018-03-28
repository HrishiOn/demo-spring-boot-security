package com.example.demospringsecurity.service;

import java.util.Optional;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demospringsecurity.domain.CustomPersonDetails;
import com.example.demospringsecurity.domain.Person;
import com.example.demospringsecurity.repository.PersonRepository;
@Service
public class CustomPersonDetailService implements UserDetailsService{

	private PersonRepository personRepository;
	public CustomPersonDetailService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		Optional<Person> optionalPersons = personRepository.findById(arg0);
		
		optionalPersons.ifPresent(persons 
				-> {
					new CustomPersonDetails(persons);});
		optionalPersons.orElseThrow(
				()-> 
				new UsernameNotFoundException("oo.. userName not found"));
		return optionalPersons.map(
					CustomPersonDetails::new).get();
	}

}
