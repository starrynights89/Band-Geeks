import { Component, OnInit } from '@angular/core';
import { Currentuser } from '../classes/currentuser';
import { LoginService } from '../services/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public loggedUser: Currentuser;
  public username: string;
  public password: string;

  constructor(
    public route: Router,
    private loginService: LoginService
    ) { }

  ngOnInit() {
    this.loginService.login(null, null).subscribe(
      resp => {
        this.loggedUser = resp;
      },
      error => {
        this.loggedUser = null;
      }
    );
  }

  login() {
    this.loginService.login(this.username, this.password).subscribe(
      resp => {
        this.loggedUser = resp;
        console.log('logged user ' + this.loggedUser);
        this.route.navigate(['/home']);

      }
    );

  }

  logout() {
    this.loginService.logout().subscribe(
      resp => {
        this.loggedUser = null;
        this.route.navigate(['/login']);

      }
    );
  }

}
