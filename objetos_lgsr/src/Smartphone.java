import java.util.Scanner;

public class Smartphone extends Celular{
//Herencia permite reutilizar y/o absorber los miembros de una clase en otra
    //herencia relacion "ES UN"
    //Permite especializar modelos
    String sistemaOperativo;
    Camara cam; // atributo compuesto
    Pantalla display;//atributo compuesto

    public Smartphone(String modelo, String marca, double precio, int mAH, String sistemaOperativo, Camara cam, Pantalla display) {
        super(modelo, marca, precio, mAH);
        this.sistemaOperativo = sistemaOperativo;
        this.cam = cam;
        this.display = display;
    }

    public Smartphone(){}

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }


    //Metodo de la forma 2: Heredado y sobreescrito
    @Override
    public void mandarMensaje(String numero, String mensaje) {
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
        System.out.println("Enviando mensaje : [" + mensaje + "]; al numero:> " + numero);
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "sistemaOperativo='" + sistemaOperativo + '\'' +
                ", cam=" + cam +
                ", display=" + display +
                ", modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", precio=" + precio +
                ", mAH=" + mAH +
                '}';
    }

    public void instalarApp(){

    }
    public void hacerVideoLlamada(){

    }

    public void hacerLlamada (String numero) {
        System.out.println("Marcando al numero:> " + numero);



    }
}
