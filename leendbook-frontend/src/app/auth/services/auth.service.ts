import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor() { }

  sayHello() : void
  {
    console.log('Hello world');
  }
}
