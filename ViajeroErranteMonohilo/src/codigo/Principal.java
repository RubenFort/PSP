package codigo;

import java.util.Random;

public class Principal {

    private static final int COLUMNAS = 10;
    private static final int FILAS = 10;
    private static final int FILA_FIN = 9;
    private static final int COLUMNA_FIN = 9;
    private static final int NUMERO_VIAJEROS = 5;
    private static final long TICK = 1; //Tiempo en ms de cada movimiento
    private static final String viajero = "Bartolin";

    public static void main(String[] args) {

        int filaActual = 0;
        int columnaActual = 0;
        boolean finalizar = false;
        Movimiento movimiento;
        int ticks = 0;
        int ups = 0;
        int downs = 0;
        int lefts = 0;
        int rights = 0;

        do {
            movimiento = muevete();
            ticks++;
            switch (movimiento) {
                case UP:
                    if (filaActual > 0) {
                        filaActual--;
                        ups++;
                    }
                    break;
                case RIGHT:
                    if (columnaActual < COLUMNAS - 1) {
                        columnaActual++;
                        rights++;
                    }
                    break;
                case LEFT:
                    if (columnaActual > 0) {
                        columnaActual--;
                        lefts++;
                    }
                    break;
                case DOWN:
                    if (filaActual < FILAS - 1) {
                        filaActual++;
                        downs++;
                    }
            }

            if (filaActual == FILA_FIN && columnaActual == COLUMNA_FIN) {
                finalizar = true;
            }

            try {
                Thread.sleep(TICK);
            } catch (InterruptedException ex) {
                //Despertó antes de tiempo
            }

        } while (!finalizar);

        //Mostramos la estadística de movimientos del viajero
        System.out.println("Nombre:" + viajero + " Ticks:" + ticks + " Ups:" + ups + " Downs:" + downs + " Lefts:" + lefts + " Rights:" + rights);

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
