import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LayoutComponent } from './layout/layout.component';
import { LoginComponent } from './login/login.component';


const routes: Routes = [
  { path : '', component : LoginComponent },
  { path: '', component : LayoutComponent, children: [
    // { path: '', redirectTo: '/login', pathMatch: 'full' },
    { path: 'home', component : HomeComponent },
    // { path: '', redirectTo: '/home', pathMatch: 'full' }  
  ]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
