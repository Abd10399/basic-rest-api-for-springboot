package com.example.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;

import io.micrometer.common.lang.NonNull;

import java.util.List;
import java.util.UUID;


@RequestMapping("api/v1/person")
@RestController
@Validated
public class PersonController {
    
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@Valid @NonNull @RequestBody Person person) {
        personService.addPerson(person);
    }
    @GetMapping
    public List<Person> getAllPeople() {
        return personService.getAllPeople();
    }
    @GetMapping(path = "{id}") //api/v1/person/(id will be here)
    public Person getPersonById(@PathVariable("id") UUID id) {
        return personService.getPersonById(id)
            .orElse(null);              //Gives message if person not found (returns null)    
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") UUID id) {
        personService.deletePersonById(id);
    }

    @PutMapping(path = "{id}") //api/v1/person/(id will be here)
    public int updatePerson(@PathVariable("id") UUID id, @Valid @NonNull @RequestBody Person person) {
        return personService.updatePerson(id, person);
    }
}
