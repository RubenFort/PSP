package codigo;

import java.util.Vector;

public class Cola {
    
    private Vector<Tarta> tartas;
    
    public Cola() {
        tartas = new Vector<Tarta>();
    }
    
    public boolean estaVacia() {
        return tartas.isEmpty();
    }
    
    public  void entraTarta(Tarta t) {
        t.setIdTarta(0);;
        tartas.add(t);
    }
    
    public  void saleTarta() {
        tartas.remove(0);
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
}
