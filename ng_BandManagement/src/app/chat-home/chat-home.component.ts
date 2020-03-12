import { Component, OnInit } from '@angular/core';
import { Message } from '../chat/chat.component';

@Component({
  selector: 'app-chat-home',
  templateUrl: './chat-home.component.html',
  styleUrls: ['./chat-home.component.css']
})
export class ChatHomeComponent implements OnInit {

  constructor() { }
  messages: Array<Message> = [];
  ngOnInit(): void {
  }

}
