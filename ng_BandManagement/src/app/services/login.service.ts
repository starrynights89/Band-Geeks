import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { HttpHeaders, HttpClient } from '@angular/common/http';
import { UrlService } from './url.service';
import { Student } from '../classes/student';
import { Instructor } from '../classes/instructor';
import { Currentuser } from '../classes/currentuser';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private appUrl = this.urlService.getUrl() + 'login';
  //private headers = new HttpHeaders({ 'Content-Type': 'application/json' });
  private headers = new HttpHeaders({
    'Content-Type': 'application/x-www-form-urlencoded'
  });

  private student: Student;
  private instructor: Instructor;

  constructor(
    private http: HttpClient,
    private urlService: UrlService
  ) { }

  login(username: string, password: string): Observable<Currentuser> {
    if (username && password) {
      // we are attempting to log in
      const body = `user=${username}&pass=${password}`;
      return this.http.post(this.appUrl, body, {
        headers: this.headers,
        withCredentials: true
      }).pipe(
        map(resp => {
          const user: Currentuser = resp as Currentuser;
          if (user) {
            console.log(user);
            this.student = user.student;
            this.instructor = user.instructor;
          }
          return user;
        })
      );
    } else {
      // checking to see if we're logged in
      return this.http.get(this.appUrl, {withCredentials: true}).pipe(
        map( resp => {
          const user: Currentuser = resp as Currentuser;
          if (user) {
            this.student = user.student;
            this.instructor = user.instructor;
          }
          console.log("Got User "+user)
          return user;
        })
      );
    }
  }
  logout(): Observable<object> {
    return this.http.delete(this.appUrl, {withCredentials: true}).pipe(
      map(success => {
        this.student = null;
        this.instructor = null;
        return success;
      })
    );
  }

  getInstructor(): Instructor {
    return this.instructor;
  }
  getStudent(): Student {
    return this.student;
  }
  isStudent(): boolean {
    return (this.student !== undefined && this.student !== null);
  }
  isInstructor(): boolean {
    return (this.student !== undefined && this.instructor !== null);
  }
}



