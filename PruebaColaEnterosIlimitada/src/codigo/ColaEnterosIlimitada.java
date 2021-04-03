package codigo;

import java.util.Vector;

public class ColaEnterosIlimitada {
    
    private Vector<Integer> datos;

    public ColaEnterosIlimitada() {
        datos = new Vector();
    }
    
    public boolean estaVacia() {
        return datos.isEmpty();
    }
    
    public void entra(int valor){
        datos.add(valor);
    }
    
    public int sale() {
        return datos.remove(0);
    }
    
}
