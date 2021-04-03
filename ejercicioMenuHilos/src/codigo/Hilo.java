package codigo;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Hilo extends Thread{
    
    private int id;
    private String nombre;
    private Date fechaYHora;
    private Estado estado;

    public Hilo(int id, String nombre, Date fechaYHora) {
        this.id = id;
        this.nombre = nombre;
        this.fechaYHora = fechaYHora;
        this.estado = estado.CORRIENDO;
    }

    public String getNombre() {
        return nombre;
    }

    public Date getFechaYHora() {
        return fechaYHora;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    @Override
    public void run() {
        while(true){
            try {
                sleep(1000);
                System.out.println(nombre + " " + estado);
            } catch (InterruptedException ex) {
                System.out.println("Problema al ejecutarse el hilo");
            }
        }
    }
}
