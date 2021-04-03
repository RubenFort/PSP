
package codigo;

public class Principal {

    public static void main(String[] args) {
        Thread.currentThread().setName("Principal");//nombre a main
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().toString());
        
        HiloEjemplo2 h = null;
        
        for (int i = 0; i < 3; i++) {
            h = new HiloEjemplo2();
            h.setName("HILO"+i);
            h.setPriority(i+1);
            h.start();
            System.out.println(
                    "Información del " + h.getName() + ": " + h.toString());
        }
        System.out.println("3 HILOS CREADOS");
        System.out.println("Hilos activos : " + Thread.activeCount());
    }
    
}
