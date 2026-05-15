public class Motocicleta {

    String marca;
    String modelo;
    int motor;
    String caterogia;
    String color;
    double precio;

    public Motocicleta(){
    }

    public Motocicleta(String marca, String modelo, int motor, String caterogia, String color, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.motor = motor;
        this.caterogia = caterogia;
        this.color = color;
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public int getMotor() {
        return motor;
    }
    public void setMotor(int motor) {
        this.motor = motor;
    }
    public String getCaterogia() {
        return caterogia;
    }
    public void setCaterogia(String caterogia) {
        this.caterogia = caterogia;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Motocicleta{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", motor=" + motor +
                ", caterogia='" + caterogia + '\'' +
                ", color='" + color + '\'' +
                ", precio=" + precio +
                '}';
    }
}