package dao;

import database.ConexionOracle; // Se importó esta Clase al crear paquetes
import java.sql.*;

public class ServiciosDAO {
    // Atributos
    private Connection con = null; // Variable que almacenará el Objeto de tipo Connection
    private PreparedStatement ps = null; // Variable que almacenará la interpretación de la sentencia que queremos utilizar en la db
    private ResultSet rs = null; // Varible que almacenará el resultado de la consulta a la db
    CallableStatement cs = null; // Este Objeto es el que nos permite llamar a un Stored Procedure

    // Este metodo consume un STORED PROCEDURE: En este caso, la lógica del negocio fue programada en el anterior SP, aquí sólo se invoca su ejecución
    public boolean pagarServicio(String numTarjeta, String convenio, String referencia) {
        boolean respuesta = false;
        String query = "{CALL PAGAR_RECIBO_TARJETA(?, ?, ?)}"; // Este query lleva llaves {}
        try {
            con = ConexionOracle.getInstance().getCon(); // Apunta a la única conexión a la db
            cs = con.prepareCall(query);
            cs.setString(1, numTarjeta);
            cs.setString(2, convenio);
            cs.setString(3, referencia);
            cs.execute(); // Sólo execute()
            respuesta = true; // Si algo falla, esta línea no se ejecuta
        } catch (SQLException ex) { // Excepción específica de SQL
            System.out.println(ex.getMessage());
        }
        return respuesta;
    }
}