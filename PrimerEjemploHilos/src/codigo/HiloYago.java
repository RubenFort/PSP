package codigo;


public class HiloYago extends Thread{

    @Override
    public void run() {
        while (true) {
            //Muestro mensaje            
            System.out.println("ES VIERNES!!!!");
            try {
                //Me echo a dormir 1000ms
                sleep(5000);
            } catch (InterruptedException e) {
                //LLegaríamos aquí si el hilo (por un fallo de la JVM) despertara durante el sueño
            }
        }
    } 
}
