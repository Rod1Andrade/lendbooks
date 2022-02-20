import { AuthResponse } from './../models/auth-response';
import { AuthService } from './../services/auth.service';
import { FormBuilder, FormControl, FormGroup, FormGroupDirective, Validators } from '@angular/forms';
import { Component, OnInit, ViewChild } from '@angular/core';
import { UserFormError } from '../models/user-form-error';
import { User } from '../models/user';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';

@Component({
  selector: 'auth-sign-in-component',
  templateUrl: './auth-sign-in.component.html',
  styleUrls: ['./auth-sign-in.component.css'],
})
export class AuthSignInComponent implements OnInit {

  @ViewChild(FormGroupDirective) formGroupDirective!: FormGroupDirective;
  isLoading = false;
  _errors!: UserFormError;
  userForm!: FormGroup;
  hideableFields: any = {
    password: true
  };

  userLogin: FormGroup = this.formBuilder.group({
    email: new FormControl('', [Validators.required, Validators.email]),
    password: new FormControl('', [
      Validators.required,
      Validators.minLength(8),
      Validators.maxLength(70),
    ]),
  });

  constructor(
    private router: Router,
    private formBuilder: FormBuilder,
    private authService: AuthService,
    private _matSnackBar: MatSnackBar,
  ) {}

  ngOnInit(): void {
  }

  /**
   * When finish the process to create a user.
   */
   onSubmit() {
    if (this.userLogin.invalid) return;
    const formValues = this.userLogin.value;

    const user = new User();
    user.setEmail(formValues.email);
    user.setPassword(formValues.password);

    this.isLoading = true;

    this.authService.authenticate(user).subscribe({
      next: (v: any) => {
        const authResponse : AuthResponse = new AuthResponse(v.token, v.refreshToken);
        this.authService.setSession(authResponse);
        this.router.navigateByUrl('/');
      },
      error: (e) => {
        this.isLoading = false;

        if(e.status == 0)
          this.onError('Não foi possível se conectar, tente novamente mais tarde.');
        else
          this.onError(e.error.message);

        this.authService.destroySession();
      },
      complete: () => {
        this.isLoading = false;
      },
    });
  }

  /**
   * Error message.
   * @param msg String
   */
   onError(msg: string): void {
    this._matSnackBar.open(msg, 'Fechar', {
      horizontalPosition: 'end',
      verticalPosition: 'top'
    })
  }
}
