import java.awt.desktop.SystemEventListener;
import java.util.Scanner;

//Herencia permire reutilizar y/o absorber los miembros de
//de una clase en otra
//Herencia relacion "ES UN"
//Permite especializar modelos
public class Smartphone extends Celular{

    String sistemaOperaivo;
    Camara[] cam; //atributo compuesto

    public Smartphone(String modelo, String marca, double precio, int mAh, String sistemaOperaivo, Camara[] cam) {
        super(modelo, marca, precio, mAh);
        this.sistemaOperaivo = sistemaOperaivo;
        this.cam = cam;
    }

    public Smartphone(){}

    public String getSistemaOperaivo() {
        return sistemaOperaivo;
    }

    public void setSistemaOperaivo(String sistemaOperaivo) {
        this.sistemaOperaivo = sistemaOperaivo;
    }


    @Override
    public String toString() {
        return "Smartphone{" +
                "sistemaOperaivo='" + sistemaOperaivo + '\'' +
                ", modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", precio=" + precio +
                ", mAh=" + mAh +
                '}';
    }
    //Metodo de la forma 2 : Heredado y sobreescrito
    @Override //<<--- sobreescritura
    public void mandarMensaje(String numero, String  mensaje){
        Scanner sc = new Scanner(System.in);
        System.out.println("1 - Mensaje de texto");
        System.out.println("2 - Mensaje por whatsapp");
        System.out.println("3 - Mensaje por telegram");
        System.out.println("4 - Mensaje por messenger");
        System.out.println("5 - Mensaje por instagram");
        System.out.println("6 - Mensaje de Voz");
        System.out.println("Ingresa una opcion");
        int seleccion = sc.nextInt();
        switch(seleccion){
            case 1:
                System.out.println("Mandando:[ "+mensaje+" ] por texto");
                break;
            case 2:
                System.out.println("Mandando:[ "+mensaje+" ] por whatsapp");
                break;
            case 3:
                System.out.println("Mandando:[ "+mensaje+" ] por telegram");
                break;
            case 4:
                System.out.println("Mandando:[ "+mensaje+" ] por messenger");
                break;
            case 5:
                System.out.println("Mandando:[ "+mensaje+" ] por instagram");
                break;
            case 6:
                System.out.println("Mandando:[ "+mensaje+" ] por Voz");
                break;
        }

    }

    public void hacerLlamada(String numero){
        System.out.println( "Marcando al numero:> "+numero);
    }


}