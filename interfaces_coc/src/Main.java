public class Main {
    public static void main(String[] args) {
        Chofer c1 = new Chofer("Joel", "Masculino", 38);
        // Invocación de metodo nativo
        c1.conducir();
        // Invocación de metodos de 3 contextos o interfaces distintas implementadas en el modelo
        c1.afinacion();
        c1.medir();
        c1.nadar();
    }
}