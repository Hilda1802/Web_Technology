import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';
import { Pedido } from 'src/app/modelos/pedido';
import { PedidoService } from 'src/app/services/pedido.service';

@Component({
  selector: 'app-pedidos',
  templateUrl: './pedidos.component.html',
  styleUrls: ['./pedidos.component.css']
})
export class PedidosComponent implements OnInit {
  pedidos: Pedido[] = [];
  constructor(private PedidoService: PedidoService, private router: Router) { }

  ngOnInit(): void {
    this.listar();
  }

  listar() {
    this.PedidoService.listarPedidos().subscribe((respuesta: any) => {
      this.pedidos = respuesta;
    })
  }
  redireccionarVistaAgregar() {
    this.router.navigateByUrl('/pedidos')
  }
}
