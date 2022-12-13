import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Producto } from 'src/app/modelos/producto';
import { ProductoService } from 'src/app/services/producto.service';

@Component({
  selector: 'app-agregar-producto',
  templateUrl: './agregar-producto.component.html',
  styleUrls: ['./agregar-producto.component.css']
})
export class AgregarProductoComponent implements OnInit {
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
  })
  authService: any;
  constructor(private fb:FormBuilder,private productoService:ProductoService,private router:Router) { }

  ngOnInit(): void {
    this.listar();
  }

  listar(){
    this.productoService.listarProductos().subscribe((respuesta:any)=>{
      this.productos = respuesta;
      console.log(this.productos);
    })
  }

  campoNoValido(campo: string) {

    if (this.listaProductos.get(campo)?.invalid && this.listaProductos) {
      return true;
    } else {
      return false;
    }
  }

  registrarProducto(){
    let producto:Producto = this.crearProducto(this.listaProductos.value)
    console.log(producto);

    if (this.listaProductos.valid) {
      let nuevoProducto: Producto = this.crearProducto(this.listaProductos.value)
      console.log("Nuevo Producto", nuevoProducto);
      this.authService.registrarProducto(nuevoProducto).subscribe((respuesta) => {
        console.log(respuesta);
        if (respuesta) {
          this.router.navigateByUrl('/productos')
        }
      }
      )

    }
  }

  crearProducto(data:any){
    return new Producto(undefined, undefined, data.undefined, undefined, undefined, undefined, undefined, undefined);
  }

}