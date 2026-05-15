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
        //Puede haber mas tipos (clases) que la implementen

        List<String> cadenas = new ArrayList<String>();

        System.out.println(cadenas.size());

        //agregar

        cadenas.add("1");
        cadenas.add("2");
        cadenas.add("tres");
        cadenas.add("IV");
        cadenas.add("5");
        cadenas.add("IV");
        cadenas.add("2");

        System.out.println(cadenas.size());

        //obtener

        System.out.println(cadenas.get(3));

        //Imprimir toda la lista de una sola vez
        System.out.println(cadenas);

        //eliminar
        cadenas.remove(2);  //eliminar por indice
        System.out.println(cadenas);

        cadenas.remove("IV"); //elimina pasandole una copia del valor a eliminar
        System.out.println(cadenas);

        //contiene?
        System.out.println(cadenas.contains("5"));

        //indice de
        System.out.println(cadenas.indexOf("2"));

        //indice de la ultima vez de un determinado valor
        cadenas.add("2");
        System.out.println(cadenas.lastIndexOf("2"));

        //reemplazar
        cadenas.set(cadenas.indexOf(2),"doce");
        System.out.println(cadenas);

        //tamanio
        cadenas.size();


        //MAPA

        Map<String, String> registro = new HashMap<String, String>();

        //Agregar un registro al mapa
        registro.put("HF34F3","Ford Focus rojo 2020");
        registro.put("F83133","Chevrolet Corvette Azul 2015");
        registro.put("GRT323","VW Teramont Negro 2020");
        registro.put("H46329","Mercedes Benz SLR McLaren gris 2015");
        registro.put("HH4612","Audi Q7 Azul oscuro 2019");
        registro.put("H42013","Nissan 400zx verde 1999");
        registro.put("JS0811","Nissan Maxima negro 2014");

        System.out.println(registro);
        System.out.println(registro.size()); //tamanio del mapa

        System.out.println(registro.get("HH4612"));// dEVUELVE AUDi
        System.out.println(registro.get("HESD83")); // devuelve null no existe

        //eliminar registro
        registro.remove("HF34F3"); //eliminando al focus rojo

        //eliminar solo si la llave esta asociada al valor indicado
        registro.remove("F83133","Chevrolet Corvette Azul 2015");
        System.out.println(registro.size());

        //Existe la placa? (key)
        System.out.println(registro.containsKey("GRT323"));

        //Existe el valor? (value)
        System.out.println(registro.containsValue("Mercedes Benz SLR McLaren gris 2015"));

        //Por cada elemento (llave) dentro de
        for (String llave: registro.keySet()){
            System.out.println(registro.get(llave));
        }


        for (String valor: registro.values()){
            System.out.println(valor);
        }


    }
}