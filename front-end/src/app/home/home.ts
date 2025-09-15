import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-home',
  imports: [],
  templateUrl: './home.html',
  styleUrl: './home.css'
})
export class Home implements OnInit{

  public tokenGoogle: string = "";

  constructor(private route: ActivatedRoute, private router: Router) {}

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      const token = params['token'];

      if (token) {
        // Salva no localStorage
        localStorage.setItem('googleToken', token);
        this.tokenGoogle = token;

        // Redireciona limpando o token da URL
        this.router.navigate(['/home']);
      }
    });
  }

}
