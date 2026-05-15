import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        //List es una interface
//        //Arraylist es una clase  que implementa  esta interface
//        //Puede  haber mas tipos (clases) que la implementan
//
//        //tamano
//        List<String> cadenas = new ArrayList<String>();
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
//        System.out.println(cadenas.size());
//        //obtener
//        System.out.println(cadenas.get(3));
//        //imprimir toda la cadena
//        System.out.println(cadenas);
//        //eliminar
//        cadenas.remove(2);
//        System.out.println(cadenas.size());
//        cadenas.remove("IV");
//        System.out.println(cadenas);
//        //contiene   ----  elimina pasandole una copia del valor a eliminar
//        System.out.println(cadenas.contains("5"));
//        //indiceDe
//        System.out.println(cadenas.indexOf("2"));// devuelve
//
//        //indice de la ultima vez de un determinado valor
//        System.out.println(cadenas.lastIndexOf("2"));
//
//        //reemplazar
//        cadenas.set(cadenas.indexOf("5"),"doce");
//        System.out.println(cadenas);
//

        Map<String, String> registro = new HashMap<String, String>();

        //agregar un registro al mapa
        registro.put("HF34F3", "Ford Focus Rojo 2020");
        registro.put("F8734", "Chrevolet Corvette Azul 2015");
        registro.put("GRTES6", "VW Teramont Negro 2020");
        registro.put("H467HE", "Mercedez Benz SLR McLaren Gris 2005");
        registro.put("HH4634", "Audi Q7 Azul Oscuro 2019");
        registro.put("H4H6H7", "Nissan 400zx Rojo 1999");
        registro.put("J474JA", "Nissan Maxima Rojo 2020");

        System.out.println(registro);//imprime al mapa completo
        System.out.println(registro.size());//imprime tamano

        System.out.println(registro.get("HH4634"));
        System.out.println(registro.get("HH463"));// Devuelve null si no existe la llave
        //Eliminar un registro llave y valor

        registro.remove("HF34F3");// Eliminando al focus rojo
        System.out.println(registro);
        System.out.println(registro.get("HF34F3"));//devuelve null porque se acaba de eliminar el valor

        //eliminar solo si la llave esta asociada al valor indicado
        registro.remove("F8734", "Chrevolet Corvette Azul 2015");//Este metodo tiene una validacion
        //Ya incluida, en la cual si el valor de la llave no coincide con su llave, simplemente no
        //hace la operacion
        System.out.println(registro.size());
        //existe la placa(key)?
        System.out.println(registro.containsKey("GRTES65"));
        //existe el auot(key value)?
        System.out.println(registro.containsValue("Nissan Maxima Rojo 2020"));

        //Por cada elemento(llave) dentro de
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");

        for (String llave : registro.keySet()) {
            System.out.println(registro.get(llave)); //imprime el objeto asociado a cada llave

        }
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        //Por cada elemento(valor) dentro de values(): devuelve solo el conjunto de valores
        for (String valor : registro.values()){
            System.out.println(valor);
        }

        System.out.println(registro.get("J474JA"));
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        registro.put("J474JA","BMW M5 Competition Black 2008");
        System.out.println(registro.get("J474JA"));

    }
}