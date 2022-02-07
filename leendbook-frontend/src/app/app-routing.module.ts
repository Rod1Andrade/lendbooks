import { AuthSignInComponent } from './auth/sign-in/auth-sign-in.component';
import { ConfirmAccountSuccess } from './auth/utils/confirm-account-success/confirm-account-success';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthSignUpComponent } from './auth/sign-up/auth-sign-up.component';

const routes: Routes = [
  { path: 'auth/signUp', component: AuthSignUpComponent },
  {
    path: 'auth/signIn',
    component: AuthSignInComponent,
  },
  {
    path: 'confirmAccountSuccess',
    component: ConfirmAccountSuccess,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
