import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String ruta="C:\\Users\\lgsai\\OneDrive\\Desktop\\datos.txt";
        String linea;
        String[] datos;
        File file = new File(ruta); // representacion del archivo en memoria
        File escritura = new File("C:\\Users\\lgsai\\OneDrive\\Desktop\\escritura.txt");
        try{
            FileReader fr = new FileReader(file); //cache
            BufferedReader br = new BufferedReader(fr); //lectura del cache
            FileWriter fw = new FileWriter(escritura);

            while ( (linea=br.readLine()) !=null) {
                //System.out.println(linea);
                // Cortar cadena de texto
                // System.out.println(linea.substring(5));
                // System.out.println(linea.substring(0,16) +" "+ linea.substring(23,33));

                datos = linea.split(" "); // devuelve un array de strings con todos los elementos separados
                //System.out.println(datos[0] + " "+datos[1]+ " "+datos[3]);

                //Filtrar si datos[0] que en realidad es el nombre termina con una e
                if(datos[0].endsWith("O") && datos[0].startsWith("D")){
                    System.out.println(datos[0] + " "+datos[1]+ " "+datos[3]);
                }
//                //buscar las personas que su apellido paterno contiene RR
//                if(datos[1].contains("RR")){
//                    System.out.println(datos[0]+ " "+ datos[1] + " "+datos[3]);
                // Filtrar todas las personas nacidas despues del 95
                int ano = Integer.parseInt(datos[3].substring(6));

//                if(ano>1995){
//                    System.out.println(datos[0]+ " "+ datos[1] + " "+datos[3]);
//
//                }
                //filtrar todos los hombres que:
                //su nombre termine con una o y
                //su apellido materno contenga una z

                //imprimir el estado

                if(datos[0].endsWith("O") && datos[2].contains("A") && datos[4].equals("M")) {
                    System.out.println(datos[0] + " " + datos[2] + " " + datos[5]);
                    String datosFiltrados = datos[0] + " " + datos[2] + " " + datos[5];

                    //escritura en el nuevo archivo

                    fw.write(datosFiltrados.toLowerCase().replace(" ", "/") + "\n");
                }
            }
            fw.close();// Compromete o concreta los acmbios en el archvio(cierra el flujo)

            }catch(Exception ex){
            System.out.println(ex.getMessage());


        }

    }
}