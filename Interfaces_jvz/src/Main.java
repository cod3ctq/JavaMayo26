public class Main {
    public static void main(String[] args) {

        //Una interface es un contrato de acciones ......
        //Diseñada pensando en QUE acciones debe cumplir, sin pensar en quien las va a hacer
        //No contiene atributos, constructores, getters/setters por





        Chofer c1 = new Chofer("Joel","Masculino",38);
        c1.conducir();
        //Invocación de metodos de 3 contextos o interfaces diferentes
        c1.afinacion();
        c1.medir();
        c1.nadar();


        //Cual es la diferencia entre clase, clase abstracta vs interface
        //Clase es un  modelo (describe al sujeto, al objeto)
        //Clase abstracta: No puede instanciarse debido a que contiene al menos 1 metodo abstracto
        //es un modelo incompleto
        //Interface: Contrato de acciones, no se trata de quien, sino de QUE acciones debe cumplir.







    }

}