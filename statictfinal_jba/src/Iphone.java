public class Iphone {
    //Atributos de clase
    //static + final constantes
    //ya no necesitan setter por que ya no son
    public static final String SISTEMA_OPERATIVO = "iOS";
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
