package codigo;

import java.util.logging.Level;
import java.util.logging.Logger;

public class HiloA extends Thread{
    
    private Object cerrojo;
    
    public HiloA(Object cerrojo) {
        this.cerrojo = cerrojo;
    }

    @Override
    public void run() {
        System.out.println("Entrando en A en " + System.currentTimeMillis());
        synchronized(cerrojo){
            try {
                sleep(5*1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloA.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Saliendo en A en " + System.currentTimeMillis());
    }
    
    
}
