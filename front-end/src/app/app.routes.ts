import { Routes } from '@angular/router';
import { Login } from './login/login';
import { Google } from './google/google';
import { Github } from './github/github';
import { Facebook } from './facebook/facebook';
import { RegisterComponent } from './register/register.component'
import { Home } from './home/home';

export const routes: Routes = [

  { path:'home', component: Home},
  { path:'login', component: Login},
  { path:'register', component: RegisterComponent},
  { path:'google', component: Google},
  { path:'github', component: Github},
  { path:'facebook', component: Facebook},


];
