import java.sql.*; // * importa todo lo que este relacionado a sql
import java.util.ArrayList;
import java.util.List;

public class ModuloAtencion implements IServiciosCliente {

    //Inyeccion Manual
    ClienteDAO clienteDAO = new ClienteDAO();


    @Override
    public void registrarCliente() {
    }
    @Override
    public void registrarCliente(Cliente cliente) {
        clienteDAO.guardarCliente(cliente);
    }

    @Override
    public List obtenerClientes(){

        return clienteDAO.obtenerClientes();
    }
    public void mostrarClientes(){
        List<Cliente> clientes = this.obtenerClientes();
        for (Cliente cliente:clientes){
            System.out.println(cliente);
        }
    }
}
