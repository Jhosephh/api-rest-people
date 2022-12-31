package com.jge.people.service;

import com.jge.people.model.Person;
import com.jge.people.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;


    @Override
    public Person getFindById(Long id) {
        return personRepository.findById(id).orElse(null);
    }

    @Override
    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }

    @Override
    public void savePerson(Person person) {
        personRepository.save(person);
    }

    @Override
    public void updatePerson(Long id, Person person) {
       Person person1 = personRepository.findById(id).orElseThrow(
               () -> new NoSuchElementException("person not found")
       );
       person1.setName(person.getName());
       person1.setLastName(person1.getLastName());
       personRepository.save(person1);
    }

    @Override
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }
}
