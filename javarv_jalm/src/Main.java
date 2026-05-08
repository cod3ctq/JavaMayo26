import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        String ruta = "C:\\Users\\angel\\OneDrive\\Escritorio\\datos.txt";
        String linea;
        String[] datos;
        File file = new File(ruta); // representacion del archivo en memoria
        File escritura = new File("C:\\Users\\angel\\OneDrive\\Escritorio\\escritura.txt");

        try {
            FileReader fr = new FileReader(file); // cache
            BufferedReader br = new BufferedReader(fr); // lectura del cache
            FileWriter fw = new FileWriter(escritura);

            while ((linea = br.readLine()) != null) {
                // System.out.println(linea);
                // cortar cadena de texto
                // System.out.println(linea.substring(5));
                // System.out.println(linea.substring(0,16) + " " + linea.substring(23,33));
                // [CARLOS,HERNANDEZ,LOPEZ,12/04/1994, M, PUEBLA]

                datos = linea.split(" "); // devuelve un array de Strings con todos los elementos separados
                // System.out.println(datos[0] + " " + datos[1] + " " + datos[3]);

//                // filtrar si datos[0] (nombre), termina con una e y empiece con una D
//                if (datos[0].endsWith("A") && datos[0].startsWith("D")) {
//                    System.out.println(datos[0] + " " + datos[1] + " " + datos[3]);
//                }
//
//                // Buscar las personas que su apellido paterno contiene RR
//                if (datos[1].contains("RR")) {
//                    System.out.println(datos[0] + " " + datos[1] + " " + datos[3]);
//                }

                // filtrar todas las personas nacidas despues del 95
                int anio = Integer.parseInt(datos[3].substring(6));

//                if (anio > 1995) {
//                    System.out.println(datos[0] + " " + datos[1] + " " + datos[3]);
//                }

                // filtrar todos los hombres que:
                // su nombre termine con una O y
                // su apellido materno contenga una A

                // Imprimir el estado
                String datosFiltrados;
                if (datos[0].endsWith("O") && datos[2].contains("A") && datos[4].equals("M")) {
                    datosFiltrados = datos[0] + " " + datos[2] + " " + datos[5];
                    // escritura en el nuevo archivo
                    //replace busca el caracter indicado y lo remplaza por otro carcater
                    fw.write(datosFiltrados.toLowerCase().replace("","$") + "\n");
                }
            }

            fw.close(); //Compromete los cambios en el archivo
            br.close();
            fr.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
