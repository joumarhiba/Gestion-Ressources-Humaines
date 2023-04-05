import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit, TemplateRef } from '@angular/core';
import { NgForm, NgModel } from '@angular/forms';
import { OffreService } from '../services/offre.service';
import { Offre } from '../services/Offre';
import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal';
import { ApplicationFormComponent } from '../application-form/application-form.component';



@Component({
  selector: 'app-offres',
  templateUrl: './offres.component.html',
  styleUrls: ['./offres.component.css']
})
export class OffresComponent implements OnInit {

  public offreToUpdate: Offre = {
    id: 0,
    title: '',
    description: '',
    status: 0,
    contrat: '',
    datePublication: '',
    recruteur_id: undefined
  }
  public offres: Offre[]= [];


  modalRef?: BsModalRef;
  constructor(private offreService: OffreService, private modalService: BsModalService
    // , private modalService: BsModalService
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
    this.modalRef = this.modalService.show(ApplicationFormComponent);
    this.offreToUpdate = offre;
    console.log('from open method :');
    console.log('offreToUpdate : '+this.offreToUpdate.id);
    console.log('offre : '+offre.id);  

  }
  // open(content) {
	// 	this.modalService.open(content, { ariaLabelledBy: 'modal-basic-title' }).result.then(
	// 		(result) => {
	// 			this.closeResult = `Closed with: ${result}`;
	// 		},
	// 		(reason) => {
	// 			this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
	// 		},
	// 	);
	// }

	// private getDismissReason(reason: any): string {
	// 	if (reason === ModalDismissReasons.ESC) {
	// 		return 'by pressing ESC';
	// 	} else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
	// 		return 'by clicking on a backdrop';
	// 	} else {
	// 		return `with: ${reason}`;
	// 	}
	// }
}
