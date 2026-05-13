package paquete1;

public class CasaDelVecino {

    Casa c = new Casa();

    public CasaDelVecino(){
        //c.cochera = "dhewiewhew"; Esta es una forma incorrecta de acceder a un miembro privado.
        //Esta es la forma correcta de acceder a un miembro privado; a través del setter.
        c.setCochera("jsdiojwe");



    }


}
