import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { UrlService } from './url.service';
import { AssignmentType } from '../classes/assignment-type';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable()
export class AssignmentTypeService {

  private appUrl = this.urlService.getUrl() + 'assignmentTypes';
  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(
    private http: HttpClient,
    private urlService: UrlService
  ) { }



  getAllAssignments(): Observable<AssignmentType[]> {
    return this.http.get(this.appUrl, { withCredentials: true })
      .pipe(map(
        resp => resp as AssignmentType[]
      ));
  }
}
