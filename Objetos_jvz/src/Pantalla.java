public class Pantalla {

    String resolucion;
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
}
