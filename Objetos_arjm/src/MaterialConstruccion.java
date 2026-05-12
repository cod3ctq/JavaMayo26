public class MaterialConstruccion {

    int BultosCemento;
    int BultosCal;
    double ArenaMetrosCubicos;
    double GravaMetrosCubicos;
    int Varillas;
    int Blocks;


    public MaterialConstruccion(){}

    public MaterialConstruccion(int bultosCemento, int bultosCal, double arenaMetrosCubicos, double gravaMetrosCubicos, int varillas, int blocks) {
        BultosCemento = bultosCemento;
        BultosCal = bultosCal;
        ArenaMetrosCubicos = arenaMetrosCubicos;
        GravaMetrosCubicos = gravaMetrosCubicos;
        Varillas = varillas;
        Blocks = blocks;
    }

    public int getBultosCemento() {
        return BultosCemento;
    }

    public void setBultosCemento(int bultosCemento) {
        BultosCemento = bultosCemento;
    }

    public int getBultosCal() {
        return BultosCal;
    }

    public void setBultosCal(int bultosCal) {
        BultosCal = bultosCal;
    }

    public double getArenaMetrosCubicos() {
        return ArenaMetrosCubicos;
    }

    public void setArenaMetrosCubicos(double arenaMetrosCubicos) {
        ArenaMetrosCubicos = arenaMetrosCubicos;
    }

    public double getGravaMetrosCubicos() {
        return GravaMetrosCubicos;
    }

    public void setGravaMetrosCubicos(double gravaMetrosCubicos) {
        GravaMetrosCubicos = gravaMetrosCubicos;
    }

    public int getVarillas() {
        return Varillas;
    }

    public void setVarillas(int varillas) {
        Varillas = varillas;
    }

    public int getBlocks() {
        return Blocks;
    }

    public void setBlocks(int blocks) {
        Blocks = blocks;
    }

    @Override
    public String toString() {
        return "MaterialConstruccion{" +
                "BultosCemento=" + BultosCemento +
                ", BultosCal=" + BultosCal +
                ", ArenaMetrosCubicos=" + ArenaMetrosCubicos +
                ", GravaMetrosCubicos=" + GravaMetrosCubicos +
                ", Varillas=" + Varillas +
                ", Blocks=" + Blocks +
                '}';
    }
}
