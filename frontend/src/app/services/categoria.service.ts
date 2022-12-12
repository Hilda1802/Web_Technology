import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/assets/environments/environment';
import { Categoria } from '../modelos/categoria';

const url = environment.url;
@Injectable({
  providedIn: 'root'
})
export class CategoriaService {

  obtenerCategoriaPorId(id: string | null) {
    return this.http.get(url + "/categorias/obtenerPorId/" + id);
  }

  constructor(private http: HttpClient) { }

  listarCategorias() {
    return this.http.get("http://localhost:8080/api/categorias/listado");
  }

  guardarCategoria(categoria: Categoria) {
    return this.http.post(url + "/categorias/guardar/", categoria);
  }

  editarCategoria(categoria: Categoria) {
    return this.http.put(url + "/categorias/actualizar/" + categoria.id, categoria);
  }

  eliminarCategoria(id: number) {
    return this.http.delete(url + "/categorias/eliminar/" + id);
  }
}
