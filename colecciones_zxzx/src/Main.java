import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //List es una interface
        //ArrayList es una clase que implementa esta interface
        //Puede haber mas tipos(clases) que la implementen
        List<String> cadenas = new ArrayList<String>();
//
//        //tamaño
//        System.out.println(cadenas.size());
//
//        //agregar
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
//
//        System.out.println(cadenas.size());
//        //obtener
//        System.out.println(cadenas.get(3));
//        //Imprimir toda la lista de una sola vez
//        System.out.println(cadenas);
//
//        //eliminar
//        cadenas.remove(2); //eliminar por indice
//        System.out.println(cadenas);
//
//        cadenas.remove("IV"); //elimina pasandole una copia del valor a eliminar
//        System.out.println(cadenas.size());
//        //contiene?
//        System.out.println(cadenas.contains("5"));
//
//        //indiceDe devuelve el indice dond encuentra por primera vez al elemento indicado
//        System.out.println(cadenas.indexOf("2"));
//
//        System.out.println(cadenas);
//        //indice de la ultima vez de un determinado valor
//        System.out.println(cadenas.lastIndexOf("2"));
//
//        //reemplazar
//        cadenas.set(cadenas.indexOf("5"), "doce");
//        System.out.println(cadenas);

        Map<String, String> registro = new HashMap<String,String>();

        //agregar un registro al mapa
        registro.put("HF34F3","Ford Focus Rojo 2020");
        registro.put("F8734H","Chevrolet Corvette Azul 2015");
        registro.put("GRTE56","VW Teramont Negro 2020");
        registro.put("H467HE","Mercedes Benz SLR Mclaren Gris 2005");
        registro.put("HH4634","Audi Q7 Azul Oscuro 2019");
        registro.put("H4H6H7","Nissan 400ZX Verde 1999");
        registro.put("J476J4","Nissan Maxima Negro 2014");

        System.out.println(registro); //imprime al mapa completo
        System.out.println(registro.size()); //imprime tamaño

        System.out.println(registro.get("HH4634")); //Devuelve Audi Q7 Azul Oscuro 2019
        System.out.println(registro.get("HHXXXX")); //Devuelve null (no existe la llave)

        //eliminar un registro (llave,valor)
        registro.remove("HF34F3"); //Eliminando al Focus Rojo
        //System.out.println(registro.get("HF34F3")); //Debe devolver null, por que lo acabo de eliminar

        //eliminar SOLO SI la llave esta asociada al valor indicado,
        //SINO, NO LO ELIMINA
        registro.remove("F8734H","Chevrolet Corvette Azul 2015"); //si lo elimino
        registro.remove("F8734H","Nissan 400ZX Verde 1999"); //No lo elimino
        System.out.println(registro.size());

        //existe la placa (key)?
        System.out.println(registro.containsKey("GRTE55"));

        //existe el auto (value)?
        System.out.println(registro.containsValue("Nissan Maxima Negro 2014"));

        System.out.println("----------------------------------------");
        //Por cada elemento(llave) dentro de keySet() : devuelve solo el conjunto de llaves
        for(String llave : registro.keySet()){
            System.out.println(llave); //imprime el objeto asociado a cada llave
        }

        System.out.println("###########################################");
        //Por cada elemento(valor) dentro de values() : devuelve solo el conjunto de valores
        for(String valor : registro.values()){
            System.out.println(valor); //imprime el objeto asociado a cada llave
        }

        System.out.println(">>>>>>>>>>>: "+registro.get("J476J4"));
        registro.put("J476J4","BMW M5 Competition Black 2008");
        System.out.println(">>>>>>>>>>>: "+registro.get("J476J4"));
    }
}