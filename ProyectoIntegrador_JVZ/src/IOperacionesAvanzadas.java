import javax.security.auth.login.AccountNotFoundException;

public interface IOperacionesAvanzadas {


    Ticket depositar(String numTarjeta, double monto, String nip) throws AccountNotFoundException;



}
