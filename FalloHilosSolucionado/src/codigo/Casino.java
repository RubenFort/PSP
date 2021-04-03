package codigo;

import java.util.ArrayList;

public class Casino extends Thread{
    
    private Baraja baraja;
    ArrayList<Crupier> crupieres;
    
    public Casino() {
        this.baraja = new Baraja();
        this.crupieres = new ArrayList<>();
        
        for (int i = 0; i < 20; i++) {
            crupieres.add(new Crupier(baraja, 50));
        }
    }

    @Override
    public void run() {
        
        //Mostramos la baraja antes de empezar
        for(int i : baraja.getArray()){
            System.out.print(i + " ");
        }
        System.out.println("");

        //Arrancar los Crupieres (baraja las cartas)
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