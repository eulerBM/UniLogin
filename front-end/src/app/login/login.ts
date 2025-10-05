import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { RequestsService } from '../services/requests.service';
import { environment } from './../../environments/environment.development';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule} from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './login.html',
  imports: [CommonModule, ReactiveFormsModule, HttpClientModule],
  styleUrls: ['./login.css']
})
export class Login {
  private apiBase = environment.apiUrl;

  public loginForm: FormGroup;
  public message: string = "";

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private http: HttpClient
  ) {

    this.loginForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required]]
    });
  }

  onSubmit() {
    if (this.loginForm.valid) {
      const { email, password } = this.loginForm.value;

      this.http.post('https://localhost:8443/user/login', { email, password })
        .subscribe({
          next: (res) => {
            console.log("Login ok:", res);
            this.router.navigate(['/home']); // redirecionar pós-login
          },
          error: (err) => {
            console.error(err);
            this.message = "Usuário ou senha inválidos";
          }
        });
    } else {
      this.message = "Preencha todos os campos corretamente!";
    }
  }

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
