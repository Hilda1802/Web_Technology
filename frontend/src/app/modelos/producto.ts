import { Estado } from "./estado";

export class Producto{
    constructor( public codigo?:string,
         public nombre?:string,
         public precioVenta?:number,
         public stock?:string,
         public imagen?:string,
         public marca?:string,
         public precioCompra?:number,
         public estado?:Estado,
         public fechaRegistro?:string,
        ){
    }
}