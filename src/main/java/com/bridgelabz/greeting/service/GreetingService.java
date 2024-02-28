package com.bridgelabz.greeting.service;

import com.bridgelabz.greeting.model.Greeting;
import com.bridgelabz.greeting.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingService {

    @Autowired
    GreetingRepository repo;

    public List<Greeting> getAllGreetings() {
        try {
            List<Greeting> allGreetings = (List<Greeting>) repo.findAll();
            System.out.println(allGreetings);
            return allGreetings;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public Greeting getGreetingByID(int id){
        try {
            return repo.findById(id).orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String addGreeting(Greeting greeting) {
        try {
            Greeting saved = repo.save(greeting);
            return "Successfully Saved : \n" + saved;
        } catch (Exception e){
            e.printStackTrace();
            return "Internal error in saving service.";
        }
    }

    public String updateGreeting(Greeting greeting) {
        try {
            Greeting updated = repo.save(greeting);
            return "Successfully Updated : \n" + updated;
        } catch (Exception e){
            e.printStackTrace();
            return "Internal error in updating service.";
        }
    }

    public String deleteALLGreetings() {
        try {
            repo.deleteAll();
            return "Successfully Deleted";
        } catch (Exception e){
            e.printStackTrace();
            return "Internal error in deleting service.";
        }
    }
    public String deleteGreeting(int id) {
        try {
            repo.deleteById(id);
            return "Successfully Deleted";
        } catch (Exception e){
            e.printStackTrace();
            return "Internal error in deleting service.";
        }
    }
}
