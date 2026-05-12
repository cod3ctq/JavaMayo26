import javax.xml.crypto.dsig.spec.XPathFilterParameterSpec;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
//
//    //Programacion Orientada a objetos
//    /*
//    Herencia
//    Encapsulamiento
//    Abstraccion: COncepto con el que buscas simplificar o sintetizar los atributos y caracteristicas relevantes
//    Polimorfismo
//     */
//
//    //Crear un objeto
//    //Clase nombrevariable=new Construtor():
//    Producto pro=new Producto();
//    pro.setCosto(850.00);
//    pro.setCategoria("Vinos y licores");
//    pro.setNombre("Tequila Don Julio");
//    pro.setFolio("F4G34DG");
//    pro.setStock(50.00);
//    pro.setFechaRegistro(new Date());
//
//    //ver el estado del objeto
//    //System.out.println(pro);
//
//    //Contruye un objeto lleno desde el inicio
//    Producto pro2=new Producto(80.00,"Sabritones","SBR3930",140.00, new Date(), "papas");
//   // System.out.println(pro2);
//
//    //Objetoo de un concepto inmaterial
//    SalidaCine sc=new SalidaCine("cinemex","10:30","k10",2,50.00,"michael jackson");
//    double costo;
//    String folio;
//    String nombre;
//    double stock;
//    Date fechaRegistro;
//
//    Personajes heroe=new Personajes("Juan",3000,"Cuerpo a cuerpo","Puñetazo triple",700,1000);
//    Personajes heroe2=new Personajes("Merlin",2200,"Hechicero","Bolas de fuego",400,400);
//    System.out.println(heroe);
//    System.out.println(heroe2);

Celular c=new Celular("1100","Nokia",1500.00,950);
 //   System.out.println(c);
c.mandarMensaje("23234594","Hola que haces");
 c.hacerLlamada("24415563");
    //System.out.println(c);
    Camara c1=new Camara(12,2.8,3,2.8,8,800);
    Camara[] cams={c1};
    Camara c2 = new Camara(200.00,1.3,1,2.8,100,800);
    Camara c3 = new Camara(12.00,1.3,1,2.8,10,800);
    Camara c4 = new Camara(20.00,1.3,1,2.8,10,800);

    Camara[] camSamsung={c1,c2,c3,c4};

    Pantalla pant1=new Pantalla("240x360",2.6,false,true,500,30);
    Smarthphone sm=new Smarthphone("s25","Samsung",25000.00,3000,"Android",cams,pant1);

    //invocamndo metodos nativos de la clase hija(le pertenecen solo a la clase hija)
    sm.instalarAplicaciones();;
    sm.hacerVideollamada();

    //invocar metodos de la clase hija desde una instancia de la clase padre
    //c.instalasAplicaciones();
    //c.hacerVideollamada();
    //NO SE PUEDE REALIZAR YA QUE NO PUEDES HEREDAR METODOS DE LA CLASE HIJA A LA CLASE PADRE


    //invocando metodos de la clase padre desde una instancia de la clase hija
  sm.mandarMensaje("3030303","Buen dia");
  sm.hacerLlamada("230303030");
    System.out.println(sm);
    //sobreescritura: redefinicion de como se resuelve una accion de forma distinta
    //adentro de la logica del metodo, es la misma funcion pero de manera escrita diferente

}
