package service;

import models.Ticket;

public interface IOperacionesbásicas {

    Object[] retirar(String numTarjeta, double monto, String nip);
    Ticket pagarServcicio(String numTarjeta, String convenio, String referencia);




}
