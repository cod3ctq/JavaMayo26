import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.SQLOutput;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String ruta="C:\\Users\\César\\Desktop\\escritorio\\datos.txt";
        String linea;
        String[] datos;
        File file = new File(ruta); //representacion del archivo en memoria
        File escritura = new File("C:\\Users\\César\\Desktop\\escritorio\\escritura.txt");
        try{
            FileReader fr = new FileReader(file); //caché
            BufferedReader br = new BufferedReader(fr); //lectura del cache
            FileWriter fw = new FileWriter(escritura); //Apuntador hacia el archivo donde se escribiran los datos
            while( (linea=br.readLine()) !=null){
                //System.out.println(linea);
                //cortar cadena de texto
                //System.out.println(linea.substring(5));
                //System.out.println(linea.substring(0,16) +" "+ linea.substring(23,33));
                //[CARLOS,HERNANDEZ,LOPEZ,12/04/1994, M, PUEBLA]
                datos = linea.split(" "); //devuelve un array de Strings con todos los elementos separados
                //System.out.println(datos[0] + " "+ datos[1] + " "+datos[3]);

//                //filtrar si datos[0] (nombre), termina con una e y empiece con una D
//                if(datos[0].endsWith("A") && datos[0].startsWith("D")){
//                    System.out.println(datos[0] + " "+ datos[1] + " "+datos[3]);
//                }
//
//                //Buscar las personas que su apellido paterno contiene RR
//                if(datos[1].contains("RR")){
//                    System.out.println(datos[0] + " "+ datos[1] + " "+datos[3]);
//                }

                //filtrar todas las personas nacidas despues del 95
                int año = Integer.parseInt(datos[3].substring(6));

//                if(año>1995){
//                    System.out.println(datos[0] + " "+ datos[1] + " "+datos[3]);
//                }

                //filtrar todos los hombres que:
                //su nombre termine con una O Y
                //su apellido materno contenga una Z

                //Imprimir el estado
                String datosFiltrados;
                if(datos[0].endsWith("O") && datos[2].contains("A") && datos[4].equals("M")){
                     datosFiltrados = datos[0]+ " "+ datos[2] + " "+datos[5];
                    //escritura en el nuevo archivo
                    //replace() : busca el caracter indicado y lo reemplaza por otro caracter
                    fw.write(datosFiltrados.toLowerCase().replace(" ","$")+"\n"); //Escribe los datos en el archivo
                }
            }
            fw.close(); //Compromete o concreta los cambios en el archivo (cierra el flujo)
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }


        //Con el archivo de autos, realizar
        //Lectura del archivo y aplicar los filtros :
        /*
        1 Mostrar los autos con un costo por encima de 600000
        2 Mostrar los que el modelo contenga un numero
        3 Mostrar todos los que NO sean SUV's
        4 Mostrar solo el modelo, año,precio y transmision filtrando por marca
        5 Mostrar modelo, marca y color, en minuscula de los modelos que comiencen con una vocal
        6: Escribir en otro archivo los resultados del ultimo filtro
         */
















    }
}