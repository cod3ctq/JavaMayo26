import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {
        // LEER UN ARCHIVO .txt
        String ruta = "C:\\Users\\carlo\\OneDrive\\Escritorio\\datos.txt"; // Ruta del archivo
        String linea; // Se almacenará cada línea en esta variable con el while
        String[] datos; // Declaramos un array de tipo String
        File file = new File(ruta); // Definimos objeto de la clase File y le pasamos la ruta, es la representación del archivo en memoria
        File escritura = new File("C:\\Users\\carlo\\OneDrive\\Escritorio\\escritura.txt"); // Nuevo Objeto de tipo File con nueva ruta de otro archivo

        try { // Bloque try siempre que trabajemos con archivos
            FileReader fr = new FileReader(file); // Captura la información que voy a leer, caché
            BufferedReader br = new BufferedReader(fr); // Hacemos la lectura del archivo, del caché
            FileWriter fw = new FileWriter(escritura); // Apuntador hacia el archivo en donde se escribirán los datos

            // ".readLine()" para leer cada línea a través del "br" y lo almacenamos en la variable "linea"
            while ((linea = br.readLine()) != null) { // Mientras que "linea" sea diferente de "null", o sea que sí tiene contenido
//                System.out.println(linea); // Imprimimos línea por línea
                // Cortar cadena de texto
//                System.out.println(linea.substring(5)); // Indicamos a partir de qué índice queremos cortar y se va hasta el final
//                System.out.println(linea.substring(0, 16) + " " + (linea.substring(23, 33))); // Indicamos desde qué índice y hasta cuál, el último índice no se incluye

                // Metodo ".split" separa la cadena en secciones cada que encuentra lo que le indiquemos, y lo almacenamos en cada posición del array que declaramos
                datos = linea.split(" "); // Devuelde un array de tipo String con todos los elementos separados de cada línea
//                System.out.println(datos[0] + " " + datos[1] + " " + datos[3]);

                // Filtramos si datos[0] (nombre), termina con una e
                // Metodo de Strings ".endsWith()" para buscar cadenas que terminen con algún caracter o caracteres en específico y ".startsWith" igual pero que empiece
//                if (datos[0].endsWith("A") && datos[0].startsWith("D")) {
//                    System.out.println(datos[0] + " " + datos[1] + " " + datos[3]);
//                }

                // Buscamos personas que su apellido paterno contenga RR
//                if (datos[1].contains("RR")) { // Metodo de Strings ".contains()" para buscar cadenas que contengan caracteres en específico en cualquier posición
//                    System.out.println(datos[0] + " " + datos[1] + " " + datos[3]);
//                }

                // Filtramos las personas nacidas después del 95
//                int anoNacimiento = Integer.parseInt(datos[3].substring(6)); // Convertimos los 4 dígitos del año a enteros
//                if (anoNacimiento > 1995) { // Si el año es mayor a 1995
//                    System.out.println(datos[0] + " " + datos[1] + " " + datos[3]);
//                }

                // Filtramos todos los hombres que:
                // Su nombre termine con O
                // Su apellido materno contenga una Z
                // Imprimir el estado
                if (datos[4].equals("M") && datos[0].endsWith("O") && datos[2].contains("A")) {
                    String datosFiltrados = datos[0] + " " + datos[1] + " " + datos[3] + " " + datos[5]; // Almacenamos información filtrada en una nueva variable
                    // Escribimos los datos en el nuevo archivo con el Metodo ".write()" en la variable "fileWriter", convertimos a minúsculas y reemplazamos espacios
                    fw.write(datosFiltrados.toLowerCase().replace(" ", "$") + "\n");
                }
            }
            fw.close(); // Cerramos variable "fileWriter" para que se guarde lo que escribimos en el archivo (cierra el flujo)
        } catch (Exception e) { // Cachamos la excepción
            System.out.println(e.getMessage()); // Imprimimos el mensaje
        }
    }
}