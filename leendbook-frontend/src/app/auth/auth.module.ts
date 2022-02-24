import { AuthComponent } from './components/auth-component/auth.component';
import { AuthSignUpComponent } from './sign-up/auth-sign-up.component';
import { AuthSignInComponent } from './sign-in/auth-sign-in.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatDialogModule } from '@angular/material/dialog';
import { AuthSignInModule } from './sign-in/auth-sign-in.module';
import { AuthSignUpModule } from './sign-up/auth-sign-up.module';
import { AuthRoutingModule } from './auth.routing.module';
import { CheckEmailDialog } from './utils/dialog/check-email-dialog';
import { NgModule } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { HttpClientModule } from '@angular/common/http';
import { MatCardModule } from '@angular/material/card';
import { MatDividerModule } from '@angular/material/divider';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatProgressSpinnerModule, MatSpinner } from '@angular/material/progress-spinner';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { RxReactiveFormsModule } from '@rxweb/reactive-form-validators';
import { AuthService } from './services/auth.service';
import { CommonModule } from '@angular/common';

@NgModule({
  declarations: [
    CheckEmailDialog,
    AuthSignUpComponent,
    AuthSignInComponent,
    AuthComponent
  ],
  providers: [
    AuthService,
  ],
  imports: [
    CommonModule,
    MatInputModule,
    MatFormFieldModule,
    MatIconModule,
    MatButtonModule,
    ReactiveFormsModule,
    MatProgressSpinnerModule,
    RxReactiveFormsModule,
    MatDialogModule,
    MatCardModule,
    MatDividerModule,
    MatSnackBarModule,
    FormsModule,
    MatDialogModule,
    AuthSignUpModule,
    AuthSignInModule,
    AuthRoutingModule,
  ],
  exports: [
    AuthComponent
  ],
})
export class AuthModule {}
