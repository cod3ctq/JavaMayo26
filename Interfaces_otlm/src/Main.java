public class Main {
    public static void  main(String[] args){
        //Una interface es un contrato de acciones
        //Diseñada en que acciones debe cumplis, sin pensar en quien las va hacer
        //No tiene atributos, constructores, getters/setters porque no es un modelo

        Chofer c1 = new Chofer("Joel","Masculino",38);
        c1.conducir();
        //Invocacion de metodos de 3 contextos o interfaces diferentes
        c1.afinacion();
        c1.medir();
        c1.nadar();

        //Cual es la diferencia entre clase, clase abstarcta y una interface
        //Clase es un modelo (describe al objeto)
        //Una clase abstracta : no puede instaciarse debido a que puede contener al menos un metodo abstracto, es un modelo incompleto
        //Interface: Un contrato de acciones, no se trata de quien, si no de que acciones debe cumplir

    }
}
