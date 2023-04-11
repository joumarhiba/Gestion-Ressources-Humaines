import { Injectable } from '@angular/core';
import { Offre } from './Offre';

@Injectable({
  providedIn: 'root'
})
export class SharedService {

  constructor() { }   
  message: any

  setMessage(data: Object){
    this.message = data
  }
  getMessage(){
    return this.message;
  }
}
