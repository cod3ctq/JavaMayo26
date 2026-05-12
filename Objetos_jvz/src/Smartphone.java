//La herencia permite reutilizar y/o absorver los miembros de una clase en otra.
//Herencia relación "ES UN"
//Permite especializar modelos

import java.util.Arrays;
import java.util.Scanner;

public class Smartphone extends Celular{

    String sistemaOperativo;
    Camarajava[] cams;
    Pantalla display;

    public Smartphone(String modelo, String marca, double precio, int mAh, String sistemaOperativo, Camarajava[] cams, Pantalla display) {
        super(modelo, marca, precio, mAh);
        this.sistemaOperativo = sistemaOperativo;
        this.cams = cams;
        this.display = display;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    public Camarajava[] getCams() {
        return cams;
    }

    public void setCams(Camarajava[] cams) {
        this.cams = cams;
    }

    public Pantalla getDisplay() {
        return display;
    }

    public void setDisplay(Pantalla display) {
        this.display = display;
    }


    //Método de la forma 2: Heredado y sobreescrito
    @Override  // <<---- sobreescritura
    public void mandarMensaje(String numero, String mensaje){
        Scanner sc = new Scanner(System.in);
        System.out.println("1 - Mensaje de texto");
        System.out.println("2 - Mensaje de whaptsapp");
        System.out.println("3 - Mensaje de telegram");
        System.out.println("4 - Mensaje de messenger");
        System.out.println("5 - Mensaje de instagram");
        System.out.println("6 - Mensaje de voz");
        System.out.println("Ingresa una opción");
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
        System.out.println("Marcando al número:> "+numero);
    }

    public void instalarAplicaciones(){

    }
    public void hacerVideoLlamada(){

    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "sistemaOperativo='" + sistemaOperativo + '\'' +
                ", cams=" + Arrays.toString(cams) +
                ", display=" + display +
                ", modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", precio=" + precio +
                ", mAh=" + mAh +
                '}';
    }
}

