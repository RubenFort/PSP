package codigo;

import static java.lang.Thread.sleep;

public class Principal {

private static long TIEMPO_SUEÑO = 20 * 1000;    
    public static void main(String[] args) throws InterruptedException {
     
        System.out.println("Thread Max Priority: " + Thread.MAX_PRIORITY);
        System.out.println("Thread Norm Priority: " + Thread.NORM_PRIORITY);
        System.out.println("Thread Min Priority: " + Thread.MIN_PRIORITY);
        
        Hilo h0 = new Hilo();
        Hilo h1 = new Hilo();
        Hilo h2 = new Hilo();
        
        h0.setPriority(Thread.MIN_PRIORITY);
        h1.setPriority(Thread.NORM_PRIORITY);
        h2.setPriority(Thread.MAX_PRIORITY);
        
        h0.start();
        h1.start();
        h2.start();
        
        //Tratar la excepcion del sleep
        long tiempoRestanteSueño = TIEMPO_SUEÑO;
        long inicio = 0;
        do {            
            try {
                inicio = System.currentTimeMillis();
                sleep(tiempoRestanteSueño);
                tiempoRestanteSueño = 0;
            } catch (InterruptedException ex) {
                tiempoRestanteSueño = TIEMPO_SUEÑO - (System.currentTimeMillis() - inicio);
            }
        } while (tiempoRestanteSueño > 0);
        
        h0.stop();
        h1.stop();
        h2.stop();
        
        //Tratar la excepcion del join
        boolean error;
        do {
            try {
                h0.join();
                h1.join();
                h2.join();
                error = false;
            } catch (InterruptedException interruptedException) {
                error = true;
            }
        } while (error);
        
        System.out.println("Veces h0: " + h0.getVeces());
        System.out.println("Veces h1: " + h1.getVeces());
        System.out.println("Veces h2: " + h2.getVeces());
    }
}
