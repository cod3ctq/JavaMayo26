import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio {
    public static void main(String[] args){
        /*Mostrar los autos con un costo por encima de 600000
        * Mostrar los que el modelo contega un numero
        * Mostrar todos los que no sean SUVs
        * Mostrar solo el modelo, año, precio, y transmision filtrando por marca
        * Mostrar modelo, marca y color, en minuscula de los modelos que comiencen con una vocal
        *
        * Escribir en otro archivo los resultados del ultimo filtro
        * */

        String linea1;
        String[] datos1;
        List<String> resultado1 = new ArrayList<>();
        List<String> resultado2 = new ArrayList<>();
        List<String> resultado3 = new ArrayList<>();
        List<String> resultado4 = new ArrayList<>();
        List<String> resultado5 = new ArrayList<>();
        String ruta = "C:\\Users\\VIOM2\\Desktop\\autos.txt";
        File file = new File(ruta);
        File escritura = new File("C:\\Users\\VIOM2\\Desktop\\autosEscritura.txt");

        try{
            FileReader fr = new FileReader(file);//caché
            BufferedReader br = new BufferedReader(fr);//lectura del caché
            FileWriter fw = new FileWriter(escritura);//Puntador hacia el archivo donde se escribiran los datos
            while ((linea1 = br.readLine()) != null) {
                datos1 = linea1.split("-");

                //Mostrar los autos con un costo por encima de 600000
                int año = Integer.parseInt(datos1[3]);
                if (año > 600000) {
                    //System.out.println(datos1[1] + " " + datos1[3]);
                    resultado1.add(datos1[1]);
                }
                //Mostrar los que el modelo contega un numero
                if(datos1[1].contains("0") || datos1[1].contains("1") || datos1[1].contains("2") || datos1[1].contains("3") || datos1[1].contains("4") ||
                        datos1[1].contains("5") || datos1[1].contains("6") || datos1[1].contains("7") || datos1[1].contains("8") || datos1[1].contains("9")){
                    //System.out.println(datos1[1]);
                    resultado2.add(datos1[1]);
                }

                //Mostrar todos los que no sean SUVs
                if(!datos1[4].equals("SUV")){
                    //System.out.println(datos1[0] + " " + datos1[1] + " " + datos1[4]);
                    resultado3.add(datos1[1]);
                }

                //Mostrar solo el modelo, año, precio, y transmision filtrando por marca
                if(datos1[0].equals("Toyota")){
                    //System.out.println(datos1[1]);
                    resultado4.add(datos1[1] + " " + datos1[2] + " " + datos1[3] + " " + datos1[6]);
                }

                //Mostrar modelo, marca y color, en minuscula de los modelos que comiencen con una vocal
                if(datos1[1].startsWith("A") || datos1[1].startsWith("E") || datos1[1].startsWith("I") || datos1[1].startsWith("O") || datos1[1].startsWith("U")){
                    //System.out.println(datos1[1] + " " + datos1[0] + " " + datos1[5]);
                    resultado5.add((datos1[1] + " " + datos1[0] + " " + datos1[5]).toLowerCase());
                    fw.write((datos1[1] + " " + datos1[0] + " " + datos1[5]).toLowerCase()+"\n");
                }
            }
            fw.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println("Autos con un costo por encima de 600000:");
        System.out.println(resultado1);
        System.out.println("Modelos que contienen un numero:");
        System.out.println(resultado2);
        System.out.println("Todos los que no sean SUVs:");
        System.out.println(resultado3);
        System.out.println("Modelo, año, precio, y transmision filtrando por marca:");
        System.out.println(resultado4);
        System.out.println("Modelo, marca y color, en minuscula de los modelos que comiencen con una vocal: ");
        System.out.println(resultado5);

    }
}
