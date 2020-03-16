import { Injectable } from '@angular/core';
import { User } from '../user';
import { Observable, of} from 'rxjs';
import { MessageService } from '../message.service';
import { HttpHeaders } from '@angular/common/http';

@Injectable()
export class UserService {
  private appUrl = this.urlService.getUrl() + 'user';
  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });

  getUsers(): Observable<User[]> {
    // TODO: send the message after fetching the users
    this.messageService.add('UserService: fetched users');
    return of(USERS);
  }

  constructor(private messageService: MessageService) { }
}
