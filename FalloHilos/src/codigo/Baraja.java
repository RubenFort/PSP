package codigo;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Baraja {
    
    private int [] array;
    
    public Baraja() {
        array = new int [10];
        for (int i=0; i<array.length; i++){
            array[i] = i;
        }
    }
    

    public void intercambia (int i, int j) {
        int tmp;
        
        //Intercambiamos los contenidos de las posiciones i y j
        tmp = array[i];
        //Usando el sleep forzamos el fallo, pq se detiene 1 ms
        try {
            sleep(1);
        } catch (InterruptedException ex) {
            //Despetó antes de tiempo
        }
      
        array[i] = array[j];
        try {
            sleep(1);
        } catch (InterruptedException ex) {
            //Despertó antes de tiempo
        }
        array[j] = tmp;
    }
    
    public int[] getArray() {
        return array;
    }
    
}
