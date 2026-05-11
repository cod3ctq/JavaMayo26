public class JugarVideojuegos {

    String nombreVideojuego;
    String consola;
    String modeloTelevisor;
    int cantidadPersonas;
    double precioVideojuego;

    //Generar el constructor


    public JugarVideojuegos(String nombreVideojuego, String consola, String modeloTelevisor, int cantidadPersonas, double precioVideojuego) {
        this.nombreVideojuego = nombreVideojuego;
        this.consola = consola;
        this.modeloTelevisor = modeloTelevisor;
        this.cantidadPersonas = cantidadPersonas;
        this.precioVideojuego = precioVideojuego;
    }

    //Incluir el miembro getter y setter

    public String getNombreVideojuego() {
        return nombreVideojuego;
    }

    public void setNombreVideojuego(String nombreVideojuego) {
        this.nombreVideojuego = nombreVideojuego;
    }

    public String getConsola() {
        return consola;
    }

    public void setConsola(String consola) {
        this.consola = consola;
    }

    public String getModeloTelevisor() {
        return modeloTelevisor;
    }

    public void setModeloTelevisor(String modeloTelevisor) {
        this.modeloTelevisor = modeloTelevisor;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public double getPrecioVideojuego() {
        return precioVideojuego;
    }

    public void setPrecioVideojuego(double precioVideojuego) {
        this.precioVideojuego = precioVideojuego;
    }

    // Visualizar el estado del objeto (ver que valores tiene cada atributo del objeto).

    @Override
    public String toString() {
        return "JugarVideojuegos{" +
                "nombreVideojuego='" + nombreVideojuego + '\'' +
                ", consola='" + consola + '\'' +
                ", modeloTelevisor='" + modeloTelevisor + '\'' +
                ", cantidadPersonas=" + cantidadPersonas +
                ", precioVideojuego=" + precioVideojuego +
                '}';
    }
}


