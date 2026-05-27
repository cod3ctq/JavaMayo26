package service.impl;

import constants.COnstantes;
import dao.AbonoDAO;
import dao.ClienteDAO;
import dao.MovimientoDAO;
import dto.ReporteMovsDTO;
import entity.Cliente;
import exception.CustomerMovementsNotFoundException;
import models.Ticket;
import service.IServiciosCliente;

import java.time.LocalDate;
import java.util.List;

public class ModuloAtencion implements IServiciosCliente {

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
        boolean ok = abonoDAO.abonar(prestamoId,monto,medioPagoId);
        Ticket ticket = null;
        if (ok){
            ticket = Ticket.builder().fecha(LocalDate.now()).tipoOperacion("ABONO").monto(monto).build();
        }
        return ticket;

    }

    @Override
    public ReporteMovsDTO generarReportMovsPorCliente(String cliente, String fechaInicio, String fechaFin) throws CustomerMovementsNotFoundException {
        ReporteMovsDTO reporte = movDAO.generarReporteMovimientosPorCliente(cliente, fechaInicio, fechaFin);

        if (reporte == null || reporte.getMovsPorCuenta().isEmpty()) {//Si no se genero el reporte.......
            throw new CustomerMovementsNotFoundException(COnstantes.CUSTOMER_MOVEMENTS_NOT_FOUND);
        }else {
            return reporte;
        }
    }

    public void mostarClients(){
        List<Cliente>clientes = this.obtenerClientes();
        for (Cliente cliente:clientes){
            System.out.println(cliente);

        }

    }

}
