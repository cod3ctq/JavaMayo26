public class Celular {
    String modelo;
    String marca;
    double precio;
    int mAH;

    public Celular(){}

    public Celular(String modelo, String marca, double precio, int mAH) {
        this.modelo = modelo;
        this.marca = marca;
        this.precio = precio;
        this.mAH = mAH;
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

    public int getmAH() {
        return mAH;
    }

    public void setmAH(int mAH) {
        this.mAH = mAH;
    }

    @Override
    public String toString() {
        return "Celular{" +
                "modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", precio=" + precio +
                ", mAH=" + mAH +
                '}';
    }
    // COMO: ACCIONES O FUNCIONES/COMPORTAMIENTO DE LOS OBJETOS
    //las clases adquieren comportamiento de 3 formas
    /*
    1 metodos nativos: Disenados y desarrollados bajo el contexto de este modelo(metodos que nacieron en la clase)
    2 metodos heredados (Comunmente se sobreescriben)
    3 metodos implementados (uso interfaces)
     */
    //metodos nativos
    //acciones o metodos que representan el uso que le doy a este objeto
    public void mandarMensaje(String numero, String mensaje) {
        System.out.println("Enviando mensaje : [" + mensaje + "]; al numero:> " + numero);
    }        /*public : Modificador de accesso
        void : Retorno del metodo
        mandarMensaje: Nombre del metodo
        (String numero, String mensaje) argumentos, datos de entrada
        { : inicio de la logica del metodo
        System.out.println("Enviando mensaje : ["+mensaje +"]; al numero:> "+numero); logica del metodo
        */
        public void hacerLlamada (String numero){
            System.out.println("Marcando al numero:> "+numero);

    }
}
