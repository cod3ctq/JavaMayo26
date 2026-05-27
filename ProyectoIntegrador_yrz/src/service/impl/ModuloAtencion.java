package service.impl;

import constants.Constantes;
import dao.AbonoDAO;
import dao.ClienteDAO;
import dao.MovimientoDAO;
import dto.ReporteMovsDTO;
import entity.Cliente;
import exception.CustomerMovementsNotFoundException;
import models.Ticket;
import service.IserviciosCliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.List;

public class ModuloAtencion implements IserviciosCliente {
    Connection con = null;//carga la conexion hacia la db
    PreparedStatement ps = null;
    ResultSet rs = null;
    ClienteDAO clienteDAO= new ClienteDAO();
    AbonoDAO abonoDAO =new AbonoDAO();
    private MovimientoDAO movDAO = new MovimientoDAO();

    @Override
    public void registrarCliente(Cliente cliente) {


        clienteDAO.guardarCliente(cliente);
    }

    @Override
    public List obtenerClientes() {

        return clienteDAO.obtenerClientes();
    }

    @Override
    public Ticket registrarAbono(int prestamoId, double monto, int mediopagoId) {
        boolean ok= abonoDAO.abonar(prestamoId,monto,mediopagoId);
        Ticket ticket = null;
        if(ok){
            ticket=Ticket.builder().fecha(LocalDateTime.now()).tipoOperacion("ABONO").monto(monto).build();
        }
        return ticket;
    }

    @Override
    public ReporteMovsDTO generarReporteMovsPorCliente(String cliente, String fechaInicio, String fechaFin) throws CustomerMovementsNotFoundException {
        ReporteMovsDTO reporte = movDAO.generarReporteMovimientosPorCliente(cliente, fechaInicio, fechaFin);

        if (reporte == null || reporte.getMovsPorCuenta().isEmpty()) {// sino se genero el reporte...
            throw new CustomerMovementsNotFoundException(Constantes.CUSTOMER_MOVEMENTS_NOT_FOUND_);
        }else {//si no, retorna al reporte
            return reporte;
        }

    }

    public void mostrarClientes() {
        List<Cliente> clientes = this.obtenerClientes();
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }
}
