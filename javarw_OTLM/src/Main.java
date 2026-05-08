import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args){
        String ruta = "C:\\Users\\VIOM2\\Desktop\\datos.txt";
        String linea;
        String[] datos;
        File file = new File(ruta);//Es una represntacion del archivo pero en memoria
        File escritura = new File("C:\\Users\\VIOM2\\Desktop\\escritura.txt");

        try{
            FileReader fr = new FileReader(file);//caché
            BufferedReader br = new BufferedReader(fr);//lectura del caché
            FileWriter fw = new FileWriter(escritura);//Puntador hacia el archivo donde se escribiran los datos
            while ((linea = br.readLine()) != null){
                //System.out.println(linea);

                //System.out.println(linea.substring(5));
                //System.out.println(linea.substring(5,10));//Devuelve una cadena de un String con los caracteres entre parametros

                datos = linea.split(" ");//devuelve un array de todos los strings con todos los elementos
                //System.out.println(datos[0] + " " + datos[1]+ " " + datos[3]);

                //filtrar si el nombre termina con A y empiece con D
//                if(datos[0].endsWith("A") && datos[0].startsWith("D")){
//                    System.out.println(datos[0] + " " + datos[1]+ " " + datos[3]);
//                }
//
//                //Buscar las personas que su apellido paterno contiene RR
//                if(datos[1].contains("RR")){
//                    System.out.println(datos[0] + " " + datos[1] + " " + datos[3]);
//                }

                //filtrar todas las personas nacidas despues del 95
//                int año = Integer.parseInt(datos[3].substring(6));
//
//                if(año>1995){
//                    System.out.println(datos[0] + " " + datos[1] + " " + datos[3]);
//                }

                //filtrar todos los hombres que:
                //Nombre termine con una O y
                //Apellido materno contenga una Z
                //Imprimir el estado

                if(datos[4].equals("M") && datos[0].endsWith("O") && datos[2].contains("A")){
                    System.out.println(datos[0] + " "  + datos[2] + " " + datos[5]);
                    String datosFiltrados = datos[0] + " " + datos[2] + " " + datos[5];
                    //escritura en el nuevo archivo
                    //replace(): busca el caracter indicado y lo reemplaza por otro caracter
                    fw.write(datosFiltrados.toLowerCase().replace(" ","$")+"\n");//Escribe los datos en el archivo
                }

            }
            fw.close();//  Compromete o concreta los cambios en el archivo (cierra flujo)
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }

    }
}
