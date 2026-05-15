package paquete1;

public class CasaDelVecino {

    Casa c = new Casa(); //Objeto

    public CasaDelVecino(){
        //c.cochera="dgdgdf"; // Forma incorrecta de acceder a un miembro privado
        c.setCochera("ssdfsf"); //Forma correcta de acceder a un miembro privado: a traves del setter

    }


}
