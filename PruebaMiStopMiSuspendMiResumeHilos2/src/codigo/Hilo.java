package codigo;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Hilo extends Thread{
    
    private boolean stop = false;
    private boolean running = true;

    @Override
    public void run() {
        
        
        //Algunas sentencias que duran un tiempo aceptable.
        if (stop){
            return;
        }
        System.out.println("Soy el hilo");
        //Algunas sentencias que duran un tiempo aceptable.
        if (stop){
            return;
        }
        for (int i = 0; i < 10; i++) {//Unica opcionde hacerlo
            try {
                sleep(100);
                 if (stop){
                    return;
                }
            } catch (InterruptedException ex) {    
            }
        }
        //Algunas sentencias que duran un tiempo aceptable.
        if (stop){
            return;
        }
    }
    
    public void miStop(){
        this.stop = true;
    }
    public void miSuspend(){
        
    }
    public void miResume(){
        
    }
    
}
