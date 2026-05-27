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

    public void registrarMoviento(int cuentaId, String operacion, double monto){

        String query = "INSERT INTO MOVIMIENTOS(CUENTA_ID, TIPO, FECHA_OP, MONTO) VALUES(?,?,?,?)";

        try{

            con = ConexionOracle.getInstance().getCon();    //Apunta a la unica conexion de la db
            System.out.println(">>>>>>>>>>>>>>>>>>>>LLAMADA A LA BASE Y:"+con);
            ps = con.prepareStatement(query);
            ps.setInt(1, cuentaId);
            ps.setString(2, operacion);
            ps.setDate(3, Date.valueOf(LocalDate.now()));
            ps.setDouble(4, monto);
            int x = ps.executeUpdate();

            if (x>0){
                System.out.println("Moviento registrado correctamente");
            }else{
                System.out.println("Error al insettar movimiento");
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public ReporteMovsDTO generarReporteMovimientosPorCliente(String cliente, String fechaInicio, String fechaFin){
        ReporteMovsDTO reporte = null; //hoja impresa
        String llave = "";//10000001:NOMINA
        //Estos 2 datos son los mismos a lo largo de todo el result set
        String titular = "";//nombre completo del cliente
        String rfc = "";//rfc
        //Mapa que guardara los detalles asociados a cada una de las cuentas individuales [10000001:NOMINA -> [0,0,0,0,0]]
        Map<String, List<DetalleMovimientoDTO>> movs = new HashMap<String, List<DetalleMovimientoDTO>>();
        //Objeto auxiliar para extraer y guardar los datos de cada movimineto [0]
        DetalleMovimientoDTO detalle;
        //Variables que guardara los totales de ingresos y egresos
        double ingresos = 0.0;
        double egresos = 0.0;

        String query = "SELECT * FROM REPORTE_MOVS WHERE TITULAR = ? " +
                "AND FECHA_OP BETWEEN TO_DATE(?, 'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY') " +
                "ORDER BY NUM_CUENTA";

        try{
            con = ConexionOracle.getInstance().getCon();
            ps = con.prepareStatement(query);//Interpretacion, precompilacion, de la sentencia
            ps.setString(1,cliente);
            ps.setString(2,fechaInicio);
            ps.setString(3,fechaFin);
            rs = ps.executeQuery();

            while(rs.next()){
                //llave : 1000000000001:AHORRO BASICA
                llave = rs.getString("NUM_CUENTA")+":"+rs.getString("DESCRIPCION");
                //detalle : RETIRO,28/05/2019, 1875
                detalle = new DetalleMovimientoDTO(rs.getString("TIPO"),
                                                        rs.getDate("FECHA_OP"),
                                                        rs.getDouble("MONTO"));
                //Si ya contiene la llave, obviamente ya tiene una lista asociada
                if(movs.containsKey(llave)){
                    movs.get(llave).add(detalle);
                }else{
                    //si no, seguramente es la primera vez que se encuentra esa combinacion de numCuenta + DESCRIPCION
                    //entonces se añade la llave al mapa (junto con su lista) y se agrega el primer detalle a esa lista
                    movs.put(llave, new ArrayList<DetalleMovimientoDTO>());
                    movs.get(llave).add(detalle);
                }

                //acumulando las catidades por categorias
                if(rs.getString("TIPO").equals("DEPOSITO")){
                    ingresos = ingresos + rs.getInt("MONTO");
                }else{
                    egresos = egresos + rs.getInt("MONTO");
                }
                titular = rs.getString("TITULAR");
                rfc = rs.getString("RFC");
            }

            reporte = new ReporteMovsDTO(titular, rfc, movs, ingresos, egresos);

        } catch (Exception ex){
            ex.printStackTrace();
        }


        return reporte;
    }
}
