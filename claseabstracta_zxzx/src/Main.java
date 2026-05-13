//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Clases abstractas : Padre, plantilla, base, no puedes instanciarla
        //Metodo abstracto : no tiene implementacion, sin logica

        //Envio e = new Envio(); Error por que es abstracta, no puede instanciarse

        //Objetos de las clases hijas : a traves de estos se define y ejecuta la logica de su clase padre
        EnvioFrio ef = new EnvioFrio("Calzada Guadalape #254",
                "Jaime","20/Mayo/2026",false,
                1000,false,1000,-5);

        System.out.println(ef.calcularCosto());

        EnvioInternacional ei = new EnvioInternacional("Calzada Guadalape #254",
                "Jaime","20/Mayo/2026",false,
                1000,false,2500,"Argentina","Terrestre","PARG");

        //Invocando a los mismmos metodos, desde objetos diferentes
        ef.calcularCosto();
        ef.validarDatos();

        ei.calcularCosto();
        ei.validarDatos();

        //Profesionista pst = new Profesionista();
        Doctor d1=new Doctor();
        AnalistaDatos an = new AnalistaDatos();

        d1.trabajar();
        an.trabajar();

        //Polimofirsmo : Multiples formas de ..
        /*
        Sobrecarga de argumentos: creacion de varios metodos con el mismo
        nombre pero formas distintas

        Sobreescritura: Redefinicion de la lógica de un metodo. Hacer lo mismo de una forma
        diferente

        Mutacion de clases: Heredar, implementar metodos de interfaces
         */








    }
}