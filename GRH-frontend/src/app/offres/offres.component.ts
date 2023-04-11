import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit, TemplateRef } from '@angular/core';
import { NgForm, NgModel } from '@angular/forms';
import { OffreService } from '../services/offre.service';
import { Offre } from '../services/Offre';
import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal';
import { ApplicationFormComponent } from '../application-form/application-form.component';
import { SharedService } from '../services/shared.service';



@Component({
  selector: 'app-offres',
  templateUrl: './offres.component.html',
  styleUrls: ['./offres.component.css']
})
export class OffresComponent implements OnInit {

  
  public offres: Offre[]= [];
offreToUpdate:Offre = {
  id: 0,
  title: '',
  description: '',
  contrat: '',
  datePublication: '',
  recruteur_id: undefined,
  status: 0
}
message:any = {
 email : "joumarhiba@gmail.com"
}

  modalRef?: BsModalRef;
  constructor(private offreService: OffreService, private modalService: BsModalService
    , private shared: SharedService
    ) {}
  ngOnInit(): void {
    this.getOffres();
  }
    

  public addOffre(addOffreForm: NgForm) {
      this.offreService.addOffre(addOffreForm.value).subscribe(
        (response: Offre) => {
          console.log(response);
          addOffreForm.reset
        },
        (error: HttpErrorResponse) => {
          console.log(error);
          console.log(addOffreForm);
          alert(error.message);
          }
      )
  }

  public getOffres() {
    this.offreService.getOffres().subscribe(
      (response: any) => {
        console.log(response.data.offers[0]);
        this.offres = response.data.offers;
      },
        (error: HttpErrorResponse) => {
          console.log(this.offres);
          console.log(error);
  
        }
    );
  }


  open(offre: Offre): void {
    
    this.offreToUpdate = offre;
    this.message = offre;
    this.shared.setMessage(this.message)
    this.message['email'] = 'joumarhiba@gmail.com'
    console.log('setMsg : 0 '+this.message.email+' & msg == '+this.message.contrat);
    
    // this.shared.setMessage(offre)
    // console.log('from setOffreToUpdate method : '+this.shared.setOffreToUpdate(offre));
    console.log('offreToUpdate : '+this.offreToUpdate.id);
    console.log('offre : '+offre.id);  
    this.modalRef = this.modalService.show(ApplicationFormComponent);

  }
  
}
