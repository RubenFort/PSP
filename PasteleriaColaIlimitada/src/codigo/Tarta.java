package codigo;

import java.util.Random;

public class Tarta {
    private int idTarta;
    private int peso;
    
    public Tarta() {
    }

    public Tarta(int idTarta, int peso) {
        this.idTarta = idTarta;
        this.peso = peso;
    }

    public int getIdTarta() {
        return idTarta;
    }

    public void setIdTarta(int idTarta) {
        this.idTarta = idTarta;
    }
    
    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
}