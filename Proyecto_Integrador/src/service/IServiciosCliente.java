package service;

import dto.ReporteMovsDTO;
import entity.Cliente;
import exception.CustomerMovementsNotFoundException;
import models.Ticket;

import java.sql.SQLException;
import java.util.List;

public interface IServiciosCliente {

    void registrarCliente(Cliente cliente);
    List obtenerClientes();
    Ticket registrarAbono(int prestamo, double monto, int medioPagoId);
    public ReporteMovsDTO generarReporteMovsPorCliente(String cliente, String fechaInicio, String fechaFin) throws CustomerMovementsNotFoundException, SQLException;




}
