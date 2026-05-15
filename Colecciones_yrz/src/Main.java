import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Main{
    public static void main(String[] args){

        //list es una interface
        //Arraylost es una clase que implementa esta interface
                // puede haber mas tipos (clases) que la implementen
        List<String> cadenas = new ArrayList<String>();
        // TAMAÑO
        System.out.println(cadenas.size());


        //Agregar
        cadenas.add("hola");
        cadenas.add("3");
        cadenas.add("9");
        cadenas.add("diez");

        System.out.println(cadenas.size());
/*

TAREA CON QUE METODO PODEMOS UTILIZAR ESTAS OPERACIONES
        Obtener

        sout    (cadenas.get(3));

        IMPRIMIR TODA LA LISTA
        sout    (cadenas)
        // indiceDE devuelve el indice donde encuentra por primera vez al elemento indicado
        sout    cadenas.indexOf(3);

        //indice de la ultima vez de un determinado valor
        last.indexOf;

        Eliminar
        .remove

        Contiene
        cadenas.contains

        IndiceDe
        Remplazar
        cadenas.set(cadenas.indexOf("3"), "hola")
        Tamaño
         */

        Map<String, String> registro = new HashMap<String,String>();

            //Agrgar un registro al mapa
            registro.put("HF73JJK", "fORD FOCUS ROJO 2020");
            registro.put("HE02DLL", "NISSA 200C VERDE 2021");
            registro.put("JDLWO354", "JETTA BETTLE NEGRO 2022");
            registro.put("F5L30323", "SEAT XX03 AZUL 2020");
            registro.put("H35EÑRKK", "fORD EROS ROJO 2025");
            registro.put("RK3JDLP3", "TOYOTA COROLLA GRIS 2023");
            registro.put("HF389DLA", "fORD PRIME VERDE 2020");

            System.out.println(registro);
            System.out.println(registro.size());

            System.out.println(registro.get("JDKW0354"));

            //eliminar un registro(llave,valor)
            registro.remove("HF73JJK");
        System.out.println(registro.get("HF73JJK"));

        //Eliminar esolo si la llave esta asociada al valor indicado VALIDA
        registro.remove("F","JDLWO354");

        //existe la placa(key)?
        System.out.println(registro.containsKey("H35EÑRKK"));

        //existe el auto(value)?
        System.out.println("nissam maxima rojo 2018");

        //por cada elemento(llave) dentro de keyset():devuelve solo el conjunto de llaves
        for(String llave: registro.keySet()){
            System.out.println(llave);
           // System.out.println(registro.get(llave)); imprime el valor de llaves
        }
        System.out.println("****************");
        //por cada elemento(valor) dentro de values():devuelve solo el conjunto de valores
        for(String valor: registro.values()){
            System.out.println(valor);
        }
        System.out.println(">>>>>>>"+registro.get("JDLWO354"));
        registro.put("JDLWO354", "JETTA vento azul 2023");
        System.out.println(">>>>>>>"+registro.get("JDLWO354"));

    }

    }
