package service.impl;

import constants.Constantes;
import dao.AbonoDAO;
import dao.ClienteDAO;
import dao.MovimientoDAO;
import dto.ReporteMovsDTO;
import entity.Cliente;
import exception.CustomerMovementsNotFoundException;
import models.Ticket;
import service.IServicioCliente;

import java.time.LocalDateTime;
import java.util.List;

public class ModuloAtencion implements IServicioCliente {

    //Inyeccion manual
    private ClienteDAO clienteDAO = new ClienteDAO();
    private MovimientoDAO movDAO = new MovimientoDAO();
    private AbonoDAO abonoDAO = new AbonoDAO();

    @Override
    public void registrarCliente(Cliente cliente) {

        clienteDAO.guardarCliente(cliente);

    }

    @Override
    public List obtenerClientes() {

        return clienteDAO.obtenerClientes();
    }

    @Override
    public Ticket registrarAbono(int prestamoId, double monto, int medioPagoId) {
        boolean ok = abonoDAO.abonar(prestamoId, monto, medioPagoId);
        Ticket ticket = null;
        if (ok) {
            ticket = Ticket.builder().fecha(LocalDateTime.now()).tipoOperacion("ABONO").monto(monto).build();
        }
        return null;
    }

    @Override
    public ReporteMovsDTO generarReporteMovsPorCliente(String cliente, String fechaInicio, String fechaFin)throws CustomerMovementsNotFoundException {
        ReporteMovsDTO reporte = movDAO.generarReporteMovimientosPorCliente(cliente, fechaInicio, fechaFin);

        if (reporte == null || reporte.getMovsPorCuenta().isEmpty()) {
            throw new CustomerMovementsNotFoundException(Constantes.CUSTOMER_MOVEMENTS_NOT_FOUND);
        } else {//si no, retorna el reporte
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
