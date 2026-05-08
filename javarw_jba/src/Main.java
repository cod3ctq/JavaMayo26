import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {
        String ruta ="C:\\Users\\ENRIQUE BORJA\\Desktop\\datos.txt";
        String linea;
        String datos [];
        File file = new File(ruta); // Representacion del archivo en memoria.
        File escritura = new File("C:\\Users\\ENRIQUE BORJA\\Desktop\\escritura.txt");
        try {
            FileReader fr = new FileReader(file); //caché
            BufferedReader br = new BufferedReader(fr); // lectura del cache

            FileWriter fw = new FileWriter(escritura);
            while( (linea=br.readLine()) !=null){
                //System.out.println(linea);

                datos= linea.split(" ");
                //System.out.println(datos[0] + " "+ datos[1] + " "+datos[3]);

//                //flitrar si datos [0] (nombre) termine con e
//
//                if (datos[0].endsWith("A") && datos[0].startsWith("D")){
//                    System.out.println(datos[0]+" "+ datos[1] + " "+datos[3]);
//                }
//                if (datos[1].contains("RR")){
//                    System.out.println(datos[0]+" "+ datos[1] + " "+datos[3]);
//
//                }

                //filtar las personas nacidas despues del 95
               int año = Integer.parseInt(datos[3].substring(6));
//                if (año>1995){
//                    System.out.println(datos[0]+" "+ datos[1] + " "+datos[3]);
//                }
                if ((datos[0].endsWith("O")) &&(datos[2].contains("A") && datos[4].equals("M"))){
                  String datosFiltrados;
                    datosFiltrados = datos[0]+ " "+ datos[1] + " "+datos[5];
                    // replace(): busca el caracter y lo reemplaza por otr
                    fw.write(datosFiltrados.toLowerCase().replace(" ","$")+"\n");
                  System.out.println(datos[0]+" "+ datos[1] + " "+datos[5]);
               }


            }
            fw.close();
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}