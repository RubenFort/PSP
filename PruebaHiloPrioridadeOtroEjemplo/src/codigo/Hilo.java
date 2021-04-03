package codigo;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Hilo extends Thread{
    long tiempoDeEjecucion;
    long tiempoInicial;
    long tiempoFinal;
    int cont = 0;
    
    @Override
    public void run() {
        tiempoInicial = System.currentTimeMillis();       
        do {
            try {
                sleep(1);
                cont++;
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (cont < 10000);
        tiempoFinal = System.currentTimeMillis();
        
        tiempoDeEjecucion = tiempoFinal - tiempoInicial;
    }

    public long getTiempoDeEjecucion() {
        return tiempoDeEjecucion;
    }
}
