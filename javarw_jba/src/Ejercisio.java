import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Ejercisio {
    public static void main(String[] args){

    String ruta= "C:\\Users\\ENRIQUE BORJA\\Desktop\\autos.txt";
    File file = new File(ruta);
    String linea;
    String datos[];

    try {
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        FileWriter fw = new FileWriter(escritura2);

        while((linea=br.readLine()) !=null){
            //System.out.println(linea);
            datos= linea.split("-");
//            int precio=  Integer.parseInt(datos[3]);

//            if (precio>=600000){
//                System.out.println(datos[0]+" "+ datos[1]+" "+"$" +datos[3]);
//            }
            // ------------------------------

//            if (datos[1].contains("0") || datos[1].contains("1") || datos[1].contains("2") || datos[1].contains("3") || datos[1].contains("4") || datos[1].contains("5") || datos[1].contains("6") || datos[1].contains("7") || datos[1].contains("8") || datos[1].contains("9") ){
//                   System.out.println(datos[0]);
//
//                }
            // ------------------------------
//                if (!datos[4].equals("SUV")){
//                    System.out.println(datos[0]+" "+ datos[1] + " "+datos[4]);
//                }
            // ------------------------------------

//                if (datos[0].equals("Ford")){
//                    System.out.println(datos[0]+ " "+datos[1]+" "+ datos[2] + " "+datos[3]);
//                }
            // ----------------------------------

                  if (datos[1].startsWith("A") || datos[1].startsWith("E") || datos[1].startsWith("I") || datos[1].startsWith("O") || datos[1].startsWith("U")){
                      String datosFiltrados;
                      datosFiltrados = datos[0]+" "+ datos[1] + " "+datos[5]+" "+datos[6];
                      fw.write(datosFiltrados.toLowerCase().replace(" ","$")+"\n");
                      System.out.println(datos[0]+" "+ datos[1] + " "+datos[5]+" "+datos[6]);
                  }

               }


        fw.close();


    } catch (Exception ex){
        System.out.println(ex.getMessage());

         }
     }
}
