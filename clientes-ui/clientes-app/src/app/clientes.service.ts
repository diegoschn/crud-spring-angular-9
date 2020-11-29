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

  
  getClientes() : Observable<Cliente[]> {
    return this.httpClient.get<Cliente[]>('http://localhost:8080/api/clientes');
  }

  getClienteById(id : number) : Observable<any>{
    return this.httpClient.get<any>(`http://localhost:8080/api/clientes/${id}`);
  }

  atualizar(cliente : Cliente) : Observable<any>{
    return this.httpClient.put<Cliente>(`http://localhost:8080/api/clientes/${cliente.id}`, cliente);
  }
}
