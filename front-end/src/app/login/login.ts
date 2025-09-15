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
    this.requestsService.getApi().subscribe({
      next: (res) => {
        this.message = res;       // ✅ resposta da API
        console.log("API:", res);
      },
      error: (err) => {
        console.error("Erro na API:", err);
      }
    });
  }

}
