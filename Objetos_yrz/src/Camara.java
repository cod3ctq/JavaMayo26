public class Camara {
    double resolucion;
    double velOpt;
    int cams;
    double aperturaOpt;
    int zoom;
    int valorISO;

    public Camara(double resolucion, double velOpt, int cams, double aperturaOpt, int zoom, int valorISO) {
        this.resolucion = resolucion;
        this.velOpt = velOpt;
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

    public double getVelOpt() {
        return velOpt;
    }

    public void setVelOpt(double velOpt) {
        this.velOpt = velOpt;
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
        return "Camara{" +
                "resolucion=" + resolucion +
                ", velOpt=" + velOpt +
                ", cams=" + cams +
                ", aperturaOpt=" + aperturaOpt +
                ", zoom=" + zoom +
                ", valorISO=" + valorISO +
                '}';
    }
}
