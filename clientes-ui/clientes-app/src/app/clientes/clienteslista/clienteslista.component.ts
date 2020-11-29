import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ClientesService } from 'src/app/clientes.service';
import { Cliente } from '../cliente';

@Component({
  selector: 'app-clienteslista',
  templateUrl: './clienteslista.component.html',
  styleUrls: ['./clienteslista.component.css']
})
export class ClienteslistaComponent implements OnInit {

  clientes : Cliente[] = [];

  constructor(
    private service : ClientesService, 
    private router : Router) {}

  ngOnInit(): void {
    this.service
    .getClientes()
    .subscribe(response =>{
      this.clientes = response;
    })
  }

  novoCadastro(){
    this.router.navigate(['/clientes-form']);
  }

}
