public class Iphone {

    //Atributos de clase
    //static + final = Constantes
    //YA NO NECESITAN SETTER POR QUE YA SON CONSTANTES: SUS VALORES NO SE REASIGNAN
    //YA NO NECESITAN GETTER POR QUE SIGUEN SIENDO ESTATICOS: PUEDES USARLO CON LLAMAR A LA CLASE
    public static final String SISTEMA_OPERATIVO = "ios";
    public static final String MARCA = "Apple";


    //Atributos de instancia
    private String color;
    private String modelo;

    public Iphone (){} //Constructor vacio

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
