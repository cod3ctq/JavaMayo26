package service.impl;

import constants.Constantes;
import dao.AbonoDAO;
import dao.ClienteDAO;
import dao.MovimientoDAO;
import dto.ReporteMovsDTO;
import entity.Cliente;
import exception.CustomerMovementsNotFoundException;
import models.Ticket;
import service.IServiciosCliente;
import java.time.LocalDateTime;
import java.util.List;

public class ModuloAtencion implements IServiciosCliente {

    // Inyección de dependencias manual
    private ClienteDAO clienteDAO = new ClienteDAO();
    private AbonoDAO abonoDAO = new AbonoDAO();
    private MovimientoDAO movDAO = new MovimientoDAO();

    @Override
    public void registrarCliente(Cliente cliente) {
        /*
        Lógica del negocio para validar que el cliente se puede registrar correctamente
        ---
         */
        clienteDAO.guardarCliente(cliente); // Entonces ya podríamos llamar al metodo de clienteDAO para guardar el cliente
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
            ticket = Ticket.builder().fecha(LocalDateTime.now()).tipoOperacion("ABONO A PRESTAMO").monto(monto).build();
        }
        return ticket;
    }

    @Override
    public ReporteMovsDTO generarReporteMovsPorCliente(String cliente, String fechaInicio, String fechaFin) throws CustomerMovementsNotFoundException {
        // Creamos Objeto dto.ReporteMovsDTO
        ReporteMovsDTO reporte = movDAO.generarReporteMovimientosPorCliente(cliente, fechaInicio, fechaFin);
        if (reporte == null || reporte.getMovsPorCuenta().isEmpty()) { // Si no se generó el reporte, o si hubo un problema al crear el mapa...
            throw new CustomerMovementsNotFoundException(Constantes.CUSTOMER_MOVEMENTS_NOT_FOUND); // Lanzamos excepción
        } else { // Si se genera el reporte...
            return reporte; // Lo retornamos
        }
    }

    public void mostrarClientes() {
        List<Cliente> clientes = this.obtenerClientes();
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }
}