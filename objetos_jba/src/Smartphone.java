import java.util.Arrays;
import java.util.Scanner;

// la herencia permite reutilizar y/o absorber los miembros de una clase en otra.
// Herencia relacion "ES UN"
//Permite especializar modelos
public class Smartphone extends Celular {

    String sistemaOperativo;
    Camara[] cam; //atributo compusto
    Pantalla display;

    public Smartphone() {
    }

    public Smartphone(String modelo, String marca, double precio, int mAh, String sistemaOperativo, Camara[] cam, Pantalla display) {
        super(modelo, marca, precio, mAh);
        this.sistemaOperativo = sistemaOperativo;
        this.cam = cam;
        this.display = display;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "sistemaOperativo='" + sistemaOperativo + '\'' +
                ", cam=" + Arrays.toString(cam) +
                ", display=" + display +
                ", modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", precio=" + precio +
                ", mAh=" + mAh +
                '}';
    }

    // metodo de la forma : Heredado y sobreescrito
    @Override //<<--- sobreescritura
    public void mandarMensaje(String numero, String mensaje) {
        Scanner scan = new Scanner(System.in);
        System.out.println("1 - Mensaje de texto");
        System.out.println("2 - Mensaje por Whatsapa");
        System.out.println("3 - Mensaje por Telegram");
        System.out.println("4 - Mensaje por messenger");
        System.out.println("5 - Mensaje por Instragram");
        System.out.println("6 - Mensaje de Voz");
        System.out.println("Ingresa una opcion");
        int seleccion = scan.nextInt();
        switch (seleccion) {
            case 1:
                System.out.println("Mandando:[ " + mensaje + " ] por texto");
                break;
            case 2:
                System.out.println("Mandando:[ " + mensaje + " ] por whatsapp");
                break;
            case 3:
                System.out.println("Mandando:[ " + mensaje + " ] por telegram");
                break;
            case 4:
                System.out.println("Mandando:[ " + mensaje + " ] por messenger");
                break;
            case 5:
                System.out.println("Mandando:[ " + mensaje + " ] por instagram");
                break;
            case 6:
                System.out.println("Mandando:[ " + mensaje + " ] por Voz");
                break;
        }



//    public void hacerLlamada(String numero){
//        System.out.println("Marcando al numero:> " +numero);
//    }
    }

    public void instalarAplicaciones (){}

    public void hacerVideollamada(){}

}
