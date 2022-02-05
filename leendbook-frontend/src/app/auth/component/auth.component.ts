import { UserFormError } from './../models/user-form-error';
import { Component, OnInit } from '@angular/core';
import { User } from '../models/user';
import {
  FormBuilder,
  FormControl,
  Validators,
} from '@angular/forms';
@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css'],
})
export class AuthComponent implements OnInit {
  isLoading = false;
  _errors: UserFormError = {};

  hideableFields: any = {
    password: true,
    confirmPassword: true,
  };

  userForm = this.formBuilder.group({
    firstName: new FormControl('', [
      Validators.required,
      Validators.minLength(3),
      Validators.maxLength(40),
    ]),
    lastName: new FormControl('', [
      Validators.required,
      Validators.minLength(4),
      Validators.maxLength(40),
    ]),
    email: new FormControl('', [Validators.required, Validators.email]),
    password: new FormControl('', [
      Validators.required,
      Validators.minLength(8),
      Validators.maxLength(70),
    ]),
  });

  constructor(private formBuilder: FormBuilder) {}

  ngOnInit(): void {
    console.log(this.userForm);
  }

  /**
   * Error object to any form field.
   *
   * @returns any
   */
  getError(): any {
    this._errors = {
      firstName: this._getFirstNameErrorMessage(),
      lastName: this._getLastNameErrorMessage(),
      email: this._getEmailErrorMessage(),
      password: this._getPasswordErrorMessage(),
      confirmPassword: '',
    };

    return this._errors;
  }

  _getFirstNameErrorMessage(): String {
    if (this.userForm.get('firstName')?.hasError('required')) {
      return 'Por favor insira seu nome.';
    }

    if (this.userForm.get('firstName')?.hasError('minlength')) {
      return 'O nome deve ter no mínimo 3 letras.';
    }

    if (this.userForm.get('firstName')?.hasError('maxlength')) {
      return 'O nome deve ser menor que 40.';
    }

    return '';
  }

  _getLastNameErrorMessage(): String {
    if (this.userForm.get('lastName')?.hasError('required')) {
      return 'Por favor insira seu sobrenome.';
    }

    if (this.userForm.get('lastName')?.hasError('minlength')) {
      return 'O nome deve ter no mínimo 4 letras.';
    }

    if (this.userForm.get('lastName')?.hasError('maxlength')) {
      return 'O nome deve ser menor que 40.';
    }

    return '';
  }

  _getEmailErrorMessage(): String {
    if (this.userForm.get('email')?.hasError('required')) {
      return 'Por favor insira seu email.';
    }

    if (this.userForm.get('email')?.hasError('email')) {
      return 'Por entre com um email válido.';
    }

    return '';
  }

  _getPasswordErrorMessage(): String {
    if (this.userForm.get('password')?.hasError('required')) {
      return 'Por favor insira sua senha.';
    }

    if (this.userForm.get('password')?.hasError('minlength')) {
      return 'A senha deve ter no minímo 8 carateres.';
    }

    if (this.userForm.get('password')?.hasError('maxlength')) {
      return 'A senha deve ter no máximo 70 carateres.';
    }

    return '';
  }

  /**
   * When finish the process to create a user.
   */
   async onSubmit()  {
    const formValues = this.userForm.value;
    const user: User = new User(
      formValues.firstName,
      formValues.lastName,
      formValues.email,
      formValues.password
    );

    // todo: mandar para o servico de registro de usuario.
    // todo: desabilitar o botao de envio.
    // todo: adicionar indicador de carregamento.
    this.isLoading = true;
    await setTimeout(() => {
      this.isLoading = false;
    } , 2000);
    console.log(user);
  }
}
