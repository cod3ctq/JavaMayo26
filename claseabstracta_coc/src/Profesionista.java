import java.util.Arrays;

public abstract class Profesionista {

    String nombre;
    String carrera;
    int aniosExp;
    boolean tieneTitulo;
    String cedulaProf;
    String[] idiomas;

    // Constructores
    public Profesionista() {
    }
    public Profesionista(String nombre, String carrera, int aniosExp, boolean tieneTitulo, String cedulaProf, String[] idiomas) {
        this.nombre = nombre;
        this.carrera = carrera;
        this.aniosExp = aniosExp;
        this.tieneTitulo = tieneTitulo;
        this.cedulaProf = cedulaProf;
        this.idiomas = idiomas;
    }

    // Getters/Setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCarrera() {
        return carrera;
    }
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    public int getAniosExp() {
        return aniosExp;
    }
    public void setAniosExp(int aniosExp) {
        this.aniosExp = aniosExp;
    }
    public boolean isTieneTitulo() {
        return tieneTitulo;
    }
    public void setTieneTitulo(boolean tieneTitulo) {
        this.tieneTitulo = tieneTitulo;
    }
    public String getCedulaProf() {
        return cedulaProf;
    }
    public void setCedulaProf(String cedulaProf) {
        this.cedulaProf = cedulaProf;
    }
    public String[] getIdiomas() {
        return idiomas;
    }
    public void setIdiomas(String[] idiomas) {
        this.idiomas = idiomas;
    }

    // Metodo toString
    @Override
    public String toString() {
        return "Profesionista{" +
                "nombre='" + nombre + '\'' +
                ", carrera='" + carrera + '\'' +
                ", aniosExp=" + aniosExp +
                ", tieneTitulo=" + tieneTitulo +
                ", cedulaProf='" + cedulaProf + '\'' +
                ", idiomas=" + Arrays.toString(idiomas) +
                '}';
    }

    // Métodos abstractos
    public abstract void trabajar();
}