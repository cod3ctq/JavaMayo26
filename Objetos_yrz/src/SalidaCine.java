public class SalidaCine {
    String pelicula;
    double costoBoleto;
    int cantidadAsientos;
    String folioAsiento;
    String horario;
    String direccionCine;

    public SalidaCine(){}


    public SalidaCine(String direccionCine, String horario, String folioAsiento, int cantidadAsientos, double costoBoleto, String pelicula) {
        this.direccionCine = direccionCine;
        this.horario = horario;
        this.folioAsiento = folioAsiento;
        this.cantidadAsientos = cantidadAsientos;
        this.costoBoleto = costoBoleto;
        this.pelicula = pelicula;
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

    public int getCantidadAsientos() {
        return cantidadAsientos;
    }

    public void setCantidadAsientos(int cantidadAsientos) {
        this.cantidadAsientos = cantidadAsientos;
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
                ", cantidadAsientos=" + cantidadAsientos +
                ", folioAsiento='" + folioAsiento + '\'' +
                ", horario='" + horario + '\'' +
                ", direccionCine='" + direccionCine + '\'' +
                '}';
    }
}

