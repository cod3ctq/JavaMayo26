import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Locale;

public class Ejerciciodeautmoviles {
    public static void main(String[] args) {

        //Con el archivo de autos, realizar
        //Lectura del archivo y aplicar los filtros :
        /*
        1. Mostrar los autos con un costo por encima de 600,000
        2. Mostrar los modelos que contengan un numero
        3. Mostrar todos los que No sean SUV'S
        4. Mostrar solo el modelo, año, precio y transmisión filtrando por marca
        5. Mostrar modelo, marca y color, en minuscula de los modelos que comiencen con una vocal
        6. Escribir en otro archivo los resultados del ultimo filtro (numero 5)
         */


        String ruta = "C:\\Users\\alber\\Escritorio\\autos.txt";
        String linea;
        String[] datos;

        File file = new File(ruta);
        File escritura = new File("C:\\Users\\alber\\Escritorio\\Resultado.txt");

        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            FileWriter fw = new FileWriter(escritura);

            while ((linea = br.readLine()) != null) {

                datos = linea.split("-");
                /*
                0 marca
                1 modelo
                2 año
                3 precio
                4 tipo
                5 color
                6 transmision
                 */

                //1. Mostrar los autos con un costo por encima de 600,000

//                int precio = Integer.parseInt(datos[3]);

//                if(precio > 600000) {

//                    System.out.println("Autos caros");
//                    System.out.println(linea);
//                }

                // 2. Mostrar modelos que contengan un número
 //               if (datos[1].matches(".*\\d.*")){

//                    System.out.println("Modelos con numero:");
//                    System.out.println(datos[1]);
//                }
                //3.Mostrar todos los modelos que no sean SUV.
//                if (!datos[4].equals("SUV´S")){

//                    System.out.println("No SUV´S:");
//                    System.out.println(linea);
//                }
                //4. Mostrar modelo, año, precio y transmisión filtrado por marca
//                if (datos[0].equals("Renault")){

//                    System.out.println("Renault");

//                    System.out.println(datos[1] + " " +datos[2] + " "+datos[3] + " "+datos[6]);
//                }

                // 5. Mostrar modelo, marca y color en minuscula de modelos que comiencen en vocal.

                if (datos[1].startsWith("A") || datos[1].startsWith("E") || datos[1].startsWith("I") || datos[1].startsWith("O") || datos[1].startsWith("U")){

                    String filtrado =
                            datos[1].toLowerCase() + " " +
                            datos[0].toLowerCase() + " " +
                            datos[5].toLowerCase();

                    System.out.println(filtrado);

                    // 6. Escribir en otro archivo
                    fw.write(filtrado + "\n");
                }






            }
            br.close();
            fw.close();


        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }












    }
}
