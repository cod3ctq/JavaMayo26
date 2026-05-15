
public class Iphone {

    //Atributos de clase
    //static + final = CONSTANTES
    //YA NO NECESITAN SETTER POR QUE YA SON CONSTANTES: SUS VALORES NO SE VAN A REASIGNAR
    //YA NO NECESITAN GETTER POR QUE SIGUEN SIENDO ESTATICOS: PUEDES USARLO CON SOLO LLAMAR A LA CLASE
    public static final String SISTEMA_OPERATIVO = "iOs";
    public static final String MARCA = "Apple";

    //Atributos de instancia
    private String color;
    private String modelo;

    public Iphone(){}

    public Iphone(String color, String modelo) {
        this.color = color;
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
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
