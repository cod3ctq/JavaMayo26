public class Chofer implements IMecanica, ICarpinteria, IBuceo{

    String nombre;
    String sexo;
    int edad;

    //Principios SOLID


    public Chofer(){}

    public Chofer(String nombre, String sexo, int edad) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
    }

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

    @Override
    public String toString() {
        return "Chofer{" +
                "nombre='" + nombre + '\'' +
                ", sexo='" + sexo + '\'' +
                ", edad=" + edad +
                '}';
    }

    //Metodo de la forma 1: metodo nativo.
    public void conducir(){}


    @Override
    public void cambiarAceite() {
        //Programar como es que el chofer cambiaria el aceite, puede no ser
        //de la misma forma en que un mecanico lo haria.
    }

    @Override
    public void afinacion() {

    }

    @Override
    public void manejar() {

    }

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
