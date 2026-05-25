import javax.security.auth.login.AccountNotFoundException;

public interface IOperacionesbásicas {

    Object[] retirar(String numTarjeta, double monto, String nip) throws AccountNotFoundException;
    Ticket pagarServcicio(String convenio, String referencia);




}
