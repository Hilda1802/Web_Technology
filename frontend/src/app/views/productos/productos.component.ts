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
export class ProductosComponent implements OnInit {
  productos: Producto[] = [];
  listaProductos = this.fb.group({
    codigo: ["", Validators.required],
    nombre: ["", Validators.required],
    precioVenta: ["", Validators.required],
    stock: [""],
    imagen: [""],
    marca: ["", Validators.required],
    estado: ["", Validators.required],
    fechaRegistro: ["", Validators.required]
  }, {});

  constructor(private fb: FormBuilder, private ProductoService: ProductoService, private router: Router) { }

  ngOnInit(): void {
    this.listar();
  }

  listar() {
    this.ProductoService.listarProductos().subscribe((respuesta: any) => {
      this.productos = respuesta.content;
      console.log(this.productos);
    })
  }
  registrarProducto() {
    let producto: Producto = this.transformaProducto(this.listaProductos.value)
    console.log(producto);

    this.ProductoService.guardarProducto(producto).subscribe(respuesta => {
      if (respuesta) {
        this.router.navigateByUrl('/productos')
      }
      })
    }

      transformaProducto(data: any){
        return new Producto(undefined, undefined, data.undefined, undefined, undefined, undefined, undefined, undefined);
      }


      eliminarProducto(codigo:any){
        console.log(codigo);
        this.ProductoService.eliminarProducto(codigo).subscribe(respuesta => {
          console.log(respuesta);
          this.listar();
        })
      }

      redireccionarVistaAgregar() {
        this.router.navigateByUrl('/productos/agregarProducto')
      }

      redireccionarVistaEditar() {
        this.router.navigateByUrl('/productos/editar/144')
      }
    }
