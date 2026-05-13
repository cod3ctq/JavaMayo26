//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // una interface es un contrato de acciones...
        //Disenada pensando en que acciones debe cumplir, sin pensar en quien las hace
        //no contiene atributos, constructores, getters/setters, etc.

        Chofer c1 = new Chofer("Joel","hombre", 56);
        c1.afinacion();
        c1.conducir();
        c1.nadar();

        //cual es la diferencia entre clase, clase abstracta y una interface
        //Clase es un modelo(describe al sujeto,objeto)
        //Clase abstracta : no puede instanciarse debido a que contiene al menos un metodo abstracto, modelo incompleto.
        //Interface:Contrato de acciones, no se trata de quien, sino de que acciones debe cumplir

    }
}