import java.util.Date;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Programacion orientada a objetos
        /* Herencia
        Encapsulamiento
        Abstraccion // Busca sinmplificar o sintetizar los atributos y caracteristicas relevantes
        Polimorfismo
        */

        //Crear un objeto
        // Clase nombreVariable = new Constructor();

//
//
//        Producto    pro = new     Producto(); //los constructores siempre tienen el mismo nombre de la clase
////       //Clase      Variable      Constructor
//        pro.setCategoria("Vinos y Licores");
//        pro.setCosto(400.0);
//        pro.setFolio("KFD21");
//        pro.setNombre("Tequila");
//        pro.setStock(50.0);
//        pro.setFechaRegistro(new Date());
//        //Ver el estado del objeto
//        System.out.println(pro);


        //Construye un objeto lleno desde el inicio
//        Producto pro2 = new Producto(80.00,"SHDH4J","Sabritones 120 gr",200.0,new Date(),"Abarrotes");
//        System.out.println(pro2);


        //SalidaCine sc = new SalidaCine("60 segundos",80.00,1,"F10","20:00", "temixco" );

        //Crear una clase modelando lo que querramos, incluir todos los miembros de la clase
        // crear 2 objetos de esa clase en la clase main
//
//        MaterialConstruccion mt = new MaterialConstruccion(10,20,2.0,2.0,20,100);
//
//        System.out.println(mt);
//
//        MaterialConstruccion mc2 = new MaterialConstruccion(20,30,1,1,30,200);
//
//        System.out.println(mc2);

        Celular c = new Celular("1100","nokia",1500.0,540);
        c.mandarMensaje("23238284","Hola java desde un nokia");
        c.hacerLlamada("74438483478");

        //Creacion del compuesto

        Camara c1 = new Camara(5.00,1.3,1,2.8,10,800);
        Camara[] cams = {c1};

        Camara c4 = new Camara(5.00,1.3,1,2.8,10,800);
        Camara c2 = new Camara(5.00,1.3,1,2.8,10,800);
        Camara c3 = new Camara(5.00,1.3,1,2.8,10,800);
        Camara[] camSamsung = {c1,c2,c3,c4};

        Pantalla pant1 = new Pantalla("240*360",2.6,false,true,500,30);
        Pantalla pant2 = new Pantalla("2k",6.8,true,true,1500,120);



        //Objeto compuesto: necesita de otros objetos mas pequeños
        Smartphone sm = new Smartphone("a100","nokia",1500.00,540,"dragon",cams,pant1);
        Smartphone s2 = new Smartphone("s23", "samsung", 2600, 5000, "Android 17", cams,pant2);


        //Invocando metodos de la clase padre desde una instancia de la clase hija
        sm.mandarMensaje("1838383","Mensaje desde el smart");
        sm.hacerLlamada("239310292");

        //Invocando metodos nativos de la clase hija(le pertenecen a la clase hija)
        sm.instalarAplicaciones();
        sm.hacerVideollamada();

        //Invocar metodos de la clase hija desde una instancia de la clse padre
        //No se puede
        //c.instalarAplicaciones();
        //c.hacerVideollamadas();

        System.out.println(sm);
        System.out.println(s2);
    }



}