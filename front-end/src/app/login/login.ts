import { environment } from './../../environments/environment.development';
import { Component } from '@angular/core';
import { RequestsService } from '../services/requests.service';
import { Router} from '@angular/router';

@Component({
  selector: 'app-login',
  imports: [],
  templateUrl: './login.html',
  styleUrl: './login.css'
})
export class Login {

  constructor(private requestsService: RequestsService, private router: Router) {}
  private apiBase = environment.apiUrl

  public message: string = "";

  buttonRegister() {
    this.router.navigate(['/register']);
  }

  buttonGoogle() {
    window.location.href = this.apiBase + "google";
  }

  buttonGithub() {
    window.location.href = this.apiBase + "github";
  }

  buttonLinkedin() {
    window.location.href = this.apiBase + "linkedin";
  }

  buttonFacebook() {
    window.location.href = this.apiBase + "facebook";
  }

}
