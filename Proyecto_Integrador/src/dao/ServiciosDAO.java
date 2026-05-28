package dao;

import database.ConexionOracle;

import java.sql.*;

public class ServiciosDAO {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    CallableStatement cs = null;

    //Este metodo consume un STORED PROCEDURE: En esta caso, la logica de negocio
    //fue programada al interior del stored procedure, y aqui solo se invoca su
    //ejecucion
    public boolean pagarServicio(String numTarjeta, String convenio, String referencia) {

        boolean respuesta = false;

        String query = "{CALL PAGAR_RECIBO_TARJETA(?,?,?)}";

        try {

            //apunta a la unica conexion a la db
            con = ConexionOracle.getInstance().getCon();

            cs = con.prepareCall(query);

            //Enviar parametros al stored procedure
            cs.setString(1, numTarjeta);
            cs.setString(2, convenio);
            cs.setString(3, referencia);

            //Ejecutar stored procedure
            cs.execute();
            respuesta = true;

        } catch (SQLException ex) {

            //Mostrar codigo del error
            System.out.println(ex.getErrorCode());

            //Mostrar mensaje del error
            System.out.println(ex.getMessage());
        }

        return respuesta;
    }
}