public class Iphone {
    //atributos de clase
//    public static  String sistemaOperativo="ios";
//    public static  String marca="Apple";
//
    //FINAL STATIC
    // combinacion de static final, crea una constante CONSTANTE
    //YA NO NECESITAN SETTER PORQUE YA SON CONSTANTRS: SUS VALORES NO SE VAN A REASIGNAN
    //GETTER PORQUE SIGUEN SIENDO ESTATIVOS: PUEDES USARLOS CON SOLO LLAMAR A LA CLASE
    public static final String SISTEMA_OPERATIVO="ios";
    public static final String MARCA="Apple";


    //atributos de instancia
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
