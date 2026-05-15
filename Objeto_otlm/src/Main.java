import java.util.Date;

public class Main {
    public static void main(String[] args){
        //´Programacion orienta a objetos
        /*
         * Herencia
         * Encapsulamiento :
         * Abstraccion   :   Es el concepto con el buscas simplificar o sintetizar los atributis y caracteristas
         *                   relevantes
         * Polimorfismo  :
         */

        //Crear un objeto
        //Clase nombreDeVariable = new Contructor();
//        Producto pro = new Producto();
//
//        pro.setCategoria("Vinos y licores");
//        pro.setCosto(850.0);
//        pro.setFolio("GFDG5TSASD54512");
//        pro.setNombre("Tequila Don Julion");
//        pro.setStock(50);
//        pro.setFechaRegistro(new Date());
//        //Ver el estado del objeto
//        System.out.println(pro);
//
//        //Construye un objeto lleno desde del inicio
//        Producto pro2 = new Producto(80.00,"GFDG5TSASD54513","Sabritones 120GR", 200.0,
//                new Date(), "Abarrotes");
//
//        System.out.println(pro2);
//
//        SalidaCine sc = new SalidaCine("Godzilla", 80.00, 1, "F10", "20:00","Agelopolis");
//
//        //Crear una clase modelando lo que ustedes quieran, incluir todos los miembros de clase
//        //Crear 2 objetis de esa clase en la clase Main;
//
//        Videojuego videojuego1 = new Videojuego("Super Smash Bros Ultimate", "E10+", 875.0, "Nintendo Switch", "Sora Ltd. y Bandai Namco Entertainment", "07/12/2018");
//        Videojuego videojuego2 = new Videojuego("Battlefield 6", "M", 1000.0, "Playstation, XBOX, PC", "Battlefield Studios", "10/10/2025");
//
//        System.out.println(videojuego1+"\n"+videojuego2);

        Celular c = new Celular("1100", "Nokia", 1500.0, 950);
        c.mandarMensaje("3328120294", "Hola Mundo desde un celular");
        c.hacerLlamada("2226735112");
        System.out.println(c);

        Camara c1 = new Camara(5.00, 1.3, 1, 2.8, 10, 800);
        Camara[] cams = {c1};
        Camara c2 = new Camara(50, 0.2, 1, 1.9, 0, 3200);
        Camara c3 = new Camara(50, 0.2, 1, 1.7, 2, 3200);
        Camara c4 = new Camara(10, 0.2, 1, 3.4, 10, 3200);
        Camara cf = new Camara(12, 0.2, 1, 2.2, 0, 3200);
        Camara[] camSamsung = {cf,c2,c3,c4};

        Pantalla pant1 = new Pantalla("240x360", 2.6, false, true, 500, 30);
        Pantalla pant2 = new Pantalla("2k", 6.8, true, true, 1500, 120);

        Smartphone sm = new Smartphone("Nokia N958GB", "NOKIA", 8000.0, 1200, "Symbian s60v3", cams,pant1);

        Smartphone sm2 = new Smartphone("Samsung S25 Ultra", "Samsung", 26000.0, 5000, "Android 17", camSamsung,pant2);
        sm.mandarMensaje("3328120294", "Mensaje desde el smartphone");
        sm.hacerLlamada("2226735112");

        //Invocando metodos nativos de la clase hija (le pertenecen solo a la hija)
        sm.intalarAplicaciones();
        sm.hacerVideollama();

        //Invocar metodos de la clase hija desde una instacia de la clase padre(no se puede)
        //c.instalarAplicaciones;

        System.out.println(sm);

        System.out.println(sm2);



    }
}
