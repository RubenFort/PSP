package codigo;

import java.util.Random;


public class Principal {

    static int MAX_COLUMNAS = 10;
    static int MAX_FILAS = 10;
    static int MIN_COLUMNAS = 10;
    static int MIN_FINAL = 10;
    static int ticks;
    static Random aleatorio;
    public static void main(String[] args) {
     
        int x, y, random;
        int arriba, abajo, izquierda, derecha;
        
        x=0;
        y=0;
        ticks=0;
        arriba = abajo = izquierda = derecha = 0;
        
        aleatorio = new Random();
        int matriz[][] = new int [MAX_COLUMNAS][MAX_FILAS];
        
        
        while(!(x==((MAX_COLUMNAS-1))&&(y==(MAX_FILAS-1)))){
            
        
            random = aleatorio.nextInt(4);
        
            switch(random){
                case 0:
                    if(x!=0){
                        x--;
                        izquierda++;
                    }
                    ticks++;
                    break;
                case 1:
                    if(x!=MAX_COLUMNAS-1){
                        x++;
                        derecha++;
                    }
                    ticks++;
                    break;
                case 2:
                    if(y!=0){
                        y--;
                        arriba++;
                    }
                    ticks++;
                    break;
                case 3:
                    if(y!=MAX_FILAS-1){
                        y++;
                        abajo++;
                    }
                    ticks++;
                    break;
            } 
        }
        System.out.println("Pepe: " + ticks + " " + arriba + " " + abajo + " " + izquierda + " " + derecha + "\n");
    }
}
