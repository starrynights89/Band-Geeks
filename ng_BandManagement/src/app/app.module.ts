import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'; // <-- NgModel lives here

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { LoginComponent } from './login/login.component';
import { HttpClientModule } from '@angular/common/http';
import { LoginService } from './services/login.service';
import { UrlService } from './services/url.service';
import { AppRoutingModule } from './app-routing/app-routing.module';
import { MDBBootstrapModule } from 'angular-bootstrap-md';
import { SidebarComponent } from './sidebar/sidebar.component';
import { UserDetailComponent } from './user-detail/user-detail.component';
import { ChatComponent } from './chat/chat.component';
import { ChatHomeComponent } from './chat-home/chat-home.component';
import { AssignmentsComponent } from './assignments/assignments.component';
import { AssignmentTypeService } from './services/assignment-type.service';
import { AssignmentService } from './services/assignment.service';
import { ChatterService } from './services/chatter.service';
import { ChatUsersService } from './services/chat-users.service';
import { ChatterComponent } from './chatter/chatter.component';
import { ProductListComponent } from './products/product-list.component';
import { RequestsInstructorComponent } from './requests-instructor/requests-instructor.component';
import { RequestInstructorService } from './services/request-instructor.service';
import { InstrumentService } from './services/instrument.service';
import { UniformService } from './services/uniform.service';
import { RequestsTeacherComponent } from './requests-teacher/requests-teacher.component';
import { LoginpageComponent } from './loginpage/loginpage.component';


@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    HeaderComponent,
    LoginComponent,
    SidebarComponent,
    UserDetailComponent,
    ChatComponent,
    ChatHomeComponent,
    AssignmentsComponent,
    ChatterComponent,
    ProductListComponent,
    RequestsInstructorComponent,
    RequestsInstructorComponent,
    RequestsTeacherComponent,
    LoginpageComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
    MDBBootstrapModule.forRoot()
  ],
  providers: [
    UrlService,
    LoginService,
    AssignmentTypeService,
    AssignmentService,
    ChatterService,
    ChatUsersService,
    RequestInstructorService,
    InstrumentService,
  

    UniformService,
    AssignmentTypeService,

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
