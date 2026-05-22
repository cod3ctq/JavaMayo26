import java.sql.*; // Para no hacer tantos imports y jalar por completo este paquete / JDBC
import java.util.ArrayList;
import java.util.List;

public class ModuloAtencion implements IServiciosCliente {

    Connection con = null; // Carga la conexión hacia la db
    PreparedStatement ps = null; // Intérprete, entrada de las sentencias a la db
    ResultSet rs = null; // Salida de los resultados, se almacenan aquí

    @Override
    public void registrarCliente(Cliente cliente) { // Metodo para registrar un cliente nuevo, recibirá como parámetro un Objeto de tipo Cliente (sin id)

        // Creamos variable con la sentencia INSERT, los signos ? en las sentencias se llaman "marcadores de posición"
        String query = "INSERT INTO CLIENTES(NOMBRE, AP_P, AP_M, DIRECCION, TELEFONO, CORREO, INE, RFC, FECHA_NAC) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            Class.forName("oracle.jdbc.OracleDriver"); // Cargar el driver, necesitamos descargarlo de Oracle
            // Inicializamos conexión con el metodo getConnection() de la Clase DriverManager
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "db1", "admin");
            ps = con.prepareStatement(query); // Interpretación/precompilación de la sentencia que queremos usar con el Metodo prepareStatement()
            ps.setString(1, cliente.getNombre()); // En el primer ? asignamos el nombre del Objeto Cliente
            ps.setString(2, cliente.getApP()); // En el segundo ? asignamos el apellido paterno del Objeto Cliente
            ps.setString(3, cliente.getApM()); // En el tercer ? asignamos el apellido materno del Objeto Cliente
            ps.setString(4, cliente.getDireccion()); // En el cuarto ? asignamos la dirección del Objeto Cliente
            ps.setString(5, cliente.getTelefono()); // En el quinto ? asignamos el teléfono del Objeto Cliente
            ps.setString(6, cliente.getCorreo()); // En el sexto ? asignamos el correo del Objeto Cliente
            ps.setString(7, cliente.getIne()); // En el séptimo ? asignamos el INE del Objeto Cliente
            ps.setString(8, cliente.getRfc()); // En el octavo ? asignamos el RFC del Objeto Cliente
            ps.setDate(9, cliente.getFechaNac()); // En el noveno ? asignamos la fecha de nacimiento del Objeto Cliente
            int x = ps.executeUpdate(); // Se ejecuta la sentencia con el metodo executeUpdate() porque habrá un cambio en la db
            if (x > 0) { // La variable x creada en la línea anterior debe almacenar un 1 en caso de haberse insertado correctamente el cliente
                System.out.println("Inserción correcta, cliente registrado");
            } else {
                System.out.println("Error al insertar");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    @Override
    public List obtenerClientes() { // Metodo que devolverá una Lista con los clientes
        String query = "SELECT * FROM CLIENTES"; // Creamos variable con la sentencia SELECT
        Cliente c = null;
        List<Cliente> clientes = new ArrayList<>();
        try {
            Class.forName("oracle.jdbc.OracleDriver"); // Cargar el driver, necesitamos descargarlo de Oracle
            // Inicializamos conexión con el metodo getConnection() de la Clase DriverManager
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "db1", "admin");
            ps = con.prepareStatement(query); // Interpretación/precompilación de la sentencia que queremos usar con el Metodo prepareStatement()
            rs = ps.executeQuery(); // Se ejecuta la sentencia con el metodo executeQuery() porque sólo estamos leyendo información

            while (rs.next()) { // Mientras en el ResultSet haya una fila enseguida, avanzamos
                // Creamos Objeto de tipo Cliente jalando los atributos que estamos iterando en ese momento
                c = new Cliente(rs.getInt("CLIENTE_ID"), rs.getString("NOMBRE"), rs.getString("AP_P"), rs.getString("AP_M"),
                        rs.getString("DIRECCION"), rs.getString("TELEFONO"), rs.getString("INE"), rs.getString("RFC"),
                        rs.getDate("FECHA_NAC"), rs.getString("STATUS"), rs.getString("CORREO"));
                clientes.add(c); // Añadimos el Objeto de tipo Cliente de cada iteración a la Lista
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return clientes;
    }
    public void mostrarClientes() {
        List<Cliente> clientes = this.obtenerClientes();
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }
}