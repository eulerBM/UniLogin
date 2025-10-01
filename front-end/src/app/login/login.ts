import { environment } from './../../environments/environment.development';
import { Component } from '@angular/core';
import { RequestsService } from '../services/requests.service';



@Component({
  selector: 'app-login',
  imports: [],
  templateUrl: './login.html',
  styleUrl: './login.css'
})
export class Login {

  constructor(private requestsService: RequestsService) {}
  private apiBase = environment.apiUrl

  public message: string = "";


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
