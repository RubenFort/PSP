package codigo;

import java.util.Vector;

public class PilaEnterosIlimitada {
        
    private Vector<Integer> datos;

    public PilaEnterosIlimitada() {
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
    
  
}
