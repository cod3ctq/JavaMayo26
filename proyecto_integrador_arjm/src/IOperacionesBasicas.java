public interface IOperacionesBasicas {

    Object[] retiro(String numTarjeta,double monto, String nip);

    Ticket pagarServicio(String convenio, String referencia);



}
