//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Clase abstracta: Padre, plantilla, base, no puedes instanciarla
        //Metodo abstracto: no tiene implementacion, sin logica

        //Envio e = new Envio(); //Error porque es abstracta, no puede instanciarse

        //Objetos de las clases hijas: a traves de estos se define y ejecuta la logica de su clase padre
        EnvioFrio ef = new EnvioFrio("Calzada Guadalupe #256", "Jaime", "28/12/26", false, 1000, false, 1000,-5);

        System.out.println(ef.calcularCosto());


        EnvioInternacional ei = new EnvioInternacional("Calzada Guadalupe #256", "Jaime", "28/12/26", false, 1000, false, 2500, "Argentina", "Terrestre", "Pesos argentinos");

        ef.calcularCosto();
        ef.validarDatos();

        ei.calcularCosto();
        ei.validarDatos();



        //Profesionista pft = new Profesionista();
        Doctor doc = new Doctor();
        Analista an =  new Analista();

        doc.trabajar();
        an.trabajar();



        //POLIMORFISMO: VARIAS FORMAS DE

    }
}