import { Component, OnInit } from '@angular/core';
import { JwksValidationHandler, OAuthService } from 'angular-oauth2-oidc';
import { authCodeFlowConfig } from 'src/app/core/easyRH-config';


declare function greetings(): any;


@Component({
  selector: 'app-home-layout',
  templateUrl: './home-layout.component.html',
  styleUrls: ['./home-layout.component.css']
})
export class HomeLayoutComponent  implements OnInit {
  name: string = "";
  


  constructor(private oauthService: OAuthService){}

  ngOnInit(): void {
    greetings();
    this.configureSingleSignOn();
    const userClaims: any = this.oauthService.getIdentityClaims();
    this.name = userClaims.name ? userClaims.name : "";
}

configureSingleSignOn() {
      this.oauthService.configure(authCodeFlowConfig);
      this.oauthService.tokenValidationHandler = new JwksValidationHandler();
      this.oauthService.loadDiscoveryDocumentAndTryLogin();
}

login(){
  this.oauthService.initCodeFlow();
}

logout(){
  this.oauthService.logOut()
}

get token() {
  let claims: any = this.oauthService.getIdentityClaims();
  return claims ? claims : null;
}
}
