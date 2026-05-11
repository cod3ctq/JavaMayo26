import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {
        String ruta="C:\\Users\\RENE PC\\Desktop\\datos.txt";
        String linea;
        String[] datos;
        File file = new File(ruta); //representacion del archivo pero en memoria
        File escritura = new File("C:\\Users\\RENE PC\\Desktop\\escritura.txt");

        try {
            FileReader fr = new FileReader(file); //cache
            BufferedReader br = new BufferedReader(fr); // lectura del cache
            FileWriter fw = new FileWriter(escritura); //apuntador hacia el archivo donde se esceribiran los datos

            while ((linea = br.readLine()) != null) {

                // System.out.println(linea);
                //cortar cadena de texto
                //System.out.println(linea.substring(5));
                //System.out.println(linea.substring(12));
                datos = linea.split(" "); //devuelve un array de Strings con todos los elememntos separados
                //System.out.println(datos[0] + " " + datos[1] + " " + datos[3] );

//                //filtrar si datos[0] (nombre, termina con una e
//                if (datos[0].endsWith("A") && datos[0].startsWith("D")){
//                   // System.out.println(datos[0] + " " + datos[1] + " " + datos[3] );
//                }
//                //buscar las personas que su apellido contiene doble r
//                if (datos[1].contains("RR")){
//                    System.out.println(datos[0] + " " + datos[1] + " " + datos[3] );
//                }

                //Filtrar todas las personas nacidas despues del 95
                int año = Integer.parseInt(datos[3].substring(6));
//                if (año>1995){
//                    System.out.println(datos[0] + " " + datos[1] + " " + datos[3] );
//                }
//
                //filtrar todos los hombres que:
                // su nombre termine con una o y
                //su apellido materno contenga una z

                String datosFiltrados;
                if (datos[0].endsWith("O") && datos[2].contains("A") && datos[4].equals("M")) {

                    datosFiltrados = datos[0] + " " + datos[2] + " " + datos[5];

                    //escritura en el nuevo archivo
                    fw.write(datosFiltrados.toLowerCase()+"\n");
                }
            }

        fw.close();

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}