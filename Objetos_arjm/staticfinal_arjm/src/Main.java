//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Static: Crear miembros de clase que pertenecen a la clase y comparten su estado con todas las instancias de esa clase

        // Final: Aplica la inmutabilidad : el estado de un objeto ya no cambia
//
//        CajaCobro ca1 = new CajaCobro("CC1","ROMAN");
//        CajaCobro ca2 = new CajaCobro("CC2","LAURA");
//        CajaCobro ca3 = new CajaCobro("CC3","ANA");
//        CajaCobro ca4 = new CajaCobro("CC4","RODRIGO");
//
//        System.out.println(ca1.getVentaTotal());
//        System.out.println(ca2.getVentaTotal());
//
//        ca1.registrarVenta(1200);
//        ca1.registrarVenta(260);
//        ca1.registrarVenta(100);
//        ca1.registrarVenta(3500);
//        ca1.registrarVenta(500);
//
//        ca1.registrarVenta(300);
//        ca1.registrarVenta(2323);
//        ca1.registrarVenta(2393);
//        ca1.registrarVenta(560);
//
//        ca1.registrarVenta(4305);
//
//        //Obtener un valor compartido por todas las instancias de la clase
//        System.out.println(ca4.getVentaTotal());
//        System.out.println(ca2.getVentaTotal());
//
//
//        //Los miembros estaticos de una clase pueden ser invocados directamnete desde la clase
//        //Clase.miembroestatico
//
//        System.out.println(CajaCobro.getVentaTotal());
//        System.out.println(CajaCobro.getNumVentas());

        Iphone ip1 = new Iphone("negro","15 pro max");//Objecto
        Iphone ip2 = new Iphone("azul","13 pro max");//Objecto
        Iphone ip3 = new Iphone("blanco","14 pro max");//Objecto
        Iphone ip4 = new Iphone("naranja","17 pro max");//Objecto



//        System.out.println(ip1.getSistemaOperativo());
//        System.out.println(ip2.getSistemaOperativo());
//        System.out.println(ip3.getSistemaOperativo());
//        System.out.println(ip4.getSistemaOperativo());
        System.out.println(Iphone.SISTEMA_OPERATIVO);

        //Iphone.SISTEMA_OPERATIVO = "windows phone"; / NO SE PUEDE DEBIDO A QUE ES UNA CONSTANTE
        //Iphone.SETmARCA("XIAOMI"); / El setter ya no existe, por que es constante


        Iphone ip5 = new Iphone("morado", " 16 pro");
        Iphone ip6 = new Iphone("dorado", " 11");
        Iphone ip7 = new Iphone("amarillo", " 5c");
        Iphone ip8 = new Iphone("verde", " 5c");

        System.out.println(ip5.SISTEMA_OPERATIVO);
        System.out.println(ip5.SISTEMA_OPERATIVO);
        System.out.println(ip5.SISTEMA_OPERATIVO);
        System.out.println(ip5.SISTEMA_OPERATIVO);

        System.out.println(ip5.MARCA);
        System.out.println(ip5.MARCA);
        System.out.println(ip5.MARCA);
        System.out.println(ip5.MARCA);


        //Modificador final tiene efecto en 3 niveles
        //nivel 1: Atributo, crea constantes
        //nivel 2: Metodo, impide la sobreescritura.
        //nivel 3: Clase, bloquea la herencia


    }
}