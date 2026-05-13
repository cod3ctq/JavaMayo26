public class Pantalla {

    String resolucion; //8k 4k 1080
    double tamanio;
    boolean tactil;
    boolean color;
    int nits;
    double tazaRef;

    public Pantalla(){

    }

    public Pantalla(String resolucion, double tamanio, boolean tactil, boolean color, int nits, double tazaRef) {
        this.resolucion = resolucion;
        this.tamanio = tamanio;
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

    public double getTamanio() {
        return tamanio;
    }

    public void setTamanio(double tamanio) {
        this.tamanio = tamanio;
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
                ", tamanio=" + tamanio +
                ", tactil=" + tactil +
                ", color=" + color +
                ", nits=" + nits +
                ", tazaRef=" + tazaRef +
                '}';
    }
}
