package codigo;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Hilo extends Thread{
    private long tiempoDeEjecucion;
    private long tiempoInicial;
    private long tiempoFinal;
    private int cont = 0;
    private final long MAX_VECES = 1000_000_000;
    
    public long getTiempoDeEjecucion() {   
    return tiempoDeEjecucion;
    }
    
    @Override
    public void run() {
        tiempoInicial = System.currentTimeMillis(); 
        float x = 0;
        for (int i = 0; i < MAX_VECES; i++) {
            x = x + 1 ;
            
        }
        tiempoFinal = System.currentTimeMillis();
        tiempoDeEjecucion = tiempoFinal - tiempoInicial;
    }
}
