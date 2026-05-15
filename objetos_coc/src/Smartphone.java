import java.util.Arrays;
import java.util.Scanner;

// La herencia permite reutilizar y/o absorber los miembros de una Clase en otra y permite especializar modelos
public class Smartphone extends Celular {

    // Atributos
    String sistemaOperativo;
    Camara[] cam; // Atributo compuesto (de otro Objeto)
    Pantalla display; // Atributo compuesto (de otro Objeto)

    // Constructores
    public Smartphone() {
    }
    public Smartphone(String modelo, String marca, double precio, int mAh, String sistemaOperativo, Camara[] cam, Pantalla display) {
        super(modelo, marca, precio, mAh);
        this.sistemaOperativo = sistemaOperativo;
        this.cam = cam;
        this.display = display;
    }

    // Getters/Setters
    public String getSistemaOperativo() {
        return sistemaOperativo;
    }
    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }
    public Camara[] getCam() {
        return cam;
    }
    public void setCam(Camara[] cam) {
        this.cam = cam;
    }

    // Métodos
    @Override // Metodo heredado y sobre escrito
    public void mandarMensaje(String numero, String mensaje) {
        Scanner scan = new Scanner(System.in);
        System.out.println("1 - Mensaje de texto");
        System.out.println("2 - Mensaje por whatsapp");
        System.out.println("3 - Mensaje por telegram");
        System.out.println("4 - Mensaje por messenger");
        System.out.println("5 - Mensaje por instagram");
        System.out.println("6 - Mensaje de voz");
        System.out.print("Ingresa una opcion: ");
        int seleccion = scan.nextInt();
        switch(seleccion) {
            case 1 -> System.out.println("Enviando: [ " + mensaje + " ] por texto");
            case 2 -> System.out.println("Enviando: [ " + mensaje + " ] por whatsapp");
            case 3 -> System.out.println("Enviando: [ " + mensaje + " ] por telegram");
            case 4 -> System.out.println("Enviando: [ " + mensaje + " ] por messenger");
            case 5 -> System.out.println("Enviando: [ " + mensaje + " ] por instagram");
            case 6 -> System.out.println("Enviando: [ " + mensaje + " ] por Voz");
        }
    }
    public void instalarApps() {
        System.out.println("Instalando Apps");
    }
    public void hacerVideollamada() {
        System.out.println("Haciendo videollamada");
    }

    // Metodo toString
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
}