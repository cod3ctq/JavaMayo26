public interface IOperacionesbásicas {

    Object[] retirar(String numTarjeta, double monto, String nip);
    Ticket pagarServcicio(String convenio, String referencia);




}
