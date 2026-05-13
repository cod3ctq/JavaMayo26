package paquete2;

import paquete1.Casa;
import paquete1.CasaDelVecino;

public class CasaLejana extends Casa { // heredansdo una clase de otro paquete

    //Casa c = new Casa(); //Objeto

    public CasaLejana(){

        //Si puede acceder al valor de manera directa (por que es publica)
        //NO SE DEBE HACER ASI
        this.direccion = "ffsfsf";

        //Siempre se debe hacer a traves de gtter/setter
        this.setDireccion("sfsfdfs");

        //c.parque = "sfsfsdf"; //Protected, sin visibilad en el 3er nivel

        c.setParque("sfsgg"); //Mediante el setter publico, si se tiene acceso

        //protected extiende su alcance cuando se hereda
        //protected es visible en clases de otros paquetes cuando se aplica herencia
        this.parque = "fsfsfd";


        //Cual es la forma correcta de acceder a los atributos de una clase
        //Siempre sera a traves de getter/setter por que son publicos

    }


}
