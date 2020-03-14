import { Component, OnInit, Input, OnChanges, SimpleChange, SimpleChanges } from '@angular/core';
import { User } from '../user';
import { LoginService } from '../services/login.service';
import { Currentuser } from '../classes/currentuser';
import { LoginComponent } from '../login/login.component';

@Component({
  selector: 'app-user-detail',
  templateUrl: './user-detail.component.html',
  styleUrls: ['./user-detail.component.css']
})
export class UserDetailComponent implements OnChanges {
  public loggedUser: Currentuser;

  // @Input decorator to make the user propertys
  // available for binding by the external UsersComponent
  constructor(private loginService: LoginService) {}

  ngOnChanges(changes: SimpleChanges): void {
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
