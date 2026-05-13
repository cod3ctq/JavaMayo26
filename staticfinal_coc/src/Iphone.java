public class Iphone {

    // final: CONSTANTES
    // Ya no necesitan Setters porque sus valores ya no se van a reasignar
    // Ya no necesitan Getters porque siguen siendo static, se pueden usar llamando directamente a la Clase
    public static final String SISTEMA_OPERATIVO = "iOs";
    public static final String MARCA = "Apple";

    private String color;
    private String modelo;

    // Constructores
    public Iphone() {
    }
    public Iphone(String color, String modelo) { // Constructor con parámetros no incluye los atributos estáticos
        this.color = color;
        this.modelo = modelo;
    }

    // Getters/Setters
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

    // Metodo toString
    @Override
    public String toString() {
        return "Iphone{" +
                "color='" + color + '\'' +
                ", modelo='" + modelo + '\'' +
                '}';
    }
}