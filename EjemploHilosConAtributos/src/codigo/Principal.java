package codigo;

public class Principal {

    public static void main(String[] args) throws InterruptedException {
         HiloQuejica oscar = new HiloQuejica("Es la hora de la tortilla", 1);
         HiloQuejica yago = new HiloQuejica("Es viernes!!", 5);
         
         oscar.start();
         yago.start();
         
         oscar.join();
         System.out.println("El hilo Oscar ha terminado");
         yago.join();
         System.out.println("El hilo Yago ha terminado");
         
         System.out.println("Todos los hilos creados han terminado");
         
    }
    
}
