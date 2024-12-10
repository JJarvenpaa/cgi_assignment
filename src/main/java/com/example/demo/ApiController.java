package com.example.demo;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    // TODO: First steps for CREATE method:
    
    ArrayList<Person> personsList = new ArrayList<Person>(); //Initialize a new array suitable for JSON data

    //Method for creating new Person
    @PostMapping("/api/persons") //create a route for /api/persons
    Person addNewPerson(@RequestBody Person newPerson) {
        //Add new Person object here
        newPerson.name = "testi";
        newPerson.ssn = "150796-111V";
        newPerson.address = "testikatu 1B7";
        newPerson.nationality = "Suomalainen";
        newPerson.language = "Suomi";
        newPerson.dateOfBirth = "01.01.1990";
        newPerson.dateOfDeath = "";
        //Populate new list with obj Person using test data
        personsList.add(newPerson);

        return newPerson;
    }
   
}
