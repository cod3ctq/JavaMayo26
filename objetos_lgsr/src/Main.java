//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //programacion Orientada  a objetos
        /*
        Herencia
        Encapsulamiento
        Abstraccion: Concepto con el que buscas simplificar o sintetizar los atributos y caracteristcas relevantes
        Polimorfismo
         */

//        //Crear un objeto
//        //Clase nombredevariable = new Constructor();   // syntax
//        Producto pro = new Producto();
//        pro.setCategoria("Vinos y Licores");
//        pro.setCosto(850.00);
//        pro.setFolio("KFD243524");
//        pro.setNombre("Tequila");
//        pro.setStock(50.00);
//        pro.setFechaRegistro(new Date());
//        //ver el estado del objeto
//        System.out.println(pro);
//
//        //Construye un objeto lleno desde el inicio
////        Producto pro2 = new Producto(80.00,"ABARROTES",new Date(),200.00,"Sabritones","SBR34787");
////        System.out.println(pro2);
////        SalidaCine sc = new SalidaCine("60vsegundos", 80.00, 1, "f10", "12:00pm","Cerrada cocuite sur" );
////        System.out.println(SalidaCine);
//        Juego j1 = new Juego();
//        j1.setNombre("Saint Seiya");
//        j1.setClasificacion("2D Fighter");
//        j1.setInventario(200);
//        j1.setCosto(999.99);
//        j1.setLanzamiento("MAYO 2020");
//        System.out.println(j1);
//
//        Juego j2 = new Juego("TEKKEN7","3D Fighter",150, "ABRIL 2024",999.99);
//        System.out.println(j2);
        Celular c = new Celular("1100","NOKIA", 1500.00, 950);
        c.mandarMensaje("23456788677", "hola java desde un nokia");
        c.hacerLlamada("23415143451");

        //creacion del objeto compuesto

        Camara c1= new Camara(5.00,1.30,1,2.80,10, 19500);

        Smartphone sm = new Smartphone("2103","NOKIA",1110.00,950,"Android17",c1);
        sm.mandarMensaje("53445","Mensaje desde el smartphone");
        sm.hacerLlamada("25323245");
        System.out.println(sm);
    }
}