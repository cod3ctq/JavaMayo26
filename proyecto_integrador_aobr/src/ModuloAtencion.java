import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ModuloAtencion implements IServiciosCliente{

    Connection con = null; //carga la conexion hacia la bd
    PreparedStatement ps = null;
    ResultSet rs = null;



    @Override
    public void registrarCliente(Cliente cliente) {

        String query="INSERT INTO CLIENTES(NOMBRE,AP_P,AP_M,DIRECCION,TELEFONO,CORREO,INE,RFC,FECHA_NAC)VALUES(?,?,?,?,?,?,?,?,?)";

        try {
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "db1", "admin");
            ps = con.prepareStatement(query);

            //Acomodar los valores en los marcadores de posicion de la sentencia
            ps.setString(1,cliente.getNombre());
            ps.setString(2, cliente.getApP());
            ps.setString(3, cliente.getApM());
            ps.setString(4, cliente.getDireccion());
            ps.setString(5, cliente.getTelefono());
            ps.setString(6, cliente.getCorreo());
            ps.setString(7, cliente.getIne());
            ps.setString(8, cliente.getRfc());
            ps.setDate(9, cliente.getFechaNac());

            //Ejecutando la sentencia de insercion
            int x = ps.executeUpdate();
            if(x>0){
                System.out.println("Insercion correcta, cliente registrado");
            } else {
                System.out.println("Error al insertar");
            }


        }catch(Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public List obtenerClientes() {
        String query="SELECT * FROM CLIENTES";
        Cliente c = null;
        List<Cliente> clientes = new ArrayList<Cliente>();
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","db1", "admin");
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while(rs.next()){

                c = new Cliente(rs.getInt("CLIENTE_ID"), rs.getString("NOMBRE"),
                        rs.getString("AP_P"), rs.getString("AP_M"),
                        rs.getString("DIRECCION"), rs.getString("TELEFONO"),
                        rs.getString("INE"), rs.getString("RFC"),
                        rs.getDate("FECHA_NAC"), rs.getString("STATUS"),
                        rs.getString("CORREO"));
                //aniadir el cliente a la lista
                clientes.add(c);

            }

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        return clientes;
    }

    public void mostrarClientes(){
        List<Cliente> clientes = this.obtenerClientes();

        for(Cliente cliente: clientes){
            System.out.println(cliente);
        }
        
    }

}
