
package codigo;

public class HiloEjemplo2Grupo extends Thread{

    @Override
    public void run() {
        System.out.println("Infromacion del hilo: " + Thread.currentThread().toString());
        
        for (int i = 0; i < 1000; i++) i++;
        System.out.println(Thread.currentThread().getName() + " Finalizando la ejecucion.");    
        
        
    }
    
}
