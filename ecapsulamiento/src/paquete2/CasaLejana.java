package paquete2;

import paquete1.Casa;

public class CasaLejana extends Casa{

    //Casa c = new Casa(); //COMPOSICION

    public CasaLejana(){

        //Aunque si se puede acceder al valor de manera directa (porque es publica)
        //NO SE DEBE HACER ASI
        //c.direccion="dlkaslda";

        //SIEMPRE SE DEBE HACER A TRAVES DE GETTER Y SETTERS
        //c.setDireccion("sadklsad");

        this.direccion="";
    }

}
