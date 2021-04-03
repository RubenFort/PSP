package codigo;

public class Principal {

    public static void main(String[] args) throws InterruptedException {
        
        Hilo h1 = new Hilo();
        Hilo h2 = new Hilo();
        Hilo h3 = new Hilo();
        
        h1.setPriority(Thread.MAX_PRIORITY);
        h2.setPriority(Thread.NORM_PRIORITY);
        h3.setPriority(Thread.MIN_PRIORITY);
        
        h1.start();
        h2.start();
        h3.start();
        
        h1.join();
        h2.join();
        h3.join();
        
        System.out.println("Tiempo de ejecucón de h1: " + h1.getTiempoDeEjecucion());
        System.out.println("Tiempo de ejecucón de h2: " + h2.getTiempoDeEjecucion());
        System.out.println("Tiempo de ejecucón de h3: " + h3.getTiempoDeEjecucion());
    }
}
