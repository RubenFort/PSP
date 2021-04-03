package codigo;

import java.util.logging.Level;
import java.util.logging.Logger;

public class HiloB extends Thread{
    
    private Object cerrojo;
    
    public HiloB(Object cerrojo) {
        this.cerrojo = cerrojo;
    }

    @Override
    public void run() {
        System.out.println("Entrando en B en " + System.currentTimeMillis());
        synchronized(cerrojo){
            try {
                sleep(5*1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloA.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Saliendo en b en " + System.currentTimeMillis());
    }
    
    
}
