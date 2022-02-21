import { AuthService } from './../../auth/services/auth.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit{

  constructor(private authService: AuthService) {}

  ngOnInit(): void {

  }
}
