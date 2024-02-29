package com.bridgelabz.greeting.controller;


import com.bridgelabz.greeting.model.Greeting;
import com.bridgelabz.greeting.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @Autowired
    private GreetingService service;

    @PostMapping("/add")
    public String greeting(@RequestBody Greeting greeting) {
        return service.addGreeting(greeting);
    }

    @GetMapping("/get")
    public List<Greeting> greeting() {
        return service.getAllGreetings();
    }

    @GetMapping("/get/{id}")
    public Greeting greeting(@PathVariable int id) {
        System.out.println("id = " + id);
        return service.getGreetingByID(id);
    }

    @PutMapping("/update")
    public String updateGreeting(@RequestBody Greeting greeting) {
        return service.updateGreeting(greeting);
    }

    @DeleteMapping("/delete/all")
    public ResponseEntity<HttpStatus> deleteGreeting() {
        try {
            service.deleteALLGreetings();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteGreeting(@PathVariable int id) {
        try {
            service.deleteGreeting(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
