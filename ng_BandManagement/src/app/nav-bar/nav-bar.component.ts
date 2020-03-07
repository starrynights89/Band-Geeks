import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {
  title = 'BMS';
  constructor(public route: Router, private loginService: LoginService) { }

  ngOnInit(): void {
  }
  isEmployee(): boolean {
    return this.loginService.isStudent();
  }
  isCustomer(): boolean {
    return this.loginService.isInstructor();
  }

}
