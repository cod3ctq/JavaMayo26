package service;

import dto.ReporteMovsDTO;
import entity.Cliente;
import exception.CustomerMovementsNotFoundException;
import models.Ticket;

import java.util.List;

public interface IServiciosCliente {

    void registrarCliente(Cliente cliente);
    List obtenerClientes();
    Ticket registrarAbono(int prestamoId, double monto, int medioPagoId);
    ReporteMovsDTO generarReporteMovsPorCliente(String cliente, String fechaInicio, String fechaFin) throws CustomerMovementsNotFoundException;

}
