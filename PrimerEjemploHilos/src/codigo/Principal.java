package codigo;

public class Principal {

    public static void main(String[] args) throws InterruptedException {
         HiloOscar oscar = new HiloOscar();
         HiloYago yago = new HiloYago();
         
         oscar.start();
         yago.start();
         
         oscar.join();
         System.out.println("El hilo Oscar ha terminado");
         yago.join();
         System.out.println("El hilo Yago ha terminado");
         
         System.out.println("Todos los hilos creados han terminado");
         
    }
    
}
