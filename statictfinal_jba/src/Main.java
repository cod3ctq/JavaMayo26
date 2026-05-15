//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
public static void main(String[] args) {

    //static}: crear miembros de clase, que pertenecen a la clase y comparten su estado con
    // todas las instancias de esa clase.

    //final: Aplica la inmutabilidad.


//    CajaCobro ca1 = new CajaCobro("CC1", "ROMAN");
//    CajaCobro ca2 = new CajaCobro("CC2", "LAURA");
//    CajaCobro ca3 = new CajaCobro("CC3", "ANA");
//    CajaCobro ca4 = new CajaCobro("CC4", "RODRIGO");
//
//
//    System.out.println(ca1.getVentaToltal());
//    System.out.println(ca3.getVentaToltal());
//
//
//    ca1.registrarVenta(1200);
//    ca1.registrarVenta(2000);
//    ca1.registrarVenta(1500);
//    ca1.registrarVenta(1000);
//
//    ca2.registrarVenta(1200);
//    ca2.registrarVenta(500);
//    ca3.registrarVenta(400);
//    ca1.registrarVenta(800);
//
//    ca2.registrarVenta(4200);
//
//    //obtener un valor compartido por todas las instancias de la clase
//    System.out.println(ca2.getVentaToltal());
//    System.out.println(ca4.getVentaToltal());
//
//    //LOS MIEMBROS ESTATICOS DE UNA CLASE PUEDEN SER INVOCADOS DIRECTAMENTE DESDE LA CLASE
//    //clase.miembroestatico
//    System.out.println(CajaCobro.getVentaToltal());
//    System.out.println(CajaCobro.getNumVentas());


    Iphone ip1 =  new Iphone("Negro", "15PM");
    Iphone ip2 =  new Iphone("Azul", "13P");
    Iphone ip3 =  new Iphone("Blanco", "14PM");
    Iphone ip4 =  new Iphone("Naranja", "17PM");

//    System.out.println(ip1.getSistemaOperativo());
//    System.out.println(ip2.getSistemaOperativo());
//    System.out.println(ip3.getSistemaOperativo());
//    System.out.println(ip4.getSistemaOperativo());

    System.out.println(Iphone.SISTEMA_OPERATIVO);

    // Iphone.SISTEMA_OPERATIVO ="GHAJS" // NO SE PUEDE DEBIDO A QUE ES UNA CONSTANTE
    Iphone ip5 =  new Iphone("Morado", "16PM");
    Iphone ip6 =  new Iphone("Dorado", "11");
    Iphone ip7 =  new Iphone("Amarillo", "5c");
    Iphone ip8 =  new Iphone("Verde", "5c");

    System.out.println(ip5.SISTEMA_OPERATIVO);
    System.out.println(ip6.SISTEMA_OPERATIVO);
    System.out.println(ip7.SISTEMA_OPERATIVO);
    System.out.println(ip8.SISTEMA_OPERATIVO);

    System.out.println(ip5.MARCA);
    System.out.println(ip6.MARCA);
    System.out.println(ip7.MARCA);
    System.out.println(ip8.MARCA);

    //Modificador final tiene efecto en 3 niveles:
    //1. Atributo, crea constantes.
    //2. Metodo, impide la sobreescritura.
    //3. Clase bloquea la herencia





  }
}