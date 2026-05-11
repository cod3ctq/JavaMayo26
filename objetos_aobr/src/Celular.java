public class Celular {

    String modelo;
    String marca;
    Double precio;
    int mAh;
    //memoria, proc, display, camaras, puertos



    public Celular(){}

    public Celular(String modelo, String marca, Double precio, int mAh) {
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

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
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

    //COMO: Acciones o funciones/compartamientos de los objetos
    //Las clases adquieren compartimientos de 3 formas
    //1. Metodos nativos: diseniados y desarrollados bajo el contexto de ese modelo
    //2. Metodos heredados(Comunmente se sobrescriben)
    //3. Metodos implementados(uso de interfaces)

    //METODOS NATIVOS
    //Acciones o metodos que representan el uso que le doy a este objeto
    public void mandarMensaje(String numero, String mensaje){
        System.out.println("Enviando mensaje: ["+mensaje+"] al numero: " +numero);
    }
    public void hacerLlamada(String numero){
        System.out.println("Marcando al numero: "+numero);
    }


}
