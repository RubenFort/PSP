package codigo;

import java.util.Random;

public class Pastelero extends Thread{
    private int idPastelero;
    private Pasteleria pasteleria;
    private int maxTartas;
    private Cola cola = new Cola();
    private Tarta tarta;
    private int idTarta;
    
    public Pastelero (Cola c, int id, Pasteleria pasteleria) {
        cola = c;
        idPastelero = id;
        this.pasteleria = pasteleria;
    }

        
    //Creo las tartas para los pasteleros asignadoles un ID y un Peso random 
    //entre 800 y 1200, que es el tiempo que tarda el pastelero en hacerla.
    //sincronizo el bloque meterTartaEnCola y comerTarta(cola) de Comilon, para
    //que no pueda suceder que se quiten 2 o mas veces la misma tarta.
    @Override
    public void run() {
        do{     
            tarta = cocerTarta();
            boolean error;
                try {                  
                    sleep(tarta.getPeso());
                    synchronized(cola){                        
                        meterTartaEnCola(tarta);
                        System.out.println("Entra Tarta ID: " + tarta.getIdTarta() +
                                " PESO: " + tarta.getPeso());
                    }
                    error = false;
                } catch (InterruptedException ex) {
                    error = true;
                }
        }while (true);
    }
    
    //creo la tarta, asigno un ID y peso
    private Tarta cocerTarta() {
        Tarta t = new Tarta();
        Random rd = new Random();
        int peso = rd.nextInt(400)+800;
        t.setPeso(peso);
        t.setIdTarta(idTarta++);
        return t;
    }
    //Meto la tarta en la cola e incremento su contador
    private void meterTartaEnCola(Tarta t) {
        cola.entraTarta(t);
        t.setIdTarta(pasteleria.incrementarTarta());
    }
}
