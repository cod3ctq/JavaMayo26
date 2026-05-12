//La herencia permite reutilizar y/o absorber los miembros de una clase en otra

import java.util.Scanner;

public class Smartphone extends Celular{

    String sistemaOperativo;

    Camara []cam;

    public  Smartphone(){

    }

    public Smartphone(String modelo, String marca, Double precio, int mAh, String sistemaOperativo, Camara[] cam) {
        super(modelo, marca, precio, mAh);
        this.sistemaOperativo = sistemaOperativo;
        this.cam = cam;
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
                ", modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", precio=" + precio +
                ", mAh=" + mAh +
                '}';
    }

    //Metodo de la forma 2: Heradado y sobreescrito
    @Override //indica sobrescritura
    public void mandarMensaje(String numero, String mensaje){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingresa una opcion:\n1-Mensaje de texto\n2-Mensaje por WhatsApp\n3-Mensaje por telegram\n4-Mensaje por messenger\n5-Mensaje por instagram\n6-Mensaje de voz");
        System.out.println("Ingresa una opcion:");
        int seleccion = teclado.nextInt();
        switch (seleccion){
            case 1:
                System.out.println("Mandando: [" + mensaje+"] por texto" );
                break;
            case 2:
                System.out.println("Mandando: [" + mensaje+"] por WhatsApp" );
                break;
            case 3:
                System.out.println("Mandando: [" + mensaje+"] por telegram" );
                break;
            case 4:
                System.out.println("Mandando: [" + mensaje+"] por messenger" );
                break;
            case 5:
                System.out.println("Mandando: [" + mensaje+"] por instagram" );
                break;
            case 6:
                System.out.println("Mandando: [" + mensaje+"] por voz" );
                break;
        }

    }
    public void hacerLlamada(String numero){
        System.out.println("Marcando al numero: "+numero);
    }


}
