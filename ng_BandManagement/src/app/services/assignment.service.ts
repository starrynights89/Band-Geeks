import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { HttpHeaders, HttpClient } from '@angular/common/http';
import { UrlService } from './url.service';
import { Assignment } from '../classes/assignment';


@Injectable()
export class AssignmentService {
  private appUrl = this.urlService.getUrl() + 'assignments/instructor';
  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(
    private http: HttpClient,
    private urlService: UrlService
  ) { }

  getAllAssignments(): Observable<Assignment[]> {
    return this.http.get(this.appUrl, { withCredentials: true })
      .pipe(map(
        resp => resp as Assignment[]
      ));
  }
  getAssignment(id: number): Observable<Assignment> {
    return this.http.get(this.appUrl + 'assignments/instructor/' + id, { withCredentials: true })
      .pipe(map(
        resp => resp as Assignment
      ));
  }
  
  updateAssignment(assignment: Assignment): Observable<Assignment> {
    const body = JSON.stringify(assignment);
    console.log("Assignment "+assignment);
    if (!assignment.id) {
      // If there is not id on the assignment, it is not from the database.
      // That means we are trying to make a new one!
      return this.http.post(this.appUrl, body,
        { headers: this.headers, withCredentials: true }).pipe(
        map( resp => resp as Assignment )
      );
    } else {
      // If there is an id, we are...
      // updating an existing resource
      const url = this.appUrl + 'assignments/instructor/' + assignment.id;
      return this.http.put(url, body, { headers: this.headers, withCredentials: true })
      .pipe(map(
        resp => resp as Assignment
      ));
    }
  }
}
