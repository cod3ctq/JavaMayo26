//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
//Clases abstracta
    //metodos abtractos

    // Mostrar la informacion esencial al usuario,
    //Es un modificador de acceso que se puede usar tanto en metodos o clases
    //son clases restringidas que no se pueden usar para crear objetos
    //nO tienen cuerpo para eso lo utilizan las clases heredadas

    //Son un tipo particular de clase, pero tienen una caracteristica, NO PUEDEN SER INSTANCIADA
    //Se utilizan como moldes para creacion de otras clases
    // una clase no puede heredar de varias clases, ejemplo
    // un padre puede tener varios hijos, pero un hijo no puede tener dos padres

EnvioFrio ef = new EnvioFrio("Calzada guadalupe","Jaime","10/mayo/2026",false,1000,false,1000,300,-5);
    System.out.println(ef.calcularCosto());
    System.out.println(ef);

    Doctor d1=new Doctor();
    Analista a1=new Analista();

    d1.trabajar();
    a1.trabajar();

    //polimorfismo: multiples formas de..
    /*
    sobrecarga de argumentos: creacion de varios metodos con el mismo nonmbre
    pero formas distintas (orden, cantidad, tipo de elemento)
    sobre escritura:--------Redefinicion de la logica de un metodo-----
    Hacer lo mismo de una forma diferente
    mutacion de clases: heredar, implementar metodos de interfaces,

    Interfaces
    Es una interconexion, es una coleccion de metodos abstractos donde tenemos atributos constantes
    todos los metodos son abstractos, dicen que son pero no como
    Las interfaces no tienen atributos,
    una interfaz es un contrato
     */
}
