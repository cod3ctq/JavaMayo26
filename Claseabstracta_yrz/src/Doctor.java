import org.w3c.dom.ls.LSOutput;

public class Doctor extends Profesionista {

    @Override
    public void trabajar() {
        System.out.println("hacer consultas, reportes" +
                "cirujia,etc");

    }
}
