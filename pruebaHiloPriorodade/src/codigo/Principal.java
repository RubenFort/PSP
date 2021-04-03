package codigo;

import static java.lang.Thread.sleep;

public class Principal {
    //Cambiamos las prioridades de los hilos, valores entre 1 y 10
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Maxima prioridad hilo: " + Thread.MAX_PRIORITY);
        System.out.println("Normal prioridad hilo: " + Thread.NORM_PRIORITY);
        System.out.println("Minimo prioridad hilo: " + Thread.MIN_PRIORITY);
        
        Corredor c = new Corredor();
        System.out.println("Prioriry: " + c.getPriority());
        sleep(100);
        
        c.start();
        
        System.out.println("Prioriry: " + c.getPriority());
        sleep(100);
        
        System.out.println("Cambio prioridad a MAX_PRIORITY --------------------");
        c.setPriority(Thread.MAX_PRIORITY);
        System.out.println("Priority: " + c.getPriority());
        sleep(100);
        
        System.out.println("Cambio prioridad a MIN_PRIORITY --------------------");
        c.setPriority(Thread.MIN_PRIORITY);
        System.out.println("Priority: " + c.getPriority());
        sleep(100);
        
        System.out.println("Cambio prioridad a MAX_PRIORITY + 1 --------------------");
        try {
            c.setPriority(Thread.MAX_PRIORITY + 1);
        } catch (Exception e) {
            System.out.println("Intentas introducir un valor de prioridad erroneo");
        } finally {
            System.out.println("La prioridad es :" + c.getPriority());
        }
        sleep(100);
        
        //Finslizar el hilo
        c.stop();
        System.out.println("Forzamos la finalizacion del hilo");
        
        c.join();
        System.out.println("El main espera a que acabe el hilo");
    }
}
