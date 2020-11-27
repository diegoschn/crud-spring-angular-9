import { Injectable } from '@angular/core';
import { Cliente } from './clientes/cliente';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ClientesService {

  constructor(private httpClient : HttpClient) { 
    
  }

  salvar(cliente : Cliente) : Observable<Cliente>{
    return this.httpClient.post<Cliente>('http://localhost:8080/api/clientes', cliente);
  }

  //getCliente que o retorno vai ser cliente
  getCliente() : Cliente {

    let cliente : Cliente = new Cliente();
    cliente.nome = 'Diego L.C. Schneider';
    cliente.cpf = '01899685596';
    return cliente;

  }
}
