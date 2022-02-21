import { AuthSignInComponent } from './sign-in/auth-sign-in.component';
import { AuthSignUpComponent } from './sign-up/auth-sign-up.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: 'signUp', component: AuthSignUpComponent },
  { path: 'signIn', component: AuthSignInComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class AuthRoutingModule {}
