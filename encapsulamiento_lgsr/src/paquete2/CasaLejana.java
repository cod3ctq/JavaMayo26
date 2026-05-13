package paquete2;

import paquete1.Casa;

public class CasaLejana extends Casa {
    //Casa c = new Casa();

    public CasaLejana(){
        //Aunque si se puede acceder al valor de manera directa(por que es publica)
        //NO SE DEBE HACER ASI
        this.direccion = "asdfasdfasdf";

        //SIEMPRE SE DEBE HACER A TRAVES DE GETTER/SETTER
        this.setDireccion("asdfasdfasdfasdf");

        //c.parque = "asdfasdfasdfasdfasfafad"; //Protected, sin visibilidad en el tercer nivel
        c.setParque("uwuwueebwebwe");

        //Modificador Protected extiende su alcance cuando se hereda
        //Protected es visible en clases de otros paquetes cuando se aplica herencia
        this.parque = "fasdfasdfa";

        // CUAL ES LA FORMA CORRECTA DE ACEDER A LOS ATRIBUTOS DE UNA CLASE
        //SIEMPRE SERA A TRAVES DE GETTERS/SETTERS(PORQUE SON PUBLICOS)

    }
}
