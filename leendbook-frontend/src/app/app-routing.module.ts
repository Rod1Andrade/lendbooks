import { AppComponent } from './app.component';
import { AuthGuard } from './guards/auth.guard';
import { ConfirmAccountSuccess } from './auth/utils/confirm-account-success/confirm-account-success';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: 'auth',
    loadChildren: () => import('./auth/auth.module').then((m) => m.AuthModule),
  },
  {
    path: 'confirmAccountSuccess',
    component: ConfirmAccountSuccess,
  },
  // Todo: added a component here....
  // { path: '', component: AppComponent, canActivate: [AuthGuard] },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
