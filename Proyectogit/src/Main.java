//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    String ruta = "C:\\Users\\Yair\\Desktop\\autos.txt";
    String linea;
    String[] datos;
    File file = new File(ruta);
    File escritura = new File("C:\\Users\\Yair\\Desktop\\escritura.txt");
/*
    try {
    //LEE LAS LINEAS
    FileReader fr = new FileReader(file);
    //GUARDA LAS LINEAS
    BufferedReader br = new BufferedReader(fr);
    //SE VA GUARDANDO EL TEXTO HASTA QUE ENCUENTRE UN VACIO Y YA NO HAYA MAS QUE LEER POR ESO !=NULL
    //ESCRIBE EN NUEVA LINEAS
    FileWriter fw=new FileWriter(escritura);
    while ((linea = br.readLine()) != null) {
        //    System.out.println(linea);
        //cortar cadena de texto
        //sout(linea);

        // separa por espacios y los guarda en datos
        datos = linea.split(" ");
        //filtra si datos[0] (nombre), termina con una e
        //if(datos[0].endsWith("A")&&datos[0].startsWith("D")){
        //  System.out.println(datos[0]+" "+datos[1]+" "+datos[3]);
        // }
        // if(datos[1].contains("RR")){
        //    System.out.println(datos[0]+" "+datos[1]+" "+datos[3]);
        // }
        // el año =                OBTENEMOS UNA SUBCADENA DEL POSCION 3, y cortamos apartir de la poscion 6
        //      SEPARANDO LA CADENA Y TENIENDO texto con numeros
        // Ahora con el metodo Integer.parseInt() podemos convertir el texto "16" a valor en numeros = 16
        int año = Integer.parseInt(datos[3].substring(6));
        //  }
      //  if (año > 1995) {
            //IMPRIMIMOS EL TEXTO EN POSICION (0)          ,(1)       ,(3)
        //                         NOMBRE,      APELLIDO PATERNO, FECHA
        //    System.out.println(datos[0] + " " + datos[1] + " " + datos[3]);
        if((datos[4].equals("M"))&&(datos[0].endsWith("O"))&&(datos[2].contains("A"))){
            String datosFlitrados;
            datosFlitrados=datos[0]+" "+datos[2]+" "+datos[5];
            //escritura en el nuevo archivo
            fw.write(datosFlitrados.toLowerCase()+"\n");
            System.out.println(datos[0] + " " + datos[1] + " " + datos[5]);
        }

    }
    fw.close();
     }
catch(Exception ex){
    System.out.println(ex.getMessage());
    }
    */

    //Con el archivo de autos, realizar
//Lectura del archivo y aplicar los filtros:
/*
1 Mostrar los autos con un costo por encima de 600000
2 Mostrar los que el modelo contenga un numero
3 Mostrar todos los que NO sean SUV's
4 Mostrar solo el modelo, año, precio y transmision filtrando por marca
5 Mostrar modelo, marca y color, en minuscula de los modelos que comiencen con una vocal
6 Escribir en otro archivo los resultados del ultimo filtro
*/
    int x;


    try {
        //LEE LAS LINEAS
        FileReader fr = new FileReader(file);
        //GUARDA LAS LINEAS
        BufferedReader br = new BufferedReader(fr);
        //SE VA GUARDANDO EL TEXTO HASTA QUE ENCUENTRE UN VACIO Y YA NO HAYA MAS QUE LEER POR ESO !=NULL
        //ESCRIBE EN NUEVA LINEAS
        FileWriter fw = new FileWriter(escritura);

        while ((linea = br.readLine()) != null) {
            datos = linea.split("-");
            // imprime los datos  System.out.println(datos);
            if (Integer.parseInt(datos[3])> 600000) {
                System.out.println(datos[0]+" "+datos[3]);
            }
            if((datos[1].contains("1")||datos[1].contains("2")||"3"||"4"||"5"||"6"||"7"||"8"||"9"||"0"))){
                System.out.println(datos[0]);
            }
          //  if(Integer.parseInt(datos[1]).contains(x)) {
             //   System.out.println((datos[0] + "" + datos[1]));
           // }
            if(!datos[4].contains("SUV")){
                System.out.println(datos[0]+" "+datos[4]);
            }
        }


    } catch (Exception ex) {
        System.out.println(ex.getMessage());
    }
}
