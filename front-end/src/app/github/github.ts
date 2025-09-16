import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-github',
  imports: [],
  templateUrl: './github.html',
  styleUrl: './github.css'
})
export class Github implements OnInit{

  public tokenGithub: string = "";

  constructor(private route: ActivatedRoute, private router: Router) {}

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      const token = params['token'];

      if (token) {
        // Salva no localStorage
        localStorage.setItem('githubToken', token);
        this.tokenGithub = token;

        // Redireciona limpando o token da URL
        this.router.navigate(['/github']);
      }
    });
  }

}
