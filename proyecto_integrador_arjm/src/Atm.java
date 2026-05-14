import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public abstract class Atm {

    private String direccion;
    private String folio;
    public static int folioOperacion = 0;
    private Cuenta[] database; //Composicion

public Atm(){
    this.database = cargarCuentas();
}

    public Atm(String direccion, String folio, Cuenta[] database) {
        this.direccion = direccion;
        this.folio = folio;
        this.database = database;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }


    public static int getFolioOperacion() {
        return folioOperacion;
    }

    public static void setFolioOperacion(int folioOperacion) {
        Atm.folioOperacion = folioOperacion;
    }

    public Cuenta[] getDatabase() {
        return database;
    }

    public void setDatabase(Cuenta[] database) {
        this.database = database;
    }

    @Override
    public String toString() {
        return "Atm{" +
                "direccion='" + direccion + '\'' +
                ", folio='" + folio + '\'' +
                '}';
    }
    public Cuenta buscarCuenta(String numTarjeta, String nip){

    Cuenta encontrado = null;

    //Buscar dentro del array de cuentas, a la cuenta con el numero y nip ingresados
        for (int i =0; i< database.length;i++){

            if (database[i].getNumTarjeta().equals(numTarjeta) && database[i].getNip().equals(nip)){
                encontrado = database[i];
                break;
            }


        }


    return encontrado;

    }
    public void consultarSaldo(String numTarjeta, String nip){


    Cuenta c = buscarCuenta(numTarjeta, nip);
    if (c!=null){
        System.out.println("Tu saldo es: " + c.getSaldo());
    }else {
        System.out.println("Cuenta inexistente");
    }
}



private Cuenta[] cargarCuentas(){
    File file = new File("C:\\Users\\RENE PC\\Desktop\\cuentas.txt");
    String Linea; // Informacion completa, junta
    Cuenta cuenta; // objeto temporal, que guardara los datos de cada linea, ya separados
    Cuenta[] cuentas = new Cuenta[50]; // de antenmano se que leere 50 registros
    String datos[]; //Informacion ya separada con el metodo split
    int contador = 0;

    try {
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        while((Linea = br.readLine())!=null){
            datos = Linea.split(",");
            cuenta = new Cuenta(datos[0],datos[1],datos[2],datos[3],Double.parseDouble(datos[4]),datos[5]);
            cuentas[contador] = cuenta;
            contador++;

        }

    }catch (Exception ex){
        System.out.println(ex.getMessage());

    }

    return cuentas;
}

public void generarRetirosSinTarjeta(){}

    public abstract void cobrarRetiroSinTarjeta();

//    public abstract void cobrarRetiroSinTarjeta();



}
