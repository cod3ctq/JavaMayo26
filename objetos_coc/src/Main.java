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

        Celular cel1 = new Celular("1100", "Nokia", 1500.00, 950);
        System.out.println(cel1);
        cel1.mandarMensaje("4921595747", "Hola desde un celular");
        cel1.hacerLlamada("4921595747");

        // Creación del Objeto compuesto
        Camara cam1 = new Camara(5.00, 1.3, 1, 2.8, 10, 800);
        Camara[] camaras = {cam1};
        Camara cam2 = new Camara(200.00, 1.3, 1, 2.8, 10, 800);
        Camara cam3 = new Camara(50.00, 1.3, 1, 2.8, 10, 800);
        Camara cam4 = new Camara(12.00, 1.3, 1, 2.8, 10, 800);
        Camara[] camarasSamsung = {cam1, cam2, cam3, cam4};

        Smartphone smart1 = new Smartphone("Nokia N95", "Nokia", 8000.00, 1200, "Symbian", camaras);
        Smartphone smart2 = new Smartphone("S23 Ultra", "Samsung", 25000.00, 5000, "Android 16", camarasSamsung);

        System.out.println(smart1);
        smart1.mandarMensaje("4921595747", "Hola desde un smartphone");
        smart1.hacerLlamada("4921595747");
    }
}