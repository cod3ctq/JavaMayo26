public class Pantalla {

    // Atributos
    String resolucion;
    double tamanio;
    boolean esTactil;
    boolean esAColor;
    int nits;
    double tasaRef;

    // Constructores
    public Pantalla() {
    }
    public Pantalla(String resolucion, double tamanio, boolean esTactil, boolean esAColor, int nits, double tasaRef) {
        this.resolucion = resolucion;
        this.tamanio = tamanio;
        this.esTactil = esTactil;
        this.esAColor = esAColor;
        this.nits = nits;
        this.tasaRef = tasaRef;
    }

    // Getters/Setters
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
    public boolean isEsTactil() {
        return esTactil;
    }
    public void setEsTactil(boolean esTactil) {
        this.esTactil = esTactil;
    }
    public boolean isEsAColor() {
        return esAColor;
    }
    public void setEsAColor(boolean esAColor) {
        this.esAColor = esAColor;
    }
    public int getNits() {
        return nits;
    }
    public void setNits(int nits) {
        this.nits = nits;
    }
    public double getTasaRef() {
        return tasaRef;
    }
    public void setTasaRef(double tasaRef) {
        this.tasaRef = tasaRef;
    }

    // Metodo toString
    @Override
    public String toString() {
        return "Pantalla{" +
                "resolucion='" + resolucion + '\'' +
                ", tamanio=" + tamanio +
                ", esTactil=" + esTactil +
                ", esAColor=" + esAColor +
                ", nits=" + nits +
                ", tasaRef=" + tasaRef +
                '}';
    }
}