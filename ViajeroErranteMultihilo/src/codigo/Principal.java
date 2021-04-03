package codigo;

import java.util.Random;

public class Principal {

    private static final int COLUMNAS = 10;
    private static final int FILAS = 10;
    private static final long TICK = 1; //Tiempo en ms de cada movimiento
    private static final int NUMERO_VIAJEROS = 5;//Numero de viajeros

    public static void main(String[] args) throws InterruptedException {
        
        //Crea y lanza (arranca) tantos viajeros como indica NUMERO_VIAJEROS
        Viajero pepe = new Viajero("Pepe", COLUMNAS, FILAS, TICK);
        Viajero bartolin = new Viajero("Bartolin", COLUMNAS, FILAS, TICK);
        Viajero ana = new Viajero("Ana", COLUMNAS, FILAS, TICK);
        Viajero maria = new Viajero("Maria", COLUMNAS, FILAS, TICK);
        Viajero juana = new Viajero("Juana", COLUMNAS, FILAS, TICK);
        
        pepe.start();
        bartolin.start();
        ana.start();
        maria.start();
        juana.start();
        
        //Espera a que todos los hilos terminen
        pepe.join();
        bartolin.join();
        ana.join();
        maria.join();
        juana.join();
        
        
        System.out.println("Nombre: " + pepe.getViajero());
        System.out.println("Numero de ticks: " + pepe.getTicks());
        System.out.println("Arriba: " + pepe.getArriba());
        System.out.println("Abajo: " + pepe.getAbajo());
        System.out.println("Izquierda: " + pepe.getIzquierda());
        System.out.println("Derecha: " + pepe.getDerecha());
        System.out.println("---------------------------------------");
        System.out.println("Nombre: " + bartolin.getViajero());
        System.out.println("Numero de ticks: " + bartolin.getTicks());
        System.out.println("Arriba: " + bartolin.getArriba());
        System.out.println("Abajo: " + bartolin.getAbajo());
        System.out.println("Izquierda: " + bartolin.getIzquierda());
        System.out.println("Derecha: " + bartolin.getDerecha());
        System.out.println("---------------------------------------");
        System.out.println("Nombre: " + ana.getViajero());
        System.out.println("Numero de ticks: " + ana.getTicks());
        System.out.println("Arriba: " + ana.getArriba());
        System.out.println("Abajo: " + ana.getAbajo());
        System.out.println("Izquierda: " + ana.getIzquierda());
        System.out.println("Derecha: " + ana.getDerecha());
        System.out.println("---------------------------------------");
        System.out.println("Nombre: " + maria.getViajero());
        System.out.println("Numero de ticks: " + maria.getTicks());
        System.out.println("Arriba: " + maria.getArriba());
        System.out.println("Abajo: " + maria.getAbajo());
        System.out.println("Izquierda: " + maria.getIzquierda());
        System.out.println("Derecha: " + maria.getDerecha());
        System.out.println("---------------------------------------");
        System.out.println("Nombre: " + juana.getViajero());
        System.out.println("Numero de ticks: " + juana.getTicks());
        System.out.println("Arriba: " + juana.getArriba());
        System.out.println("Abajo: " + juana.getAbajo());
        System.out.println("Izquierda: " + juana.getIzquierda());
        System.out.println("Derecha: " + juana.getDerecha());
        System.out.println("---------------------------------------");
        
        System.out.println("Todos los hilos creados han terminado");
    }
}
