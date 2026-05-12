import java.util.Arrays;
import java.util.Scanner;

//La herencia permite reultilizar y o absorber los miembro de una clase en otra
//Herencia  relacion "ES UN" (por ejemplo un smartphone ES UN celular avanzado)
//Permite especializar modelos
public class Smartphone extends Celular{
    String sistemaOperativo;
    Camara[] cam;//atributo compuesto
    Pantalla display;//atributo compuesto

    public Smartphone(){
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
                "mAh=" + mAh +
                ", precio=" + precio +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", display=" + display +
                ", cam=" + Arrays.toString(cam) +
                ", sistemaOperativo='" + sistemaOperativo + '\'' +
                '}';
    }

    //Metodo de la forma 2 Heredao y sobreescrito
    @Override
    public void mandarMensaje(String  numero, String mensaje){
        Scanner sc = new Scanner(System.in);
        System.out.println("1 - Mensaje de texto");
        System.out.println("2 - Mensaje por whatsapp");
        System.out.println("3 - Mensaje por telegram");
        System.out.println("4 - Mensaje por messenger");
        System.out.println("5 - Mensaje por instagram");
        System.out.println("6 - Mensaje de Voz");
        System.out.println("Ingresa una opcion");
        int seleccion = sc.nextInt();
        switch(seleccion) {
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
    }

    public void hacerLlamada(String  numero){
        System.out.println("Marcando al numero: "+numero);
    }

    public void intalarAplicaciones(){

    }

    public void hacerVideollama(){

    }
}
