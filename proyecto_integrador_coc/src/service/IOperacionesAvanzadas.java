package service;

import models.Ticket;

public interface IOperacionesAvanzadas {
    // Todos los metodos en las interfaces son public
    Ticket depositar(String numTarjeta, double monto, String nip); // Devolverá Objeto de tipo models.Ticket
}