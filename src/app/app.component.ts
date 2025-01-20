import { Component, ViewEncapsulation } from '@angular/core'
import { RouterOutlet } from '@angular/router'
import { FormsModule } from '@angular/forms';
import { Person } from './person'
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  encapsulation: ViewEncapsulation.None,
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

  modifying = false
  persons: any //TODO: try to type this 

  ngOnInit() {
    //TODO: Make this its own service and a reusable sendRequest method that only takes parameters that define the request type and does the error handling
    this.fetchPersonsRequest()

  }
  
 onAddSubmit() {
    this.addPersonRequest(this.person)
    //TODO: make fetch async, so it happens after the new Person is added, not at the same time
    this.fetchPersonsRequest()

  }

  onModifySubmit(personId: number | null, person: Person) {
    this.modifyPersonRequest(personId, person)

  }

  startModify() { this.modifying = true }

  cancelModify() { 
    this.fetchPersonsRequest() //Get data from backend if not saved, so the form doesn't have the temp data
    this.modifying = false 
  }

  removePerson(name: string, personID: number | null) {
    if(confirm('Oletko varma että haluat poistaa tämän henkilön tiedot? ' + name)) {
      this.removePersonRequest(personID)
      this.fetchPersonsRequest()
    }

  }

  removePersonRequest(personId: number | null) {
    this.http.delete('http://localhost:8080/api/persons/' + personId).subscribe(response => {console.log('Response from API: ', response)})
  }
  
  modifyPersonRequest(personId: number | null, person: Person) {
    //TODO validate Person obj before sending request
    this.http.put('http://localhost:8080/api/persons/' + personId, person).subscribe(response => { console.log('Response from API: ', response)})
    this.modifying = false

  }
  
  addPersonRequest(person: Person) {
  //TODO: validate Person obj before sending request
  this.http.post('http://localhost:8080/api/persons', person).subscribe(response => {  console.log('Response from API: ', response);});
  
  }

  fetchPersonsRequest() {
    this.http.get('http://localhost:8080/api/persons').subscribe(persons => { this.persons = persons })
  }

}

