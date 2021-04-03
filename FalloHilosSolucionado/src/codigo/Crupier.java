package codigo;
//Baraja las cartas tantas veces como se le indique

import java.util.Random;

public class Crupier extends Thread{
    
    private Baraja baraja;
    private final int intercambiosARealizar;
    
    public Crupier (Baraja baraja, int intercambiosARealizar){
        this.baraja = baraja;
        this.intercambiosARealizar = intercambiosARealizar;
    }

    @Override
    public void run() {
        Random generador = new Random();
        
        int i;
        int j;
        
        for (int veces = 0; veces < intercambiosARealizar; veces++) {
        
            do {                
                i = generador.nextInt(10);//Genera un entero aleatorio entgre 0 y 9
                j = generador.nextInt(10);//Genera un entero aleatorio entgre 0 y 9
            } while (i==j);
        baraja.intercambia(i, j);   
        } 
    }
}
