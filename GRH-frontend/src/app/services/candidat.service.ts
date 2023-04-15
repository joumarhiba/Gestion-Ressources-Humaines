import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Candidat } from './Candidat';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CandidatService {

  public apiServerUrl = 'http://localhost:8081';

  constructor(private http: HttpClient) { }

  public addCandidat(candidat: Candidat): Observable<Candidat>{
    return this.http.post<any>(`${this.apiServerUrl}/api/v1/candidat`, candidat);
  }

}
