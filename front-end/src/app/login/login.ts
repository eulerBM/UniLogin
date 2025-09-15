import { Component } from '@angular/core';
import { RequestsService } from '../services/requests.service';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-login',
  imports: [],
  templateUrl: './login.html',
  styleUrl: './login.css'
})
export class Login {

  constructor(private requestsService: RequestsService) {}

  public message: string = "";

  buttonGoogle() {
    window.location.href = "http://localhost:8080/oauth2/authorization/google";
  }

}
