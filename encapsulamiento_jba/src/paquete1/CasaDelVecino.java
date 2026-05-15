package paquete1;

public class CasaDelVecino {

    Casa c1 = new Casa();

    public CasaDelVecino(){
       // c1.cochera="hghjhgfgh"; forma incorrecta de acceder a un miembro privado

        //forma correcvta de acceder a un miembro privado: a traves del setter
        c1.setCochera("fghjkjhg");

    }
}
