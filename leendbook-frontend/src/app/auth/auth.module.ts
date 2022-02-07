import { CheckEmailDialog } from './utils/dialog/check-email-dialog';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { AuthSignUpComponent } from './sign-up/auth-sign-up.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { RxReactiveFormsModule } from '@rxweb/reactive-form-validators';
import { HttpClientModule } from '@angular/common/http';
import { MatDialogModule } from '@angular/material/dialog';
import { MatCardModule } from '@angular/material/card';
import { MatDividerModule } from '@angular/material/divider';
import { MatSnackBarModule } from '@angular/material/snack-bar';
@NgModule({
  declarations: [AuthSignUpComponent, CheckEmailDialog],
  providers: [],
  imports: [
    CommonModule,
    MatInputModule,
    MatFormFieldModule,
    MatIconModule,
    MatButtonModule,
    FormsModule,
    ReactiveFormsModule,
    MatProgressSpinnerModule,
    RxReactiveFormsModule,
    HttpClientModule,
    MatDialogModule,
    MatCardModule,
    MatDividerModule,
    MatSnackBarModule
  ],
  exports: [],
})
export class AuthModule {}
