

public class Celular {
    String modelo;
    String marca;
    double precio;
    //memoria, procesador, display, cámaras, puertos,
    int mAh;



    public  Celular(){


    }

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
    //COMO : Acciones o funciones o comportamientos de los objetos
    //Las clases adquieren comportamiento de 3 formas
    /*
    1. Métodos nativos: dieseñados y desarrollados bajo el contexto de este modelo
    2. métodos heredados (comunmente se sobreescriben)
    3. MMétodos implementados (uso de interfaces).
     */

    //Métodos nativos
    //Acciones o metodos que representan el ujso que le doy al objeto.
    public void mandarMensaje(String numero, String mensaje){
        System.out.println("Enviando mensaje : ["+mensaje +"] al número:> "+numero);
    }

    public void hacerLlamada(String numero){
        System.out.println("Marcando al número:> "+numero);
}


}

