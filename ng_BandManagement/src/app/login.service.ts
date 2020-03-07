import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { HttpHeaders, HttpClient } from '@angular/common/http';
import { UrlService } from 'src/app/shared/url.service';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private appUrl = this.urlService.getUrl() + 'login';
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
  getUser(id: number): Observable<User> {
    return this.http.get(this.appUrl + '/' + id, { withCredentials: true })
      .pipe(map(
        resp => resp as User
      ));
  }




}
