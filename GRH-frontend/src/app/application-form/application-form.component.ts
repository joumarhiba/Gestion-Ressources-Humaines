import { OffreService } from './../services/offre.service';
import { Component, Input, OnInit } from '@angular/core';
import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal';
import { Offre } from '../services/Offre';
import { HttpErrorResponse } from '@angular/common/http';
import { SharedService } from '../services/shared.service';

@Component({
  selector: 'app-application-form',
  templateUrl: './application-form.component.html',
  styleUrls: ['./application-form.component.css']
})
export class ApplicationFormComponent implements OnInit {

  // @Input()
  // offreToUpdate!: Offre;
  public offreToUpdate: Offre = {
    id: 0,
    title: '',
    description: '',
    status: 0,
    contrat: '',
    datePublication: '',
    recruteur_id: undefined
  }

  message : any

  constructor(public modalRef: BsModalRef,private offreService: OffreService, private shared: SharedService) {}
  ngOnInit(): void {
    this.message = this.shared.getMessage();
    console.log(this.message);
    
  }

  
  

  public updateOffre() {
    console.log("getoffreToUpdate ===========> "+this.offreToUpdate);
    
    document.getElementById('close-modal')?.click();
    this.offreService.updateOffre(this.offreToUpdate).subscribe(
  (response: Offre) => {
  console.log("the response "+response);
  window.location.reload()
  },
    (error: HttpErrorResponse) => {
      console.log(error);
    alert(error.message);
  }
)
  }


}
