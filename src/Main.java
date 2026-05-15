import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        //List es una interface
//        //ArrayList es una clase que implementa esta interface
//        //Puede haber mas tipos(clases) que la implementen
//        List<String> cadenas = new ArrayList<>();
//
//        //tamaño
//        System.out.println(cadenas.size());
//
//        //agregar
//        cadenas.add("1");
//        cadenas.add("2");
//        cadenas.add("tres");
//        cadenas.add("IV");
//        cadenas.add("5");
//        System.out.println(cadenas.size());
//
//        //obtener
//        System.out.println(cadenas.get(3));
//
//        //Imprimir toda la lista de una sola vez
//        System.out.println(cadenas);
//
//        //eliminar
//        cadenas.remove(index 2); //eliminar por indice
//        System.out.println(cadenas);
//
//        cadenas.remove(o:"IV"); //elimina pasandole una copia  del valor a eliminar
//
//        System.out.println(cadenas.size());
//        //contiene?
//
//        System.out.println(cadenas.contains("5"));
//        //devuelve el indice donde encuentra por primera vez al elemento indicado
//        System.out.println(cadenas.indexOf("9"));
//
//
//        //reemplazar
//
//
//
//        //indice de la utlima vez de un determinado valor
//
//        //agregar

        Map<String, String> registro = new HashMap<String, String>();

        //agregar un registro del mapa
        registro.put("HF34F3","Ford Focus Rojo 2020");
        registro.put("F8345M","Chevrolet Corvette Azul 2015");
        registro.put("P435M5","VW Teramont Negro 2020");
        registro.put("3NJN53","Mercedes Benz SLR Mclarene Gris 2006");
        registro.put("JL456O","Audi A8 Negro 2027");
        registro.put("PR5677","Nissan Versa Rojo 2009");
        registro.put("HF34F3","BMW A6 Blanco 2025");

        System.out.println(registro); //Imprime el mapa completo
        System.out.println(registro.size()); //Imprime tamaño

        System.out.println(registro.get("P435M5")); //Devuelve VW Teramont Negro 2020

       //eliminar un registro (llave valor)
        registro.remove("P435M5"); //Eliminando

        //eliminar solo si la llave esta asociada al valor indicado

        //existe la placa (key)?
        System.out.println(registro.containsKey("PR5677"));


        //existe el auto (value)?
        System.out.println(registro.containsValue("BMW A6 Blanco 2025"));

        //por cada elemento(llave) dentro de keySet() devuelve solo el conjunto de llaves
        for(String llave : registro.keySet()){
            System.out.println(registro.get(llave)); // Imprime el objeto asociado a cada llave

        }

        System.out.println("############################");
        //Por cada elemento(valor) dentro de values () : devuelve solo el conjunto de valores
        for(String llave : registro.values()){
            System.out.println(valor); // Imprime el objeto asociado a cada llave

        }

        System.out.println(">>>>>>>>>>>: "+registro.get("F8345M"));
        registro.put("F8345M","Chevrolet Corvette Azul 2015")







    }
}