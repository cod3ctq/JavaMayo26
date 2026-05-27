package service;

import models.Ticket;

public interface iOperacionesAvanzadas {

    Ticket depositar(String numTarjeta, double monto, String nip);

}
