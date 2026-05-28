public interface IOperacionesBasicas {
    Ticket cobrarRetiroSinTarjeta();
    Object[] retirar(String numTarjeta, double monto, String nip);
    Ticket pagarServicio(String convenio, String referencia);

}