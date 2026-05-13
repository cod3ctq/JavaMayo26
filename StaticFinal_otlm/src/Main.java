//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //static: Crear miembros de clase, que pertenecen a la clase y comparten su estado con
        //todas las instancias de la clase

        //final : Aplica la inmutabilidad

//        CajaCobro ca1 = new CajaCobro("CC1", "DANIEL");
//        CajaCobro ca2 = new CajaCobro("CC2", "ITZEL");
//        CajaCobro ca3 = new CajaCobro("CC3", "OMAR");
//        CajaCobro ca4 = new CajaCobro("CC4", "LUIS");
//
//        System.out.println(ca1.getVentaTotal());
//
//        ca1.registrarVenta(1000);
//        ca1.registrarVenta(520);
//        ca1.registrarVenta(20);
//        ca1.registrarVenta(875);
//        ca1.registrarVenta(503);
//
//        ca2.registrarVenta(420);
//        ca3.registrarVenta(320);
//        ca1.registrarVenta(100);
//        ca3.registrarVenta(896);
//        ca2.registrarVenta(1235);
//
//        ca3.registrarVenta(125);
//        ca2.registrarVenta(8000);
//        ca2.registrarVenta(1503);
//        ca2.registrarVenta(4500);
//        ca1.registrarVenta(10000);
//
//        //Obtener un valor compartido por todas las instancias de la clase
//        System.out.println(ca4.getVentaTotal());
//        System.out.println(ca2.getVentaTotal());
//
//        //Los miembros estaticos de una clase pueden ser invocados directamente desde la clase
//        //Clase .miembroestatico
//        System.out.println(CajaCobro.getVentaTotal());
//        System.out.println(CajaCobro.getNumVentas());

        Iphone ip1 = new Iphone("Negro", "15PM");
        Iphone ip2 = new Iphone("Azul", "13P");
        Iphone ip3 = new Iphone("Blanco", "14PM");
        Iphone ip4 = new Iphone("Naranja", "17PM");

//        System.out.println(ip1.getSistemaOperativo());
//        System.out.println(ip2.getSistemaOperativo());
//        System.out.println(ip3.getSistemaOperativo());
//        System.out.println(ip4.getSistemaOperativo());

        System.out.println(Iphone.SISTEMA_OPERATIVO);

        //No se pueden reasignar porque es una constante
//        Iphone.SISTEMA_OPERATIVO = "Android";
//        Iphone.setMarca("Xiaomi");

        Iphone ip5 = new Iphone("Morado", "16P");
        Iphone ip6 = new Iphone("Dorado", "11");
        Iphone ip7 = new Iphone("Amarillo", "5c");
        Iphone ip8 = new Iphone("Verde", "5c");

        System.out.println(ip5.SISTEMA_OPERATIVO);
        System.out.println(ip6.SISTEMA_OPERATIVO);
        System.out.println(ip7.SISTEMA_OPERATIVO);
        System.out.println(ip8.SISTEMA_OPERATIVO);

        System.out.println(ip5.MARCA);
        System.out.println(ip6.MARCA);
        System.out.println(ip7.MARCA);
        System.out.println(ip8.MARCA);

        //Modificador Final tiene efecto en 3 niveles:
        //1 Atributo : Crea constantes
        //2 Metodo : Impide la sobreescritura
        //3 Clase : Bloquea la herencia, si se puede instanciar
        
    }
}