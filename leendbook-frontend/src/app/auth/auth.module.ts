import { MatDialogModule } from '@angular/material/dialog';
import { AuthSignInModule } from './sign-in/auth-sign-in.module';
import { AuthSignUpModule } from './sign-up/auth-sign-up.module';
import { AuthService } from './services/auth.service';
import { AuthRoutingModule } from './auth.routing.module';
import { CheckEmailDialog } from './utils/dialog/check-email-dialog';
import { NgModule } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';

@NgModule({
  declarations: [
    CheckEmailDialog,
  ],
  providers: [
    AuthService
  ],
  imports: [
    MatDialogModule,
    MatButtonModule,
    AuthSignUpModule,
    AuthSignInModule,
    AuthRoutingModule,
  ],
  exports: [
  ],
})
export class AuthModule {}
