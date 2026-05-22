import java.io.*;
import java.time.LocalDate;
import java.util.*;

public abstract class Atm {
    private String direccion;
    private String folio;
    public static int folioOperacion = 0;

    private Cuenta[] database;
    private List<CuentaDTO> cacheCuentas;

    public static Map<String, Double> cacheRetirosDiarios = new HashMap<>();

    private CuentaDAO cuentadao = new CuentaDAO();
    private MovimientoDAO movimientodao = new MovimientoDAO();

    public Atm() {
        this.cacheCuentas = cuentadao.leerCuentas();
    }

    public Atm(String direccion, String folio) {
        this.direccion = direccion;
        this.folio = folio;
        this.cacheCuentas = cuentadao.leerCuentas();
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public static int getFolioOperacion() {
        return folioOperacion;
    }

    public static void setFolioOperacion(int folioOperacion) {
        Atm.folioOperacion = folioOperacion;
    }

    public List<CuentaDTO> getCacheCuentas() {
        return cacheCuentas;
    }

    public void setCacheCuentas(List<CuentaDTO> cacheCuentas) {
        this.cacheCuentas = cacheCuentas;
    }

    public static Map<String, Double> getCacheRetirosDiarios() {
        return cacheRetirosDiarios;
    }

    public static void setCacheRetirosDiarios(Map<String, Double> cacheRetirosDiarios) {
        Atm.cacheRetirosDiarios = cacheRetirosDiarios;
    }

    public CuentaDAO getCuentaDao() {
        return cuentadao;
    }

    public MovimientoDAO getMovimientoDao() {
        return movimientodao;
    }

    public CuentaDTO buscarCuenta(String numTarjeta, String nip) throws AccountNotFoundException {
        CuentaDTO encontrado = null;

        for (int i = 0; i < cacheCuentas.size(); i++) {
            if (cacheCuentas.get(i).getNumTarjeta().equals(numTarjeta)
                    && cacheCuentas.get(i).getNip().equals(nip)) {
                encontrado = cacheCuentas.get(i);
                break;
            }
        }

        if (encontrado != null) {
            return encontrado;
        } else {
            throw new AccountNotFoundException(Constantes.ACCOUNT_NOT_FOUND);
        }
    }

    public void consultarSaldo(String numTarjeta, String nip) {
        try {
            CuentaDTO c = buscarCuenta(numTarjeta, nip);
            System.out.println("Tu saldo es: " + c.getSaldo());
        } catch (AccountNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void generarRetiroSinTarjeta() {}

    public abstract void cobrarRetiroSinTarjeta();

    public void inspeccionarCacheRetirosDiarios() {
        for (String registro : cacheRetirosDiarios.keySet()) {
            System.out.println(registro + " : " + cacheRetirosDiarios.get(registro));
        }
    }
}