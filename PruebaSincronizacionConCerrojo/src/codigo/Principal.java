
package codigo;

public class Principal {

    public static void main(String[] args) throws InterruptedException {
        Object cerrojo = new Object();
        
        HiloA a = new HiloA(cerrojo);
        HiloB b = new HiloB(cerrojo);
        
        a.start();
        b.start();
        
        a.join();
        b.join();;
        
    }
    
}
