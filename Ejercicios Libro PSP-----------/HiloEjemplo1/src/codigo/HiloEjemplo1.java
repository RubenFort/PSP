package codigo;

public class HiloEjemplo1 extends Thread{
        
    public HiloEjemplo1 (String name) {
        super(name);
        System.out.println("CREANDO HILO: " + getName());
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Hilo: " + getName() + " C = " + i);
        }
    }
    
    
}
