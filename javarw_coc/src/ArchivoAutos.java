import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class ArchivoAutos {
    public static void main(String[] args) {
        // *** EJERCICIO ***
        // Con el archivo de autos, realizar lectura del archivo y aplicar los filtros:
        // 1. Mostrar los autos con un costo por encima de 600,000 +
        // 2. Mostrar los que el modelo contenga un número +
        // 3. Mostrar todos los que no sean SUV's +
        // 4. Mostrar sólo el modelo, año, precio y transmisión filtrando por marca -
        // 5. Mostrar modelo, marca y color, en minúscula de los modelos que comiencen con una vocal +

        // 6. Escribir en otro archivo los resultados del último filtro +

        String ruta = "C:\\Users\\carlo\\OneDrive\\Escritorio\\autos.txt";
        String linea;
        String[] datos;
        File file = new File(ruta);
        File escritura = new File("C:\\Users\\carlo\\OneDrive\\Escritorio\\escritura.txt");
        String numeros = "0123456789";
        String vocales = "AEIOU";

        try {
            FileReader fr = new FileReader(ruta);
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter(escritura);

            while ((linea = br.readLine()) != null) { // Mientras que haya información en la línea, iteramos
                datos = linea.split("-"); // Separamos los elementos y los guardamos en un array
                int costo = Integer.parseInt(datos[3]);
                if (costo > 600000) {
                    for (int i = 0 ; i < datos[1].length() ; i++) {
                        String caracter = datos[1].charAt(i) + "";
                        if (numeros.contains(caracter)) {
                            if (! datos[4].equals("SUV")) {
                                System.out.println(datos[1] + " " + datos[2] + " " + datos[3] + " " + datos[4] + " " + datos[6]);
                                for (int v = 0 ; v < datos[1].length() ; v++) {
                                    String caracter2 = datos[1].charAt(0) + "";
                                    if (vocales.contains(caracter2)) {
                                        System.out.println((datos[1] + " " + datos[0] + " " + datos[3] + " " + datos[5]).toLowerCase());
                                        String datosFiltrados = (datos[1] + " " + datos[0] + " " + datos[3] + " " + datos[5] + "\n").toLowerCase();
                                        fw.write(datosFiltrados);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            fw.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}