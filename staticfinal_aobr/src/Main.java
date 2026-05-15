//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //static: Crear miembros de clase, que pertenecen a la clase y comparten su estado con todas
        //        las instancias de esa clase

        //final: Aplica la inmutabilidad
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

        //Obtener un valor compartido por todas las instancias de la clase
        System.out.println(ca4.getVentaTotal());


        //Los miembros estaticos de una clase pueden ser invocados directamente desde la clase
        System.out.println(CajaCobro.getVentaTotal());
        System.out.println(CajaCobro.getNumVentas());




        ///////////////////////////////////////////////////////////////////////

        Iphone ip1 = new Iphone("Negro","15PM");
        Iphone ip2 = new Iphone("Azul","13P");
        Iphone ip3 = new Iphone("Blanco","14PM");
        Iphone ip4 = new Iphone("Naranja","17PM");

        //System.out.println(Iphone.getSistemaOperativo());
        System.out.println(Iphone.SISTEMA_OPERATIVO);

        //Ya no se puede debido a que es una constante
        //Iphone.setSistemaOperativo("Windows Phone");
        //Iphone.setMarca("Xiaomi");
        Iphone ip5 = new Iphone("Morado", "16P");
        Iphone ip6 = new Iphone("Dorado", "11");
        Iphone ip7 = new Iphone("Amarillo", "5c");
        Iphone ip8 = new Iphone("Verde", "5c");

//        System.out.println(ip5.getSistemaOperativo());
//        System.out.println(ip5.getMarca());
        System.out.println(ip5.SISTEMA_OPERATIVO);
        System.out.println(ip5.MARCA);



    }
}