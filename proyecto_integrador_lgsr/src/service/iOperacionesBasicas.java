package service;

import models.Ticket;

public interface iOperacionesBasicas {
    public Object[] retirar(String numTarjeta, double monto, String nip);
    Ticket pagarServicio(String numTarjeta, String convenio, String referencia);
}
