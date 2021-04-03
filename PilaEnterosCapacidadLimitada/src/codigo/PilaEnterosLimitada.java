package codigo;

import java.util.Vector;

public class PilaEnterosLimitada {
        
    private final Vector<Integer> datos;
    private final int capacidad;
    
    
    public PilaEnterosLimitada(int capacidad) {
        this.capacidad = capacidad;
        datos = new Vector();
    }
    
    public boolean estaVacia() {
        return datos.isEmpty();
    }
    
    public void entra(int valor){
        datos.add(valor);
    }
    
    public int sale() {
        return datos.remove((datos.size())-1);
    }
    
    public boolean estaLLena() {
        return datos.size() == capacidad;
    }
  
}
