import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';
import { Categoria } from 'src/app/modelos/categoria';
import { CategoriaService } from 'src/app/services/categoria.service';

@Component({
  selector: 'app-categorias',
  templateUrl: './categorias.component.html',
  styleUrls: ['./categorias.component.css']
})
export class CategoriasComponent implements OnInit {
  categorias: Categoria[] = [];
  constructor(private CategoriaService: CategoriaService, private router: Router) { }

  ngOnInit(): void {
    this.listar();
  }

  listar() {
    this.CategoriaService.listarCategorias().subscribe((respuesta: any) => {
      this.categorias = respuesta;
    })
  }

  redireccionarVistaAgregar() {
    this.router.navigateByUrl('/categorias/agregar')
  }

  redireccionarVistaEditar(id:any) {
    this.router.navigateByUrl('/categorias/editar/'+id)
  }

  eliminarCategoria(id:any){
    console.log(id);
    this.CategoriaService.eliminarCategoria(id).subscribe(respuesta=>{
      console.log(respuesta);
      this.listar();
    })
  }
}
