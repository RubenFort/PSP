package codigo;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Corredor extends Thread{

    @Override
    public void run() {
        do {            
            try {
                sleep(200);
            } catch (InterruptedException ex) {
            }
        System.out.println("Cada 0.2 segundos esprinto");    
        } while (true);
    }
}
