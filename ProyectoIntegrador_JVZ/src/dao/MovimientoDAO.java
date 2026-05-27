package dao;

import database.ConexionOracle;
import dto.DetalleMovimientoDTO;
import dto.ReporteMovsDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovimientoDAO {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;


    public void resgistrarMovimiento(int cuentaId, String operacion, double monto){

        String query ="INSERT INTO MOVIMIENTOS(CUENTA_ID, TIPO, FECHA_OP, MONTO)VALUES(?,?,?,?)";

        try{

            con = ConexionOracle.getInstance().getCon();
            System.out.println("LLAMADA A LA BASE Y:"+con);
            ps = con.prepareStatement(query);
            ps.setInt(1, cuentaId);
            ps.setString(2, operacion);
            ps.setDate(3, java.sql.Date.valueOf(LocalDate.now()));
            ps.setDouble(4, monto);
            int x = ps.executeUpdate();

            if (x>0){
                System.out.println("Moviemiento registrado correctamente");
            }else {
                System.out.println("Error al insertar el movimiento");
            }

        } catch (Exception ex){
            ex.printStackTrace();

        }
    }

    public ReporteMovsDTO generarReporteMovimientosPorCliente(String cliente, String fechaInicio, String fechaFin){
       ReporteMovsDTO reporte = null; // Hoja impresa
       String llave = ""; //10000003 nomina
        //Estos 2 datos son los mismos (se repiten) a lo largo de todo el resultset
       String titular = ""; //Nombre completo del cliente
       String rfc = "";   // rfc
        //Mapa que guardara los detalles
        Map<String, List<DetalleMovimientoDTO>> movs = new HashMap<String, List<DetalleMovimientoDTO>>();
        DetalleMovimientoDTO detalle;
        double ingresos = 0.0;
        double egresos = 0.0;
        String query = "SELECT * FROM REPORTE_MOVS WHERE TITULAR = ? " +
                "AND FECHA_OP BETWEEN TO_DATE(?, 'DD/MM/YYYY') AND TO_DATE(?, 'DD/MM/YYYY') " +
                "ORDER BY NUM_CUENTA";

        try{
            con = ConexionOracle.getInstance().getCon();
            ps = con.prepareStatement(query);  //Interpretacion, precompilacion de la sentencia
            ps.setString(1, cliente);
            ps.setString(2, fechaInicio);
            ps.setString(3, fechaFin);
            rs = ps.executeQuery();


            while (rs.next()){
                //llave = 1000000001: AHORRO BASICA
                llave = rs.getString("NUM_CUENTA")+":"+rs.getString("DESCRIPCION");
                //Detalle: RETIRO28/05/2019

                detalle = new DetalleMovimientoDTO(rs.getString("TIPO"),
                        rs.getDate("FECHA_OP"),
                        rs.getDouble("MONTO"));
                //Si ya se tiene la llave, obviamente ya tiene una lista asociada
                if (movs.containsKey(llave)){
                    movs.get(llave).add(detalle);
                }else {
                    //Si no, seguramente es la primera vez que se encuentra esa combinacion de numCuenta + DESCRIPCION
                    //Entonces se añade la llave al mapa (junto con su lista) y se agrega el primer detalle a esa lista
                    movs.put(llave, new ArrayList<DetalleMovimientoDTO>());
                    movs.get(llave).add(detalle);
                }
                //Acumulando las cantidades por categoria
                if (rs.getString("TIPO").equals("DEPOSITO")){
                    ingresos = ingresos + rs.getInt("MONTO");
                }else {
                    egresos = egresos +rs.getInt("MONTO");
                }
                titular = rs.getString("TITULAR");
                rfc = rs.getString("RFC");

            }
            //Ya con todos los detalles conectados en las listas del mapa, se concreta el objeto reporte global
            reporte = new ReporteMovsDTO(titular, rfc, movs, ingresos, egresos);

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return  reporte;
    }

}
