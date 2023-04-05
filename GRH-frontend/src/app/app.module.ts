import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home/home.component';
import { FooterComponent } from './core/footer/footer.component';
import { LoginComponent } from './login/login.component';
import { HttpClientModule } from '@angular/common/http';
import { OAuthModule } from 'angular-oauth2-oidc';
import { OffresComponent } from './offres/offres.component';
import { NavbarComponent } from './core/navbar/navbar.component';
import { HomeLayoutComponent } from './core/home-layout/home-layout.component';
import { ApplicationFormComponent } from './application-form/application-form.component';
import { ModalModule  } from 'ngx-bootstrap/modal';


@NgModule({
  schemas: [ CUSTOM_ELEMENTS_SCHEMA ],
  declarations: [
    AppComponent,
    HomeComponent,
    FooterComponent,
    LoginComponent,
    OffresComponent,
    NavbarComponent,
    HomeLayoutComponent,
    ApplicationFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    OAuthModule.forRoot(),
    ModalModule.forRoot(),
  ],
  providers: [],
  bootstrap: [AppComponent],
  entryComponents: [ ApplicationFormComponent]
})
export class AppModule { }
