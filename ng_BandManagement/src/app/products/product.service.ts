import { Injectable } from '@angular/core';
import { IProduct } from './product';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import {catchError, tap} from 'rxjs/operators';
import { UrlService } from '../services/url.service';

@Injectable({
    providedIn: 'root'
})
export class ProductService{
    private productUrl = this.urlService.getUrl();

    constructor(private http: HttpClient,
        private urlService: UrlService){}

    getProducts(): Observable<IProduct[]>{
        return this.http.get<IProduct[]>(this.productUrl + 'inventory').pipe(
            tap(data => console.log('ALL: ' + JSON.stringify(data))),
            catchError(this.handleError)
        );
    }

    addRequest(productId: number){
        const body = `itemId=${productId}`;
        console.log('adding request: '+productId +' '+ this.productUrl + 'add');
        return this.http.post(this.productUrl +'add/'+productId, body, {withCredentials: true}).subscribe(
            (response) => console.log(response));
    }

    private handleError(err: HttpErrorResponse){
        let errorMessage = '';
        if (err.error instanceof ErrorEvent){
            errorMessage = `An Error occured: ${err.error.message}`;
        }else{
            errorMessage = `Server returned code: ${err.status}, error message is: ${err.message}`;
        }
        console.error(errorMessage);
        return throwError(errorMessage);
    }

}