public interface IOperacionesBasicas {

    Object[] retirar(String numTarjeta, double monto, String nip);

    Ticket pagaServicio(String convenio, String referencia);

}
