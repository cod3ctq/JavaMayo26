public interface iOperacionesBasicas {
    public Object[] retirar(String numTarjeta, double monto, String nip);
    Ticket pagarServicio(String convenio, String referencia);
}
