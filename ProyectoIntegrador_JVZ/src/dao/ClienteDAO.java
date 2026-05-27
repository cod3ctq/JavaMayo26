package dao;

import database.ConexionOracle;
import entity.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;


    public void guardarCliente(Cliente cliente){
        String query = "INSERT INTO CLIENTES(NOMBRE,AP_P,AP_M,DIRECCION,TELEFONO,CORREO,INE,RFC,FECHA_NAC)VALUES(?,?,?,?,?,?,?,?,?)";
        try{
            con = ConexionOracle.getInstance().getCon();
            ps = con.prepareStatement(query); //Interpretacion, precompialcion de la sentencia

            //Acomodar los valores en los marcadores de posicion de la sentencia.
            ps.setString(1, cliente.getNombre());
            ps.setString(2,cliente.getApP());
            ps.setString(3, cliente.getApM());
            ps.setString(4, cliente.getDireccion());
            ps.setString(5, cliente.getTelefono());
            ps.setString(6, cliente.getCorreo());
            ps.setString(7, cliente.getIne());
            ps.setString(8, cliente.getRfc());
            ps.setDate(9, cliente.getFechaNac());
            //Ejecutando la sentencia de inserción
            int x = ps.executeUpdate();
            if(x>0){
                System.out.println("Insercion correcta, cliente registrado");

            }else {
                System.out.println("Error al insertar");
            }
        }catch (Exception ex){
            ex.printStackTrace();

        }


    }

    public List obtenerClientes() {
        String query = "SELECT * FROM CLIENTES";
        Cliente c = null;
        List<Cliente> clientes = new ArrayList<Cliente>();
        try{
            con = ConexionOracle.getInstance().getCon();
            ps = con.prepareStatement(query); //Interpretacion, precompialcion de la sentencia
            rs = ps.executeQuery(); //Ejecutar la sentencia

            while(rs.next()){

                c = new Cliente(rs.getInt("CLIENTE_ID"), rs.getString("NOMBRE"),
                        rs.getString("AP_P"), rs.getString("AP_M"),
                        rs.getString("DIRECCION"),rs.getString("TELEFONO"),
                        rs.getString("INE"),rs.getString("RFC"),
                        rs.getDate("FECHA_NAC"),rs.getString("STATUS"),
                        rs.getString("CORREO"));
                //Añadir el cliente a la lista
                clientes.add(c);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return clientes;
    }




}
