import { Routes } from '@angular/router';
import { Login } from './login/login';
import { Google } from './google/google';
import { Github } from './github/github';

export const routes: Routes = [

  { path:'login', component: Login},
  { path:'google', component: Google},
  { path:'github', component: Github},

];
