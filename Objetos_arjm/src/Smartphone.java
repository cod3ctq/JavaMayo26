//Herencia permite reutilizar y absorber los miembros de una clase en otra
//Herencia relacion "ES UN"
//Permite especializar modelos

import java.util.Arrays;
import java.util.Scanner;

public class Smartphone extends Celular {
    String sistemaOperativo;

 // atributo compuesto
    Camara[] cam;
    Pantalla display; //atributo compuesto



    public Smartphone (){}

    public Smartphone(String modelo, String marca, double costo, int mA, String sistemaOperativo, Camara[] cam, Pantalla display) {
        super(modelo, marca, costo, mA);
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


    //Metodo de la forma 2: heredadoysobreescrito
    @Override//sobreescritura
    //Sobre escritura
    public void mandarMensaje(String numero, String mensaje){
        Scanner sc = new Scanner(System.in);
        System.out.println("1 Mensaje de texto");
        System.out.println("2 Mensaje de whatsapp");
        System.out.println("3 Mensaje telegram");
        System.out.println("4 mensaje por messenger");
        System.out.println("5 mensaje por instagram");
        System.out.println("6 mensaje de voz");
        int seleccion = sc.nextInt();

        switch (seleccion){
            case 1:
                System.out.println("Mandando: [" + mensaje + "] por texto");
            break;
            case 2:
                System.out.println("Mandando: [" + mensaje + "] por whatsapp");
                break;
            case 3:
                System.out.println("Mandando: [" + mensaje + "] por teelgram");
                break;
            case 4:
                System.out.println("Mandando: [" + mensaje + "] messenger");
                break;
            case 5:
                System.out.println("Mandando: [" + mensaje + "] instagram ");
                break;
            case 6:
                System.out.println("Mandando: [" + mensaje + "]  de voz");
                break;
        }
    }


    public void hacerLlamada(String numero){
        System.out.println("Marcando al numero : " + numero );

    }
    //Representa acciones o metodos que puede hacer la clase hija,
    //Metodos
    public void instalarAplicaciones(){}

    public void hacerVideollamada(){}

    @Override
    public String toString() {
        return "Smartphone{" +
                "sistemaOperativo='" + sistemaOperativo + '\'' +
                ", cam=" + Arrays.toString(cam) +
                ", display=" + display +
                ", modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", costo=" + costo +
                ", mA=" + mA +
                '}';
    }
}
