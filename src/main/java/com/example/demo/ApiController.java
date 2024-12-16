package com.example.demo;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class ApiController {
    
    //TODO: Can we use other than public in class and methods?
    ArrayList<Person> personsList = new ArrayList<Person>(); //Initialize a new array suitable for JSON data
    //TODO: write personsList to a file with JSON syntax to emulate a database
    public int counter = -1; //We want to start ID incrementing at 0
    //TODO: return http codes in methods

    
    //Method for getting all Persons
    @GetMapping("/api/persons") // Create a route for /api/persons for GET requests
    public ArrayList<Person> getPersons() {
        //TODO: read Persons from a json file
        //TODO: return Persons as a json to frontend
        // Return personsList to here as a test
        return personsList;
    }
    
    //Method for creating new Person
    @PostMapping("/api/persons") //create a route for /api/persons for POST requests
    int addNewPerson(@RequestBody Person newPerson) {
        //Jackson does the JSON handling for us, so we only need to add the id
        counter++;
        newPerson.id = counter; //Add id as incrementing counter
        //Populate new list with obj Person using test data
        personsList.add(newPerson);
        //TODO: catch here if something goes wrong when adding Person to list

        return 201;
    }

    //Method for modifying Person
    @PutMapping("api/persons/{id}") //Create route for modifying Person with PUT request
    public int modifyPerson(@PathVariable int id, @RequestBody Person modifiedPerson) {
      
        //TODO: catch here if something goes wrong when updating Person to list or when person with ID is not found
        personsList.set(id, modifiedPerson);
        
        // Return modifiedPerson
        return 201;
    }

    
    
    //fix http 405 error with DELETE request
    // Maybe tomcat prevents it somehow?
    // For some reason now it works after restart, leave it for now
    
    //Method for removing Person
    @DeleteMapping("/api/persons/{id}")
    public int deletePerson(@PathVariable int id) {
        //Find Person with DELETE request ID from personsList
        Person toRemove = personsList.get(id);
        //delete Person from personsList
        personsList.remove(toRemove);
        //TODO: try catch if something does wrong in remove
        //TODO: maybe a logger for this?
        return 200;
    }


    
   
}
