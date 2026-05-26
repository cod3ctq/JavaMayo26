import java.util.Random;

//Clase Helper: Contienen funciones/metodos que seran utilizados a lo largo de todo el programa
public class Helper {

    public static String generarReferencia() {

        Random random = new Random();
        StringBuilder numero = new StringBuilder();

        for (int i = 0; i < 16; i++) {

            int digito = random.nextInt(10); // 0 - 9
            numero.append(digito);
        }

        return numero.toString();
    }

    public static String generarMonto() {

        Random random = new Random();

        int numeroBase = random.nextInt(99) + 1;

        int resultado = numeroBase * 100;

        return String.format("%04d", resultado);
    }

    //Genera una clave de 4 digitos
    public static String generarClave() {

        Random random = new Random();

        int clave = random.nextInt(9000) + 1000;

        return String.valueOf(clave);
    }
}