public class Camara {

    // Atributos
    double resolucion;
    double velOpt;
    int camaras;
    double aperturaOpt;
    int zoom;
    int valorISO;

    // Constructores
    public Camara() {
    }
    public Camara(double resolucion, double velOpt, int camaras, double aperturaOpt, int zoom, int valorISO) {
        this.resolucion = resolucion;
        this.velOpt = velOpt;
        this.camaras = camaras;
        this.aperturaOpt = aperturaOpt;
        this.zoom = zoom;
        this.valorISO = valorISO;
    }

    // Getters/Setters
    public double getResolucion() {
        return resolucion;
    }
    public void setResolucion(double resolucion) {
        this.resolucion = resolucion;
    }
    public double getVelOpt() {
        return velOpt;
    }
    public void setVelOpt(double velOpt) {
        this.velOpt = velOpt;
    }
    public int getCamaras() {
        return camaras;
    }
    public void setCamaras(int camaras) {
        this.camaras = camaras;
    }
    public double getAperturaOpt() {
        return aperturaOpt;
    }
    public void setAperturaOpt(double aperturaOpt) {
        this.aperturaOpt = aperturaOpt;
    }
    public int getZoom() {
        return zoom;
    }
    public void setZoom(int zoom) {
        this.zoom = zoom;
    }
    public int getValorISO() {
        return valorISO;
    }
    public void setValorISO(int valorISO) {
        this.valorISO = valorISO;
    }

    // Metodo toString
    @Override
    public String toString() {
        return "Camara{" +
                "resolucion=" + resolucion +
                ", velOpt=" + velOpt +
                ", camaras=" + camaras +
                ", aperturaOpt=" + aperturaOpt +
                ", zoom=" + zoom +
                ", valorISO=" + valorISO +
                '}';
    }
}