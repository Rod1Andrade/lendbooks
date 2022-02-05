import { Component, OnInit } from '@angular/core';
import { User } from '../models/user';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css'],
})
export class AuthComponent implements OnInit {
  _user: User = new User();

  constructor(private authService: AuthService) {}

  ngOnInit(): void {
    this.authService.sayHello();

    this._user.setFirstName('Rodrigo');
  }

  getUser(): User {
    return this._user;
  }

  onChangeFirstName(event: any): void {
    this.getUser().setFirstName(event.target.value);
  }

  onChangeLastName(event: any): void {
    this.getUser().setLastName(event.target.value);
  }

  onChangeEmail(event: any): void {
    this.getUser().setEmail(event.target.value);
  }

  onChangePassword(event: any): void {
    this.getUser().setPassword(event.target.value);
  }

  onClickFinish(event: any): void {
    console.log(this.getUser());
  }
}
