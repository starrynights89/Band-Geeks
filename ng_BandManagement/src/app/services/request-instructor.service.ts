import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { HttpHeaders, HttpClient } from '@angular/common/http';
import { UrlService } from './url.service';
import { Request } from '../classes/request';
@Injectable({
  providedIn: 'root'
})
export class RequestInstructorService {

  private appUrl = this.urlService.getUrl() + 'request/';
  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });
  
  constructor(
    private http: HttpClient,
    private urlService: UrlService
  ) { }

  getAllRequests(): Observable<Request[]> {
    return this.http.get(this.appUrl, { withCredentials: true })
      .pipe(map(
        resp => resp as Request[]
      ));
  }
  getRequest(id: number): Observable<Request> {
    return this.http.get(this.appUrl + 'request/' + id, { withCredentials: true })
      .pipe(map(
        resp => resp as Request
      ));
  }
  
  updateRequest(request: Request): Observable<Request> {
    const body = JSON.stringify(request);
    if (!request.requestId) {
      // If there is not id on the request, it is not from the database.
      // That means we are trying to make a new one!
      return this.http.post(this.appUrl, body,
        { headers: this.headers, withCredentials: true }).pipe(
        map( resp => resp as Request )
      );
    } else {
      // If there is an id, we are...
      // updating an existing resource
      const url = this.appUrl + request.requestId;
      return this.http.put(url, body, { headers: this.headers, withCredentials: true })
      .pipe(map(
        resp => resp as Request
      ));
    }
  
  }




}
