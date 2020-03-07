import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'; // <-- NgModel lives here

import { AppComponent } from './app.component';
<<<<<<< HEAD
import { LoginComponent } from './login/login.component';
=======
import { UsersComponent } from './users/users.component';
import { UserDetailComponent } from './user-detail/user-detail.component';
>>>>>>> a4f88f9719eb01f1cf79f8d22c7fca63f1d51ad2

@NgModule({
  declarations: [
    AppComponent,
<<<<<<< HEAD
    LoginComponent
=======
    UsersComponent,
    UserDetailComponent
>>>>>>> a4f88f9719eb01f1cf79f8d22c7fca63f1d51ad2
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
