//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Clases Abstractas:padre, plantilla, base

        //Metodo Abstracto:

//        Envio e = new Envio(); Error por que es abstracta, no puede instanciarse
//        e.validarDatos();


        //Objetos de las clases hijas :  a traves de estos se define y ejecuta la logica de su clase padre

        EnvioFrio ef = new EnvioFrio("Calzada Guadalupe numn:254", "Jaime", "20/05/2025",
                false, 1000, false, 1000, -5);
        System.out.println(ef.calcularCosto());
        EnvioInternacional ei = new EnvioInternacional("Calzada Guadalupe numn:254", "Jaime", "20/05/2025",
                false, 1000, false, 2500, "Argentina", "Terrestre", "kskls");

        ef.calcularCosto();
        ef.validarDatos();

        ei.calcularCosto();
        ei.validarDatos();

//Profesionista pst = new Profesionista();

        Doctor d1 = new Doctor();
        AnalistaDatos an = new AnalistaDatos();
        d1.trabajar();
        an.trabajar();

        //Polimorfismo: multiples formas de....
        /* sobrecarga de argumentos: creacion de varios metodos con el mismo nombre pero formas distintas
        * sobreescritura: es la redefinicion de la logica de un metodo hacer lo mismo de una forma diferente
        * mutacion de clases: heredar, implementar metodos de interfaces
        * */

    }
}