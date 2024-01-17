package com.example.demo.service;

import com.example.demo.model.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Qualifier;

import com.example.demo.dao.PersonDao;


import java.util.UUID;
import java.util.Optional;
import java.util.List;

@Service
public class PersonService {
    
    private final PersonDao personDao;
    //Get the interface

    @Autowired
    public PersonService(@Qualifier("postgres") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person) {
        return personDao.insertPerson(person);
    }

    public List<Person> getAllPeople() {
        return personDao.selectAllPeople();
    }

    public Optional<Person> getPersonById(UUID id) {
        return personDao.selectPersonById(id);
    }

    public int deletePersonById(UUID id) {
        return personDao.deletePersonById(id);
    }

    public int updatePerson(UUID id, Person person) {
        return personDao.updatePersonById(id, person);
    }
}
