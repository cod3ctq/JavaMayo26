package paquete2;

import paquete1.Casa; // Se importa el paquete1 que contiene la Clase Casa

public class CasaLejana extends Casa {

    //Casa c = new Casa(); // Creamos Objeto de la Clase Casa

    public CasaLejana() {
        //c.direccion = "asdfg"; // Se puede acceder de manera directa porque es pública, PERO NO ES CORRECTO (antes de heredar)
        this.direccion = "asdfg"; // Ahora podemos acceder directamente porque estamos heredando y Casa y sus miembros ya son parte de esta Clase
        //c.setDireccion("asdfg"); // Esta es la manera correcta, a través de getters/setters

        //c.parque = "qwerty"; // Protected, sin acceso a él desde otros paquetes (3er nivel)
        this.parque = "qwerty"; // De esta manera podemos acceder a él

        // Modificador protected extiende su alcance a las clases hijas cuando se hereda
    }
}