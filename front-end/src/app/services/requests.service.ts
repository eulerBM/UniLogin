import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RequestsService {

  private apiUrlGoogle = "http://localhost:8080/google"

  constructor(private http: HttpClient) {}

  getApi(): Observable<string> {

    return this.http.get(this.apiUrlGoogle, { responseType: 'text' });
    
  }



}
