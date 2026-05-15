import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        //List es una interface
        //ArrayList es una clase que implementa esta interface
        //Puede haber mas tipos (clases) que la implementen.

        List<String> cadenas = new ArrayList<String>();

//        System.out.println(cadenas.size());
//
//
//
//        //Agregar
//        cadenas.add("1");
//        cadenas.add("2");
//        cadenas.add("tres");
//        cadenas.add("IV");
//        cadenas.add("tres");
//        cadenas.add("5");
//        cadenas.add("2");
//        cadenas.add("1");
//        cadenas.add("tres");
//        cadenas.add("2");
//        cadenas.add("ocho");
//        System.out.println(cadenas.size());
//        //Obtener
//        System.out.println(cadenas.get(3));
//        //Imprimir toda la lista de una sola vez
//        System.out.println(cadenas);
//        //Eliminar
//        cadenas.remove(2); //Eliminar por indice.
//        System.out.println(cadenas);
//
//        cadenas.remove("IV"); //Eliminar pasandole una copia del valor a eliminar
//        System.out.println(cadenas.size());
//        //Contiene?
//        System.out.println(cadenas.contains("5"));
//        //Indice devuelve el indice donde encuentra por primera vez al elemento indicado
//        System.out.println(cadenas.indexOf("2"));
//
//
//        System.out.println(cadenas);
//        //Indice de la ultima vez de un determinado valor.
//        System.out.println(cadenas.lastIndexOf("2"));
//
//        //Reemplazar
//        cadenas.set(cadenas.indexOf("5"),"doce");
//        System.out.println(cadenas);
//
//
//        //Tamaño

        Map<String, String> registro = new HashMap<String, String>();

        // Agregar un registro al mapa
        registro.put("HF34F3","Ford Focus Rojo 2020");
        registro.put("HVMIF6","Chevrolet Corvette Azul 2015");
        registro.put("JF8975","VW Teramont Negro 2020");
        registro.put("HJNI26","Mercedes Benz SLR Mclaren Gris 2005");
        registro.put("HSUA85","Audi Q7 Azul Oscuro 2019");
        registro.put("UHDS78" ,"Nissan 400ZX Verde 1999");
        registro.put("OAID62","Nisan Maxima Negro 2014");

        System.out.println(registro); //Esta linea imprime el mapa completo
        System.out.println(registro.size()); //Esta linea de codigo imprime el tamaño del mapa

        System.out.println(registro.get("HSUA85")); // Devuelve el valor del Audi Q7 Azul Oscuro 2019
        System.out.println(registro.get("HSUA84")); // Devuelve null, ya que es una llave que no existe.

        // Eliminar un registro, es decir llave y valor.
        registro.remove("HF34F3"); //Con el metodo remote elimino al Focus Rojo
        System.out.println(registro.get("HF34F3")); // Si lo imprimo debe de devolver un valor "Null" ya que lo acabo de eliminar

        // Eliminar SOLO si la llave esta asociada al valor indicado.
        //SINO, NO LO ELIIMINA.
        registro.remove("HVMIF6", "Chevrolet Corvette Azul 2015"); //Si lo elimino
        registro.remove("HVMIF6", "Nissan 400ZX Verde 1999"); //No lo elimino
        System.out.println(registro.size());

        //Existe la placa (key)?
        System.out.println(registro.containsKey("JF8979"));



        //Existe el auto (value)?
        System.out.println(registro.containsValue("Nisan Maxima Negro 2014"));

        System.out.println("-------------------");
        //Por cada elemento (llave) dentro de (:) key set() : Devuelve solo el conjunto de las llaves.
        for(String llave : registro.keySet()){
            System.out.println(llave); //Imprime el objeto asociado de cada llave
        }

        System.out.println("##############################");
        //Por cada elemento (llave) dentro de (:) key set() : Devuelve solo el conjunto de valores.
        for(String valor : registro.values()){
            System.out.println(valor); //
        }


        System.out.println(">>>>>>>>>>: "+registro.get("OAID62"));
        registro.put("OAID62", "BMW M5 Competition Black 2008");
        System.out.println(">>>>>>>>>>: "+registro.get("OAID62"));





    }
}