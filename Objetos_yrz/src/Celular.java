public class Celular {
    String modelo;
    String marca;
    double precio;
    int mAh;
    //memoeria, procesador,display


    public Celular(String modelo, String marca, double precio, int mAh) {
        this.modelo = modelo;
        this.marca = marca;
        this.precio = precio;
        this.mAh = mAh;

    }

    public Celular() {
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

    // Como: acciones o funciones/comportamiento de los objetos
    // Las clases adquieren comportaminto de 3 formas
    /*
    1 metodos nativos
    2 metodos heredados (conmunente se sobreescriben)
    3 metodos implementados (uso interfaces)
     */
    // modificadir de accesi, retorno, nombre del metodo
    // argumentos de entrada

    //MEtodos nativos
    public void mandarMensaje(String numero, String mensaje){
        System.out.println("Enviando un mensaje: "+mensaje+" al numero:"+numero);
    }
    public void hacerLlamada(String numero){
        System.out.println("Marcando al numero:"+numero);
    }
}
