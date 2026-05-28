package models;

import constants.Constantes;
import dao.CuentaDAO;
import dao.MovimientoDAO;
import dao.ServiciosDAO;
import dto.CuentaDTO;
import entity.Cuenta;
import exception.AccountNotFoundException;
import util.Helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public abstract class Atm {

    private String direccion;
    private String folio;
    public static int folioOperacion = 0;
    private Cuenta[] database;
    private static List<CuentaDTO> cacheCuentas;
    public static Map<String, Double> cacheRetirosDiarios = new HashMap<>();
    public static Map<String, Double> cacheRst = new HashMap<>();
    public static Set<String> cacheRetirosCobrados = new HashSet<>();
    //Inyeccion de dependencias manuales
    //Se inyecta en esta clase, anunque ccualquier otra tambien puede usarlo
    private CuentaDAO cuentadao = new CuentaDAO();
    private MovimientoDAO movimientodao = new MovimientoDAO();
    private ServiciosDAO serviciosDAO = new ServiciosDAO();

    public Atm() {
        cacheCuentas = cuentadao.leerCuentas();
    }
    public Atm(String direccion, String folio) {
        this.direccion = direccion;
        this.folio = folio;
        this.database = cargarCuentas();
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
        Atm.cacheCuentas = cacheCuentas;
    }
    public static Map<String, Double> getCacheRetirosDiarios() {
        return cacheRetirosDiarios;
    }
    public static void setCacheRetirosDiarios(Map<String, Double> cacheRetirosDiarios) {
        Atm.cacheRetirosDiarios = cacheRetirosDiarios;
    }
    public MovimientoDAO getMovimientodao() {
        return movimientodao;
    }
    public void setMovimientodao(MovimientoDAO movimientodao) {
        this.movimientodao = movimientodao;
    }
    public CuentaDAO getCuentadao() {
        return cuentadao;
    }
    public void setCuentadao(CuentaDAO cuentadao) {
        this.cuentadao = cuentadao;
    }
    public static Map<String, Double> getCacheRst() {
        return cacheRst;
    }
    public static void setCacheRst(Map<String, Double> cacheRst) {
        Atm.cacheRst = cacheRst;
    }
    public static Set<String> getCacheRetirosCobrados() {
        return cacheRetirosCobrados;
    }
    public static void setCacheRetirosCobrados(Set<String> cacheRetirosCobrados) {
        Atm.cacheRetirosCobrados = cacheRetirosCobrados;
    }

    public ServiciosDAO getServiciosDAO() {
        return serviciosDAO;
    }

    public void setServiciosDAO(ServiciosDAO serviciosDAO) {
        this.serviciosDAO = serviciosDAO;
    }

    @Override
    public String toString() {
        return "models.Atm{" +
                "direccion='" + direccion + '\'' +
                ", folio='" + folio + '\'' +
                '}';
    }
    public static CuentaDTO buscarCuenta(String numTarjeta, String nip) throws AccountNotFoundException {
        CuentaDTO encontrado = null;
        for (int i = 0; i < cacheCuentas.size(); i++) {
            if (cacheCuentas.get(i).getNumTarjeta().equals(numTarjeta) &&
                    cacheCuentas.get(i).getNip().equals(nip)) {
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
            if (c != null) {
                System.out.println("Tu saldo es: " + c.getSaldo());
            } else {
                System.out.println("entity.Cuenta inexistente!");
            }
        } catch (AccountNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
    private Cuenta[] cargarCuentas() {
        File file = new File("C:\\Users\\César\\Desktop\\cuentas.txt");
        String linea;
        Cuenta cuenta;
        Cuenta[] cuentas = new Cuenta[50];
        String[] datos;
        int contador = 0;
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            while ((linea = br.readLine()) != null) {datos = linea.split(",");
                cuenta = new Cuenta(datos[0], datos[1], datos[2], datos[3],
                        Double.parseDouble(datos[4]), datos[5]);cuentas[contador] = cuenta;contador++;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return cuentas;
    }
    //Metodo hecho solo para automatizar la generacion de los retiros asociadandolos a una cuenta
    //leida desde la data base, es solo para simular datos
    public void generarRetiroSinTarjeta() {
        //Genera 1 retiros sin tarjeta con valores aleatorios
        for (CuentaDTO dto:getCacheCuentas()) {
            cacheRst.put(dto.getNumCuenta() + ":" + Helper.generarReferencia()+ ":" + Helper.generarClave(), Double.parseDouble(Helper.generarMonto()));
        }
    }
    public abstract Ticket cobrarRetiroSinTarjeta();

    public void inspeccionarCacheRetirosDiarios() {
        for (String registro : cacheRetirosDiarios.keySet()) {
            System.out.println(registro + " : " + cacheRetirosDiarios.get(registro));
        }
    }
}