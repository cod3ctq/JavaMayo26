public class EnvioInternacional extends Envio {

    String paisDestino;
    String medioTransporte;
    String divisa;

    // Constructores
    public EnvioInternacional(String direccion, String receptor, String fechaEntrega, boolean esFragil, double precioBase, boolean statusEntrega, double peso, String paisDestino, String medioTransporte, String divisa) {
        super(direccion, receptor, fechaEntrega, esFragil, precioBase, statusEntrega, peso);
        this.paisDestino = paisDestino;
        this.medioTransporte = medioTransporte;
        this.divisa = divisa;
    }

    // Sobre escribimos Métodos de Envio
    @Override
    public double calcularCosto() {
        // Necesitaríamos catálogo de países, de medios de transporte, de divisas, etc
        // Sería un código más elaborado y extenso que el de la clase EnvioFrio
        return 0;
    }
    @Override
    public void validarDatos() {
    }
}