import { AuthGuard } from './guards/auth.guard';
import { AuthInteceptor } from './auth/services/auth.interceptor';
import { AuthService } from './auth/services/auth.service';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AuthRoutingModule } from './auth/auth.routing.module';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    CommonModule,
    BrowserModule,
    AuthRoutingModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule
  ],
  providers: [
    AuthService,
    AuthInteceptor,
    AuthGuard
  ],
  exports: [
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
