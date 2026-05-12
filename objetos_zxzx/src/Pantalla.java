public class Pantalla {

    String resolucion; //8K, 4K, FullHD
    double tamaño;
    boolean tactil;
    boolean color;
    int nits;
    double tazaRef;

    public Pantalla(){}

    public Pantalla(String resolucion, double tamaño, boolean tactil, boolean color, int nits, double tazaRef) {
        this.resolucion = resolucion;
        this.tamaño = tamaño;
        this.tactil = tactil;
        this.color = color;
        this.nits = nits;
        this.tazaRef = tazaRef;
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

    public double getTazaRef() {
        return tazaRef;
    }

    public void setTazaRef(double tazaRef) {
        this.tazaRef = tazaRef;
    }

    @Override
    public String toString() {
        return "Pantalla{" +
                "resolucion='" + resolucion + '\'' +
                ", tamaño=" + tamaño +
                ", tactil=" + tactil +
                ", color=" + color +
                ", nits=" + nits +
                ", tazaRef=" + tazaRef +
                '}';
    }
}
