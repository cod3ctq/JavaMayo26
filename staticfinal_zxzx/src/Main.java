import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //static: Crear miembros de clase, que pertenecen a la clase y comparten su estado con todas
        //las instancias de esa clase

        //final : Aplica la inmutabilidad

//        CajaCobro ca1 = new CajaCobro("CC1","ROMAN");
//        CajaCobro ca2 = new CajaCobro("CC2","lAURA");
//        CajaCobro ca3 = new CajaCobro("CC3","ANA");
//        CajaCobro ca4 = new CajaCobro("CC4","RODRIGO");
//
//        System.out.println(ca1.getVentaTotal());
//        System.out.println(ca3.getVentaTotal());
//
//        ca1.registrarVenta(1200);
//        ca1.registrarVenta(260);
//        ca1.registrarVenta(100);
//        ca1.registrarVenta(3500);
//        ca1.registrarVenta(500);
//
//        ca2.registrarVenta(300);
//        ca2.registrarVenta(2323);
//        ca3.registrarVenta(2393);
//        ca1.registrarVenta(560);
//
//        ca2.registrarVenta(4305);
//
//        //Obtener un valor compartido por todas las intancias de la clase
//        System.out.println(ca2.getVentaTotal());
//        System.out.println(ca4.getVentaTotal());
//
//        //Los miembros estaticos de una clase pueden ser invocados directamente desde la clase
//        //Clase.miembroestatico
//        System.out.println(CajaCobro.getVentaTotal());
//        System.out.println(CajaCobro.getNumVentas());

        Iphone ip1 = new Iphone("Negro","15PM");
        Iphone ip2 = new Iphone("Azul","13P");
        Iphone ip3 = new Iphone("Blanco","14PM");
        Iphone ip4 = new Iphone("Naranja","17PM");

//        System.out.println(ip1.getSistemaOperativo());
//        System.out.println(ip2.getSistemaOperativo());  iOs
//        System.out.println(ip3.getSistemaOperativo());
//        System.out.println(ip4.getSistemaOperativo());

        System.out.println(Iphone.SISTEMA_OPERATIVO);

        //Iphone.SISTEMA_OPERATIVO = "windows phone"; No se puede debido a que es una constante
        //Iphone.setMarca("Xiaomi"); el setter ya no existe, por que es CONSTANTE
        Iphone ip5 = new Iphone("Morado","16P");
        Iphone ip6 = new Iphone("Dorado","11");
        Iphone ip7 = new Iphone("Amarillo","5c");
        Iphone ip8 = new Iphone("Verde","5c");

        System.out.println(ip5.SISTEMA_OPERATIVO);
        System.out.println(ip5.SISTEMA_OPERATIVO);
        System.out.println(ip5.SISTEMA_OPERATIVO);
        System.out.println(ip5.SISTEMA_OPERATIVO);

        System.out.println(ip5.MARCA);
        System.out.println(ip5.MARCA);
        System.out.println(ip5.MARCA);
        System.out.println(ip5.MARCA);

        //Modificador final tiene efecto en 3 niveles:
        // 1 : Atributo, Crea CONSTANTES
        // 2 : Metodo, impide la sobreescritura
        // 3: Clase, bloquea la herencia










    }
}