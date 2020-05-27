import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {map} from 'rxjs/operators';
import { HttpClient} from '@angular/common/http';

import 'rxjs/Rx';


@Injectable({
  providedIn: 'root'
})
export class RestService {

  path : string = 'http://localhost:8081';

  constructor(public http : HttpClient) {}

  public get(url: string, transformation : any) : Observable<any>{
    return this.http.get(this.path + url).pipe(map(transformation));
  }

  public getPrimivite(url: string) : Observable<any>{
    return this.http.get(this.path + url);
  }

  public getList(url: string, transformation : any) : Observable<any[]>{
    return this.http.get<any[]>(this.path + url).pipe(map(res => res.map(transformation)));
  }

  public post(url: string, data: Object, transformation : any) : Observable<any>{
    return this.http.post(this.path + url, data).pipe(map(transformation));
  };


  public postList(url: string, data: any, transformation : any) : Observable<any>{
    return this.http.post<any[]>(this.path + url, data).pipe(map(transformation));
  }


}
