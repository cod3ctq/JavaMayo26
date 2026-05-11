public class Celular {

    String modelo;
    String marca;
    double precio;
    int mAh;
    // memoria, proc, display, camara, puertos
    public Celular(){}

    public Celular(String modelo, String marca, double precio, int mAh) {
        this.modelo = modelo;
        this.marca = marca;
        this.precio = precio;
        this.mAh = mAh;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getmAh() {
        return mAh;
    }

    public void setmAh(int mAh) {
        this.mAh = mAh;
    }

    @Override
    public String toString() {
        return "Celular{" +
                "modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", precio=" + precio +
                ", mAh=" + mAh +
                '}';
    }

    // COMO: Acciones o funciones/comportamiento de los objetos
    //Las clases adquieren comportamineto de 3 fases.
    /*
    Metodos nativos
    Metodos heredados(comunmente se sobreescriben)
    Metodos implementados(usos interfaces)
     */

    public void mandarMensaje(String numero, String mensaje){
        System.out.println("Enviando Mensaje : ["+mensaje +"] al numero:>" +numero);
    }

    public void hacerLlamada(String numero){
        System.out.println("Marcando al numero:> " +numero);
    }

}
