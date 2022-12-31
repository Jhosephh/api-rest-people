package com.jge.people.service;

import com.jge.people.model.Person;

import java.util.List;

public interface PersonService {
    Person getFindById(Long id);
    List<Person> getAllPerson();
    void savePerson(Person person);
    void updatePerson(Long id, Person person);
    void deletePerson(Long id);

}
