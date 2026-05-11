import javax.xml.transform.Source;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {

        String ruta = "C:\\Users\\alber\\Escritorio\\datos.txt";
        String linea;
        String[] datos;
        File file = new File(ruta); //representacion del archivo en memoria
        File escritura = new File("C:\\Users\\alber\\Escritorio\\Escritura.txt");
        try {
            FileReader fr = new FileReader(file); //caché
            BufferedReader br = new BufferedReader(fr); //lectura del caché
            FileWriter fw = new FileWriter(escritura);

            while ((linea = br.readLine()) !=null){ //caché
                //System.out.println(linea);
                //cortar cadenas de texto
                //System.out.println(linea.substring(5));
                //System.out.println(linea.substring(0,16)) +" "+ linea.substring(23,33);
                //[CALORS,HERNANDEZ,12/04/1994, M, PUEBLA]
                datos =linea.split(" "); //devuelve un arrayb de String con todos los elementos separados.
                //System.out.println(datos[0] + " "+ datos[1] + " "+datos[3]);



                //filtar si datos[0] (nombres), termina con una e
                if(datos[0].endsWith("A") && datos[0].startsWith("D")){
                    System.out.println(datos[0] + " " +datos[1] + " "+datos[3]);
                }


                //Buscar las personas que su apellido parteno contiene RR
                if(datos[1].contains("RR")){
                    System.out.println(datos[0] + " "+ datos[1] + " "+datos[3]);

                }
             //filtrar todas las personas nacidas despues del 95
                int año = Integer.parseInt(datos[3].substring(6));

      //          if(año>1995){
      //              System.out.println(datos[0] + " "+ datos[1] + " "+datos[3]);
      //          }

                //filtrar todos los nombres que terminen con una o:
                //su apellido materno contenga una z
                //Imprimir el estado
                String datosFiltrados;
                if (datos[0].endsWith("O") && datos[2].contains("A") && datos[4].equals("M")){
                   datosFiltrados = datos[0]+ " "+ datos[2] + " "+datos[5];
                    //escritura en el nuevo archivo
                    //replace() : busca el caracter indicado y lo reemplaza por otro caracter.
                    fw.write(datosFiltrados.toLowerCase().replace(" ","$")+"\n"); //Escribe los datos en el archivo

                }
            }
            fw.close(); // compromete o concreta los cambios en el archivo (cierra el flujo)
        } catch (Exception ex){
            System.out.println(ex.getMessage());

        }


    }

}
