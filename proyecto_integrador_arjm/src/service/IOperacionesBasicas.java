package service;

import models.Ticket;

public interface IOperacionesBasicas {

    Object[] retiro(String numTarjeta,double monto, String nip);

    Ticket pagarServicio(String numTarjeta, String convenio, String referencia);



}
