import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Locale;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String ruta="C:\\Users\\osval\\OneDrive\\Escritorio\\datos.txt";
        String linea;
        String []datos;
        File file = new File(ruta);
        File escritura = new File("C:\\Users\\osval\\OneDrive\\Escritorio\\escritura.txt");

        try{
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            FileWriter fw = new FileWriter(escritura);

            while((linea=br.readLine()) !=null){
                System.out.println(linea);
                //cortar cadena de texto
                System.out.println(linea.substring(5));
                System.out.println(linea.substring(0,16));

                datos=linea.split(" "); //devuelve un array de Strings con todos los elementos separados
                //System.out.println(datos[0]+" "+datos[1]+" "+datos[3]);

                //filtar si datos[0] (nombre) termina con una e
                if (datos[0].endsWith("A")&& datos[0].startsWith("D")) {
                    System.out.println(datos[0]+" "+datos[1]+" "+datos[3]);
                }
                //Buscar las personas que su apellido p contiene RR
                if(datos[1].contains("RR")){
                    System.out.println(datos[0]+" "+datos[1]+" "+datos[3]);
                }

                //filtrar todas las personas nacidas despues del 95
                int anio=Integer.parseInt(datos[3].substring(6));

                if (anio>1995){
                    System.out.println(datos[0]+" "+datos[1]+" "+datos[3]);
                }



                //EJERCICIO
                //filtrar todos los hombres que:
                //su nombre termine con una O Y
                //su apellido maaterno contenga una Z

                //imprimir el estado

                if(datos[4]=="M" && datos[0].endsWith("O") && datos[2].contains("Z")){
                    System.out.println(datos[0]+" "+datos[1]+" "+datos[3] + " "+ datos[5]);

                    String datosFiltrados=datos[0]+" "+datos[1]+" "+datos[3] + " "+ datos[5];

                    //escritura en el nuevo archivo
                    fw.write(datosFiltrados.toLowerCase().replace(" ","$")+"\n");
                }



            }
            fw.close(); //concreta los cambios en el archivo
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}