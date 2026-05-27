package dao;

import database.ConexionOracle;
import dto.CuentaDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//patron de diseno DAO: DATA ACCESS OBJECT
//ENCAPSULA LA LOGICA DE ACCESO A DATOS EN PALABRAS SIMPLES LAS CONSULTAS  EN UN SOLO LUGAR
public class CuentaDAO {
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public List<CuentaDTO> leerCuentas() {

        String query = "SELECT T.NUM_TARJETA, T.NIP, CU.CUENTA_ID, CU.NUM_CUENTA, CU.SALDO,TC.SALDO_MIN,TC.SALDO_MAX, CU.FECHA_AP, C.NOMBRE || ' '||  C.AP_P || ' ' || C.AP_M AS TITULAR " +
                "FROM TARJETAS T INNER JOIN CUENTAS CU " +
                "ON T.CUENTA_ID = CU.CUENTA_ID " +
                "INNER JOIN CLIENTES C " +
                "ON CU.CLIENTE_ID = C.CLIENTE_ID " +
                "INNER JOIN TIPO_CUENTA TC " +
                "ON CU.TIPO_CUENTA_ID = TC.TIPO_CUENTA_ID";
        List<CuentaDTO> dtos = new ArrayList<CuentaDTO>();
        CuentaDTO dto = null;
        try {

            con = ConexionOracle.getInstance().getCon(); //Apunta a la unica conexion a la base de datos
            System.out.println(">>>>>>>>>>LLAMADA A LA BASE DE DATOS 1:"+con);
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {

                dto = new CuentaDTO(rs.getString("NUM_TARJETA"), rs.getString("NIP"),rs.getInt("CUENTA_ID"),
                        rs.getString("NUM_CUENTA"),
                        rs.getDouble("SALDO"), rs.getDouble("SALDO_MIN"), rs.getDouble("SALDO_MAX"),
                        rs.getDate("FECHA_AP"), rs.getString("TITULAR"));

                dtos.add(dto);

            }


        } catch (Exception ex) {
            ex.printStackTrace();
        }


        return dtos;

    }
    public void actualizarSaldoCuenta(String numCuenta, double nuevoSaldo) {
        String query = "UPDATE CUENTAS SET SALDO = ? WHERE NUM_CUENTA = ? ";

        try {

            con = ConexionOracle.getInstance().getCon();//Apunta a la unica conexion en la db
            System.out.println(">>>>>>>>>>LLAMADA A LA BASE DE DATOS X:"+con);
            ps = con.prepareStatement(query);
            ps.setDouble(1, nuevoSaldo);
            ps.setString(2, numCuenta);
            int x = ps.executeUpdate();
            if (x > 0) {
                System.out.println("Saldo actualizado correctamente");
            } else {
                System.out.println("Error al actualizar saldo");
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }

    public double getSaldoCuenta(String numCuenta){
        String query="SELECT SALDO FROM CUENTAS WHERE NUM_CUENTA='"+numCuenta+"'";
        double saldo = 0.0;
        try{
            con = ConexionOracle.getInstance().getCon();//Apunta a la unica conexion en la db
            System.out.println(">>>>>>>>>>LLAMADA A LA BASE DE DATOS X:"+con);
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                saldo = rs.getDouble("SALDO");
            }

        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return saldo;
    }
}
