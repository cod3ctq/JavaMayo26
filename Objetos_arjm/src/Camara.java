public class Camara {

    double resolucion;
    double vel0pt;
    int cams;
    double apertura0pt;
    int zoom;
    int valorISO;


    public Camara(double resolucion, double vel0pt, int cams, double apertura0pt, int zoom, int valorISO) {
        this.resolucion = resolucion;
        this.vel0pt = vel0pt;
        this.cams = cams;
        this.apertura0pt = apertura0pt;
        this.zoom = zoom;
        this.valorISO = valorISO;
    }

    public double getResolucion() {
        return resolucion;
    }

    public void setResolucion(double resolucion) {
        this.resolucion = resolucion;
    }

    public double getVel0pt() {
        return vel0pt;
    }

    public void setVel0pt(double vel0pt) {
        this.vel0pt = vel0pt;
    }

    public int getCams() {
        return cams;
    }

    public void setCams(int cams) {
        this.cams = cams;
    }

    public double getApertura0pt() {
        return apertura0pt;
    }

    public void setApertura0pt(double apertura0pt) {
        this.apertura0pt = apertura0pt;
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
                ", vel0pt=" + vel0pt +
                ", cams=" + cams +
                ", apertura0pt=" + apertura0pt +
                ", zoom=" + zoom +
                ", valorISO=" + valorISO +
                '}';
    }
}
