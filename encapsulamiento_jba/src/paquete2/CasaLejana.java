package paquete2;

import paquete1.Casa;

public class CasaLejana extends Casa{

    // Casa c1 = new Casa();

    public CasaLejana(){
    //Aunque se puede acceder al valor de manera directa (por que es directa)
        //nose debe hacer asi
        this.direccion=("fghjkjhgh");

        //siempre debe hacerse atraves de getters/setters

        this.setDireccion("fghjkjkjh");

        //parque= "qaefrtyuytre"; //protected sin visibilidad en el tercer nivel
       //-------- c1.setParque("fghjkjhgjkl"); //mediante el setter publico, si tiene acceso

        //modificador protected extiende su alcance cuando de hereda
        //Protected es visible en clases de otros paquetes cuando se aplica herencia
        this.parque= "fghjklhjk";

        //CUAL ES LA FORMA CORECTA DE ACCEDER A LOS ATRIBUTOS DE UNA CLASE
        //SIEMPRE SERA A TRAVES DE GETTERS/SETTERS (PORQUE SON PUBLICOS
    }


}
