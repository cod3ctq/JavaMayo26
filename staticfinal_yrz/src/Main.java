public class Main{
    public static void main(String[] args){

//        //SON MODIFICADORE QUE ALTERAN EL COMPORTAMIENDO DE VARIABLES; METODOS; OBJETOS
//        //Static: Es uun valor que es compartido por todo un grupo
//        // crea miembros de clase, que pertenecen a la clase  y comparten su estado con todas
//        // las instacias de esa clase:
//
//        //final: Un valor que es definitivo, ya no lo puedes modificar
//        // aplica la inmutabilidad,
//        // STATIC FINAL: Es un valor compartido por un grupo y no se puede modificar
//        // EJEMPLO EL NOMBRE DE UNA ESCUELA; VARIOS ALUMNOS; VARIAS CLASES
//        // PERO EL MISMO NOMBRE
//
//        CajaCobro ca1=new CajaCobro("CC1","JUAN");
//        CajaCobro ca2=new CajaCobro("CC2","ANA");
//        CajaCobro ca3=new CajaCobro("CC3","LAURA");
//        CajaCobro ca4=new CajaCobro("CC4","RODRIGO");
//
//
//        ca1.registrarVenta(1200);
//        ca1.registrarVenta(600);
//        ca1.registrarVenta(200);
//        ca1.registrarVenta(400);
//        ca1.registrarVenta(1200);
//        ca1.registrarVenta(500);
//
//        ca3.registrarVenta(300);
//
//        ca2.registrarVenta(200);
//        ca2.registrarVenta(800);
//        ca2.registrarVenta(300);
//        ca2.registrarVenta(600);
//
//
//        System.out.println(ca4.getVentaTotal());
//
//        //Se acompleta el .get si se llama atraves de la clase, no de una instancia
//        System.out.println(CajaCobro.getVentaTotal());
//        System.out.println(CajaCobro.getNumVentas());
//
//        //los miembros estaticos de una clase pueden ser invocados directamente desde la clase
//        //Clase.miembroestatico
//

        Iphone ip1=new Iphone("negro","12PM");
        Iphone ip2=new Iphone("azul","13PM");
        Iphone ip3=new Iphone("rojo","14PM");
        Iphone ip4=new Iphone("blanco","15PM");
        Iphone ip5=new Iphone("naranja","17PM");

//        System.out.println(ip1.getSistemaOperativo());
//        System.out.println(ip2.getSistemaOperativo());
//        System.out.println(ip3.getSistemaOperativo());
//        System.out.println(ip4.getSistemaOperativo());

        //System.out.println(Iphone.getSistemaOperativo());


      //  Iphone.setSistemaOperativo("Windows phone");
       // Iphone.setMarca("xiaomi");

        //Iphone.SISTEMA_OPERATIVO="windows phone"; no se puede debido a que es una constante
        //el setter ya no existe porque es constante


        Iphone ip6=new Iphone("morado","16");
        Iphone ip7=new Iphone("dorado","11");
        Iphone ip8=new Iphone("amarillo","5c");
        Iphone ip9=new Iphone("verde","5c");
        Iphone ip10=new Iphone("azul","11");

        System.out.println(ip6.SISTEMA_OPERATIVO);
        System.out.println(ip7.SISTEMA_OPERATIVO);
        System.out.println(ip8.SISTEMA_OPERATIVO);
        System.out.println(ip9.SISTEMA_OPERATIVO);


        System.out.println(ip6.MARCA);

        //Modificador final tiene efecto en 3 niveles:
        //1: Atributo, crea constantes
        //2: Metodo, impide la sobreescritura
        //3: Clase, bloquea herencia


    }
}
