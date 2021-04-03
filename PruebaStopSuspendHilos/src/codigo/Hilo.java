package codigo;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Hilo extends Thread{

    @Override
    public void run() {
        while (true) { 
            System.out.println("Soy el hilo");
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                
            }
        }
    }
    
}
