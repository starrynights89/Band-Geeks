import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { HttpHeaders, HttpClient } from '@angular/common/http';
import { UrlService } from './url.service';
import { Instrument } from '../classes/instrument';


@Injectable({
  providedIn: 'root'
})
export class InstrumentService {

  private appUrl = this.urlService.getUrl() + 'instrument/';
  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(
    private http: HttpClient,
    private urlService: UrlService
  ) { }
  getAllInstruments(): Observable<Instrument[]> {
    return this.http.get(this.appUrl, { withCredentials: true })
      .pipe(map(
        resp => resp as Instrument[]
      ));
  }
  getInstrument(id: number): Observable<Instrument> {
    return this.http.get(this.appUrl + 'instrument/' + id, { withCredentials: true })
      .pipe(map(
        resp => resp as Instrument
      ));
  }
  createInstrument(instrument: Instrument){
    const body = JSON.stringify(instrument);
    return this.http.post(this.appUrl, body,
      { headers: this.headers, withCredentials: true }).pipe(
      map( resp => resp as Instrument )
    );
  
  }
  
  updateInstrument(instrument: Instrument): Observable<Instrument> {
    const body = JSON.stringify(instrument);
    if (!instrument.id) {
      // If there is not id on the request, it is not from the database.
      // That means we are trying to make a new one!
      return this.http.post(this.appUrl, body,
        { headers: this.headers, withCredentials: true }).pipe(
        map( resp => resp as Instrument )
      );
    } else {
      // If there is an id, we are...
      // updating an existing resource
      const url = this.appUrl + 'instrument/' + instrument.id;
      return this.http.put(url, body, { headers: this.headers, withCredentials: true })
      .pipe(map(
        resp => resp as Instrument
      ));
    }
  }
}


