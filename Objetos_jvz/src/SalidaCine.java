public class SalidaCine {

    String pelicula;
    double costo;
    int cantidadAsiento;
    String folioAsiento;
    String horario;
    String direccionCine;


    //Hacer el constructor (generate y opcion de constructor)

    public SalidaCine(String pelicula, double costo, int cantidadAsiento, String folioAsiento, String horario, String direccionCine) {
        this.pelicula = pelicula;
        this.costo = costo;
        this.cantidadAsiento = cantidadAsiento;
        this.folioAsiento = folioAsiento;
        this.horario = horario;
        this.direccionCine = direccionCine;
    }

    //Hacer los getting y setting (generate y opcion de getting y setting)

    public String getPelicula() {
        return pelicula;
    }

    public void setPelicula(String pelicula) {
        this.pelicula = pelicula;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public int getCantidadAsiento() {
        return cantidadAsiento;
    }

    public void setCantidadAsiento(int cantidadAsiento) {
        this.cantidadAsiento = cantidadAsiento;
    }

    public String getFolioAsiento() {
        return folioAsiento;
    }

    public void setFolioAsiento(String folioAsiento) {
        this.folioAsiento = folioAsiento;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getDireccionCine() {
        return direccionCine;
    }

    public void setDireccionCine(String direccionCine) {
        this.direccionCine = direccionCine;
    }


    // Visualizar el estado del objeto (ver que valores tiene cada atributo del objeto).


    @Override
    public String toString() {
        return "SalidaCine{" +
                "pelicula='" + pelicula + '\'' +
                ", costo=" + costo +
                ", cantidadAsiento=" + cantidadAsiento +
                ", folioAsiento='" + folioAsiento + '\'' +
                ", horario='" + horario + '\'' +
                ", direccionCine='" + direccionCine + '\'' +
                '}';
    }
}
