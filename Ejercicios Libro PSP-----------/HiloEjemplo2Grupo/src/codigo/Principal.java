package codigo;

public class Principal {

    public static void main(String[] args) {
        Thread.currentThread().setName("Principal");
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().toString());
        
        ThreadGroup grupo = new ThreadGroup("Grupo de hilos");
        HiloEjemplo2Grupo h = new HiloEjemplo2Grupo();
        
        Thread h1 = new Thread(grupo, h, "Hilo 1");
        Thread h2 = new Thread(grupo, h, "Hilo 2");
        Thread h3 = new Thread(grupo, h, "Hilo 3");
        
        h1.start();
        h2.start();
        h3.start();
        
        System.out.println("3 HILOS CREADOS");
        System.out.println("Hilos activos: " + Thread.activeCount());
    }
    
}
