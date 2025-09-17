import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-facebook',
  imports: [],
  templateUrl: './facebook.html',
  styleUrl: './facebook.css'
})
export class Facebook implements OnInit{

  public tokenFacebook: string = "";

  constructor(private route: ActivatedRoute, private router: Router) {}

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      const token = params['token'];

      if (token) {
        // Salva no localStorage
        localStorage.setItem('facebookToken', token);
        this.tokenFacebook = token;

        // Redireciona limpando o token da URL
        this.router.navigate(['/facebook']);
      }
    });
  }

}
