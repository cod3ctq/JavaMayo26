import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<String> cadenas = new ArrayList<>();
        // Con una lista podemos:
        // Agregar valores
        cadenas.add("1");
        cadenas.add("Dos");
        cadenas.add("Three");
        cadenas.add("IV");
        cadenas.add("5");
        cadenas.add("1");
        // Obtener el tamaño
        System.out.println(cadenas.size());
        // Obtener un valor en específico
        System.out.println(cadenas.get(2));
        // Imprimir toda la lista de una sola vez
        System.out.println(cadenas);
        // Eliminar
        cadenas.remove(1); // Eliminar por índice
        System.out.println(cadenas);
        cadenas.remove("Three"); // Elimina pasándole una copia del valor a eliminar
        System.out.println(cadenas);
        System.out.println(cadenas.size()); // = 3, ya que borramos 2 elementos
        // Contiene ?
        System.out.println(cadenas.contains("IV")); // = true
        // IndiceDe
        System.out.println(cadenas.indexOf("1")); // = 2
        System.out.println(cadenas.lastIndexOf("1"));
        // Reemplazar
        cadenas.set(cadenas.lastIndexOf("1"), "Uno");
        System.out.println(cadenas);

        Map<String, String> registro = new HashMap<>();
        // Agregar registros al mapa
        registro.put("ABC123", "Ford Focus Rojo 2020");
        registro.put("DEF456", "Chevrolet Corvette Azul 2015");
        registro.put("GHI789", "VW Teramont Negro 2020");
        registro.put("JKL123", "Mercedes Benz SLR Mclaren Gris 2005");
        registro.put("MNO456", "Audi Q7 Azul Oscuro 2019");
        registro.put("PQR789", "Nissan 400ZX Verde 1999");
        registro.put("STU123", "Nissan Maxima Negro 2014");

        System.out.println(registro); // Imprime mapa completo
        System.out.println(registro.size()); // Imprime tamaño del mapa
        System.out.println(registro.get("MNO456")); // Imprime sólo el valor asociado a esa llave valor
        System.out.println(registro.get("XXX000")); // Devuelve "null", ya que no eciste la llave valor
        registro.remove("ABC123"); // Eliminamos el Ford Focus Rojo
        System.out.println(registro.get("ABC123")); // Debe devolver "null" porque lo acabamos de eliminar

        // Eliminar SOLO SI la llave está asociada al valor indicado, sino no lo elimina
        registro.remove("DEF456", "Chevrolet Corvette Azul 2015"); // Usamos llave valor y el valor asociado
        System.out.println(registro.size()); // Devuelve el tamaño del mapa (cuántos elementos tiene)
        System.out.println(registro.containsKey("GHI789")); // El mapa contiene esta llave? Devuelve boolean
        System.out.println(registro.containsValue("VW Teramont Negro 2020")); // El mapa contiene este valor? Devuelve boolean

        System.out.println("-------------------------");
        // Iteramos con ciclo forEach para las colecciones
        // Iteramos sobre las llaves valor
        for (String llave : registro.keySet()) { // Se lee: "Por cada elemento (llave) dentro de keySet()(el conjunto de llaves)"
            System.out.println(llave); // Se imprimen sólo las llaves del mapa
            System.out.println(registro.get(llave)); // Imprime sólo los valores asociados a cada llave que se está iterando
        }
        System.out.println("-------------------------");
        // Iteramos sobre los valores, no las llaves
        for (String valor : registro.values()) { // Se lee: "Por cada registro (valor) dentro de values()(los valores del mapa)"
            System.out.println(valor); // Se imprimen sólo los valores del mapa
        }
        System.out.println("-------------------------");
        System.out.println(registro.get("STU123")); // Imprimimos el valor asociado a esta llave
        registro.put("STU123", "BMW M5 Competition Black 2008"); // Sobre escribimos el valor asociado a esta llave
        System.out.println(registro.get("STU123")); // Volvemos a imprimir pero con el nuevo valor asociado
    }
}