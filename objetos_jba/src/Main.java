//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        // Programacion Orientada a obejtos.
//        /*
//        Herencia
//        Encapsulamiento
//        Abstraccion: Concepto con el que buscas simplificar o sintetizar los atributos y caracteristicas reelevantes.
//        Polimorfismo
//         */
//
//        // Crear un Objeto
//        //Clase nombredevariable = new Constructor();
//        producto pro = new producto();
//
//
//        //ver el estado del objeto
//        pro.setCategoria("Vinos y licores");
//        pro.setCosto(850.00);
//        pro.setFolio("KFD3675");
//        pro.setNombre("tequila don Julio");
//        pro.setStock(50.00);
//        pro.setFechaRegistro(new Date());
//
//        //imoprimir el estadon del objeto
//        System.out.println(pro);
//
//        producto pro2 = new producto(80.00,"SBR68587", "SABRITONES", 200.00, new Date(), "ABARROTES");
//        System.out.println(pro2);
//
//        SalidaCine sc= new SalidaCine("60segundos", 80.00, 1, "F10", "9:15", "ANGELOPOLIS, PUEBLA, MEXICO");
//        System.out.println(sc);
//
//        TiendaRopa tr= new TiendaRopa("Cuidado con el perro","Tecamac, Estado de Mexico", "AHF5789686", new Date(), 4);
//        System.out.println(tr);
//        TiendaRopa tr2= new TiendaRopa("Louis Vuitton", "Puebla", "BNH477657", new Date(), 5);
//        System.out.println(tr2);
    Celular c = new Celular("1100", "Nokia", 1500, 950);
    c.mandarMensaje("5516100535", "Hola Java desde un Nokia");
    c.hacerLlamada("5516100535");

        System.out.println(c);
    Camara c1= new Camara(5.00, 1.3, 1, 2.8, 10, 800);
    Camara[] cams = {c1};
    Camara c2 = new Camara(200.00, 1.3, 1, 2.8, 100, 800);
    Camara c3 = new Camara(12.00, 1.3, 1, 2.8, 10, 800);
    Camara c4 = new Camara(20.00, 1.3, 1, 2.8, 10, 800);
    Camara[] camSansung = {c1,c2,c3,c4};

    Pantalla pant1 = new Pantalla("240x360", 2.6, false, true, 500, 30);
    Pantalla pant2 = new Pantalla("2k", 6.8, true, true, 1500, 120);

    Smartphone sm= new Smartphone("N95", "Nokia", 800, 1200, "Symbian",cams, pant1);
    Smartphone sm2 = new Smartphone("S23Ultra", "Nokia", 800, 1200, "Symbian",camSansung, pant2);
    sm2.mandarMensaje("5516903456", "Mensaje enviado desde smartphone");
    sm2.hacerLlamada("666666666");

        System.out.println(sm);
        System.out.println(sm2);

        //invocando metodos nativos de la clase hija
        sm.instalarAplicaciones();
        sm.hacerVideollamada();



    }
}