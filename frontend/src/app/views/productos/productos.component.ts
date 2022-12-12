import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Producto } from 'src/app/modelos/producto';
import { ProductoService } from 'src/app/services/producto.service';

@Component({
  selector: 'app-productos',
  templateUrl: './productos.component.html',
  styleUrls: ['./productos.component.css']
})
export class ProductosComponent implements OnInit{ 

  listaProductos = this.fb.group({
  codigo: ["", Validators.required],
  nombre: ["", Validators.required],
  precioVenta: ["", Validators.required],
  stock: [""],
  imagen: [""],
  marca: ["", Validators.required],
  estado: ["", Validators.required],
  fechaRegistro: ["", Validators.required]
}, { });

  constructor(private fb:FormBuilder, private ProductoService: ProductoService, private router: Router) { }

  ngOnInit(): void {
    this.listar();
  }

  listar() {
    this.ProductoService.listarProductos().subscribe((respuesta: any) => {
      this.listaProductos = respuesta;
    })
  }

  redireccionarVistaAgregar() {
    this.router.navigateByUrl('/categorias/agregar')
  }

  redireccionarVistaEditar() {
    this.router.navigateByUrl('/categorias/editar/144')
  }

  eliminarProducto(id:any){
    console.log(id);
    this.ProductoService.eliminarProducto(id).subscribe(respuesta=>{
      console.log(respuesta);
      this.listar();
    })
  }
}
