public class Chofer implements IMecanica, ICarpinteria, IBuceo {

    String nombre;
    String sexo;
    int edad;

    // Constructores
    public Chofer() {
    }
    public Chofer(String nombre, String sexo, int edad) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
    }

    // Getters/Setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }

    // Metodo toString
    @Override
    public String toString() {
        return "Chofer{" +
                "nombre='" + nombre + '\'' +
                ", sexo='" + sexo + '\'' +
                ", edad=" + edad +
                '}';
    }

    // Metodo nativo de este modelo
    public void conducir() {
    }

    // Métodos implementados de la interfaz IMecanica
    @Override
    public void cambiarAceite() {
        // Programar cómo es que el chofer cambiaría el aceite, puede no ser de la misma forma en que un mecánico lo haría
    }
    @Override
    public void afinacion() {
    }
    @Override
    public void manejar() {
    }

    // Métodos implementados de la interfaz ICarpinteria
    @Override
    public void lijar() {
    }
    @Override
    public void cortar() {
    }
    @Override
    public void medir() {
    }
    @Override
    public void armar() {
    }

    // Métodos implementados de la interfaz IBuceo
    @Override
    public void nadar() {
    }
    @Override
    public void controlarRespiracion() {
    }
    @Override
    public void descompresionar() {
    }
}