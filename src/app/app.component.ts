import { Component } from '@angular/core'
import { RouterOutlet } from '@angular/router'
import {FormsModule} from '@angular/forms';
import {Person} from './person'

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, FormsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})


export class AppComponent {
  person = new Person(
    '',
    '',
    '',
    '',
  )
  
 onSubmit() {
    console.log(this.person)
  }
  
  
}

