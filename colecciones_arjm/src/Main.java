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

//        //tamaño
//        System.out.println(cadenas.size());
//
//        //AGREGAR
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
//
//        //Obtener
//        System.out.println(cadenas.get(3));
//
//        //Imprimir toda la lista de una sola vez
//        System.out.println(cadenas);
//
//        //ELIMINAR VALORES
//        cadenas.remove(2);//eliminar por indice
//        System.out.println(cadenas);
//
//        cadenas.remove("IV");//elimina asandole una copia del valor a eliminar
//        System.out.println(cadenas.size());//.size muestra el tamaño de la cadena
//
//        //CONTIENE?
//        System.out.println(cadenas.contains("5"));
//
//        //INDICE DE
//        System.out.println(cadenas.indexOf("9"));//devuelve - indexof encuentra donde esta el valor por primera vez
//
//        System.out.println(cadenas);
//
//        //indice de la ultima vez de un determinado valor
//        System.out.println(cadenas.lastIndexOf("2"));
//
//        //REMPLAZAR
//        cadenas.set(cadenas.indexOf("5"),"doce" );//remplaza el valor que le indiquemos .set remplaza index off encuentra el valor
//        System.out.println(cadenas);

        Map<String,String> registro = new HashMap<String,String>();
        //Agregar un elemento al mapa

        registro.put("SADAAS","Ford Focus Rojo 2020");
        registro.put("SSFSF","Chevrolet Corvet Azul 2015");
        registro.put("GEEGXV","VW Teramot negro 2020");
        registro.put("HRTJEFW","Mercedes Benz SLR Mclaren Gris 2005");
        registro.put("QQFGGHE","Audi Q7 Azul Obscuro 2019");
        registro.put("JTRYERG","Nissan 400ZX Verde 1999");
        registro.put("QWERJDF","Nissan Maxima Negro 2014");

        System.out.println(registro); //Imprime los datos dentro de la tabla
        System.out.println(registro.size()); //Imprime el tamaño .size

        System.out.println(registro.get("QQFGGHE"));// MUESTRA los datos solo de la key ingresada

        System.out.println(registro.get("SFGSSD")); //Devuelve el null (si no existe la llave)

        //Eliminar registro, LLave y valor
        registro.remove("SADAAS"); //Eliminandoel primer registro
        System.out.println(registro.get("SADAAS")); //devolvera null por que ya esta eliminado

        //eliminar solo si la llave esta asociada al valor indicado
        registro.remove("SSFSF" , "Chevrolet Corvet Azul 2015");
        System.out.println(registro.size());
        registro.remove("SSFSF" , "Nissan Maxima Negro 2014");//si la placa no esta asociada al valor, no se elimina
        System.out.println(registro.size());

        //existe la placa (key) ?

        System.out.println(registro.containsKey("GEEGXV"));//Busca si existe la key ingresada

        //existe el auto (value)?
        System.out.println(registro.containsValue("Nissan Maxima Negro 2014"));//Busca si existe el valor indicado

        System.out.println("-----------------------------------------");
        //Por cada elemento(llave) dentro de : keySet - devuelve solo el conjunto de llaves
        for(String llave: registro.keySet()){
            System.out.println(registro.get(llave));//imprime los valores dentro de la llave
        }
        System.out.println("-------------------------------------------");

        //por cada elemento (valor) dentro de values() : devuelve solo el conjunto de valores
        for(String valor: registro.values()){
            System.out.println(valor);//imprime los valores dentro de la llave
        }

        //Sobre escribe el valor asociado
        System.out.println(registro.get("------: " + "QWERJDF"));
        registro.put("QWERJDF","BMW M5 Competition Black 2008");
        System.out.println(registro.get("------: " + "QWERJDF"));
        
    }
}