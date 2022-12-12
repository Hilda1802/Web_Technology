import { Usuario } from "./usuario";

export class Pedido{
    constructor( public codigo?:string,
         public fecha?:Date,
         public total?:number,
         public usuario?:Usuario,
        ){

    }
}