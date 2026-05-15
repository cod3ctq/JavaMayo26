public class Personajes {

        String nombre;
        double vida;
        String arquetipo;
        String poderEspecial;
        double fuerza;
        double defensa;

        public Personajes(){}

        public Personajes(String nombre, double vida, String arquetipo, String poderEspecial, double fuerza, double defensa) {
            this.nombre = nombre;
            this.vida = vida;
            this.arquetipo = arquetipo;
            this.poderEspecial = poderEspecial;
            this.fuerza = fuerza;
            this.defensa = defensa;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public double getVida() {
            return vida;
        }

        public void setVida(double vida) {
            this.vida = vida;
        }

        public String getArquetipo() {
            return arquetipo;
        }

        public void setArquetipo(String arquetipo) {
            this.arquetipo = arquetipo;
        }

        public String getPoderEspecial() {
            return poderEspecial;
        }

        public void setPoderEspecial(String poderEspecial) {
            this.poderEspecial = poderEspecial;
        }

        public double getFuerza() {
            return fuerza;
        }

        public void setFuerza(double fuerza) {
            this.fuerza = fuerza;
        }

        public double getDefensa() {
            return defensa;
        }

        public void setDefensa(double defensa) {
            this.defensa = defensa;
        }


        //permite convertir a texto el estado de un objeto
        @Override
        public String toString() {
            return "Personajes{" +
                    "nombre='" + nombre + '\'' +
                    ", vida=" + vida +
                    ", arquetipo='" + arquetipo + '\'' +
                    ", poderEspecial='" + poderEspecial + '\'' +
                    ", fuerza=" + fuerza +
                    ", defensa=" + defensa +
                    '}';
        }
    }


