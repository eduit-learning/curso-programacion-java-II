import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Bienvenido al mundo de Angular';

  course: string = 'Programación con Java II';

  date: string = 'Agosto - Septiembre 2022';
}
