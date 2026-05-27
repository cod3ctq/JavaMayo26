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
import java.sql.PreparedStatement;



public class MovimientoDAO {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;


    public void registrarMocimiento(int cuentaId, String operacion, double monto) {
        String query = "INSERT INTO MOVIMIENTOS(CUENTA_ID, TIPO, FECHA_OP, MONTO)VALUES(?,?,?,?)";

        try {

            con = ConexionOracle.getInstance().getCon();
            System.out.println("LLAMAR A LA BASE Y: " + con);
            ps = con.prepareStatement(query);
            // estas operacion son para acompletar el query
            //aqui se asigna con el primer marcador de posicion, y se acuatliza nuevo saldo
            ps.setDouble(1, cuentaId);
            ps.setString(2, operacion);
            ps.setDate(3, Date.valueOf(LocalDate.now()));
            ps.setDouble(4, monto);
            int x = ps.executeUpdate();
            if (x > 0) {
                System.out.println("Movimiento registrado correctamente");
            } else {
                System.out.println("Error al insertar movimiento");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ReporteMovsDTO generarReporteMovimientosPorCliente(String cliente, String fechaInicio, String fechaFin) {

        ReporteMovsDTO reporte = null; //HOJA IMPRESA
        String llave = ""; //1000003: NOMINA
        // ESTOS 2 DATOS SON LOS MISMOS(SE REPITEN) ALO LARGO DE TODO EL RESULSET
        String titular = "";
        String rfc = "";
        //mapa que guardara los detalles asociados a cada cuenta individual (1000004:nomina -> [0,0,0,0,0]]
        Map<String, List<DetalleMovimientoDTO>> movs = new HashMap<String, List<DetalleMovimientoDTO>>();
        //objeto axiliar para extraer y guardar los datos de cada movimiento [0]
        DetalleMovimientoDTO detalle;

        double ingresos = 0.0;
        double egresos = 0.0;
        String query = "SELECT * FROM REPORTE_MOVS WHERE TITULAR = ? " +
                "AND FECHA_OP BETWEEN TO_DATE(?, 'DD/MM/YYYY') AND TO_DATE (?, 'DD/MM/YYYY') " +
                "ORDER BY NUM_CUENTA";

        try {
            con = ConexionOracle.getInstance().getCon();
            ps = con.prepareStatement(query);//Interpretacion, precompilacion de la sentencia
            ps.setString(1, cliente);
            ps.setString(2, fechaInicio);
            ps.setString(3, fechaFin);
            rs = ps.executeQuery();//ejecuta la sentencia. regresa un resulset

            while (rs.next()) {
                System.out.println("@@@@@@@@@@@@@@@@@@@@");
                //lave: 10000001:AHORRO BASICA
                llave = rs.getString("NUM_CUENTA") + ":" + rs.getString("DESCRIPCION");
                // detakke : RETIRP, 28/05/2019, 1875
                detalle = new DetalleMovimientoDTO(rs.getString("TIPO"),
                        rs.getDate("FECHA_OP"),
                        rs.getDouble("MONTO"));

                //si ya contiene la llave, obviamente ya tiene una lista asociada
                if (movs.containsKey(llave)) {
                    movs.get(llave).add(detalle); //se añade el objeto a la lista
                } else {
                    //si no, seguramente es la primera vez que se encuentra esa comnbinaion de numCuenta + Descripcion
                    //entonces se añade a la llave al mapa (junto con su lista) y se agrega al primer detalle
                    movs.put(llave, new ArrayList<DetalleMovimientoDTO>());
                    movs.get(llave).add(detalle);
                }
                //acumulando las cantidades por cateforia
                if (rs.getString("TIPO").equals("DEPOSITO")) {
                    ingresos = ingresos + rs.getInt("MONTO");
                } else {
                    egresos = egresos + rs.getInt("MONTO");
                }
                titular = rs.getString("TITULAR");
                rfc = rs.getString("RFC");
            }
            reporte = new ReporteMovsDTO(titular, rfc, movs, ingresos, egresos);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        return reporte;
    }
}
