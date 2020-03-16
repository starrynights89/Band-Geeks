import { Component, OnInit } from '@angular/core';
import { Chatter } from '../classes/chatter';
import { Router } from '@angular/router';
import { ChatUsersService } from '../services/chat-users.service';
import { User } from '../classes/user';
import { ChatterService } from '../services/chatter.service';

@Component({
  selector: 'app-chatter',
  templateUrl: './chatter.component.html',
  styleUrls: ['./chatter.component.css']
})
export class ChatterComponent implements OnInit {
  public messages: Chatter[];
  public message: Chatter;
  public chatUsers: User[];
  public reply: string;

  constructor(
    public route: Router,
    private chatUserService: ChatUsersService,
    private chatterService: ChatterService
  ) { }

  ngOnInit(): void {
    //Create message
    this.message = new Chatter();

    this.chatUserService.getUsers().subscribe(
      resp => {
        this.chatUsers = resp;
        console.log("Chat Users "+resp);
      }
    );
  

    this.chatterService.getMessages().subscribe(
      resp => {
        this.messages = resp;
        console.log("Messages "+resp);
      }
    );
  }

  set(id: number): void{
    console.log("Reciever Id "+id);
    this.message.reciever = id;
    this.message.read = "N";
  }
  setM(id: number): void{
    console.log("Message Id "+id);
    this.message.id = id;
    this.message.read = "Y";
    this.chatterService.updateMessage(this.message).subscribe(
      message => {
        this.message = message;
        console.log("Message "+ this.message);
      }
    );
  }
  send(): void {
    console.log(this.message);
    this.chatterService.updateMessage(this.message).subscribe(
      message => {
        this.message = message;
        console.log("Message "+ this.message);
        this.route.navigate(['/chat']);
      }
    );
  }

  Reply(id: number): void {
       //Create message
       
      this.message = new Chatter();
      this.message.reciever = id;
      this.message.read = "N";
      this.message.message = this.reply;

      this.chatterService.updateMessage(this.message).subscribe(
      message => {
        this.message = message;
        console.log("Message "+ this.message);
        this.route.navigate(['/chat']);
      }
    );
  }




}
