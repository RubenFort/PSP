
package codigo;

import static java.lang.Thread.sleep;

public class HiloB extends Thread{
    
    private Contador contador;
    
    public HiloB(String n, Contador c) {
        setName(n);
        contador = c;
    }

    @Override
    public void run() {
        synchronized (contador){
            for (int i = 0; i < 300; i++) {
                try {
                    contador.decrementar();
                    sleep(10);
                } catch (InterruptedException ex) {

                }
            }
            System.out.println(getName() + " contador vale " + contador.valor());
        }
    }    
}
