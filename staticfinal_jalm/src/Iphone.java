public class Iphone {
    // Atributos de clase:
    // static + final = constantes.
    // Ya no necesitan setter porque ya son constantes: sus valores no se van a reasignar.
    // Ya no necesitan getter porque siguen siendo estaticos: puedes usarlos llamando a la clase.
    public static final String SISTEMA_OPERATIVO = "iOS";
    public static final String MARCA = "Apple";

    // Atributos de instancia:
    // No son static porque cada iPhone puede tener su propio color y modelo.
    private String color;
    private String modelo;


    // Constructor vacio: permite crear un Iphone sin mandar datos al inicio.
    public Iphone(){

    }

    // Constructor con parametros: permite crear un Iphone con color y modelo.
    public Iphone(String color, String modelo) {
        this.color = color;
        this.modelo = modelo;
    }

    // Regresa el color de este iPhone en especifico.
    public String getColor() {
        return color;
    }

    // Cambia el color de este iPhone en especifico.
    public void setColor(String color) {
        this.color = color;
    }

    // Regresa el modelo de este iPhone en especifico.
    public String getModelo() {
        return modelo;
    }

    // Cambia el modelo de este iPhone en especifico.
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
