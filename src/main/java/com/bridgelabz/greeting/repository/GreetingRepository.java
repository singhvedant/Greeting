package com.bridgelabz.greeting.repository;

import com.bridgelabz.greeting.model.Greeting;
import org.springframework.data.repository.CrudRepository;

public interface GreetingRepository extends CrudRepository<Greeting, Integer> {
}
