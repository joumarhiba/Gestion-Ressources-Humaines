import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from '../app/home/home/home.component';

const routes: Routes = [
  // { path: '', loadChildren: () => import('../app/home/home/home.component').then(m => m.HomeComponent) },
  { path: '', component: HomeComponent},
  { path: 'login', component: HomeComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
