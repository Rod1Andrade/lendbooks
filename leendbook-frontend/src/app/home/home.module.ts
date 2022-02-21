import { HomeRoutingModule } from './home-routing.module';
import { HomeComponent } from './component/home.component';
import { NgModule } from '@angular/core';

@NgModule({
  declarations: [
    HomeComponent,
  ],
  imports: [
    HomeRoutingModule
  ],
  providers: [],
  exports: [
    HomeComponent,
  ]
})
export class HomeModule {}
