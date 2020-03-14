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
    private productUrl = this.urlService.getUrl() + 'inventory';

    constructor(private http: HttpClient,
        private urlService: UrlService){}

    getProducts(): Observable<IProduct[]>{
        return this.http.get<IProduct[]>(this.productUrl).pipe(
            tap(data => console.log('ALL: ' + JSON.stringify(data))),
            catchError(this.handleError)
        );
    }

    addRequest(productId: number){
        const request = {
            productId: productId
        };
        return this.http.post(this.productUrl +'/add', request)
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