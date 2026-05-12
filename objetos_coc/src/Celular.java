public class Celular {

    // Atributos
    String modelo;
    String marca;
    double precio;
    int mAh;

    // Constructores
    public Celular(){
    }
    public Celular(String modelo, String marca, double precio, int mAh) {
        this.modelo = modelo;
        this.marca = marca;
        this.precio = precio;
        this.mAh = mAh;
    }

    // Getters/Setters
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

    // Metodo toString
    @Override
    public String toString() {
        return "Celular{" +
                "modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", precio=" + precio +
                ", mAh=" + mAh +
                '}';
    }

    // CÓMO? Acciones o funciones/comportamientos de los Objetos
    // Las Clases obtienen comportamientos de 3 formas
    /*
    1. Métodos nativos: Diseñados y desarrollados bajo el contexto de este modelo
    2. Métodos heredados (comunmente se sobre escriben)
    3. Métodos implementados (uso de interfaces)
     */

    // Métodos
    public void mandarMensaje(String numero, String mensaje) {
        System.out.println("Enviando mensaje: [" + mensaje + "] al número: " + numero);
    }
    public void hacerLlamada(String numero) {
        System.out.println("Marcando al número: " + numero);
    }
}