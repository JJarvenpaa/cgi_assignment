import { Component, input } from '@angular/core'
import { RouterOutlet } from '@angular/router'
import { FormsModule } from '@angular/forms';
import { Person } from './person'
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, FormsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})

@Injectable({providedIn: 'root'})
export class AppComponent {
  constructor(private http: HttpClient) {}

  person = new Person(
    '',
    '',
    '',
    '',
  )

  modifyPerson = new Person(
    '',
    '',
    '',
    '',
  )
  
  //personsArray = new Array()

  persons: any //TODO: try to type this 
  ngOnInit() {
    //TODO: Make this its own service and a reusable sendRequest method that only takes parameters that define the request type
    this.fetchPersonsRequest()
  }
  
 onSubmit() {
    this.addPersonRequest(this.person)
    //TODO: make fetch async, so it happens after the new Person is added, not at the same time
    this.fetchPersonsRequest()
  }

  onModify(personId: number | null) {
    //Get the modified person ID here for the request
   
    const modifyPersonWithId: number | null = personId
    //TODO: Find doesn't benefit us, we only need the modified data and the personId which we already have, so I guess button should make inputs editable and then we use that data in here

    //const personToModify = this.persons.find((person: { id: number | null; }) => person.id === modifyPersonWithId)
    //this.modifyPerson = personToModify
    //this.http.put('http://localhost:8080/api/persons/' + modifyPersonWithId, this.modifyPerson).subscribe(response => { console.log('Response from API: ', response)})
    
  }
  
  addPersonRequest(person: Person) {
  //TODO: validate Person obj before sending request
  //Send a POST request to our backend with Person obj
  this.http.post('http://localhost:8080/api/persons', person).subscribe(response => {  console.log('Response from API: ', response);});
  
  }

  fetchPersonsRequest() {
    this.http.get('http://localhost:8080/api/persons').subscribe(persons => { this.persons = persons })
  }
}

