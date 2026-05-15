//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //static: Crear miembros de clase que pertenecen a la clase y comparten su estado con
        //todas las instancias de esa clase

        //final : Aplica la inmutabilidad(No se pueden modificar las instancias, es decir, ya no cambia)

//        CajaCobro ca1 = new CajaCobro("CC1","ROMAN");
//        CajaCobro ca2 = new CajaCobro("CC2","LAURA");
//        CajaCobro ca3 = new CajaCobro("CC3","ANA");
//        CajaCobro ca4 = new CajaCobro("CC4","RODRIGO");
//
//        System.out.println(ca1.getVentaTotal());
//        System.out.println(ca3.getVentaTotal());
//
//        ca1.registrarVenta(1200.00);
//        ca1.registrarVenta(260.00);
//        ca1.registrarVenta(100.00);
//        ca1.registrarVenta(3500.00);
//        ca1.registrarVenta(500.00);
//
//        ca2.registrarVenta(300.00);
//        ca2.registrarVenta(2323.00);
//        ca3.registrarVenta(2393.00);
//        ca1.registrarVenta(560.00);
//
//        ca2.registrarVenta(4305.00);
//
//        //Obetner un valor compartido por todas las instancias de la clase
//        System.out.println(ca4.getVentaTotal());
//        System.out.println(ca2.getVentaTotal());
//
//        //Los miembros estaticos de uan clase pueden ser invocados directamente desde la clase
//        //clase miembro estatico
//        System.out.println(CajaCobro.getVentaTotal());
//        System.out.println(CajaCobro.getNumVentas());

        Iphone ip1 = new Iphone("negro","15PM");
        Iphone ip2 = new Iphone("Azul","13P");
        Iphone ip3 = new Iphone("Blanco","14PM");
        Iphone ip4 = new Iphone("Naranja","17PM");

//        System.out.println(ip1.getSistemaOperativo());
//        System.out.println(ip2.getSistemaOperativo());
//        System.out.println(ip3.getSistemaOperativo());
//        System.out.println(ip4.getSistemaOperativo());


        System.out.println(Iphone.SISTEMA_OPERATIVO);

//        Iphone.setSistemaOperativo("Windows Phone"); // No se puede debido a que es una constante
//        Iphone.setMarca("Xiaomi");// el setter ya no existe porque es constante

        Iphone ip5 = new Iphone("morado","16P");
        Iphone ip6 = new Iphone("Dorado","11");
        Iphone ip7 = new Iphone("Amarillo","5C");
        Iphone ip8 = new Iphone("Verde","5C");

        System.out.println(ip5.SISTEMA_OPERATIVO);
        System.out.println(ip6.SISTEMA_OPERATIVO);
        System.out.println(ip7.SISTEMA_OPERATIVO);
        System.out.println(ip8.SISTEMA_OPERATIVO);

        System.out.println(ip5.MARCA);
        System.out.println(ip6.MARCA);
        System.out.println(ip7.MARCA);
        System.out.println(ip8.MARCA);

        //Modificador Final tiene efecto en 3 niveles:
        //1: Atributo, Crea CONSTANTES
        //2: Metodo, impide la sobrescritura
        //3: Clase. bloquea la herencia

    }
}