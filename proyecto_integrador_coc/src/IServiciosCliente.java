import java.util.List;

public interface IServiciosCliente {
    // Todos los metodos en las interfaces son public
    void registrarCliente(Cliente cliente); // Metodo para registrar un cliente nuevo, recibirá como parámetro un Objeto de tipo Cliente (sin id)
    List obtenerClientes(); // Metodo que devolverá una Lista con los clientes
}