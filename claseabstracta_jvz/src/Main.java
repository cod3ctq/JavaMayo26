public class Main {
    public static void main(String[] args) {

        //TEMA: Clases abstractas: Padre, plantilla, base
        //Método abstracto :no tiene implementacion, sin lógica.


        //Envio e = new Envio(); Esto es error por que es abstracta, no puede instanciarse


        //Objetos de las clases hijas : a traves de estos se define y ejecuta la logica de su clase padre
        EnvioFrio ef = new EnvioFrio("Calzada Guadalupe #254",
                "Jaime", "20/Mayo/2026",false,
                1000,false,1000,-5);

        System.out.println(ef.calcularCostos());

        EnvioInternacional ei = new EnvioInternacional("Calzada Guadalupe #254",
                "Jaime", "20/Mayo/2026",false,
                1000,false,2500,"Argentina","Terrestre","PARG");

        //Invocando a los mismos metodos, desde objetos diferentes
        ef.calcularCostos();
        ef.validarDatos();

        ei.calcularCostos();
        ei.validarDatos();

       //Profesionista pst = new Profesionista();

        Doctor di = new Doctor();
        Analista an = new Analista();

        di.trabajar();
        an.trabajar();

        //Polimorfismo: Multiples formas de...
        /*
        Sobrecarga de argumentos : Creacion de varios metodos con el mismo
        nombre pero formas distintas
        Sobreescritura: Es la redefinicion de la logica de un metodo. Hacer lo mismo de una forma
        diferente

        Mutación de clases : Heredar, implementar métodos de interfaces

         */







    }
}