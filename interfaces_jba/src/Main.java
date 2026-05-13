//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //una interface en un contrato de acciones...
        //Diseñada en QUE acciones debe cumplir, sin pensar quien



        Chofer c1 = new Chofer("Joel Perez", "masculino",28);

        //invocacion de metodos de 3 contextos o interfaces diferentes
        c1.afinacion();
        c1.medir();
        c1.nadar();


        //cual es la diferiencia entre clase Abstracta vs Interface
        //Una clase es un modelo:(describe al sujeto, al objeto)
        //clase Abstracta: no puede instanciarse debido a que contiene almenos un metodo abstracto, modelo incompleto
        //Interface: contrato de acciones, no se trata de quien, sino de QUE acciones debe cumplir

    }
}