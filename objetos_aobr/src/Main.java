import java.util.Date;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*Programacion orientada a objetos
        Herencia
        Encapsulamiento
        Abstraccion
        Polimorfismo
         */


//        //Crear un objeto
//        //Clase nombrevariable new = new Constructor();
//        Producto pro = new Producto();
//
//        pro.setCategoria("Vinos y licores");
//        pro.setCosto(850.00);
//        pro.setFolio("KSAD212");
//        pro.setNombre("Tequila Don Julio");
//        pro.setStock(50.00);
//        pro.setFechaRegistro(new Date());
//
//
//
//
//
//        //Ver el estado del objeto
//        System.out.println(pro);
//
//
//        //Construir un objeto lleno desde el inicio
//        Producto pro2 = new Producto(80.00,"SBRSDA23","SABRITONES 120GR", 200, new Date(),"ABARROTES");
//        System.out.println(pro2);
//
//
//        //Objeto de un concepto inmaterial
//        SalidaCine sc = new SalidaCine("60Segundos", 80, 1,"F10","20:00","Angelopolis");
//
//
//        //Crear una clase modelando lo que yo quiera, incluir todos los miembros de clase
//        //Crear 2 objetos de esa clase en la clase main
//
//
//        Carro car = new Carro("Honda","Civic",2006,100000,"Negro","2130310");
//        Carro car2 = new Carro("Mazda","Rx7",1997,150000,"Amarillo","319041");
//        System.out.println(car);
//        System.out.println(car2);

        Celular c = new Celular("","",1500.00,900);
        System.out.println(c);
        c.mandarMensaje("734420141","Hola Java desde un Nokia");
        c.hacerLlamada("33841941");

        //Creacion del objeto compuesto
        Camara c1 = new Camara(5.00,1.3,1,2.8,10,800);
        Camara[] cams = {c1};


        Camara c2 = new Camara(200.00,1.3,1,2.8,100,800);
        Camara c3 = new Camara(12.00,1.3,1,2.8,10,800);
        Camara c4 = new Camara(20.00,1.3,1,2.8,10,800);
        Camara[] camSamsung = {c1,c2,c3,c4};


        Smartphone sm = new Smartphone("Nokia n95","nokia",8000.00,1200,"Symbian",cams);
        //Objeto compuesto: necesita de otros objetos mas pequenios
        Smartphone s2 = new Smartphone("S23 ultra","samsung",25000.00,5000,"Android",camSamsung);

        sm.mandarMensaje("318041","Mensaje desde el Smarthphone");
        sm.hacerLlamada("31804");

        System.out.println(sm);

    }
}