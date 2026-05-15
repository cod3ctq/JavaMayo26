import java.util.Arrays;

public abstract class Profesionista {
    String Nombre;
    String carrera;
    int anosexp;
    boolean titulado;
    String[] idiomas;

    public Profesionista(){}

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getAnosexp() {
        return anosexp;
    }

    public void setAnosexp(int anosexp) {
        this.anosexp = anosexp;
    }

    public boolean isTitulado() {
        return titulado;
    }

    public void setTitulado(boolean titulado) {
        this.titulado = titulado;
    }

    public String[] getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String[] idiomas) {
        this.idiomas = idiomas;
    }

    @Override
    public String toString() {
        return "Profesionista{" +
                "Nombre='" + Nombre + '\'' +
                ", carrera='" + carrera + '\'' +
                ", anosexp=" + anosexp +
                ", titulado=" + titulado +
                ", idiomas=" + Arrays.toString(idiomas) +
                '}';
    }

    public Profesionista(String nombre, String carrera, int anosexp, boolean titulado, String[] idiomas) {
        Nombre = nombre;
        this.carrera = carrera;
        this.anosexp = anosexp;
        this.titulado = titulado;
        this.idiomas = idiomas;


    }

    //metodo abstracto
    public abstract void trabajar();
}
