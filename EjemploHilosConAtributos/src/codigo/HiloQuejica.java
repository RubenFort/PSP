package codigo;

public class HiloQuejica extends Thread{
    
    private String mensaje; //Netbeans nos recomienda que sea final pq no hay ningún metodo Set, final le ahorra tiempo a la JVM
    private int segundos;

    private HiloQuejica() { //Al poner private denominariamos un "tapado"
    }
    
    public HiloQuejica(String mensaje, int segundos) {
        this.mensaje = mensaje;
        this.segundos = segundos;
    }
    
    @Override
    public void run() {
      
        while (true) {     
            //Muestro el mensaje indicado
            System.out.println(mensaje);
            try {
                //Me echo a dormir los segundos indicados
                sleep(1000 * segundos);
            } catch (InterruptedException ex) {
                //LLegaríamos aquí si el hilo (por un fallo de la JVM) despertara durante el sueño
                
            }
        }
    }
}
