package paquete2;

import paquete1.Casa;

public class CasaLejana extends Casa {

    //Casa c = new Casa();
    public CasaLejana(){
        //Aunque si se puede acceder al valor de manera directa (por que es publica)
        //PERO, NO SE DEBE HACER ASI
        this.direccion = "shbdfvkjhfvb";

        //Siempre se debe hacer a traves de getter/setters
        this.setDireccion("edsfsdfgvdf");

        //c.parque = "sdfvsdfvsdfv"; //Protected, sin visibilidad en el 3er nivel
        c.setParque("uviudfvufdhv"); //Mediante el setter publico, si se tiene acceso

        //Modificador protected extiende su alcance cuando se hereda
        //Protected es visible en clases de otros paquetes cuando se aplica herencia
        this.parque ="fhvkjnfvksdjfjjv";

        //CUAL ES LA FORMA CORRECTA DE ACCEDER A LOS ATRIBUTOS DE UNA CLASE
        //SIEMPRE SERA A TRAVES DE GETTERS/SETTERS (POR QUE SON PUBLICOS)
    }



}
