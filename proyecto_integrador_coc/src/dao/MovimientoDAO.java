package dao;

import database.ConexionOracle; // Se importó esta Clase al crear paquetes
import dto.DetalleMovimientoDTO; // Se importó esta Clase al crear paquetes
import dto.ReporteMovsDTO; // Se importó esta Clase al crear paquetes
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// DAO: Data Access Object
// Patrón de diseño DAO: Esta Clase encapsula la lógica de acceso a datos de los movimientos de la db (consultas) en un sólo lugar
public class MovimientoDAO {
    // Atributos
    private Connection con = null; // Variable que almacenará el Objeto de tipo Connection
    private PreparedStatement ps = null; // Variable que almacenará la interpretación de la sentencia que queremos utilizar en la db
    private ResultSet rs = null; // Varible que almacenará el resultado de la consulta a la db

    public void registrarMovimiento(int cuentaId, String tipoOperacion, double monto) {
        String query = "INSERT INTO MOVIMIENTOS(CUENTA_ID, TIPO, FECHA_OP, MONTO) VALUES (?, ?, ?, ?)";
        try {
            // Llamamos a los métodos .getInstance() y .getCon() de la Clase database.ConexionOracle y almacenamos en variable de tipo Connection
            con = ConexionOracle.getInstance().getCon(); // Apunta a la única conexión a la db
            System.out.println(">>>>> LLAMADA A LA DB Y: " + con);
            ps = con.prepareStatement(query);
            ps.setInt(1, cuentaId);
            ps.setString(2, tipoOperacion);
            ps.setDate(3, Date.valueOf(LocalDate.now())); // Se registra en automático la fecha del momento
            ps.setDouble(4, monto);
            int x = ps.executeUpdate(); // Se ejecuta la actualización y devuelve el número de filas que fueron afectadas por el UPDATE
            if (x > 0) {
                System.out.println("Movimiento registrado correctamente");
            } else {
                System.out.println("Error al registrar el movimiento");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ReporteMovsDTO generarReporteMovimientosPorCliente(String cliente, String fechaInicio, String fechaFin) {
        ReporteMovsDTO reporte = null; // Hoja impresa que mostrará el resultado
        String llave = ""; // Variable que almacenará la llave para acceder al mapa (numCuenta:descripcion)
        // Estos 2 datos son los mismos que se repiten a lo largo del resultSet
        String titular = ""; // Almacenará el nombre completo del cliente
        String rfc = ""; // Almacenará el RFC del cliente
        // Mapa que guarda los detalles asociados a cada cuenta individual [100001:NOMINA -> [0, 0, 0, 0, 0]]
        Map<String, List<DetalleMovimientoDTO>> movs = new HashMap<>();
        // Objeto auxiliar para extraer y guardar los datos de cada movimiento [0] que irá almacenado dentro del mapa como Valor
        DetalleMovimientoDTO detalle;
        // Variables que guardarán totales de ingresos y egresos
        double ingresos = 0.0;
        double egresos = 0.0;
        String query = "SELECT * FROM REPORTE_MOVS WHERE TITULAR = ? " + // Esta es una vista, pero podemos utilizarla como una tabla
                "AND FECHA_OP BETWEEN TO_DATE(?, 'DD,MM,YYYY') AND TO_DATE (?, 'DD,MM,YYYY') " + // Pasamos como texto las fechas, TO_DATE convierte a formato fecha
                "ORDER BY NUM_CUENTA";
        try {
            con = ConexionOracle.getInstance().getCon();
            ps = con.prepareStatement(query); // Interpretación / precompilación de la sentencia
            ps.setString(1, cliente);
            ps.setString(2, fechaInicio);
            ps.setString(3, fechaFin);
            rs = ps.executeQuery(); // Ejecuta la sentencia, se almacena en resultSet toda la información
            // Iteremos por todas las líneas del resultSet
            while (rs.next()) {
                // Llave = 1000001:AHORRO BASICA
                llave = rs.getString("NUM_CUENTA") + ":" + rs.getString("DESCRIPCION");
                // detalle = RETIRO,28/05/2019,$3575
                detalle = new DetalleMovimientoDTO(rs.getString("TIPO"),
                        rs.getDate("FECHA_OP"),
                        rs.getDouble("MONTO"));
                // Si ya contiene la llave, obviamente ya tiene una lista asociada
                if (movs.containsKey(llave)) {
                    movs.get(llave).add(detalle); // "Dame la lista asociada a esa llave y agrega este Objeto a ella"
                } else {
                    // Si no, seguramente es la primera vez que se encuentra esa combinación de numCuenta + descripcion
                    // Entonces se añade la llave al mapa (junto con su lista) y se agrega el primer detalle a esa lista
                    movs.put(llave, new ArrayList<DetalleMovimientoDTO>()); // Crea la llave en el mapa y el valor como una lista
                    movs.get(llave).add(detalle); // Se añade el Objeto a la lista asociada a esa llave
                }
                // Acumulamos las cantidades por categoría
                if (rs.getString("TIPO").equals("DEPOSITO")) {
                    ingresos += rs.getInt("MONTO");
                } else {
                    egresos += rs.getInt("MONTO");
                }
                titular = rs.getString("TITULAR");
                rfc = rs.getString("RFC");
            }
            // Ya con todos los detalles recolectados en las listas del mapa, se concreta el Objeto reporte global
            reporte = new ReporteMovsDTO(titular, rfc, movs, ingresos, egresos); // Objeto de tipo dto.ReporteMovsDTO
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return reporte;
    }
}