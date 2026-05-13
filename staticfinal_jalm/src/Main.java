public class Main {

    public static void main(String[] args) {

        // Concepto visto en el proyecto:
        // static: se usa cuando un atributo o metodo pertenece directamente a la clase
        // y no a un objeto creado con new. Por eso el metodo main es static: Java puede
        // ejecutarlo al iniciar el programa sin tener que crear primero un objeto de Main.

        // final: se usa para indicar que algo ya no puede cambiar despues de asignarse.
        // En una variable significa que su valor queda fijo; en un metodo evita que se
        // sobrescriba, y en una clase evita que otra clase herede de ella.

        // Aqui se crean 4 objetos de tipo CajaCobro.
        // Cada objeto representa una caja diferente con su id y nombre del cajero.
        CajaCobro ca1 = new CajaCobro("CC1", "ROMAN");
        CajaCobro ca2 = new CajaCobro("CC2", "LAURA");
        CajaCobro ca3 = new CajaCobro("CC3", "ANA");
        CajaCobro ca4 = new CajaCobro("CC4", "RODRIGO");

        // Aqui se registran 7 ventas.
        // Cada venta se agrega a la caja que la hizo.
        // Tambien se suma al total general de todas las cajas.
        ca1.registrarVenta(150.50);
        ca2.registrarVenta(240.00);
        ca3.registrarVenta(99.90);
        ca4.registrarVenta(310.75);
        ca1.registrarVenta(85.25);
        ca2.registrarVenta(420.00);
        ca3.registrarVenta(60.60);

        // Se muestra el total vendido por la caja 1 y cuantas ventas hizo.
        System.out.println("Total ventas caja 1: " + ca1.getVentaTotalCaja());
        System.out.println("Cantidad de ventas caja 1: " + ca1.getNumVentasCaja());

        // Se muestra el total vendido por la caja 2 y cuantas ventas hizo.
        System.out.println("Total ventas caja 2: " + ca2.getVentaTotalCaja());
        System.out.println("Cantidad de ventas caja 2: " + ca2.getNumVentasCaja());

        // Se muestra el total vendido por la caja 3 y cuantas ventas hizo.
        System.out.println("Total ventas caja 3: " + ca3.getVentaTotalCaja());
        System.out.println("Cantidad de ventas caja 3: " + ca3.getNumVentasCaja());

        // Se muestra el total vendido por la caja 4 y cuantas ventas hizo.
        System.out.println("Total ventas caja 4: " + ca4.getVentaTotalCaja());
        System.out.println("Cantidad de ventas caja 4: " + ca4.getNumVentasCaja());

        // Estos datos son generales porque pertenecen a la clase CajaCobro.
        // No son de una caja en especifico, sino de todas las cajas juntas.
        System.out.println("Venta total: " + CajaCobro.getVentaTOtal());
        System.out.println("Numero de ventas: " + CajaCobro.getNumVentas());

        // Aqui se crea un objeto de tipo Iphone llamado ip1.
        // Se le manda su color y modelo usando el constructor con parametros.
        Iphone ip1 = new Iphone("Negro", "15PM");

        // Se muestra la informacion del iPhone.
        // Sistema operativo y marca son static, por eso se llaman desde la clase Iphone.
        // Color y modelo son de instancia, por eso se llaman desde el objeto ip1.
        System.out.println("Sistema operativo: " + Iphone.SISTEMA_OPERATIVO
                + ", Color: " + ip1.getColor()
                + ", Marca: " + Iphone.MARCA
                + ", Modelo: " + ip1.getModelo());

        // Aqui se crean otros 4 objetos de tipo Iphone.
        // Cada uno tiene diferente color y modelo.
        Iphone ip5 = new Iphone("Morado", "16P");
        Iphone ip6 = new Iphone("Dorado", "11");
        Iphone ip7 = new Iphone("Amarillo", "5C");
        Iphone ip8 = new Iphone("Verde", "5C");

        // Aunque SISTEMA_OPERATIVO y MARCA son static final,
        // aqui se muestran usando ip5 para seguir el ejemplo de clase.
        System.out.println(ip5.SISTEMA_OPERATIVO);

        System.out.println(ip5.MARCA);
        System.out.println(ip5.MARCA);
        System.out.println(ip5.MARCA);
        System.out.println(ip5.MARCA);

        // Modificador final tiene efecto en 3 niveles:
        // 1 : Atributo, crea CONSTANTES.
        // 2 : Metodo, evita que el metodo sea sobrescrito.
        // 3 : Clase, evita que la clase pueda ser heredada.

    }
}
