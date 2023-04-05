import { OffreService } from './../services/offre.service';
import { Component, Input } from '@angular/core';
import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal';
import { Offre } from '../services/Offre';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-application-form',
  templateUrl: './application-form.component.html',
  styleUrls: ['./application-form.component.css']
})
export class ApplicationFormComponent {

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


  constructor(public modalRef: BsModalRef,private offreService: OffreService) {}

  public edit(offre: Offre) : void{
    this.offreToUpdate = offre;
  }

  public updateOffre() {
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
