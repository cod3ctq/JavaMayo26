package paquete1;

public class CasaDelVecino {

    Casa c = new Casa(); // Creamos Objeto de la Clase Casa

    public CasaDelVecino() { // Constructor
        //c.cochera = "asdfg" // Incorrecto, forma incorrecta de acceder a un miembro privado
        c.setCochera("asdfg"); // Forma correcta de acceder a un miembro privado
    }
}