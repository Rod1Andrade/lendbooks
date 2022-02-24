import { MatIconModule } from '@angular/material/icon';
import { HomeRoutingModule } from './home-routing.module';
import { HomeComponent } from './component/home.component';
import { NgModule } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';

@NgModule({
  declarations: [
    HomeComponent,
  ],
  imports: [
    HomeRoutingModule,
    MatIconModule,
    MatButtonModule,
  ],
  providers: [],
  exports: [
    HomeComponent,
  ]
})
export class HomeModule {}
