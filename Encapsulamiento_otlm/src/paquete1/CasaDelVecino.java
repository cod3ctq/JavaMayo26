package paquete1;

public class CasaDelVecino {
    Casa c = new Casa();

    public CasaDelVecino(){
        //c.cochera = "sdfasdfasdfasfasfasfasdf"; Forma incorrecta de acceder a un miembro privado
        c.setCochera("carro");//Froma correcta de acceder a un miembro privado : a traves de un setter

    }


}
