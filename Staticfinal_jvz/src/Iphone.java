
public class Iphone {

    //Atributos de la clase
    //Static + final = CONSTANTES
    //Ya no necesitan setter  por que ya sopn constantes: sus valores no se van a reasignar.
    //Ya no necesitan getters por que siguen siendo estaticos: Puedes usarlo con solo llamar a la clase.
    public static final String SISTEMA_OPERATIVO = "iOs";
    public static final String MARCA = "Apple";

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
