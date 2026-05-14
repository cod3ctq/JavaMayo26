import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public abstract class ATM {

    private String direcciones;
    private String folio;
    public static int folioOperaciones = 0; //Contador global de todas las operaciones del cajero
    private Cuenta[] database; //Composición


    public ATM(){
        this.database = cargarCuentas();
    }

    public ATM(String direcciones, String folio) {
        this.direcciones = direcciones;
        this.folio = folio;
        this.database = cargarCuentas();
    }

    public String getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(String direcciones) {
        this.direcciones = direcciones;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public static int getFolioOperaciones() {
        return folioOperaciones;
    }

    public static void setFolioOperaciones(int folioOperaciones) {
        ATM.folioOperaciones = folioOperaciones;
    }

    public Cuenta[] getDatabase() {
        return database;
    }

    public void setDatabase(Cuenta[] database) {
        this.database = database;
    }

    @Override
    public String toString() {
        return "ATM{" +
                "direcciones='" + direcciones + '\'' +
                ", folio='" + folio + '\'' +
                '}';
    }

    //
    public Cuenta buscarCuenta(String numTarjeta, String nip){

        Cuenta encontrado = null;
        //Buscar dentro del array de cuentas, a la cuenta con el numero y nip ingresados
        for (int i = 0; i<database.length; i++){
            if (database[i].getNumTarjeta().equals(numTarjeta) && database[i].getNip().equals(nip)){
                encontrado = database[i];
                break;

            }

        }
        return encontrado;
    }

    public void consultarSaldo(String numTarjeta, String nip){
        Cuenta c = buscarCuenta(numTarjeta,nip);
        if (c!=null){
            System.out.println("Tu saldo es: "+c.getSaldo());
        } else {
            System.out.println("Cuenta inexistente!");
        }


    }


    private Cuenta[] cargarCuentas(){
        File file = new File("C:\\Users\\alber\\Escritorio\\Cuentas.txt");
        String linea; //Información completa, junta
        Cuenta cuenta; // Objeto temporal, que guardara los datos de cada linea ya separados
        Cuenta[] cuentas = new Cuenta[50]; //De antemano sé que leere 50 registros
        String[] datos; //Información ya separada, con el metodo split()
        int contador = 0;
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            while ((linea = br.readLine())!=null){
                datos = linea.split(",");
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



}
