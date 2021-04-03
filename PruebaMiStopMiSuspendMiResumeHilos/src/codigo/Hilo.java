package codigo;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Hilo extends Thread{
    
    private boolean stop = false;
    private boolean suspended = false;

    @Override
    public void run() {
        
        while (suspended) {            
            try {
                sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        while (!stop) { 
            System.out.println("Soy el hilo");
            try {
                sleep(500);
                while(suspended){
                    sleep(10);
                }
                sleep(500);
            } catch (InterruptedException ex) {
                
            }
        }
        while (suspended) {            
            try {
                sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void miStop(){
        this.stop = true;
    }
    public void miSuspend(){
        this.suspended = true;
    }
    public void miResume(){
        this.suspended = false;
    }
    
}
