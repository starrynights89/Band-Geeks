import { Component, OnInit, Input } from '@angular/core';
import { User } from '../user';
import { LoginService } from '../services/login.service';
import { Currentuser } from '../classes/currentuser';
import { LoginComponent } from '../login/login.component';

@Component({
  selector: 'app-user-detail',
  templateUrl: './user-detail.component.html',
  styleUrls: ['./user-detail.component.css']
})
export class UserDetailComponent implements OnInit {
  public loggedUser: Currentuser;

  // @Input decorator to make the user propertys
  // available for binding by the external UsersComponent
  constructor(private loginService: LoginService) {}

  ngOnInit(): void {
    this.loginService.login(null, null).subscribe(resp => {
      this.loggedUser = resp;
    });
  }

  isStudent(): boolean {
    return this.loginService.isStudent();
  }
  isInstructor(): boolean {
    return this.loginService.isInstructor();
  }
}
