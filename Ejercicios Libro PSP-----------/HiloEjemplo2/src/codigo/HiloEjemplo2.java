
package codigo;

public class HiloEjemplo2 extends Thread{

    @Override
    public void run() {
        System.out.println(
                "\tDentro del hilo: " + Thread.currentThread().getName() +
                "\n\tPrioridad      : " + Thread.currentThread().getPriority() +
                "\n\tID             : " + Thread.currentThread().getId()+
                "\n\tHilos Activos  : " + Thread.currentThread().activeCount());
    }
    
}
