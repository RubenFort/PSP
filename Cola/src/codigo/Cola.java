package codigo;

import java.util.Vector;

public class Cola {
    private Vector <Integer> colas;
    private int valorADevolver;
    
    public Cola (){
        colas = new Vector(200);
    }

    void entra(Integer i) {
        colas.add(i);
    }

    int sale() {
        return colas.remove(0);
    }

    boolean estaVacia() {
        if (colas.size()>0){
            return false;
        } else {
            return true;
        }
    }
    
    
    
}
