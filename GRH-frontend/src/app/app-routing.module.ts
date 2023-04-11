import { AuthGuard } from './auth.guard';
import { LoginComponent } from './login/login.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from '../app/home/home/home.component';
import { OffresComponent } from './offres/offres.component';
import { ApplicationFormComponent } from './application-form/application-form.component';
import { EspaceRecruteurComponent } from './espace-recruteur/espace-recruteur.component';


const routes: Routes = [
  // { path: '', loadChildren: () => import('../app/home/home/home.component').then(m => m.HomeComponent) },
  { path: '', component: HomeComponent},
  // { path: 'offre', component:OffresComponent},
  { path: 'offre', component:OffresComponent, canActivate: [AuthGuard]},
  { path: 'espaceRecruteur', component:EspaceRecruteurComponent, canActivate: [AuthGuard]},
  { path: 'login', component: LoginComponent},
  { path: 'postuler', component:ApplicationFormComponent},
  { path: '**', redirectTo: '', pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
