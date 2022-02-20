import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css']
})
export class AuthComponent implements OnInit{

  @Input()
  title: String = '';

  @Input()
  headerImagePath = '';

  ngOnInit(): void {
    console.log('Hello world');
  }
}
