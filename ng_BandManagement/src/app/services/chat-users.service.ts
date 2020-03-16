import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { UrlService } from './url.service';
import { User } from '../classes/user';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable()
export class ChatUsersService {
  private appUrl = this.urlService.getUrl() + 'user';
  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });

  

  constructor(
    private http: HttpClient,
    private urlService: UrlService
  ) { }

  getUsers(): Observable<User[]> {
    return this.http.get(this.appUrl, { withCredentials: true })
      .pipe(map(
        resp => resp as User[]
      ));
  }
  updateAssignment(user: User): Observable<User> {
    const body = JSON.stringify(user);
    console.log("User"+user);
    if (!user.id) {
      // If there is not id on the assignment, it is not from the database.
      // That means we are trying to make a new one!
      return this.http.post(this.appUrl, body,
        { headers: this.headers, withCredentials: true }).pipe(
        map( resp => resp as User)
      );
    } 
  }



}
