package codigo;

import static java.lang.Thread.sleep;

public class Principal {

    public static void main(String[] args) throws InterruptedException {
        
        //Creamos el hilo y esperamos 5 seg anntes de arrancarlo 
        System.err.println("Creamos el hilo y esperamos 5 seg anntes de arrancarlo ");
        Hilo hilo = new Hilo();
        sleep(5000);
        
        //Arrancamos el hilo y lo dejamos trabajar otros 5 seg
        System.err.println("Arrancamos el hilo y lo dejamos trabajar otros 5 seg");
        hilo.start();
        sleep(5000);
        
        //detenemos el hilo durante 5 seg
        System.err.println("detenemos el hilo durante 5 seg");
        hilo.suspend();
        sleep(5000);
        
        //reanudamos el hilo y lo dejamos trabajar 5 seg
        System.err.println("reanudamos el hilo y lo dejamos trabajar 5 seg");
        hilo.resume();
        sleep(5000);
        
        //finalizamos el hilo
        System.err.println("finalizamos el hilo");
        hilo.stop();
        
        //esperamos la finalizacuion del hilo
        System.out.println("esperamos la finalizacuion del hilo");
        hilo.join();
        
    }
    
}
