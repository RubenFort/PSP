package codigo;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

//Extiendo a Thread para poder usar hilos
public class Pasteleria extends Thread{
    
    private final int MAX_COMILONES;
    private final int MAX_PASTELEROS;
    private final int MAX_TARTAS;

    private int tartasProducidas;
    private int tartasConsumidas;
    private int tartasTotales;
    private Vector<Pastelero> pasteleros;
    private Vector<Comilon> comilones;
    public Cola cola;
    
    public Pasteleria(String nombre, int p, int c, int maxT) {
        this.pasteleros = new Vector<Pastelero>();
        this.comilones = new Vector<Comilon>();
        Cola cola = new Cola();
        System.out.println("----- Pastelería " + nombre + " -----");
        MAX_PASTELEROS = p;
        MAX_COMILONES = c;
        MAX_TARTAS = maxT; 
               
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
        //Imprimo los datos finales
        System.out.println("-------------------------------------------------");
        for (int i = 0; i < MAX_PASTELEROS; i++) {
            System.out.println("Pastelero con ID: " + 
                    pasteleros.elementAt(i).getIdPastelero() + "\t coció: " + 
                    pasteleros.elementAt(i).getTartasFabricadas() + " tartas");
        }
        
        for (int i = 0; i < MAX_COMILONES; i++) {
            System.out.println("Comilón con ID: " + 
                    comilones.elementAt(i).getIdComilon() + "\t comió: " + 
                    comilones.elementAt(i).getTartasComidas() + " tartas");
        }
        System.out.println("Tartas cocidas: " + tartasProducidas);
        System.out.println("Tartas comidas: " + tartasConsumidas);
        
    }
    
    //Contador de tardatas producidas
    int incrementarTarta() {
        tartasProducidas++;
        return tartasProducidas;
        
    }
    //Contador de tartas comidas y balance de tartas
    void decrementarTartas() {
        tartasConsumidas++; 
    }
    
boolean tartasTotales() {
        if (tartasProducidas >= MAX_TARTAS) {
            return false;
        }
        return true;
    } 

boolean tartasComidas() {
        if (tartasConsumidas >= MAX_TARTAS) {
            return false;
        }
        return true;
    } 
}