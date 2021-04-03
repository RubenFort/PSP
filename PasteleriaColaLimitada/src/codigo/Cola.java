package codigo;

import java.util.Vector;

public class Cola {
    
    private Vector<Tarta> tartas;
    private int maxTartas;
    private int tartasEnCola;
    
    public Cola() {
        tartas = new Vector<Tarta>();
    }

    public void setTartasEnCola(int tartasEnCola) {
        this.tartasEnCola = tartasEnCola;
    }

    public void setMaxTartas(int maxTartas) {
        this.maxTartas = maxTartas;
    }
    
    public boolean estaVacia() {
        return tartas.isEmpty();
    }
    
    public  void entraTarta(Tarta t) {
        t.setIdTarta(0);;
        tartas.add(t);
        tartasEnCola++;
    }
    
    public  void saleTarta() {
        tartas.remove(0);
        tartasEnCola--;
    }
    
    public int tamañoCola () {
        return tartas.size();
    }
    

    public int pesoTarta (){
        if(!tartas.isEmpty()){
            Tarta t = tartas.firstElement();
            int peso = t.getPeso();
            return peso;
        } else {
            return 0;
        }
    }
    
    public int recuperarIdTarta (){
        if(!tartas.isEmpty()){
        Tarta t = tartas.firstElement();
        return t.getIdTarta();
        }
        return 0;
    }
    
}