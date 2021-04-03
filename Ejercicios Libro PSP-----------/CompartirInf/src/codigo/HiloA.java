package codigo;

import java.util.logging.Level;
import java.util.logging.Logger;

public class HiloA extends Thread{
    private Contador contador;
    
    public HiloA(String n, Contador c) {
        setName(n);
        contador = c;
    }

    @Override
    public void run() {
        synchronized (contador){
            for (int i = 0; i < 300; i++) {
                try {
                    contador.incrementar();
                    sleep(10);
                } catch (InterruptedException ex) {

                }
            }
            System.out.println(getName() + " contador vale " + contador.valor());
        }
    }    
}
