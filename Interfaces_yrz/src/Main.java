//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
// Una interface es un contrato de acciones
    //Design  pensando en que acciones debe cumplir,
    // SIn pensar en quien las va hacer
    //No contiene atributos, constructores, getter/setters
    // porque no es un modelo

    Chofer c1 = new Chofer("joel", "masculino", 38);
    c1.conducir();
    c1.nadar();
    c1.medir();
    c1.cambiarAceite();

    //Cual es la diferencia entre clase, clase abstracta vs interface
    // Clase es un modelo:(describe al sujeto, objeto)
    // Clase abstracta: no puede instanciarse debido a que contiene al menos
    // 1 metodo abstracto, modelo incompleto
    //Interface: es un contrato de acciones, no se trata de quien sino de que acciones debe cumplir


}
