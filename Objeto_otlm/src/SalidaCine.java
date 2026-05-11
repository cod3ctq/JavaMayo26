public class SalidaCine {
    String pelcula;
    double costoBoleto;
    int catidadAsiento;
    String folioAsiento;
    String horario;
    String lugar;

    public SalidaCine(){

    }

    public SalidaCine(String pelcula, double costoBoleto, int catidadAsiento, String folioAsiento, String horario, String lugar) {
        this.pelcula = pelcula;
        this.costoBoleto = costoBoleto;
        this.catidadAsiento = catidadAsiento;
        this.folioAsiento = folioAsiento;
        this.horario = horario;
        this.lugar = lugar;
    }

    public String getPelcula() {
        return pelcula;
    }

    public void setPelcula(String pelcula) {
        this.pelcula = pelcula;
    }

    public double getCostoBoleto() {
        return costoBoleto;
    }

    public void setCostoBoleto(double costoBoleto) {
        this.costoBoleto = costoBoleto;
    }

    public int getCatidadAsiento() {
        return catidadAsiento;
    }

    public void setCatidadAsiento(int catidadAsiento) {
        this.catidadAsiento = catidadAsiento;
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

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    @Override
    public String toString() {
        return "SalidaCine{" +
                "pelcula='" + pelcula + '\'' +
                ", costoBoleto=" + costoBoleto +
                ", catidadAsiento=" + catidadAsiento +
                ", folioAsiento='" + folioAsiento + '\'' +
                ", horario='" + horario + '\'' +
                ", lugar='" + lugar + '\'' +
                '}';
    }

}
