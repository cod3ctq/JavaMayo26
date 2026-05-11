//Herenica permite reuitilizar y absorber los miembros de una
// una clase a otra

import java.util.Scanner;

// relacion "ES UN"
// permite especializar modelos
    public class Smarthphone extends Celular {
    String sistemaOperativo;
    Camara cam;//atributo compuesto

    public Smarthphone() {

    }

    public Smarthphone(String modelo, String marca, double precio, int mAh, String sistemaOperativo) {
        super(modelo, marca, precio, mAh);
        this.sistemaOperativo = sistemaOperativo;
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
                "modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", precio=" + precio +
                ", mAh=" + mAh +
                ", sistemaOperativo='" + sistemaOperativo + '\'' +
                '}';
    }
@Override
//significa sobreescritura
    public void mandarMensaje(String numero, String mensaje){
        Scanner scan=new Scanner(System.in);
        System.out.println("1. Mensaje de texto");
        System.out.println("2. Mensaje de whatsapp");
        System.out.println("3. Mensaje de telegram");
        System.out.println("4. Mensaje de messenger");
        System.out.println("5. Mensaje de instagram");
        System.out.println("6. Mensaje de voz");
        System.out.println("Ingrese una opcion");

        int seleccion=scan.nextInt();
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
                System.out.println("Mandando:[ "+mensaje+" ] por voz");
                break;

        }
        System.out.println("Enviando un mensaje: "+mensaje+" al numero:"+numero);
    }

    public void hacerLlamada(String numero){
        System.out.println("Marcando al numero:"+numero);
    }
}
