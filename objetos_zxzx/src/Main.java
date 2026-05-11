import java.util.Date;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Programacion Orientada a Objetos
        /*
        Herencia
        Encapsulamiento
        Abstraccion : Concepto con el que buscas simplificar o sintetizar los atributos y caracteristicas reelevantes
        Polimorfismo
         */

        //Crear un objeto
        //Clase nombredevariable = new Constructor();
//        Producto pro = new Producto();
//
//        pro.setCategoria("Vinos y licores");
//        pro.setCosto(850.00);
//        pro.setFolio("KFD243524");
//        pro.setNombre("Tequila Don Julio");
//        pro.setStock(50.00);
//        pro.setFechaRegistro(new Date());
//        //Ver el estado del objeto
//        System.out.println(pro);
//        //Construye un objeto lleno desde el inicio
//        Producto pro2 = new Producto(80.00,"SBR34787","SABRITONES 120GR",200.00, new Date(),"ABARROTES");
//        System.out.println(pro2);

        //Objeto de un concepto inmaterial
        //SalidaCine sc = new SalidaCine("60Segundos",80.00,1,"F10","20:00", "Angelopolis");

        //Crear una clase modelando lo que ustedes quieran, incluir todos los miembros de clase
        //Crear 2 objetos de esa clase en la clase Main.


        Celular c = new Celular("1100","Nokia",1500.00, 950);
        c.mandarMensaje("23453453245","Hola Java desde un nokia");
        c.hacerLlamada("462452345");


        //Creacion del objeto compuesto
        Camara c1 = new Camara(5.00,1.3, 1,2.8,10,800);
        Camara[] cams = {c1};
        Camara c2 = new Camara(200.00,1.3, 1,2.8,100,800);
        Camara c3 = new Camara(12.00,1.3, 1,2.8,10,800);
        Camara c4 = new Camara(20.00,1.3, 1,2.8,10,800);
        Camara[] camSamsung = {c1,c2,c3,c4};
        Smartphone sm = new Smartphone("Nokia N958GB", "Nokia", 8000,1200,"Symbian s60v3",cams);

        //Objeto compuesto : Necesita de otros objetos mas pequeños
        Smartphone s2 = new Smartphone("S23Ultra", "Samsung", 26000,5000,"Android 17",camSamsung);


        sm.mandarMensaje("52345","Mensaje desde el smartphone");
        sm.hacerLlamada("25345234");

        System.out.println(sm);

    }
}