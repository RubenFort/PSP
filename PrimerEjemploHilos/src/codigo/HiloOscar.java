package codigo;

import java.util.logging.Level;
import java.util.logging.Logger;
import sun.util.logging.PlatformLogger;

public class HiloOscar extends Thread{
    
    @Override
    public void run() {
      
        while (true) {     
            //Muestro mensaje
            System.out.println("Es Hora de la tortilla !!!!");
            try {
                //Me echo a dormir 1000ms
                sleep(1000);
            } catch (InterruptedException ex) {
                //LLegaríamos aquí si el hilo (por un fallo de la JVM) despertara durante el sueño
                
            }
        }
    }
}
