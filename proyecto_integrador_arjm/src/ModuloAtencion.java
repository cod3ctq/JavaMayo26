import java.sql.*; // * importa todo lo que este relacionado a sql
import java.util.ArrayList;
import java.util.List;

public class ModuloAtencion implements IServiciosCliente {

    Connection con = null;//Carga la conexion hacia la base de datos
    PreparedStatement ps = null;//Interprete, entrada de las sentencias a la base
    ResultSet rs = null;//Salida de los resultados


    @Override
    public void registrarCliente() {

    }

    @Override
    public void registrarCliente(Cliente cliente) {
        String query = "INSERT INTO CLIENTES(NOMBRE,AP_P,AP_M,DIRECCION,TELEFONO,CORREO,INE,RFC,FECHA_NAC)VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            Class.forName("oracle.jdbc.OracleDriver");//Cargar el driver
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","db1","admin");
            ps = con.prepareStatement(query);//Interpretacion o precomppilacion de a sentencia

            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApP());
            ps.setString(3, cliente.getApM());
            ps.setString(4, cliente.getDireccion());
            ps.setString(5, cliente.getTelefono());
            ps.setString(6, cliente.getCorreo());
            ps.setString(7, cliente.getIne());
            ps.setString(8, cliente.getRfc());
            ps.setDate(9,cliente.getFechaNac());

            int x = ps.executeUpdate();

            if (x > 0) {
                System.out.println("Insercion correcta, cliente registrado");
            }else {
                System.out.println("Error al insertar");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public List obtenerClientes() {
        String query= "SELECT * FROM CLIENTES";
        Cliente c = null;
        List<Cliente> clientes = new ArrayList<Cliente>();
        try{
            Class.forName("oracle.jdbc.OracleDriver");//Cargar el driver
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","db1","admin");
            ps = con.prepareStatement(query);//Interpretacion o precomppilacion de a sentencia
            rs = ps.executeQuery();//Ejecuta la secuencia

            while (rs.next()){
                c = new Cliente(rs.getInt("CLIENTE_ID"),rs.getString("NOMBRE"),
                        rs.getString("AP_P"),rs.getString("AP_M"),
                        rs.getString("DIRECCION"),rs.getString("TELEFONO"),
                        rs.getString("INE"), rs.getString("RFC"),
                        rs.getDate("FECHA_NAC"), rs.getString("STATUS"),
                        rs.getString("CORREO"));

                //aÑADIR EL CLIENTE A LA LISTA
                clientes.add(c);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return clientes;
    }


    public void mostrarClientes(){
        List<Cliente> clientes = this.obtenerClientes();
        for (Cliente cliente:clientes){
            System.out.println(cliente);
        }
    }
}
