package codigo;

public class Principal {

    public static void main(String[] args) {
        
        Cola c = new Cola();
        int valorRecuperado;
        

        if (c.estaVacia()){
            System.out.println("Vector vacio");
        } else {
            valorRecuperado = c.sale();
            System.out.println(valorRecuperado);
        }
        
        c.entra(2);
        c.entra(23);
        c.entra(5);
        

        if (c.estaVacia()){
            System.out.println("Vector vacio");
        } else {
            valorRecuperado = c.sale();
            System.out.println(valorRecuperado);
        }
        if (c.estaVacia()){
            System.out.println("Vector vacio");
        } else {
            valorRecuperado = c.sale();
            System.out.println(valorRecuperado);
        }   
        if (c.estaVacia()){
            System.out.println("Vector vacio");
        } else {
            valorRecuperado = c.sale();
            System.out.println(valorRecuperado);
        }   
    }
}
