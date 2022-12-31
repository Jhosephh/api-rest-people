package com.jge.people.controller;

import com.jge.people.model.Person;
import com.jge.people.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/person")
public class PersonController{

    @Autowired
    private PersonService personService;

    private Map<String,Object> response = new HashMap<>();

    @GetMapping("/all")
    private ResponseEntity<?> findAllPerson() {
        response.clear();
        response.put("people", personService.getAllPerson());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private  ResponseEntity<?> getPersonById(@PathVariable Long id){
        response.clear();
        response.put("people", personService.getFindById(id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping("/new")
    private  ResponseEntity<?> savePerson(@RequestBody Person person){
        response.clear();
        personService.savePerson(person);
        response.put("message","save person successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    private  ResponseEntity<?> updatePerson(@PathVariable Long id, @RequestBody Person person){
            response.clear();
            personService.updatePerson(id, person);
            response.put("message", "person updated");
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deleteById(@PathVariable Long id){
        response.clear();
        personService.deletePerson(id);
        response.put("message", "person delete successfully");
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
}
