//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Clases abstractas : Padre, plantilla, base, no puedes instanciarla
        //metodo abstracta : no tiene implementacion

        //Envio e = new Envio();
        //e.validarDatos();
        EnvioFrio ef = new EnvioFrio("Calzada Guadalupe #254","Jaime","20 de mayo",false,1000.00,false, 1000.00,-5);
        System.out.println(ef.calcularCosto());

        EnvioInternacional ei = new EnvioInternacional("Calzada Guadalupe #254","Jaime","20 de mayo",false,1000.00,false, 100.00,"argentina","terrestre","Peso Argentino");
        //invocando a los mismos metodos, desde objetos diferentes
        ef.calcularCosto();
        ef.validarDatos();
        ei.calcularCosto();
        ei.validarDatos();

        //Profesionista pst = new Profesionista()
        Doctor d1 = new Doctor();
        AnalistaDatos an = new AnalistaDatos();

        d1.trabajar();
        an.trabajar();

        //Polimorfismo: Multiples formas de
        /*
        Sobrecarga de argumentos : Creacion de varios metodos con el mismo nombre pero formas distintas
        Sobreescritura de argumentos: Redefinicion de la logica de un metodo hacer lo mismo de una forma diferente.
        Mutacion de clases : Heredar, implementar metodos de interface
         */
    }

}