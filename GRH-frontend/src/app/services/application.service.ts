import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Application } from './Application';

@Injectable({
  providedIn: 'root'
})
export class ApplicationService {

  public apiServerUrl = 'http://localhost:8081';

  constructor(private http: HttpClient) { }

  public addOffre(application: Application): Observable<Application>{
    return this.http.post<any>(`${this.apiServerUrl}/api/v1/application`, application);
}

}
