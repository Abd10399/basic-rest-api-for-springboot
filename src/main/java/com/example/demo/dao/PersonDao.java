package com.example.demo.dao;

import java.util.List;
import java.util.UUID;
import java.util.Optional;

import com.example.demo.model.Person;

public interface PersonDao {
    
    int insertPerson(UUID id, Person person);
    //Inserts person with a given id
    
    default int insertPerson(Person person) {
        //Inserts person with a random id

        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

    List<Person> selectAllPeople();
    //Returns a list of all people

    Optional<Person> selectPersonById(UUID id);

    int deletePersonById(UUID id);

    int updatePersonById(UUID id, Person person);

}
