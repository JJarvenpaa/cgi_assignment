import { Component } from '@angular/core'
import { RouterOutlet } from '@angular/router'

@Component({
  selector: 'app-root',
  imports: [RouterOutlet],
  template: `
  <main>
    <div class="container">
      <button>Lisää uusi henkilö</button>
      <!-- TODO: make person parameters as inputs here-->
        {{ name }}
    </div>
  </main>
  <router-outlet />
  `,
  //templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
/*
TODO: use this in component constructor
class Person {
  id: number
  name: string
  ssn: string 
  nationality: string
  language: string
  //TODO: Should I implement familyRelations?
  dateOfBirth: string
  dateOfDeath?: string

}
*/

export class AppComponent {
  counter: number = 0
  id: number
  name: string
  ssn: string 
  nationality: string
  language: string
  //TODO: Should I implement familyRelations?
  dateOfBirth: string
  dateOfDeath: string

  constructor() {
    this.id = this.counter++
    this.name = 'Nimi'
    this.ssn = 'DD.MM.YYYY(tunniste)XXXX'
    this.nationality = 'Kansalaisuus'
    this.language = 'Äidinkieli'
    this.dateOfBirth = 'Syntymäpäivä'
    this.dateOfDeath = 'Kuolinpäivä'
  }
  
}

