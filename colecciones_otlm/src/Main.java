import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

//        List es una interface
//        ArrayList es una clase que implementa esta interface
//        Puede haber mas tipos (clases) que las implementen
         List<String> cadenas = new ArrayList<>();
//
//        //agregar
//        cadenas.add("1");
//        cadenas.add("2");
//        cadenas.add("3");
//        cadenas.add("Cuatro");
//        cadenas.add("V");
//        cadenas.add("5");
//        cadenas.add("seis");
//        cadenas.add("2");
//        cadenas.add("DOS");
//
//
//        //tamaño
//        System.out.println(cadenas.size());
//
//        //obtener
//        System.out.println(cadenas.get(3));
//
//        //imprimir toda lista
//        System.out.println(cadenas);
//
//        //eliminar
//        cadenas.remove(2);
//        System.out.println(cadenas);
//
//        cadenas.remove("IV");
//        System.out.println(cadenas);
//
//        //contiene : devuelve un booleano
//        System.out.println(cadenas.contains("5"));
//        System.out.println(cadenas.contains("IV"));
//        System.out.println(cadenas);
//
//        //indiceDe
//        System.out.println(cadenas.indexOf("2"));
//        System.out.println(cadenas);
//
//        //indice del ultimo valor encontrado
//        System.out.println(cadenas.lastIndexOf("2"));
//        System.out.println(cadenas);
//
//        //reemplazar : pide primero el indice y despues el valor que va a reemplazar
//        System.out.println(cadenas.set(cadenas.indexOf("5"), "doce"));
//        System.out.println(cadenas);

        Map<String, String> registro = new HashMap<String, String>();
        //agregar un registro
        registro.put("AAA0001","Ford Focus Rojo 2020");
        registro.put("AAA0002","KIA K3 Rojo 2024");
        registro.put("AAA0003","Nissan March Gris 2023");
        registro.put("AAA0004","Hyundai HB20 Azul marino 2024");
        registro.put("AAA0005","Toyota Prius Gris 2025");
        registro.put("AAA0006","Nissan V Drive Naranja 2024");
        registro.put("AAA0007","Mazda 2 Negro 2024");
        System.out.println(registro);//devulve el mapa completo
        System.out.println(registro.size());//devuelve el tamaño del mapa

        System.out.println(registro.get("AAA0005"));//devuelve el elemento asociado a la llave
        System.out.println(registro.get("OOOOOOo"));//Deluelve null si no lo encuentra

        //eliminar un registro
        registro.remove("AAA0001");
        System.out.println(registro.get("AAA0001"));

        //eliminar solo si la llave esta asociada al valor indicado
        //SINO no lo elimina
        registro.remove("AAA0003", "Nissan March Gris 2023");
        System.out.println(registro.size());

        //Existe la llave
        System.out.println(registro.containsKey("TTT0005"));

        //Existe el valor (en este caso el auto)
        System.out.println(registro.containsValue("Mazda 2 Negro 2024"));

        //Por cada elemento (llave) dentro de keySet() : devuelve el conjunto de valores
        System.out.println("-------------------------------------------------------------------------------------------------------");
        for(String llave :registro.keySet()){
            System.out.println(registro.get(llave));
        }
        System.out.println("-------------------------------------------------------------------------------------------------------");
        //Por cada elemento (valor dentro de values() . devuelve solo el conjunto de valores)
        for(String valor :registro.values()){
            System.out.println(valor);//imprime el valor obtenido
        }
        System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.println(registro.get("AAA0004"));
        registro.put("AAA0004","Hyundai Elantra Blanco 2020");
        System.out.println(registro.get("AAA0004"));
    }
}