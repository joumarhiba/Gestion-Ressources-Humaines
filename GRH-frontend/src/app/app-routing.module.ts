import { AuthGuard } from './auth.guard';
import { LoginComponent } from './login/login.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes, CanActivate } from '@angular/router';
import { HomeComponent } from '../app/home/home/home.component';
import { OffresComponent } from './offres/offres.component';


const routes: Routes = [
  // { path: '', loadChildren: () => import('../app/home/home/home.component').then(m => m.HomeComponent) },
  { path: '', component: HomeComponent},
  { path: 'offres', component:OffresComponent, canActivate: [AuthGuard]},
  { path: 'login', component: LoginComponent},
  { path: '**', redirectTo: '', pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
