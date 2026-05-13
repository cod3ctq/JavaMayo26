//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

    //UNA INTERFACE ES UN CONTRATO DE ACCIONES
        //Diseniada en QUE acciones debe cumplir, sin pensar en quien las va a hacer
        //No contiene atributos, constructores, getter/setters PORQUE NO ES UNA CLASE



        Chofer c1 = new Chofer("Joel","Masculino",38);
        c1.conducir();


        //Invocacion de 3 metodos o interfaces diferentes
        c1.afinacion();
        c1.medir();
        c1.nadar();

    }
}