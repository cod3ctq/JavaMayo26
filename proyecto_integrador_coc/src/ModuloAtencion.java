import java.util.List;

public class ModuloAtencion implements IServiciosCliente {

    // Inyección de dependencias manual
    ClienteDAO clienteDAO = new ClienteDAO();

    @Override
    public void registrarCliente(Cliente cliente) {
        /*
        Lógica del negocio para validar que el cliente se puede registrar correctamente
        ---
        ---
        ---
        ---
        ---
         */
        clienteDAO.guardarCliente(cliente); // Entonces ya podríamos llamar al metodo de clienteDAO para guardar el cliente
    }

    @Override
    public List obtenerClientes() {
        return clienteDAO.obtenerClientes();
    }

    public void mostrarClientes() {
        List<Cliente> clientes = this.obtenerClientes();
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }
}