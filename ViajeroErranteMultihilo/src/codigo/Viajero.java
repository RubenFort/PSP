package codigo;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Viajero extends Thread{

    private String viajero;
    private int COLUMNAS;
    private int FILAS ;
    private long TICK ; //Tiempo en ms de cada movimiento
    private Movimiento movimiento;
    //Las variables int al estar en esta posicion, se autoinicializan a 0
    private int x, y, ticks;
    private int arriba, abajo, izquierda, derecha;

    public String getViajero() {
        return viajero;
    }

    public int getTicks() {
        return ticks;
    }

    public int getArriba() {
        return arriba;
    }

    public int getAbajo() {
        return abajo;
    }

    public int getIzquierda() {
        return izquierda;
    }

    public int getDerecha() {
        return derecha;
    }
    
    public Viajero(String viajero, int columnas, int filas, long tick) {
        this.viajero = viajero;
        COLUMNAS = columnas;
        FILAS = filas;
        TICK = tick;
    }
    
    @Override
    public void run() {
        
        arriba = abajo = izquierda = derecha = 0;
        
        int matriz[][] = new int [COLUMNAS][FILAS];
        
        while(!(x==((COLUMNAS-1))&&(y==(FILAS-1)))){
            
            try {
                sleep(TICK);
            } catch (InterruptedException ex) {
                //LLegaríamos aquí si el hilo (por un fallo de la JVM) despertara durante el sueño
            }
            
            movimiento = muevete();
            switch(movimiento){
                case UP:
                    if(x!=0){
                        x--;
                        izquierda++;
                    }
                    ticks++;
                    break;
                case DOWN:
                    if(x!=COLUMNAS-1){
                        x++;
                        derecha++;
                    }
                    ticks++;
                    break;
                case LEFT:
                    if(y!=0){
                        y--;
                        arriba++;
                    }
                    ticks++;
                    break;
                case RIGHT:
                    if(y!=FILAS-1){
                        y++;
                        abajo++;
                    }
                    ticks++;
                    break;
            } 
        }

    }
    
    
        private static Movimiento muevete() {

        Random aleatorio = new Random();

        int valor = aleatorio.nextInt(4);

        //Devuelve UP para 0, DOWN para 1, LEFT para 2 y RIGHT para 3
        switch (valor) {
            case 0:
                return Movimiento.UP;
            case 1:
                return Movimiento.DOWN;
            case 2:
                return Movimiento.LEFT;
            case 3:
                return Movimiento.RIGHT;
            default://Nunca llega aquí
                return null;
        }
    }
}
