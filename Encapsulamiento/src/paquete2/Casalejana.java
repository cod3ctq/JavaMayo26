package paquete2;

import paquete1.Casa;

public class Casalejana extends Casa {

    //Casa c = new Casa();


    public Casalejana(){
        //Aunque si se puede acceder al valor de manera directa (por que es publica)
        //Esto no se debe de hacer asi
        this.direccion = "dnfklfjld";

        //Siempre se debe de hacer a través de Getter/Setters.
        this.setDireccion("jdkfjkfjf");


        //c.parque = "dbikdfdn"; //Protected, sin visibilidad en el 3er nivel
        //c.setParque("jkdhdfkhsk"); // Mediante el setter publico, si se logra tener el acceso.


        //El modificador protected extiende su alcance cuando se hereda
        //Es decir el protected es visible en clases de otros paquetes cuando se aplica herencia.
        this.parque ="ugiuguuk";


        //¿CUAL ES LA FORMA CORRECTA DE ACCEDER A LOS ATRIBUTOS DE UNA CLASE
        //Siempre será a través de getters y setters porque son públicos.


    }





}
