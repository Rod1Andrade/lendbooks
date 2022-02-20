import { AuthService } from './../services/auth.service';
import { FormBuilder, FormControl, FormGroup, FormGroupDirective, Validators } from '@angular/forms';
import { Component, OnInit, ViewChild } from '@angular/core';
import { UserFormError } from '../models/user-form-error';
import { User } from '../models/user';
import { email } from '@rxweb/reactive-form-validators';

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
    private formBuilder: FormBuilder,
    private authService: AuthService
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

    console.log(formValues);
    this.isLoading = true;

    this.authService.authenticate(user).subscribe({
      next: (v) => {
        console.log(v);
      },
      error: (e) => {
        this.isLoading = false;
      },
      complete: () => {
        this.isLoading = false;
        this.userLogin.reset();
        this.formGroupDirective.resetForm();
      },
    });
  }
}
