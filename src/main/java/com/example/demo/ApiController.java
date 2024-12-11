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
    public Integer counter = -1; //We want to start ID incrementing at 0

    
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
    Person addNewPerson(@RequestBody Person newPerson) {
        //TODO: use the actual JSON data provided via frontend
        //Add new Person object here
    
        counter++;
        newPerson.id = counter; //Add id as incrementing counter
        newPerson.name = "testi uusi";
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

    //Method for modifying Person
    @PutMapping("api/persons/{id}") //Create route for modifying Person with PUT request
    public Person modifyPerson(@PathVariable Integer id, @RequestBody String modifiedPerson) {
      
        // Find Person with PUT request ID from personsList
        Person personToModify = personsList.get(id);

        //TODO: update Person with actual data provided via frontend
        // Update Person with new data
        personToModify.name = "testi muutos";
        personToModify.ssn = "150796-111 muutos";
        personToModify.address = "testikatu 1B7 muutos";
        personToModify.nationality = "Suomalainen muutos";
        personToModify.language = "Suomi muutos";
        personToModify.dateOfBirth = "01.01.1990 muutos";
        personToModify.dateOfDeath = "";
        personsList.set(id, personToModify);
        
        // Return modifiedPerson
        return personToModify;
    }

    //TODO: Method for removing Person
    /**
     * Find Person with DELETE request ID from personsList
     * delete Person from personsList
     * Return string with deletion confirmation and id

     */

     //TODO: fix http 405 error with DELETE request
     // Maybe tomcat prevents it somehow?
    // @DeleteMapping("api/persons/{id}") //Create route for deleting Person with DELETE request
     @RequestMapping(value="/api/persons/{id}", method={RequestMethod.DELETE, RequestMethod.GET})
     public void deletePerson(@PathVariable Integer id) {
         
        //personsList.remove(id);
        //return "deleted Person with ID: " + id;
     }


    
   
}
