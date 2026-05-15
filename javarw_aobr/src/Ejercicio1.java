import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

public class Ejercicio1 {
    public static void main(String[] args) {
        //con el archivo de autos, realizar
        //lectura del archivo y aplicar los filtros
        /*
        1 MOSTRAR LOS AUTOS CON UN COSTO POR ENCIMA DE 600000
        2 MOSTRAR LOS QUE EL MODELO CONTENGA UN NUMERO
        3 MOSTRAR TODOS LOS QUE NO SEAN SUV
        4 MOSTRAR SOLO EL MODELO, ANIO, PRECIO Y TRANSMISION FILTRANDO POR MARCA
        5 MOSTRAR MODELO, MARCA Y COLOR, EN MINUSCULA DE LOS MODELOS QUE COMIENCEN CON UNA VOCAL

        6 ESCRIBIR EN OTRO ARCHIVO LOS RESULTADOS DEL ULTIMO FILTRO
         */

        Filtro1 f1 = new Filtro1();
        f1.ejecutar();

        Filtro2 f2 = new Filtro2();
        f2.ejecutar();

        Filtro3 f3 = new Filtro3();
        f3.ejecutar();

        Filtro4 f4 = new Filtro4();
        f4.ejecutar();

        Filtro5 f5 = new Filtro5();
        f5.ejecutar();

    }

}

    class Filtro1{
        public void ejecutar(){

            String ruta="C:\\Users\\osval\\Downloads\\autos.txt";
            String linea;
            String []datos;
            String numeros="1234567890";

            File file = new File(ruta);

            try{

                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                System.out.println("1 MOSTRAR LOS AUTOS CON UN COSTO POR ENCIMA DE 600000");
                while ((linea=br.readLine())!=null){ //leyendo  linea por linea
                    datos=linea.split("-");
                    int costo = Integer.parseInt(datos[3]);

                    if(costo>600000){
                        System.out.println(Arrays.toString(datos));
                    }
                }
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
    }

    class Filtro2{
        public void ejecutar(){
            String ruta="C:\\Users\\osval\\Downloads\\autos.txt";
            String linea;
            String []datos;
            String numeros="1234567890";

            File file = new File(ruta);

            try{

                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                System.out.println("\n2 MOSTRAR LOS QUE EL MODELO CONTENGA UN NUMERO");
                while ((linea=br.readLine())!=null){ //leyendo  linea por linea
                    datos=linea.split("-");

                    for (int i = 0; i < datos[1].length(); i++) {
                        if(datos[1].contains("1") || datos[1].contains("2") || datos[1].contains("3") || datos[1].contains("4") || datos[1].contains("5") || datos[1].contains("6") || datos[1].contains("7") || datos[1].contains("9") || datos[1].contains("0")){
                            System.out.println(Arrays.toString(datos));
                        }
                    }
                }
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
    }

    class Filtro3{
        public void ejecutar(){
            String ruta="C:\\Users\\osval\\Downloads\\autos.txt";
            String linea;
            String []datos;
            String numeros="1234567890";

            File file = new File(ruta);

            try{

                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                System.out.println("\n3 MOSTRAR TODOS LOS QUE NO SEAN SUV");
                while ((linea=br.readLine())!=null){ //leyendo  linea por linea
                    datos=linea.split("-");

                    for (int i = 0; i < datos[1].length(); i++) {
                        if(!datos[4].contains("SUV")){
                            System.out.println(Arrays.toString(datos));
                        }
                    }
                }
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
    }

    class Filtro4{
        public void ejecutar(){
            String ruta="C:\\Users\\osval\\Downloads\\autos.txt";
            String linea;
            String []datos;
            String numeros="1234567890";

            File file = new File(ruta);

            try{

                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                System.out.println("\n4 MOSTRAR SOLO EL MODELO, ANIO, PRECIO Y TRANSMISION FILTRANDO POR MARCA");
                while ((linea=br.readLine())!=null){ //leyendo  linea por linea
                    datos=linea.split("-");

                    for (int i = 0; i < datos[1].length(); i++) {
                        if(datos[0].contains("Subaru")){
                            System.out.println(Arrays.toString(datos));
                        }
                    }
                }
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
    }

    class Filtro5{
        public void ejecutar(){
            String ruta="C:\\Users\\osval\\Downloads\\autos.txt";
            String linea;
            String []datos;
            String numeros="1234567890";

            File file = new File(ruta);

            try{

                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                System.out.println("\nMOSTRAR MODELO, MARCA Y COLOR, EN MINUSCULA DE LOS MODELOS QUE COMIENCEN CON UNA VOCAL");
                while ((linea=br.readLine())!=null){ //leyendo  linea por linea
                    datos=linea.split("-");

                    for (int i = 0; i < datos[1].length(); i++) {
                        if(datos[0].contains("Subaru")){
                            System.out.println(datos[1]+" "+);
                        }
                    }
                }
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
    }