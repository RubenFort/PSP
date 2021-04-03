package codigo;

//LIFO (Last In First Out)
public class Principal {
    
    public final static int MAX_CAPACIDAD = 4;
    
    public static void main(String[] args) {
        
        
        //Creo una cola
        PilaEnterosLimitada cola = new PilaEnterosLimitada(MAX_CAPACIDAD);
        
        //Encolamos unos cunatos enteros
        System.out.println("Se intenta encolar el dato entrante -2");
        if (cola.estaLLena()){
            System.out.println("Cola llena, no se pueden introducir más elementos");
        } else {
            cola.entra(-2);
            System.out.println("Se encoló el -2");
        }
        System.out.println("Se intenta encolar el dato entrante -1");
        if (cola.estaLLena()){
            System.out.println("Cola llena, no se pueden introducir más elementos");
        } else {
            cola.entra(-1);
            System.out.println("Se encoló el -1");
        }
        System.out.println("Se intenta encolar el dato entrante 0");
        if (cola.estaLLena()){
            System.out.println("Cola llena, no se pueden introducir más elementos");
        } else {
            cola.entra(0);
            System.out.println("Se encoló el 0");
        }
        System.out.println("Se intenta encolar el dato entrante 1");
        if (cola.estaLLena()){
            System.out.println("Cola llena, no se pueden introducir más elementos");
        } else {
            cola.entra(1);
            System.out.println("Se encoló el 1");
        }
        System.out.println("Se intenta encolar el dato entrante 2");
        if (cola.estaLLena()){
            System.out.println("Cola llena, no se pueden introducir más elementos");
        } else {
            cola.entra(2);
            System.out.println("Se encoló el 2");
        }
        
        System.out.println("-------------------------------------------------------");
        
        while(!cola.estaVacia()) {
            System.out.println(cola.sale());
        }
        System.out.println("-------------------------------------------------------");
    }
    
}
