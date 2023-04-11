import { OffreService } from './../services/offre.service';
import { Component, Input, OnInit } from '@angular/core';
import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal';
import { Offre } from '../services/Offre';
import { HttpErrorResponse } from '@angular/common/http';
import { SharedService } from '../services/shared.service';
import { ApplicationService } from '../services/application.service';
import { Application } from '../services/Application';
import { NgForm } from '@angular/forms';

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

  constructor(public modalRef: BsModalRef, private shared: SharedService, private applicationService: ApplicationService) {}
  ngOnInit(): void {
    this.message = this.shared.getMessage();
    console.log(this.message);
    this.getUserInfo()
    
  }

  
  

  public addApplication(addApplicationForm: NgForm) {
    document.getElementById('close-modal')?.click();
    this.applicationService.addApplication(addApplicationForm.value).subscribe(
      (response: Application) => {
        console.log("the response "+response);
        window.location.reload()
        console.log("in addApplication oofreToUpdate ===========> "+this.offreToUpdate);
  },
      (error: HttpErrorResponse) => {
        console.log(error);
  }
)
  }


  public getUserInfo(){
    console.log("insiiiiiiiiiiiiiiiiiiiiiiiide get user infoooooooooooooooooo");
    
    this.applicationService.getUserInfo().subscribe(
      (response: any) => {
        console.log("useer info ===> "+response); 
      },
      (error: HttpErrorResponse) => {
        console.log(error);
  }
    )
  }


}
