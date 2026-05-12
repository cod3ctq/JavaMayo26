public class Pantalla {
    String resolucion;//8k, 4k, fullHD
    double tamaño;
    boolean tactil;
    boolean color;
    int nits;
    double tazaRes;

    public Pantalla(){}

    public Pantalla(String resolucion, double tamaño, boolean tactil, boolean color, int nits, double tazaRes) {
        this.resolucion = resolucion;
        this.tamaño = tamaño;
        this.tactil = tactil;
        this.color = color;
        this.nits = nits;
        this.tazaRes = tazaRes;
    }

    public String getResolucion() {
        return resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    public double getTamaño() {
        return tamaño;
    }

    public void setTamaño(double tamaño) {
        this.tamaño = tamaño;
    }

    public boolean isTactil() {
        return tactil;
    }

    public void setTactil(boolean tactil) {
        this.tactil = tactil;
    }

    public boolean isColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public int getNits() {
        return nits;
    }

    public void setNits(int nits) {
        this.nits = nits;
    }

    public double getTazaRes() {
        return tazaRes;
    }

    public void setTazaRes(double tazaRes) {
        this.tazaRes = tazaRes;
    }

    @Override
    public String toString() {
        return "Pantalla{" +
                "resolucion='" + resolucion + '\'' +
                ", tamaño=" + tamaño +
                ", tactil=" + tactil +
                ", color=" + color +
                ", nits=" + nits +
                ", tazaRes=" + tazaRes +
                '}';
    }
}
