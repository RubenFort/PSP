package codigo;

import java.util.Vector;

public class Data {
    private Vector<Hilo> hilos;

    public Data() {
        hilos = new Vector<>();
    }
    
    //Compruebo si existe un hilo con el nombre que recibimos, devolvemos el hilo
    Hilo buscarHilo(String nombre){
        Hilo hilo = coincidencia (nombre);
        return hilo;
    }
    
    //Añado un hilo a Vector
    void addHilo(Hilo h) {
        hilos.add(h);
    }
    
    //Devuelvo el Vector en Forma de array
    Hilo[] todosLosHilos() {
        Hilo[] todos = new Hilo[hilos.size()];
        return hilos.toArray(todos);
    }
    
    //Compruebo si existe un hilo con el nombre que recibimos, dependiendo del 
    //resultado devuelvo true o false
    boolean hiloExiste(String nombre) {
        Hilo hilo = coincidencia (nombre);
        if (hilo != null) {
            return true;
        } else {
            return false;
        }
    }
    
    //Recorro el Vector hasta que exista una coincidencia entre el nombre recibido
    //y el del Vector y devuelvo el Objeto hiloTmp. Si no hay coincidencia devuelvo null.
    Hilo coincidencia (String nombre){
        Hilo hiloTmp;
        String nombreHilo;
        for (int i = 0; i < hilos.size(); i++) {
            hiloTmp = hilos.elementAt(i);
            nombreHilo = hiloTmp.getNombre();
            if (nombre.equals(nombreHilo)){
                return hiloTmp;
            }
        }
    return null;
    }
}
