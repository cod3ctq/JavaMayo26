public class Camarajava {

    double resolucion;
    double velopt;
    int cams;
    double aperturaOpt;
    int zoom;
    int valorISO;

    public Camarajava(double resolucion, double velopt, int cams, double aperturaOpt, int zoom, int valorISO) {
        this.resolucion = resolucion;
        this.velopt = velopt;
        this.cams = cams;
        this.aperturaOpt = aperturaOpt;
        this.zoom = zoom;
        this.valorISO = valorISO;

    }

    public double getResolucion() {
        return resolucion;
    }

    public void setResolucion(double resolucion) {
        this.resolucion = resolucion;
    }

    public double getVelopt() {
        return velopt;
    }

    public void setVelopt(double velopt) {
        this.velopt = velopt;
    }

    public int getCams() {
        return cams;
    }

    public void setCams(int cams) {
        this.cams = cams;
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

    @Override
    public String toString() {
        return "Camarajava{" +
                "resolucion=" + resolucion +
                ", velopt=" + velopt +
                ", cams=" + cams +
                ", aperturaOpt=" + aperturaOpt +
                ", zoom=" + zoom +
                ", valorISO=" + valorISO +
                '}';
    }
}
