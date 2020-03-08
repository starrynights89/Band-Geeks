import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'; // <-- NgModel lives here

import { AppComponent } from './app.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { LoginComponent } from './login/login.component';
import { HttpClientModule } from '@angular/common/http';
import { LoginService } from './services/login.service';
import { UrlService } from './services/url.service';
import { AppRoutingModule } from './app-routing-module/app-routing-module.module';

@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    LoginComponent
    
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [
    UrlService,
    LoginService

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
