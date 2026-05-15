import java.util.Arrays;

public class Main {
    public static void main(String[] args) {


        //Static: ?? Este modificador crea miembros de clase y comparten su estado con todas
        //las instancias de esa clase
        //Final: ?? Aplica la inmutabilidad


        CajaCobro ca1 = new CajaCobro("CC1","ROMAN");
        CajaCobro ca2 = new CajaCobro("CC2","LAURA");
        CajaCobro ca3 = new CajaCobro("CC3","ANA");
        CajaCobro ca4 = new CajaCobro("CC4","RODRIGO");

        System.out.println(ca1.getVentaTotal());
        System.out.println(ca3.getVentaTotal());

        ca1.registrarVenta(1200);
        ca1.registrarVenta(260);
        ca1.registrarVenta(100);
        ca1.registrarVenta(3500);
        ca1.registrarVenta(500);

        ca2.registrarVenta(300);
        ca2.registrarVenta(2323);
        ca3.registrarVenta(2393);
        ca1.registrarVenta(560);

        ca2.registrarVenta(4305);

        //Obtener un valor compartido por todas las instancias de la clase.

        System.out.println(ca2.getVentaTotal());
        System.out.println(ca4.getVentaTotal());


        //Los miembros estáticos de una clase pueden ser invocados directamente desde la clase.
        //Clase.miembroestatico
        System.out.println(CajaCobro.getVentaTotal());
        System.out.println(CajaCobro.getNumVentas());


        Iphone ip1 = new Iphone("Negro","15PM");
        Iphone ip2 = new Iphone("Azul","13PM");
        Iphone ip3 = new Iphone("Blanco","14PM");
        Iphone ip4 = new Iphone("Naranja","17PM");


       // System.out.println(ip1.getSistemaOperativo());
        //System.out.println(ip2.getSistemaOperativo());
        //System.out.println(ip3.getSistemaOperativo());
        //System.out.println(ip4.getSistemaOperativo());

        System.out.println(Iphone.SISTEMA_OPERATIVO);

        // phone.SISTEMA_OPERATIVO = "Windows iphone"; Esto no se puede debido a que es una constante
        //Iphone.setMarca("Xiaomi"); El setter ya no existe, porque es CONSTANTE

        Iphone ip5 = new Iphone("Morado", "16P");
        Iphone ip6 = new Iphone("Dorado", "11");
        Iphone ip7 = new Iphone("Amarillo", "5c");
        Iphone ip8 = new Iphone("Verde", "5c");

        System.out.println(ip5.SISTEMA_OPERATIVO);
        System.out.println(ip5.SISTEMA_OPERATIVO);
        System.out.println(ip5.SISTEMA_OPERATIVO);
        System.out.println(ip5.SISTEMA_OPERATIVO);

        System.out.println(ip5.MARCA);
        System.out.println(ip5.MARCA);
        System.out.println(ip5.MARCA);
        System.out.println(ip5.MARCA);

        //Modificador final: tiene efecto en 3 niveles:
        // 1: Crea constantes a nivel de atributo
        //2: Impide la sobreescritura a nivel de metodo
        //3: Bloquea la herencia a nivel de clase.


    }

}