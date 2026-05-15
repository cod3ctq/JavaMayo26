import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //list es una interface
        //Arraylist es una clase que implementa esta interface
        //puede haber mas tipos(clases) que la implementen

        List<String> cadenas = new ArrayList<String>();
//        //tamaño
//        System.out.println(cadenas.size());
//
//        //Agregar
//        cadenas.add("1");
//        cadenas.add("2");
//        cadenas.add("tres");
//        cadenas.add("IV");
//        cadenas.add("5");
//        cadenas.add("tres");
//        cadenas.add("IV");
//        cadenas.add("5");
//        cadenas.add("1");
//        cadenas.add("2");
//        cadenas.add("ocho");
//        System.out.println(cadenas.size());
//
//
//
//
//        //Obtener
//        System.out.println(cadenas.get(3));
//
//        //imprimir toda la lista de una sola vez
//        System.out.println(cadenas);
//
//
//        System.out.println(cadenas.indexOf("tres"));
//        //eliminar un elmento por posicion;
//        cadenas.remove(0);
//        //eliminar por copia del elemento.
//        cadenas.remove("5");
//        System.out.println(cadenas);
//
//
//
//        //contiene?
//        System.out.println(cadenas.contains("IV"));
//
//        //indiceDe
//        System.out.println(cadenas.indexOf("2")); //indica el indice donde encuentra por primera vez al elemento indicado.
//        System.out.println(cadenas);
//        //indice de la ultima vez de un determinado valor.
//        System.out.println(cadenas.lastIndexOf("2"));
//
//        //reemplazar
//        cadenas.set(cadenas.indexOf("5"), "doce");
//        System.out.println(cadenas);
//
//        //borra todos los elementos del Arraylist
//       cadenas.clear();
//        System.out.println(cadenas);

        Map<String, String> registro = new HashMap<String,String>();


        //agregar un elemento al mapa
        registro.put("HF34F3","Ford Focus Rojo 2020");
        registro.put("HJ78G6","Chevrolet Corvett Azul 2015");
        registro.put("TG65H6","VW Teramont Negro 2023");
        registro.put("AA69A1","Ford Fiesta Blanco 2019");
        registro.put("QW12Z9","Nissan Sentra Vino 2025");
        registro.put("LL86W3","Ford Raptor Verde 2018");
        registro.put("JK77P0","Nissan Maxima Rojo 2016");


        System.out.println(registro); //imprime al mapa completo.
        System.out.println(registro.size()); //imprime el tamaño

        System.out.println(registro.get("HJ78G6"));
        System.out.println(registro.get("HHHHHH"));

        //eliminar un registro(Llave, valor)
        registro.remove("AA69A1");//eliminar al ford fiesta
        //System.out.println(registro.remove("AA69A1")); //debe devolver null, por que se acaba de eliminar.

        //Elimina solo SI ESTA Asociada al valor indicado
        //SINO no lo elimina
        registro.remove("JK77P0", "Nissan Maxima Rojo 2016"); //Si lo elimina
        registro.remove("JK77P0", "Nissan Sentra Vino 2025"); //No lo elimina
        System.out.println(registro.size());

        //exisrte la placa?
        System.out.println(registro.containsKey("QW12Z9"));

        //existe el auto(value)
        System.out.println(registro.containsValue("Chevrolet Corvett Azul 2015"));

        System.out.println("--------------------------------------");
        //por cada elemento (llave) dentro de keySet() : imprime solo el conjunto de llaves
        for (String llave : registro.keySet()){
            System.out.println(llave); //Imprime el objeto asociado a cada llave
        }
        System.out.println("--------------------------------------");
        //por cada elemento (valor) dentro de values() : imprime solo el conjunto de valores
        for (String valor : registro.values()){
            System.out.println(valor); //Imprime el objeto asociado a cada valor
        }

        System.out.println("HJ78G6");
        registro.put("HJ78G6", "Nissan Tsuru Gris 2012");
        System.out.println(">>>>>>>>>: "+registro.get("HJ78G6"));



    

    }
}