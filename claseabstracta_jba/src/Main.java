//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Clases Abstractas:Padre, plantilla, base, no se puede instanciar.
        //Metodo Abstracto:no tiene implementacion, sin logica


        EnvioFrio ef = new EnvioFrio("Calzada de Guadalupe #254", "Jaime", "20/Mayo/2026", false, 1000, false, 1000, -5);
        System.out.println(ef.CalcularCosto());

        EnvioInternacional ei = new  EnvioInternacional("Calzada de Gaudalupe", "Jaime", "20/Mayo/2026", false, 1000, false, 2500, "Argentina", "Terrestre", "PArgentinos");

        ef.CalcularCosto();
        ef.ValidarDatos();

        ei.CalcularCosto();
        ei.ValidarDatos();

        //Profesionista pst = new Profesionista();

        Doctor d1 = new Doctor();
        AnalistaDatos an = new AnalistaDatos();

        d1.trabajar();
        an.trabajar();

        //Polimorfismo: Multiples formas de ..
        /*
        Sobrecarga de elementos: creacion de varios metodos con el mismo nombre pero formas distintas.
        sobreescritura: Redefinicion de la logica de un metodo. Hacer lo mismo pero de una forma diferente
        mutacion de clases:Heredar, implementar metodos de interfaces
         */

    }
}