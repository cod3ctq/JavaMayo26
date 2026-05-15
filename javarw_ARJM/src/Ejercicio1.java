import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;


public class Ejercicio1 {
    public static void main(String[] args) {

        //con el archivo de autos, realizar
        //lectrua del archivo y aplicar los filtros:
        //Mostrar los autos con un costo por encima de 600000
        //Mostrar los que el modelo contenga un numero
        //Mostrar todos los que no sean SUV´s
        //Mostrar solo el modelo, año, precio, y transmision filtrando por marca
        // Mostrar, modelo, marca y color, en minuscula de los modelos que comiencen con una vocal
        // Escribir en otro archivo los resultados del ultimo filtro

        String ruta = "C:\\Users\\RENE PC\\Desktop\\autos.txt";
        String linea;
        String[] datos;
        File file = new File(ruta); //representacion del archivo pero en memoria
        File escritura = new File("C:\\Users\\RENE PC\\Desktop\\Ejercicio.txt");

        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter(escritura);

            while ((linea = br.readLine()) != null) {
                datos = linea.split("-");

                int precio = Integer.parseInt(datos[3]); //filtra costo por encima de 600000
                if (precio>=600000){
                    System.out.println(datos[3]);
                }
                if (datos[1].chars().anyMatch(Character::isDigit)){//filtra si el modelo contiene numero
                    System.out.println(datos[1]);
                }
                if (!datos[4].contains  ( "SUV")){ //filtra los que no son SUV
                    System.out.println(datos[4]);
                }
                if (datos[0].equalsIgnoreCase("toyota")){
                    System.out.println(datos[1]  + " " +  datos[2]  + " " + datos[3]  + " " + datos[6] );
                }

//                 //Mostrar, modelo, marca y color, en minuscula de los modelos que comiencen con una vocal
                String textoEjercicio;
                char primerLetra = Character.toLowerCase(datos[1].charAt(0));
                if (primerLetra == 'a' || primerLetra == 'e' || primerLetra == 'i' || primerLetra == 'o' || primerLetra == 'u'){
                    System.out.println(datos[1]  + " " +  datos[0]  + " " + datos[5]);

                // Escribir en otro archivo los resultados del ultimo filtro

                    textoEjercicio = datos[1] + " " + datos[0] + " " + datos[5];

                    //escritura en el nuevo archivo
                    fw.write(textoEjercicio.toLowerCase()+"\n");
                }
            }
            fw.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}