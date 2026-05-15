public class EnvioInternacional extends Envio{

    String pais;
    String medioTransporte;
    String divisa;

    public EnvioInternacional(String direccion, String receptor, String fechaEntrega, boolean fragil, double precioBase, boolean status, double pesoPaquete, String pais, String medioTransporte, String divisa) {
        super(direccion, receptor, fechaEntrega, fragil, precioBase, status, pesoPaquete);
        this.pais = pais;
        this.medioTransporte = medioTransporte;
        this.divisa = divisa;
    }

    @Override
    public double calcularCosto() {
        return 0;
    }

    @Override
    public void validarDatos() {

    }
}
