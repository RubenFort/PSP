package codigo;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Comilon extends Thread{
   private int idComilon;
    private Pasteleria pasteleria;
    private int maxTartas;
    private Cola cola = new Cola();
    private Tarta tarta;

    Comilon(Cola cola, int id, Pasteleria pasteleria) {
        this.pasteleria = pasteleria;
        this.cola = cola;
        idComilon = id;
    }
    
    //si la cola no está vacia, el comilon come la tarta, tarda en comerla el 
    //peso de la misma que hemos recuperado.
    //Sincronizo el bloque comerTarta, para que los comilones 
    //no cojan la misma tarta ni intenten coger tarta cuando la cola está vacía
    @Override
    public void run() {
        do {        
            if (!cola.estaVacia()) {  
                    int peso = cola.pesoTarta(); 
                    if (peso!=0) {
                        try {
                            sleep(peso);
                            synchronized(cola){
                                comerTarta(cola);
                            }
                        } catch (InterruptedException ex) { 
                        }
                    }
                }
        } while (true);
    }
    
    //Quito la tarta que ocupa la primera posicion en el vector y actualizo su 
    //contador y el contador total
    private void comerTarta(Cola cola) {
        if(cola.estaVacia()){
            return;  
        }
        
        if(cola.tamañoCola()>0){
            cola.saleTarta();
            pasteleria.decrementarTartas();
            
        }
    }
}
