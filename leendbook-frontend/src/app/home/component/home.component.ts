import { AuthService } from './../../auth/services/auth.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit{

  constructor(
    private router: Router,
    private authService: AuthService
    ) {}

  ngOnInit(): void {
  }

  /**
   * Logout user
   */
  onLoginIsClicked(): void {
    this.authService.destroySession();
  }
}
