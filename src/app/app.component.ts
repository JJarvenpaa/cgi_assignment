import { Component } from '@angular/core'
import { RouterOutlet } from '@angular/router'
import {FormsModule} from '@angular/forms';
import {Person} from './person'
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
  
 onSubmit() {
    console.log(this.person)
    this.sendRequest(this.person)
  }
  
  sendRequest(person: Person) {
  //Send a POST request to our backend with Person obj
  this.http.post('http://localhost:8080/api/persons', person).subscribe(response => {  console.log('Response from API: ', response);});
  
  }
  
  
}

