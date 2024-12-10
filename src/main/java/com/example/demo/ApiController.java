package com.example.demo;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class ApiController {
    
    ArrayList<Person> personsList = new ArrayList<Person>(); //Initialize a new array suitable for JSON data
    public Integer counter = -1; //We want to start ID incrementing at 0
    //TODO: write personsList to a file with JSON syntax to emulate a database

    /* TODO: Steps for READ all functionality (GET)
     * use /api/persons route but with GET request
     * Return personsList to here as a test
     * 
     */
    //Method for getting all Persons
    @GetMapping("/api/persons")
    public ArrayList<Person> getPersons() {
        return personsList;
    }
    
    //Method for creating new Person
    @PostMapping("/api/persons") //create a route for /api/persons
    Person addNewPerson(@RequestBody Person newPerson) {
        //TODO: use the actual JSON data provided via frontend
        //Add new Person object here
    
        counter++;
        newPerson.id = counter; //Add id as incrementing counter
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
