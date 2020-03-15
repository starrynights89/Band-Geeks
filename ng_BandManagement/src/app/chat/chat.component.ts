import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Currentuser } from '../classes/currentuser';
import { LoginService } from '../services/login.service';
// import { EventEmitter } from 'protractor';
declare const feather: any;

export interface Message {
  text: string;
}

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.css']
})
export class ChatComponent implements OnInit {

  public loggedUser: Currentuser;

  constructor(private http: HttpClient, private loginService: LoginService) { }

  @Output() onSendMessage: EventEmitter<Message> = new EventEmitter();
  message = {
    text: '',
  };
  sendMessage() {
    if (this.message.text !== '') {
      this.http
        .post(`http://localhost:4200/contact`, this.message)
        .subscribe((res: Message) => {
          this.onSendMessage.emit(res);
          this.message = {
            text: '',
          };
        });
    }
  }

  ngOnInit(): void {
    feather.replace();
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
