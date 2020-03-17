import { Component, OnInit } from '@angular/core';
import { Message } from '../chat/chat.component';
import { Currentuser } from '../classes/currentuser';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-chat-home',
  templateUrl: './chat-home.component.html',
  styleUrls: ['./chat-home.component.css']
})
export class ChatHomeComponent implements OnInit {

  public loggedUser: Currentuser;

  // @Input decorator to make the user propertys
  // available for binding by the external UsersComponent
  constructor(private loginService: LoginService) {}
  messages: Array<Message> = [];
  ngOnInit(): void {

  }

}
