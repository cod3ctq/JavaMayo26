package paquete2;

import paquete1.Casa;

public class CasaLejana extends Casa{

    //Casa c = new Casa();

    public CasaLejana(){
        //Aunque si se puede acceder al valor de manera directa (es publica) NO SE DEBE HACER ASI
        this.direccion = "calle 1, num1 , colonia 1, 1 , 1";
        //Siempre se debe hacer a traves de getters / setters
        this.setDireccion("calle 1, num1 , colonia 1, 1 , 1");

        //c.parque = "parque 1"; Protected, sin visibilidad en el 3er nivel
        this.setParque("Parque 1");//Mediante el setter publico, si tiene aceceso

        //Modificador protected extiende su alcance cuando se hereda
        //Protected es visible en clases de otros paquetes cuando se aplica herencia
        this.parque = "Parque 2";

        //Cual es la forma correcta de acceder alos atributis de una clase
        //Siempre a traves de getters / setters, porque son publicos
    }
}
