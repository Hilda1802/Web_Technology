import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/assets/environments/environment';
import { loginUsuario } from '../modelos/login-usuario';
import { Usuario } from '../modelos/usuario';

const url = environment.url;
@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http:HttpClient) { }

  registrarUsuario(usuario:Usuario){
    return this.http.post(url+"/auth/register",usuario)
  }

  login(usuario:loginUsuario){
  }

}
