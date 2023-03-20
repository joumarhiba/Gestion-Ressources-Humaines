import { Component, OnInit } from '@angular/core';

declare function greetings(): any;

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'GRH-frontend';

  ngOnInit(): void {
    // greetings();
}
}
