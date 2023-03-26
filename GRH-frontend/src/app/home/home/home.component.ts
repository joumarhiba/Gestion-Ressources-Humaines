import { Component, OnInit } from '@angular/core';
import { OAuthService } from 'angular-oauth2-oidc';
import { JwksValidationHandler } from 'angular-oauth2-oidc-jwks';
import { authCodeFlowConfig } from 'src/app/core/easyRH-config';

declare function greetings(): any;


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  name: string = "";


  constructor(private oauthService: OAuthService){}

  ngOnInit(): void {
    greetings();
    // this.configureSingleSignOn();
    const userClaims: any = this.oauthService.getIdentityClaims();
    this.name = userClaims.name ? userClaims.name : "";
}

// configureSingleSignOn() {
//       this.oauthService.configure(authCodeFlowConfig);
//       this.oauthService.tokenValidationHandler = new JwksValidationHandler();
//       this.oauthService.loadDiscoveryDocumentAndTryLogin();
// }

// login(){
//   this.oauthService.initCodeFlow();
// }

// logout(){
//   this.oauthService.logOut()
// }

// get token() {
//   let claims: any = this.oauthService.getIdentityClaims();
//   return claims ? claims : null;
// }
}
