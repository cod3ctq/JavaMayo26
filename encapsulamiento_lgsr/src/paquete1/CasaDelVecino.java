package paquete1;

public class CasaDelVecino {
    Casa c = new Casa();
    public CasaDelVecino(){
        //c.cochera= "asdfasdf" //// Forma incorrecta de acceder a un miembro privado.
        //forma correcta de acceder a un miembro privado : a traves del setter
        c.setCochera("AIEAEAOU");

    }
}
