public class Iphone {

    //atributos de clase
    //STATIC + FINAL = CONSTANTES
    //YA NO NECESITAN SEETER PORQUE YA SON CONSTANTES: SUS VALOREAS NO SE VAN A REASIGNAR
    //YA NO NECESITAN GETTER PORQUE SIGUEN SIENDO ESTATICOS = PUEDES LLAMAR DIRECTO A LA CLASE.
    public static final String SISTEMA_OPERATIVO = "iOs";
    public static final String MARCA= "Apple";
    //atributos de instancia
    private String color;
    private String modelo;

    public Iphone(){}

    public Iphone(String color, String modelo) {
        this.color = color;
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Iphone{" +
                "color='" + color + '\'' +
                ", modelo='" + modelo + '\'' +
                '}';
    }
}
