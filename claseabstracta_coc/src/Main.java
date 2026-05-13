public class Main {
    public static void main(String[] args) {

        // Clases abstractas
        // Métodos abstractos

        // Creamos Objetos de las Clases hijas
        EnvioFrio ef = new EnvioFrio("Nacional 281", "Jaime", "20/05", false, 1000, false, 1000, -5);
        System.out.println(ef.calcularCosto());

        EnvioInternacional ei = new EnvioInternacional("Nacional 281", "Jaime", "20/05", false, 1000, false, 2500, "Argentina", "Terrestre", "Peso argentino");
        System.out.println(ei.calcularCosto());

        // Llamamos a Métodos desde los distintos Objetos
        ef.calcularCosto();
        ef.validarDatos();

        ei.calcularCosto();
        ei.validarDatos();

        Doctor doc = new Doctor();
        AnalistaDatos ad = new AnalistaDatos();

        doc.trabajar();
        ad.trabajar();
    }
}