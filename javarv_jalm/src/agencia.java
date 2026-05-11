import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class agencia {

    public static void main(String[] args) {
        String ruta = "C:\\Users\\angel\\OneDrive\\Escritorio\\autos.txt";
        File archivo = new File(ruta);
        File escritura = new File("C:\\Users\\angel\\OneDrive\\Escritorio\\Resultados.txt");

        String marcaFiltro = "Toyota";

        try {
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter(escritura);

            String linea;
            String[] datos;

            System.out.println("1. Autos con costo por encima de 600,000");
            while ((linea = br.readLine()) != null) {
                datos = linea.split("-");
                int precio = Integer.parseInt(datos[3]);

                if (precio > 600000) {
                    System.out.println(linea);
                }
            }

            br.close();
            fr.close();

            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            System.out.println("\n2. Modelos que contienen un numero");
            while ((linea = br.readLine()) != null) {
                datos = linea.split("-");
                String modelo = datos[1];

                if (modelo.matches(".*[0-9].*")) {
                    System.out.println(modelo);
                }
            }

            br.close();
            fr.close();

            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            System.out.println("\n3. Autos que no son SUV'S");
            while ((linea = br.readLine()) != null) {
                datos = linea.split("-");
                String tipo = datos[4];

                if (!tipo.equalsIgnoreCase("SUV")) {
                    System.out.println(linea);
                }
            }

            br.close();
            fr.close();

            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            System.out.println("\n4. Modelo, anio, precio y transmision filtrando por marca: " + marcaFiltro);
            while ((linea = br.readLine()) != null) {
                datos = linea.split("-");
                String marca = datos[0];
                String modelo = datos[1];
                String anio = datos[2];
                String precio = datos[3];
                String transmision = datos[6];

                if (marca.equalsIgnoreCase(marcaFiltro)) {
                    System.out.println(modelo + " " + anio + " " + precio + " " + transmision);
                }
            }

            br.close();
            fr.close();

            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            System.out.println("\n5. Modelo, marca y color en minuscula de modelos que comienzan con una vocal");
            while ((linea = br.readLine()) != null) {
                datos = linea.split("-");
                String marca = datos[0];
                String modelo = datos[1];
                String color = datos[5];
                String primerLetra = modelo.substring(0, 1).toLowerCase();

                if (primerLetra.matches("[aeiou]")) {
                    String resultado = (modelo + " " + marca + " " + color).toLowerCase();
                    System.out.println(resultado);
                    fw.write(resultado + "\n");
                }
            }

            fw.close();
            br.close();
            fr.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
