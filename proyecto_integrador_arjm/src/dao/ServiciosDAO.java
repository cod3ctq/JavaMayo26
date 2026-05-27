package dao;

import database.ConexionOracle;

import java.sql.*;

public class ServiciosDAO {
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private CallableStatement cs = null;//llama al STORED PROCEDURE de la db


    //Este metodo comsume un STORED PROCEDURE: En este caso, la logica de negocio
    //fue programada al interior de stored procedure, y aqui solo se invoca su
    //ejecucion
    public boolean pagarServicio(String numTarjeta, String convenio, String referencia){
        boolean respuesta = false;
        String query="{CALL PAGAR_RECIBO_TARJETA(?,?,?)}";
        try {
            con = ConexionOracle.getInstance().getCon();
            cs = con.prepareCall(query);
            cs.setString(1,numTarjeta);
            cs.setString(2,convenio);
            cs.setString(3,referencia);
            cs.execute();
            respuesta = true;
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return respuesta;
    }
}
