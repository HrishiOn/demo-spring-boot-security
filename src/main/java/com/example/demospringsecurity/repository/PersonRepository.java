package com.example.demospringsecurity.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demospringsecurity.domain.Person;

@Repository
public interface PersonRepository extends MongoRepository<Person, String>{

	Optional<Person> findByUserName(String userName);

}
