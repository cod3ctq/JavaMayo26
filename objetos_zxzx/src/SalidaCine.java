public class SalidaCine {

    String pelicula;
    double costoBoleto;
    int cantidadAsiento;
    String folioAsiento;
    String horario;
    String direccionCine;

    public SalidaCine(){}

    public SalidaCine(String pelicula, double costoBoleto, int cantidadAsiento, String folioAsiento, String horario, String direccionCine) {
        this.pelicula = pelicula;
        this.costoBoleto = costoBoleto;
        this.cantidadAsiento = cantidadAsiento;
        this.folioAsiento = folioAsiento;
        this.horario = horario;
        this.direccionCine = direccionCine;
    }

    public String getPelicula() {
        return pelicula;
    }

    public void setPelicula(String pelicula) {
        this.pelicula = pelicula;
    }

    public double getCostoBoleto() {
        return costoBoleto;
    }

    public void setCostoBoleto(double costoBoleto) {
        this.costoBoleto = costoBoleto;
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

    @Override
    public String toString() {
        return "SalidaCine{" +
                "pelicula='" + pelicula + '\'' +
                ", costoBoleto=" + costoBoleto +
                ", cantidadAsiento=" + cantidadAsiento +
                ", folioAsiento='" + folioAsiento + '\'' +
                ", horario='" + horario + '\'' +
                ", direccionCine='" + direccionCine + '\'' +
                '}';
    }
}
