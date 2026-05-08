import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Autos {
    public static void main(String[] args) {
        //con el archivo de autos, realizar
        //Lectura del archivo y aplicar los filtros
        /*
        1 mostrar los autos con un costo por encima de 60000
        2 Mostrar los que el modelo contenga un numero
        3 mostrar todos los que no sean suvs
        4 mostrar solo el modelo ano precio y transmision filtrando por marca
        5 mostrar modelo marca y color en minuscula de los modelos que comiencen con una vocal.

        7 escribir en otro archivo los resultados del ultimo filtro .
         */
        String ruta= "C:\\Users\\lgsai\\OneDrive\\Desktop\\autos.txt";
        String linea;
        String[] datos;
        File file = new File(ruta);
        File ejercicio = new File("C:\\Users\\lgsai\\OneDrive\\Desktop\\ejercicio.txt");
        try{
            FileReader fr = new FileReader(file); //cache
            BufferedReader br = new BufferedReader(fr); //lectura del cache
            FileWriter fw = new FileWriter(ejercicio);

            while ( (linea=br.readLine()) !=null) {
                datos = linea.split("-");
                String marca = datos[0];
                String modelo = datos[1];
                String ano = datos[2];
                String tipo = datos[4];
                String color = datos[5];
                String transmision = datos[6];
                    int valor = Integer.parseInt(datos[3]);
                    if(valor>600000) {// mostrar los autos con un costo por encima de 60000
                        System.out.println(datos[0] + " " + datos[1] + " " + datos[3]);
                    }
                    if (modelo.matches(".*\\d.*")) {// Mostrar los que el modelo contenga un numero
                        //. en la expresion regex, el punto significa cualquier caracter
                        //* significa "cero o mas veces"
                        // \\d codigo para buscar un digito del 1 al 9.
                        //. cualquier caracter de nuevo
                        //"Busca cualquier cosa (.*), que después tenga un número (\\d), y que después siga cualquier otra cosa (.*)".
                    System.out.println(datos[0] + " " + datos[1]);
                }
                if (!tipo.equalsIgnoreCase("SUV")) {// mostrar todos los que no sean suvs
                    System.out.println(datos[0] + " " + datos[1] + " " + datos[4]);
                }
                if (marca.equalsIgnoreCase("Honda")) {
                    System.out.println(datos[1] + " " + datos[2] + " " + datos[3] + " " + datos[4]);
                }
                if (modelo.toLowerCase().matches("^[aeiou].*")) {
                    String resultado = (modelo + " " + marca + " " + color).toLowerCase();
                    System.out.println(resultado);
                    fw.write(resultado+ "\n");
                }
            }
            fw.close();
            }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        }

    }
