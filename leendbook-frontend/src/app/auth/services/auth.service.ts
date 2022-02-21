import { AuthResponse } from './../models/auth-response';
import { User } from './../models/user';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable()
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

  /**
   * Call the authenticate user service
   *
   * @param user
   */
  authenticate(user: User): Observable<Object> {
    return this.http.post(`${this.lendbooksApiUrl}/auth/signIn`, user);
  }

  setSession(authResponse: AuthResponse): void {
    localStorage.setItem('accessToken', authResponse.accessToken);
    localStorage.setItem('refreshToken', authResponse.refreshToken);
  }

  destroySession() {
    localStorage.removeItem('accessToken');
    localStorage.removeItem('refreshToken');
  }

  isLogged(): boolean {
    return localStorage.getItem('accessToken') != null &&
          localStorage.getItem('refreshToken') != null;
  }
}
