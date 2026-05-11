import java.util.Date;

public class Main {
    public static void main(String[] args) {

        //Programacion orientada a objetos
        /*
        Herencia
        Encapsulamiento
        Abstracción : Concepto con el que buscas simplificar los atributos y caracteristicas relevantes
        Polimorfismo
         */

        //Crear un objeto
        //Clase nombredevariable = new Constructor();
        Producto pro = new Producto();

        pro.setCategoria("Vinos y licores");
        pro.setCosto(850.00);
        pro.setFolio("KFD243524");
        pro.setNombre("Tequila Don Julio");
        pro.setStock(50.00);
        pro.setFechaRegistro(new Date());


        //Ver el estado del objeto
        System.out.println(pro);

        //Construye un objeto lleno desde el incio
        Producto pro2 = new Producto(80,"SBR34787","SABRITONES 120GR",200.00, new Date(),"ABARROTES");
        System.out.println(pro2);
        //Objeto de un concepto inmaterial.
        SalidaCine sc = new SalidaCine("60 Segundos", 80.00, 1, "F10", "20:00", "Angelopolis");
        System.out.println(sc);

        //Crear una clase modelando lo que ustedes quieran, incluir todos los miembros de la clase.
        //Crear dos objetos de esa clase en la clase Main.

        JugarVideojuegos jv= new JugarVideojuegos("Halo", "PlayStation4","Samsung 40 pulgadas", 2, 500.00);
        System.out.println(jv);


        Celular c = new Celular("1100","Nokia",1500.00,950);
        c.mandarMensaje("5530502740", "Hola Java de un nokia");
        c.hacerLlamada("46582845959");

        //Creacion del objeto compuesto: Necesito de otros objetos más pequeños.
        Camarajava c1 = new Camarajava(5.00, 1.3, 1, 2.8, 10, 800);
        Camarajava[] cams = {c1};
        Camarajava c2 = new Camarajava(200.00,1.3,1,2.8,10,800);
        Camarajava c3 = new Camarajava(12.00,1.3,1,2.8,10,800);
        Camarajava c4 = new Camarajava(20.00,1.3,1,2.8,10,800);
        Camarajava[] canSamsung = {c1, c2, c3, c4};



        //Creacion del objeto compuesto: Necesito de otros objetos más pequeños.
        Smartphone sm = new Smartphone("Nokia N958GB", "Nokia", 8000, 1200, "Symbian s60v3", cams);
        Smartphone s2 = new Smartphone("S23ULTRA", "Samsung", 2600, 5000, "Android 17", canSamsung);
        sm.mandarMensaje("525264","Mensaje desde el smartphone");
        sm.hacerLlamada("254556564");

        System.out.println(sm);








    }

}