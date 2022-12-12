import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PedidoService {

  constructor(private http: HttpClient) { }

  listarPedidos(){
    return this.http.get("http://localhost:8080/api/pedidos/listado");
  }
}
