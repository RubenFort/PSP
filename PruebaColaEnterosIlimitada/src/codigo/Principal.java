package codigo;

public class Principal {

    public static void main(String[] args) {
        
        //Creo una cola
        ColaEnterosIlimitada cola = new ColaEnterosIlimitada();
        
        //Encolamos unos cunatos enteros
        cola.entra(-2);
        cola.entra(-1);
        cola.entra(0);
        cola.entra(1);
        cola.entra(2);
        
        while(!cola.estaVacia()) {
            System.out.println(cola.sale());
        }

    }
    
}
