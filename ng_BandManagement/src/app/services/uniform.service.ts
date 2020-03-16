import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { HttpHeaders, HttpClient } from '@angular/common/http';
import { UrlService } from './url.service';
import { Uniform } from '../classes/uniform';

@Injectable({
  providedIn: 'root'
})
export class UniformService {

  private appUrl = this.urlService.getUrl() + 'uniform/';
  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });
 
  constructor(
    private http: HttpClient,
    private urlService: UrlService
  ) { }
  getAllUniforms(): Observable<Uniform[]> {
    return this.http.get(this.appUrl, { withCredentials: true })
      .pipe(map(
        resp => resp as Uniform[]
      ));
  }
  getUniform(id: number): Observable<Uniform> {
    return this.http.get(this.appUrl + 'uniform/' + id, { withCredentials: true })
      .pipe(map(
        resp => resp as Uniform
      ));
  }
  
  updateUniform(uniform: Uniform): Observable<Uniform> {
    const body = JSON.stringify(uniform);
    if (!uniform.id) {
      // If there is not id on the request, it is not from the database.
      // That means we are trying to make a new one!
      return this.http.post(this.appUrl, body,
        { headers: this.headers, withCredentials: true }).pipe(
        map( resp => resp as Uniform )
      );
    } else {
      // If there is an id, we are...
      // updating an existing resource
      const url = this.appUrl + 'uniform/' + uniform.id;
      return this.http.put(url, body, { headers: this.headers, withCredentials: true })
      .pipe(map(
        resp => resp as Uniform
      ));
    }
  }

}
