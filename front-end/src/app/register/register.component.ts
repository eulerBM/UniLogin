import { Component} from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  imports: [CommonModule, ReactiveFormsModule, HttpClientModule],
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

 registerForm: FormGroup;

  constructor(private fb: FormBuilder, private http: HttpClient) {
    this.registerForm = this.fb.group({
      nome: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      senha: ['', Validators.required],
      confirmarSenha: ['', Validators.required]
    });
  }

  onSubmit() {
    if (this.registerForm.valid) {
      const formData = this.registerForm.value;
      console.log("dados do form: " + formData.nome);

      // Enviando para API
      this.http.post('http://localhost:8080/api/users', formData)
        .subscribe({
          next: (res) => console.log('Usuário criado:', res),
          error: (err) => console.error('Erro:', err)
        });
    }
  }

}
