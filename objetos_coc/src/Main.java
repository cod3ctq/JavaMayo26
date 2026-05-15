import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Programación Orientada a Objetos
        /*
        Abstracción: Concepto con el que se busca simplificar o sintetizar los atributos y características relevantes
        Encapsulamiento
        Herencia: Relación "ES UN"
        Polimorfismo
         */

        // Objeto de tipo Celular
        Celular cel1 = new Celular("1100", "Nokia", 1500.00, 950); // Creamos Objeto
        System.out.println(cel1.toString());
        cel1.mandarMensaje("4921595747", "Hola desde un celular"); // Llamamos a Metodo de la Clase padre
        cel1.hacerLlamada("4921595747"); // Llamamos a Metodo de la Clase padre

        // Creación de Objetos de tipo Camara
        Camara cam1 = new Camara(5.00, 1.3, 1, 2.8, 10, 800);
        Camara[] camaras = {cam1}; // Array que nos servirá para el Smartphone de una cámara
        Camara cam2 = new Camara(200.00, 1.3, 1, 2.8, 10, 800);
        Camara cam3 = new Camara(50.00, 1.3, 1, 2.8, 10, 800);
        Camara cam4 = new Camara(12.00, 1.3, 1, 2.8, 10, 800);
        Camara[] camarasSamsung = {cam2, cam3, cam4}; // Array que nos servirá para el Smartphone de 3 cámaras

        // Creación de Objetos de tipo Pantalla
        Pantalla pant1 = new Pantalla("240 x 360", 2.6, false, true, 500, 30);
        Pantalla pant2 = new Pantalla("4K", 6.8, true, true, 1500, 120);

        // Objetos de tipo Smartphone (compuestos, tienen Objetos de tipo Camara y Pantalla como atributos)
        Smartphone smart1 = new Smartphone("Nokia N95", "Nokia", 8000.00, 1200, "Symbian", camaras, pant1);
        System.out.println("\n" + smart1.toString());
        smart1.mandarMensaje("4921595747", "Hola desde smartphone 1"); // Llamamos a Metodo sobre escrito en la Clase hija
        smart1.hacerLlamada("4921595747"); // Llamamos a Metodo de la Clase padre

        Smartphone smart2 = new Smartphone("S23 Ultra", "Samsung", 25000.00, 5000, "Android 16", camarasSamsung, pant2);
        System.out.println("\n" + smart2.toString());
        smart2.mandarMensaje("4921595747", "Hola desde smartphone 2"); // Llamamos a Metodo sobre escrito en la Clase hija
        smart2.hacerLlamada("4921595747"); // Llamamos a Metodo de la Clase padre
        smart2.instalarApps(); // Llamamos a Metodo de la Clase hija
        smart2.hacerVideollamada(); // Llamamos a Metodo de la Clase hija


        // Creamos Objeto con constructor vacío:
//        Producto prod1 = new Producto();
//        prod1.setCategoria("Vinos y licores");
//        prod1.setCosto(850.00);
//        prod1.setFolio("VYL12345");
//        prod1.setNombre("Tequila don Julio");
//        prod1.setStock(50.00);
//        prod1.setFechaRegistro(new Date());

        // Ver el estado del Objeto
//        System.out.println(prod1);

        // Creamos Objeto con constructor con argumentos
//        Producto prod2 = new Producto(80.00, "AB12345", "Sabritones", 200.00, new Date(), "Abarrotes");
//        System.out.println(prod2);

        // Objeto de un concepto inmaterial
//        SalidaCine salida1 = new SalidaCine("60 Segundos", 80.00, 1, "F10", "20:00", "Angelopolis");
//        System.out.println(salida1);

        // Crear una Clase modelando lo que yo quiera, incluir todos los miembros de la Clase
        // Crear 2 Objetos de esa Clase en la Clase Main:
//        Motocicleta moto1 = new Motocicleta("BMW", "R1200GS", 1200, "Aventura", "Azul", 320000.00);
//        System.out.println(moto1);

//        Motocicleta moto2 = new Motocicleta("Yamaha", "R6", 600, "Deportiva", "Negro", 240000.00);
//        System.out.println(moto2);
    }
}