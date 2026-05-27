package dao;

import database.ConexionOracle; // Se importó esta Clase al crear paquetes
import entity.Cliente;
import java.sql.*; // Para no hacer tantos imports, jalamos por completo este paquete / JDBC
import java.util.ArrayList;
import java.util.List;

// DAO: Data Access Object
// Patrón de diseño DAO: Esta Clase encapsula la lógica de acceso a datos de los clientes de la db (consultas) en un sólo lugar
public class ClienteDAO {
    // Atributos
    Connection con = null; // Carga la conexión hacia la db
    PreparedStatement ps = null; // Intérprete, entrada de las sentencias a la db
    ResultSet rs = null; // Salida de los resultados, se almacenan aquí

    public void guardarCliente(Cliente cliente) { // Metodo para guardar un cliente nuevo, recibirá como parámetro un Objeto de tipo entity.Cliente (sin id)
        // Creamos variable con la sentencia INSERT, los signos ? en las sentencias se llaman "marcadores de posición"
        String query = "INSERT INTO CLIENTES(NOMBRE, AP_P, AP_M, DIRECCION, TELEFONO, CORREO, INE, RFC, FECHA_NAC) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            // Llamamos a los métodos .getInstance() y .getCon() de la Clase database.ConexionOracle y almacenamos en variable de tipo Connection
            con = ConexionOracle.getInstance().getCon(); // Apunta a la única conexión a la db
            ps = con.prepareStatement(query); // Interpretación/precompilación de la sentencia que queremos usar con el Metodo prepareStatement()
            ps.setString(1, cliente.getNombre()); // En el primer ? asignamos el nombre del Objeto entity.Cliente
            ps.setString(2, cliente.getApP()); // En el segundo ? asignamos el apellido paterno del Objeto entity.Cliente
            ps.setString(3, cliente.getApM()); // En el tercer ? asignamos el apellido materno del Objeto entity.Cliente
            ps.setString(4, cliente.getDireccion()); // En el cuarto ? asignamos la dirección del Objeto entity.Cliente
            ps.setString(5, cliente.getTelefono()); // En el quinto ? asignamos el teléfono del Objeto entity.Cliente
            ps.setString(6, cliente.getCorreo()); // En el sexto ? asignamos el correo del Objeto entity.Cliente
            ps.setString(7, cliente.getIne()); // En el séptimo ? asignamos el INE del Objeto entity.Cliente
            ps.setString(8, cliente.getRfc()); // En el octavo ? asignamos el RFC del Objeto entity.Cliente
            ps.setDate(9, cliente.getFechaNac()); // En el noveno ? asignamos la fecha de nacimiento del Objeto entity.Cliente
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

    public List obtenerClientes() { // Metodo que devolverá una Lista con los clientes
        String query = "SELECT * FROM CLIENTES"; // Creamos variable con la sentencia SELECT
        Cliente c = null;
        List<Cliente> clientes = new ArrayList<>();
        try {
            // Llamamos a los métodos .getInstance() y .getCon() de la Clase database.ConexionOracle y almacenamos en variable de tipo Connection
            con = ConexionOracle.getInstance().getCon(); // Apunta a la única conexión a la db
            ps = con.prepareStatement(query); // Interpretación/precompilación de la sentencia que queremos usar con el Metodo prepareStatement()
            rs = ps.executeQuery(); // Se ejecuta la sentencia con el metodo executeQuery() porque sólo estamos leyendo información
            while (rs.next()) { // Mientras en el ResultSet haya una fila enseguida, avanzamos
                // Creamos Objeto de tipo entity.Cliente jalando los atributos que estamos iterando en ese momento
                c = new Cliente(rs.getInt("CLIENTE_ID"), rs.getString("NOMBRE"), rs.getString("AP_P"), rs.getString("AP_M"),
                        rs.getString("DIRECCION"), rs.getString("TELEFONO"), rs.getString("INE"), rs.getString("RFC"),
                        rs.getDate("FECHA_NAC"), rs.getString("STATUS"), rs.getString("CORREO"));
                clientes.add(c); // Añadimos el Objeto de tipo entity.Cliente de cada iteración a la Lista
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return clientes;
    }
}