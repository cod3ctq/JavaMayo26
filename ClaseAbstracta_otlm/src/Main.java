public class Main {
    public static void main(String[] args){
        //Clases abstarctas : Padre, plantilla, base, no puedes instanciarlas
        //Metodo abstracto: no tinene implementacion, sin logica

        EnvioFrio ef = new EnvioFrio("Calzada Guadalupe #123", "Pepito", "20/05/2026", false, 1000, false, 1000, -5);

        System.out.println(ef.calcularCosto());

        EnvioInternacional ei = new EnvioInternacional("Calzada Guadalupe #123", "Pepito", "20/05/2026", false, 1000, false, 2500, "Argentina", "Terrestre", "Peso Argentino");

        ef.calcularCosto();
        ef.validarDatos();

        ei.calcularCosto();
        ei.validarDatos();

        Doctor d1 = new Doctor();
        AnalistaDatos  an = new AnalistaDatos();

        d1.trabajar();
        an.trabajar();

        //Polimorfismo : Multiples formas de...
        /*
        Sobrecarga de argumentos : creacion de varios metodos con el mismo nombre pero diferente implimentacion
        Sobreescritura : Redefinicion de la logica de un metodo. Hacer lo mismo de una forma diferente
        Mutacion de clases : Heredar, implementar metodos de interfaces
         */

    }
}
