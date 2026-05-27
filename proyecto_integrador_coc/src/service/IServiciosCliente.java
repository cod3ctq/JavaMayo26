package service;

import dto.ReporteMovsDTO;
import entity.Cliente;
import exception.CustomerMovementsNotFoundException;
import models.Ticket;

import java.util.List;

public interface IServiciosCliente {
    // Todos los metodos en las interfaces son public
    void registrarCliente(Cliente cliente); // Metodo para registrar un cliente nuevo, recibirá como parámetro un Objeto de tipo entity.Cliente (sin id)
    List obtenerClientes(); // Metodo que devolverá una Lista con los clientes
    Ticket registrarAbono(int prestamoId, double monto, int medioPagoId); // Metodo para registrar el abono de un préstamo que devolverá un ticket
    // Metodo para generar un reporte con los movimientos por cliente
    ReporteMovsDTO generarReporteMovsPorCliente(String cliente, String fechaInicio, String fechaFin) throws CustomerMovementsNotFoundException;
}