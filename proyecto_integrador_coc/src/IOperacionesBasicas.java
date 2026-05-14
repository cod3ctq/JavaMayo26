public interface IOperacionesBasicas {
    // Todos los metodos en las interfaces son public
    Object[] retirar(String numTarjeta, double monto, String nip); // Metodo que devolverá un array de tipo Object, o sea que puede devolver distintos tipos de datos
    Ticket pagarServicio(String convenio, String referencia); // Devolverá Objeto de tipo Ticket
}