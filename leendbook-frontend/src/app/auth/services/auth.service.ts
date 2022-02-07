import { User } from './../models/user';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  lendbooksApiUrl: String = environment.lendbookApiUrl;

  constructor(private http: HttpClient) {}

  /**
   * Call the register user service.
   *
   * @param user User
   * @returns Observable<Object>
   */
  registerUser(user: User): Observable<Object> {
    return this.http.post(`${this.lendbooksApiUrl}/auth/signUp`, user);
  }
}
