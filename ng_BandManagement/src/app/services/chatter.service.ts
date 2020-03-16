import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { UrlService } from './url.service';
import { Chatter } from '../classes/chatter';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable()
export class ChatterService {
  private appUrl = this.urlService.getUrl() + 'chat';
  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(
    private http: HttpClient,
    private urlService: UrlService
  ) { }

  getMessages(): Observable<Chatter[]> {
    return this.http.get(this.appUrl, { withCredentials: true })
      .pipe(map(
        resp => resp as Chatter[]
      ));
  }

  getMessage(id: number): Observable<Chatter> {
    return this.http.get(this.appUrl + '/' + id, { withCredentials: true })
      .pipe(map(
        resp => resp as Chatter
      ));
  }

  updateMessage(chatter: Chatter): Observable<Chatter> {
    const body = JSON.stringify(chatter);
    console.log("Message"+chatter);
    if (!chatter.id) {
      // If there is not id on the assignment, it is not from the database.
      // That means we are trying to make a new one!
      return this.http.post(this.appUrl, body,
        { headers: this.headers, withCredentials: true }).pipe(
        map( resp => resp as Chatter )
      );
    } else {
      // If there is an id, we are...
      // updating an existing resource
      const url = this.appUrl;
      return this.http.put(url, body, { headers: this.headers, withCredentials: true })
      .pipe(map(
        resp => resp as Chatter
      ));
    }
  }



}
