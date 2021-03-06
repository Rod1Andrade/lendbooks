import { CheckEmailDialog } from '../utils/dialog/check-email-dialog';
import { AuthService } from '../services/auth.service';
import { RxwebValidators } from '@rxweb/reactive-form-validators';
import { UserFormError } from '../models/user-form-error';
import { Component, OnInit, ViewChild } from '@angular/core';
import { User } from '../models/user';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  FormGroupDirective,
  Validators,
} from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar, MatSnackBarHorizontalPosition, MatSnackBarVerticalPosition } from '@angular/material/snack-bar';
@Component({
  selector: 'app-auth',
  templateUrl: './auth-sign-up.component.html',
  styleUrls: ['./auth-sign-up.component.css'],
})
export class AuthSignUpComponent implements OnInit {
  @ViewChild(FormGroupDirective) formGroupDirective!: FormGroupDirective;
  isLoading = false;
  _errors!: UserFormError;
  userForm!: FormGroup;
  hideableFields!: any;

  /**
   * Constructor.
   * @param formBuilder
   */
  constructor(
    private formBuilder: FormBuilder,
    private authService: AuthService,
    private _matDialog: MatDialog,
    private _matSnackBar: MatSnackBar
  ) {}

  /**
   * ngOnInit()
   */
  ngOnInit(): void {
    this.createUserFormGroup();
    this.createHideableFields();
  }

  /**
   * Cria objeto que representa o formulario do usuario.
   */
  createUserFormGroup(): void {
    this.userForm = this.formBuilder.group({
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
      confirmPassword: ['', RxwebValidators.compare({ fieldName: 'password' })],
    });
  }

  /**
   * Cria o objeto que representa os campos 'hide'
   */
  createHideableFields(): void {
    this.hideableFields = {
      password: true,
      confirmPassword: true,
    };
  }

  /**
   * Error object to any form field.
   *
   * @returns UserFormError
   */
  getError(): any {
    this._errors = {
      firstName: this._getFirstNameErrorMessage(),
      lastName: this._getLastNameErrorMessage(),
      email: this._getEmailErrorMessage(),
      password: this._getPasswordErrorMessage(),
      confirmPassword: 'As senhas devem coincidir',
    };

    return this._errors;
  }

  openCheckEmailDialog(): void {
    this._matDialog.open(CheckEmailDialog);
  }

  /**
   * Erros possiveis para nome.
   * @returns String
   */
  _getFirstNameErrorMessage(): String {
    if (this.userForm.get('firstName')?.hasError('required')) {
      return 'Por favor insira seu nome.';
    }

    if (this.userForm.get('firstName')?.hasError('minlength')) {
      return 'O nome deve ter no m??nimo 3 letras.';
    }

    if (this.userForm.get('firstName')?.hasError('maxlength')) {
      return 'O nome deve ser menor que 40.';
    }

    return '';
  }

  /**
   * Erros possiveis para sobrenome.
   * @returns String
   */
  _getLastNameErrorMessage(): String {
    if (this.userForm.get('lastName')?.hasError('required')) {
      return 'Por favor insira seu sobrenome.';
    }

    if (this.userForm.get('lastName')?.hasError('minlength')) {
      return 'O nome deve ter no m??nimo 4 letras.';
    }

    if (this.userForm.get('lastName')?.hasError('maxlength')) {
      return 'O nome deve ser menor que 40.';
    }

    return '';
  }

  /**
   * Erros possiveis para email.
   * @returns String
   */
  _getEmailErrorMessage(): String {
    if (this.userForm.get('email')?.hasError('required')) {
      return 'Por favor insira seu email.';
    }

    if (this.userForm.get('email')?.hasError('email')) {
      return 'Por entre com um email v??lido.';
    }

    return '';
  }

  /**
   * Erros possiveis para senha.
   * @returns String
   */
  _getPasswordErrorMessage(): String {
    if (this.userForm.get('password')?.hasError('required')) {
      return 'Por favor insira sua senha.';
    }

    if (this.userForm.get('password')?.hasError('minlength')) {
      return 'A senha deve ter no min??mo 8 carateres.';
    }

    if (this.userForm.get('password')?.hasError('maxlength')) {
      return 'A senha deve ter no m??ximo 70 carateres.';
    }

    return '';
  }

  /**
   * When finish the process to create a user.
   */
  onSubmit() {
    if (this.userForm.invalid) return;
    const formValues = this.userForm.value;
    const user: User = new User(
      formValues.firstName,
      formValues.lastName,
      formValues.email,
      formValues.password
    );

    this.isLoading = true;

    this.authService.registerUser(user).subscribe({
      next: (v) => {
      },
      error: (e) => {
        this.isLoading = false;
        if(e.status == 0)
          this.onError('N??o foi poss??vel se conectar, tente novamente mais tarde.');
        else
          this.onError(e.error.message);
      },
      complete: () => {
        this.isLoading = false;
        this.userForm.reset();
        this.formGroupDirective.resetForm();
        this.openCheckEmailDialog();
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
