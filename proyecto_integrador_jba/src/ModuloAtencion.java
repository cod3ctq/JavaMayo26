import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ModuloAtencion implements IServiciosCliente{

   ClienteDAO clienteDAO= new ClienteDAO();


    @Override
    public void registrarCliente(Cliente cliente) {

        clienteDAO.guardarCliente(cliente);


    }

    @Override
    public List obtenerClientes() {
        return clienteDAO.obtenerClientes();
    }

    public void mostrarClientes(){
        List<Cliente> clientes =this.obtenerClientes();
        for (Cliente cliente:clientes){
            System.out.println(cliente);
        }
    }
}
