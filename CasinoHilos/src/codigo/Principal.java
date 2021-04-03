package codigo;

import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) throws InterruptedException {
        
        //Crear una Baraja (un array de enteros) y la mostramos
        Baraja baraja = new Baraja();
        for(int i : baraja.getArray()){
            System.out.print(i + " ");
        }
        System.out.println("");
           
        
        //Crear unos cuantos Crupieres(20), comparten baraja
        ArrayList<Crupier> crupieres = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            crupieres.add(new Crupier(baraja, 50));
        }
        
        //Arrancar los Crupieres 
        for (Crupier c: crupieres) {
            c.start();
        }
        
        //Esperar a que todos los Crupieres terminen (con join)
        boolean error;
        for (Crupier c: crupieres) {
            do {
                try {
                    c.join();
                    error = false;
                } catch (Exception e) {
                    error = true;
                }
            } while (error);
        }
                
        //Volvemos a mostrar la baraja debería estar desordenada
        for(int i : baraja.getArray()){
            System.out.print(i + " ");
        }
        System.out.println("");
        
    }
    
}
