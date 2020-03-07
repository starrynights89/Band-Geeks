import { Component, OnInit, Input } from '@angular/core';
import { User } from '../user';

@Component({
  selector: 'app-user-detail',
  templateUrl: './user-detail.component.html',
  styleUrls: ['./user-detail.component.css']
})
export class UserDetailComponent implements OnInit {

  // @Input decorator to make the user property
  // available for binding by the external UsersComponent
  @Input() user: User;
  constructor() { }

  ngOnInit(): void {
  }

}
