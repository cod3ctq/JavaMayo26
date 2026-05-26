import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class ModuloAtencion implements IServiciosCliente{

    //Inyeccion manual
    ClienteDAO clienteDAO = new ClienteDAO();

    @Override
    public void registrarCliente(Cliente cliente) {
        clienteDAO.guardarCliente(cliente);
    }

    @Override
    public List obtenerClientes() {
        return clienteDAO.obtenerClientes();
    }


    public void mostrarClientes(){
        List<Cliente> clientes = this.obtenerClientes();
        for(Cliente cliente:clientes){
            System.out.println(cliente);
        }
    }
}
