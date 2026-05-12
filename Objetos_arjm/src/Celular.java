public class Celular {
    String modelo;
    String marca;
    double costo;
    int mA;
    //memoria,procesador,display,camaras,puertos

    public Celular(){

    }

    public Celular(String modelo, String marca, double costo, int mA) {
        this.modelo = modelo;
        this.marca = marca;
        this.costo = costo;
        this.mA = mA;
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

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public int getmA() {
        return mA;
    }

    public void setmA(int mA) {
        this.mA = mA;
    }

    @Override
    public String toString() {
        return "Celular{" +
                "modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", costo=" + costo +
                ", mA=" + mA +
                '}';
    }
    //COMO: Acciones o funciones/comportamiento de los onjetos
    //Las clases adquieren comportamiento de 3 formas
    /*
    1 Metodos Nativos: diseñados y desarrollados bajo el contexto de este modelo
    2 Metodos heredados ( comunmente se sobreescriben)
    3 Metodos implementados (uso interfaces)
    */


    //Metodos nativos
    //Acciones o metodos que representan el uso que le doy a este objeto

    public void mandarMensaje(String numero, String mensaje){
        System.out.println("Enviando mensaje :  [" + mensaje + "] al numero:> " + numero);
    }
    public void hacerLlamada(String numero){
        System.out.println("Marcando al numero:> " + numero);
    }

}
