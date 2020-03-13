import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { USERS } from '../mock-users';
import { UserService } from '../services/user.service';
import { MessageService } from '../message.service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {
  users: User[];
  selectedUser: User;

  constructor(
    private userService: UserService,
    private messageService: MessageService
  ) {}

  ngOnInit(): void {
    this.getUsers();
  }

  onSelect(user: User): void {
    this.selectedUser = user;
    this.messageService.add('UserService: Selected user id=${user.id}');
  }

  // TODO replace this function as it will not work with
  // real database. Currently used to test mock data
  getUsers(): void {
    this.userService.getUsers().subscribe(users => this.users = users);
  }
}
