import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Offre } from './Offre';

@Injectable({
  providedIn: 'root'
})
export class OffreService {

  public apiServerUrl = 'http://localhost:8081';

  constructor(private http: HttpClient) { }

  public addOffre(offre: Offre): Observable<Offre>{
    return this.http.post<any>(`${this.apiServerUrl}/api/v1/offre`, offre);
}

public updateOffre(offre: Offre): Observable<Offre> {
  return this.http.put<any>(`${this.apiServerUrl}/api/v1/offre`, offre);
}

public getOffres(): Observable<any> {
  return this.http.get<any>(`${this.apiServerUrl}/api/v1/offre`);
}



}
