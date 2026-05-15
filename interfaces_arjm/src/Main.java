//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Una interface es un contrato de acciones
        //Diseñada pensando en que acciones debe cumplir, sin pensar en quien las va a hacer
        //No contiene atributos, constructores, getter/setters por que no es un modelo



        Chofer c1 = new Chofer("joel","masculino", 38);
        c1.conducir();
        //Invocacion de metodos de 3 contextos o interfaces diferentes
        c1.conducir();
        c1.afinacion();
        c1.nadar();
        c1.medir();

//cUAL ES LA DIFERENCIA ENTRE UNA CLASE, clase ABSTRACTA VS INTERFACE
        //Clase: es un modelo (describe al sujeto, al objeto)
        //Clase abstracta: no puede instanciarse debido a que contiene al menos 1 metodo abstracto
        //Interface: contrato de acciones, no se trata de quien, si no de que acciones debe cumplir


    }
}