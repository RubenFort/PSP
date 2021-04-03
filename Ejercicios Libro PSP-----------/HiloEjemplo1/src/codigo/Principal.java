package codigo;

public class Principal {

    public static void main(String[] args) {
        HiloEjemplo1 h1 = new HiloEjemplo1("Hilo1");
        HiloEjemplo1 h2 = new HiloEjemplo1("Hilo2");
        HiloEjemplo1 h3 = new HiloEjemplo1("Hilo3");
        
        h1.start();
        h2.start();
        h3.start();
        
        System.out.println("3 HILOS INICIADOS...");
    }//
    
}
