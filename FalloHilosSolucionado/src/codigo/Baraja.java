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
    
   //AL poner synchronized solo un crupier puede acceder al metodo al mismo tiempo, crupieres que comparten baraja 
    public synchronized void intercambia (int i, int j) {
        int tmp;
        
        //Intercambiamos los contenidos de las posiciones i y j
        {
        tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
        }
    }
    
    public int[] getArray() {
        return array;
    }
    
}
