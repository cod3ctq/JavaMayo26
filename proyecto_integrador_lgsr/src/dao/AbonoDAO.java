package dao;

import database.ConexionOracle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

public class AbonoDAO {
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public boolean abonar(int prestamoId, double monto, int medioPagoId){
        boolean ok = false;
        String query = "INSERT INTO ABONOS(PRESTAMO_ID, FECHA, MONTO, MEDIO_PAGO)VALUES(?,?,?,?)";
        try{
            con = ConexionOracle.getInstance().getCon();
            ps = con.prepareStatement(query);
            ps.setInt(1,prestamoId);
            ps.setDate(2, Date.valueOf(LocalDate.now()));
            ps.setDouble(3,monto);
            ps.setInt(4,medioPagoId);
            int x = ps.executeUpdate();
            if (x>0){
                ok = true;
                System.out.println("Abono registrado correctamente");
            }else{
                System.out.println("Error al insertar el abono");
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }
            return ok;
    }
}
