import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { USERS } from '../mock-users';
import { UserService } from '../user.service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  users: User[];
  selectedUser: User;

  onSelect(user: User): void {
    this.selectedUser = user;
  }

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.getUsers();
  }

  // TODO replace this function as it will not work with
  // real database. Currently used to test mock data
  getUsers(): void {
    this.users = this.userService.getUsers();
  }

}
