import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import { RegisterComponent } from './auth/register/register.component';
import { CarritoComponent } from './views/carrito/carrito.component';
import { HomeComponent } from './views/home/home.component';
import { PedidosComponent } from './views/pedidos/pedidos.component';

const routes: Routes = [
  {path:"", component:HomeComponent},
  {path:"carrito", component:CarritoComponent},
  {path:"pedidos", component:PedidosComponent},
  {path:"iniciar sesion", component:LoginComponent},
  {path:"registro", component:RegisterComponent},
  {path:"**", pathMatch:"full",component:HomeComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
