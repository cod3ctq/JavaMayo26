public class EnvioInternacional extends Envio{

    String pais;
    String MedioTransporte;
    String divisa;


    public EnvioInternacional(String direccion, String receptor, String fechaEntrega, boolean fragil, double precioBase, boolean status, double pesoPaquete, String pais, String medioTransporte, String divisa) {
        super(direccion, receptor, fechaEntrega, fragil, precioBase, status, pesoPaquete);
        this.pais = pais;
        MedioTransporte = medioTransporte;
        this.divisa = divisa;
    }

    @Override
    public double CalcularCosto() {
    //

        return 0;
    }

    @Override
    public void ValidarDatos() {

    }
}
