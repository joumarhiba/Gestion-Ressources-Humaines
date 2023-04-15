import { Component, OnInit } from '@angular/core';
import { ApplicationService } from '../services/application.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-espace-recruteur',
  templateUrl: './espace-recruteur.component.html',
  styleUrls: ['./espace-recruteur.component.css']
})
export class EspaceRecruteurComponent implements OnInit {

  received : number = 0
  trashed : number= 0
  uploaded : number = 0
  result : any
  trashedApplication : any
  searchText : any

  constructor(private applicationService: ApplicationService) {}
  ngOnInit(): void {
    this.getReceivedApplications()
    this.getTrashedApplications()
    this.getUploadedApplications()
    this.getAllReceivedApplications()
  }

  public getAllReceivedApplications() {
    this.applicationService.getAllReceivedApplications().subscribe(
      (response: any) => {
        console.log("all received apps "+response.data.application);
        this.result = response.data.application
      },
        (error: HttpErrorResponse) => {
          console.log(error);
  
        }
    );
  }

  public getReceivedApplications() {
    this.applicationService.getReceivedApplications().subscribe(
      (response: any) => {
        this.received = response.data.application
      },
        (error: HttpErrorResponse) => {
          console.log(error);
  
        }
    );
  }

  public getTrashedApplications() {
    this.applicationService.getTrashedApplications().subscribe(
      (response: any) => {
        this.trashed = response.data.application
      },
        (error: HttpErrorResponse) => {
          console.log(error);
  
        }
    );
  }

  public getUploadedApplications() {
    this.applicationService.getUploadedApplications().subscribe(
      (response: any) => {
        this.uploaded = response.data.application
      },
        (error: HttpErrorResponse) => {
          console.log(error);
  
        }
    );
  }

  trashApplication(id : number){
    this.applicationService.trashApplication(id).subscribe(
      (response: any) => {
        console.log("------------ "+response.data.application);
        this.trashedApplication = response.data.application
        window.location.reload()
      },
        (error: HttpErrorResponse) => {
          console.log(error);
  
        }
    );
  }
  

  uploadApplication(id : number){
    this.applicationService.uploadApplication(id).subscribe(
      (response: any) => {
        console.log("------------ "+response.data.application);
        this.trashedApplication = response.data.application
        window.location.reload()
      },
        (error: HttpErrorResponse) => {
          console.log(error);
  
        }
    );
  }
}
