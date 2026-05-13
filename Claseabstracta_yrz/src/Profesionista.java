import java.util.Arrays;

public abstract class Profesionista {
String nombre;
String carrera;
int añosEXp;
boolean titulado;
String cedula;
String[] idiomas;

public Profesionista(){}

    public Profesionista(String nombre, String carrera, int añosEXp, boolean titulado, String cedula, String[] idiomas) {
        this.nombre = nombre;
        this.carrera = carrera;
        this.añosEXp = añosEXp;
        this.titulado = titulado;
        this.cedula = cedula;
        this.idiomas = idiomas;
    }

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

    public int getAñosEXp() {
        return añosEXp;
    }

    public void setAñosEXp(int añosEXp) {
        this.añosEXp = añosEXp;
    }

    public boolean isTitulado() {
        return titulado;
    }

    public void setTitulado(boolean titulado) {
        this.titulado = titulado;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
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
                "nombre='" + nombre + '\'' +
                ", carrera='" + carrera + '\'' +
                ", añosEXp=" + añosEXp +
                ", titulado=" + titulado +
                ", cedula='" + cedula + '\'' +
                ", idiomas=" + Arrays.toString(idiomas) +
                '}';
    }

// metodo abstractp
    public abstract void trabajar();

}
