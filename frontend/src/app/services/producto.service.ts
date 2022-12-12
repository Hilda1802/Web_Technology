import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/assets/environments/environment';
import { Producto } from '../modelos/producto';

const url = environment.url;
@Injectable({
  providedIn: 'root'
})
export class ProductoService {

  obtenerProductoPorId(id: string | null) {
    return this.http.get(url + "/productos/obtenerPorId/" + id);
  }

  constructor(private http: HttpClient) { }

  listarProductos() {
    return this.http.get("http://localhost:8080/api/productos/listado");
  }

  guardarProducto(producto: Producto) {
    return this.http.post(url + "/productos/guardar/", producto);
  }

  editarProducto(producto: Producto) {
    return this.http.put(url + "/productos/actualizar/" + producto.codigo, producto);
  }

  eliminarProducto(id: number) {
    return this.http.delete(url + "/productos/eliminar/" + id);
  }
}
