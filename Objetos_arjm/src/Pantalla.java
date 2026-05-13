public class Pantalla {


    String resolucion; //8k,4k.1080
    double tamaño;
    boolean tactil;
    boolean color;
    int nits;
    double  velAct;

    public Pantalla (){};

    public Pantalla(String resolucion, double tamaño, boolean tactil, boolean color, int nits, double velAct) {
        this.resolucion = resolucion;
        this.tamaño = tamaño;
        this.tactil = tactil;
        this.color = color;
        this.nits = nits;
        this.velAct = velAct;
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

    public double getVelAct() {
        return velAct;
    }

    public void setVelAct(double velAct) {
        this.velAct = velAct;
    }

    @Override
    public String toString() {
        return "Pantalla{" +
                "resolucion='" + resolucion + '\'' +
                ", tamaño=" + tamaño +
                ", tactil=" + tactil +
                ", color=" + color +
                ", nits=" + nits +
                ", velAct=" + velAct +
                '}';
    }
}
