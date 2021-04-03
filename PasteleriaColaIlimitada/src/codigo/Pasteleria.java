package codigo;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

//Extiendo a Thread para poder usar hilos
public class Pasteleria extends Thread{
    
    private final int MAX_COMILONES = 5;
    private final int MAX_PASTELEROS = 4;
    private final int MAX_TARTAS = 100;

    private int tartasProducidas;
    private int tartasConsumidas;
    private Vector<Pastelero> pasteleros;
    private Vector<Comilon> comilones;
    public Cola cola;
    
    public Pasteleria() {
        this.pasteleros = new Vector<Pastelero>();
        this.comilones = new Vector<Comilon>();
        Cola cola = new Cola();
        
        //Creo los pasteleros y comilones
        for (int i = 0; i < MAX_PASTELEROS; i++) {
            pasteleros.add(new Pastelero(cola, i, this));
        }
        for (int i = 0; i < MAX_COMILONES; i++) {
            comilones.add(new Comilon(cola, i, this));
        }
    }
    
    //Reescribir metodo run y arranco los hilos
    @Override
    public void run() {
        for(Pastelero p : pasteleros){   
            p.start();
        }
        for(Comilon c : comilones){   
            c.start();
        }
        for(Pastelero p : pasteleros) {
            boolean error;
            do{
                try {
                    p.join();
                    error = false;
                } catch (InterruptedException ex) {
                    error = true;
                }
            }while (error);
        }
        for(Comilon c : comilones) {
            boolean error;
            do{
            
                try {
                    c.join();
                    error = false;
                } catch (InterruptedException ex) {
                    error = true;
                }
            }while (error);
        } 
    }
    
    //Contador de tardatas producidas
    int incrementarTarta() {
        tartasProducidas++;
        System.out.println("Tartas producidas: " + tartasProducidas);
        return tartasProducidas;  
    }
    //Contador de tartas comidas y balance de tartas
    void decrementarTartas() {
        tartasConsumidas++;
        System.out.println("Tartas comidas: " + tartasConsumidas);
        System.out.println("Tartas totales: " + (tartasProducidas - tartasConsumidas));
    }
}