package dao;

import database.ConexionOracle;
import dto.DetalleMovimientoDTO;
import dto.ReporteMovsDTO;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovimientoDAO {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public void registraMovimiento(int cuentaId, String operacion, double monto) {
        String query = "INSERT INTO MOVIMIENTOS(CUENTA_ID, TIPO, FECHA_OP, MONTO)VALUES(?,?,?,?)";

        try {

            con = ConexionOracle.getInstance().getCon(); //Apunta a la unica conexion a la db
            System.out.println(">>>>>>Llamada a la base Y:" + con);
            ps = con.prepareStatement(query);
            ps.setInt(1, cuentaId);
            ps.setString(2, operacion);
            ps.setDate(3, Date.valueOf(LocalDate.now()));
            ps.setDouble(4, monto);
            int x = ps.executeUpdate();

            if (x > 0) {
                System.out.println("Movimiento registrado correctamente");
            } else {
                System.out.println("Error al insertar el movimiento");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public ReporteMovsDTO generarReporteMovimientosPorCliente(String cliente, String fechaInicio, String fechaFin) {

        ReporteMovsDTO reporte = null; //hoja impresa
        String llave = ""; //10000003:NOMINA
        String titular = "";
        String rfc = "";
        Map<String, List<DetalleMovimientoDTO>> movs = new HashMap<String, List<DetalleMovimientoDTO>>();
        DetalleMovimientoDTO detalle;
        double ingresos = 0.0;
        double egresos = 0.0;

        String query = "SELECT * FROM REPORTE_MOVS WHERE TITULAR = ? " +
                "AND FECHA_OP BETWEEN TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY') " +
                "ORDER BY NUM_CUENTA";

        try {
            con = ConexionOracle.getInstance().getCon(); //Apunta a la unica conexion a la db
            ps = con.prepareStatement(query);
            ps.setString(1, cliente);
            ps.setString(2, fechaInicio);
            ps.setString(3, fechaFin);
            rs = ps.executeQuery();

            while (rs.next()) {

                llave = rs.getString("NUM_CUENTA") + ":" + rs.getString("DESCRIPCION");

                detalle = new DetalleMovimientoDTO(rs.getString("TIPO"),
                        rs.getDate("FECHA_OP"),
                        rs.getDouble("MONTO"));
                //SI YA CONTIENE la lista, obviamente ya tiene una lista asociada
                if (movs.containsKey(llave)) {
                    movs.get(llave).add(detalle);//se añade el objeto a la lista
                } else {
                    movs.put(llave, new ArrayList<DetalleMovimientoDTO>());
                    movs.get(llave).add(detalle);
                }
                //acomulando las cantidades por categoria
                if (rs.getString("TIPO").equals("DEPOSITO")) {
                    ingresos = ingresos + rs.getInt("MONTO");
                } else {
                    egresos = egresos + rs.getInt("MONTO");
                }
                titular = rs.getString("TITULAR");
                rfc = rs.getString("RFC");
            }
            //ya con todos los detalles colectados en las listas del mapa, se concreta el objeto reporte global
            reporte = new ReporteMovsDTO(titular,rfc,movs,ingresos, egresos);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return reporte;
    }

}