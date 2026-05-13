public class Main {
    public static void main(String[] args) {
//        CajaCobro caja1 = new CajaCobro("CC1", "ROMAN");
//        CajaCobro caja2 = new CajaCobro("CC2", "LAURA");
//        CajaCobro caja3 = new CajaCobro("CC3", "ANA");
//        CajaCobro caja4 = new CajaCobro("CC4", "RODRIGO");
//
//        // Imprimimos ventas antes de registrar alguna
//        System.out.println(CajaCobro.getVentaTotal());
//        System.out.println(CajaCobro.getNumVentas());
//
//        caja1.registrarVenta(1200);
//        caja1.registrarVenta(260);
//        caja1.registrarVenta(100);
//        caja1.registrarVenta(3500);
//        caja2.registrarVenta(300);
//        caja2.registrarVenta(2323);
//        caja3.registrarVenta(2393);
//        caja1.registrarVenta(100.00);
//        caja2.registrarVenta(4305);
//
//        // Imprimimos ventas después de registrar varias
//        // Accedemos a los miembros estáticos directamente desde la Clase, no desde una instancia, esto es lo correcto
//        System.out.println(CajaCobro.getVentaTotal());
//        System.out.println(CajaCobro.getNumVentas());

        Iphone ip1 = new Iphone("Negro", "15 Pro Max");
        Iphone ip2 = new Iphone("Azul", "13 Pro");
        Iphone ip3 = new Iphone("Blanco", "14 Pro Max");
        Iphone ip4 = new Iphone("Naranja", "17 Pro Max");

        System.out.println(Iphone.SISTEMA_OPERATIVO);
        System.out.println(Iphone.MARCA);

        //Iphone.SISTEMA_OPERATIVO = "Windows Phone"; // Error, no se puede modificar el dato de una constante

        Iphone ip5 = new Iphone("Morado", "16 Pro");
        Iphone ip6 = new Iphone("Dorado", "11");
        Iphone ip7 = new Iphone("Amarillo", "5C");
        Iphone ip8 = new Iphone("Verde", "5C");

        System.out.println(ip5.SISTEMA_OPERATIVO); // No es correcto obtener los datos static desde una instancia
        System.out.println(ip6.MARCA); // Aunque el IDE lo permita
    }
}